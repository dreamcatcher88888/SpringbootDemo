package com.springboot.demo.common.pagination;

public class Pagination<T> {
    private int pageNo = 1;
    private int pageSize = 10;
    private T param;

    public Pagination(int pageNo, int pageSize, T param) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.param = param;
    }

    public Pagination(int pageNo, int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public Pagination() {
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public T getParam() {
        return param;
    }

    public void setParam(T param) {
        this.param = param;
    }


}
