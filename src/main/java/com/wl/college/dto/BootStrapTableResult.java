package com.wl.college.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

/**
 * bootstraptable请求返回
 *
 * @param <T>
 * @author yugoh
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BootStrapTableResult<T> implements Serializable {

    private static final long serialVersionUID = -4185151304730685014L;

    private Integer total;
    private List<T> rows;

    public BootStrapTableResult(Integer total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
