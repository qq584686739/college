package com.wl.college.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wl.college.exception.BizExceptionMessage;

import java.io.Serializable;


/**
 * ajax请求返回
 *
 * @param <T>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResult<T> implements Serializable {

    private static final long serialVersionUID = 6034112963064295478L;

    private boolean success;
    private T data;
    private BizExceptionMessage error;

    public BaseResult(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public BaseResult(boolean success, BizExceptionMessage error) {
        this.success = success;
        this.error = error;
    }

    @Override
    public String toString() {
        return "BaseResult{" +
                "success=" + success +
                ", data=" + data +
                ", error='" + error + '\'' +
                '}';
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BizExceptionMessage getError() {
        return error;
    }

    public void setError(BizExceptionMessage error) {
        this.error = error;
    }
}
