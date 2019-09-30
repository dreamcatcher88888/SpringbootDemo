package com.springboot.demo.common.response;

public class CommonResponse<T> extends BaseResponse {

    private long total;

    private T results;


    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

}
