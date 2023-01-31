package com.shiro.ds.pojo;

//package com.huajiao.platform.main.util;

public class RestResult {

    private int errno;
    private String errmsg;
    private Object data;

    public RestResult(int errno, String errmsg) {
        this.errno = errno;
        this.errmsg = errmsg;
    }

    public RestResult(int errno, String errmsg, Object data) {
        this.errno = errno;
        this.errmsg = errmsg;
        this.data = data;
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}

