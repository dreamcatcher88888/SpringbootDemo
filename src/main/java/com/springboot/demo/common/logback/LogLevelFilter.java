package com.springboot.demo.common.logback;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.AbstractMatcherFilter;
import ch.qos.logback.core.spi.FilterReply;

/**
 * logback 日志过滤
 * 大于指定级别的日志就算匹配, LevelFilter实现是完全匹配
 * @see ch.qos.logback.classic.filter.LevelFilter
 */
public class LogLevelFilter extends AbstractMatcherFilter<ILoggingEvent> {
    Level level;

    public LogLevelFilter() {
    }

    public FilterReply decide(ILoggingEvent event) {
        if (!this.isStarted()) {
            return FilterReply.NEUTRAL;
        } else {
            if (this.level == null || event.getLevel() == null){
                return FilterReply.NEUTRAL;
            }

            return event.getLevel().levelInt >= this.level.levelInt ? this.onMatch : this.onMismatch;
        }
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public void start() {
        if (this.level != null) {
            super.start();
        }

    }
}
