package com.zhao.utils;

import lombok.Data;

@Data
public class PageRequest {
    /**
     * 当前页数，默认是1
     */
    private Integer pageIndex = 1;

    /**
     * 每页的数据条数， 默认10条
     */
    private Integer pageSize = 10;

    private Integer startIndex;

    public Integer getStartIndex() {
        return (pageIndex - 1)*pageSize;
    }
}
