package com.springboot.demo.common.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.session.ConcurrentSessionControlAuthenticationStrategy;
import org.springframework.security.web.session.ConcurrentSessionFilter;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.security.web.session.SimpleRedirectSessionInformationExpiredStrategy;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    private CustomUserDetailService userDetailsService;
    @Resource
    private CustomAccessDecisionManager customAccessDecisionManager;
    @Resource
    private DefaultSecurityMetadataSource defaultSecurityMetadataSource;
    @Resource
    private SessionRegistry sessionRegistry;

    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService((UserDetailsService) this.userDetailsService)
                .passwordEncoder(new PasswordEncoder() {
                    public String encode(final CharSequence charSequence) {
                        final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                        return encoder.encode(charSequence.toString());
                    }

                    public boolean matches(final CharSequence charSequence, final String s) {
                        final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                        return encoder.matches(charSequence, s);
                    }
                });
    }

    protected void configure(final HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();
        http.authorizeRequests().withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
            @Override
            public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                o.setSecurityMetadataSource(defaultSecurityMetadataSource);
                o.setAccessDecisionManager(customAccessDecisionManager);
                return o;
            }
        }).and().formLogin().loginPage("/login").defaultSuccessUrl("/").permitAll().and().logout().permitAll()
                .logoutSuccessHandler(new CustomLogoutSuccessHandler()).invalidateHttpSession(true).and()
                .exceptionHandling().authenticationEntryPoint(new CustomAuthenticationEntryPoint());
        http.csrf().disable();
        http.cors().disable();
        http.addFilterAt(this.customJSONLoginFilter(), UsernamePasswordAuthenticationFilter.class);
//        session并发控制过滤器
        http.addFilterAt(new ConcurrentSessionFilter(sessionRegistry, sessionInformationExpiredStrategy()), ConcurrentSessionFilter.class);

        http.addFilterBefore(corsFilter(), UsernamePasswordAuthenticationFilter.class)
                .headers()
                .cacheControl();
    }

    public void configure(final WebSecurity web) {
        web.ignoring().antMatchers("/demo/index.html", "/index.html", "/static/**", "/login_p", "/favicon.ico", "/",
                "/css/**", "/js/**", "/xxxxx/**");
    }

    private CustomJSONLoginFilter customJSONLoginFilter() {
        CustomJSONLoginFilter customJSONLoginFilter = new CustomJSONLoginFilter("/login", userDetailsService, sessionRegistry);
        customJSONLoginFilter.setAuthenticationFailureHandler(new CustomAuthenticationFailureHandler());
        customJSONLoginFilter.setAuthenticationSuccessHandler(new CustomAuthenticationSuccessHandler());
//        session并发控制,因为默认的并发控制方法是空方法.这里必须自己配置一个
        customJSONLoginFilter.setSessionAuthenticationStrategy(new ConcurrentSessionControlAuthenticationStrategy(sessionRegistry));
        return customJSONLoginFilter;
    }

    /**
     * 注册bean sessionRegistry
     */
    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    /**
     * 解决session失效后 sessionRegistry中session没有同步失效的问题，启用并发session控制，首先需要在配置中增加下面监听器
     *
     * @return
     */
    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }

    //session失效跳转
    private SessionInformationExpiredStrategy sessionInformationExpiredStrategy() {
        return new SimpleRedirectSessionInformationExpiredStrategy("/login");
    }

    @Bean
    public CorsFilter corsFilter() throws Exception {
        return new CorsFilter();
    }

}
