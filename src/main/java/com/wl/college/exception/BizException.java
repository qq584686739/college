package com.wl.college.exception;

public class BizException extends RuntimeException {

    private static final long serialVersionUID = -2160050713760937269L;

    //友好提示的code码
    private BizExceptionEnum bizExceptionEnum;

    public BizException(BizExceptionEnum bizExceptionEnum) {
        this.bizExceptionEnum = bizExceptionEnum;
    }

    public BizExceptionEnum getBizExceptionEnum() {
        return bizExceptionEnum;
    }
}
