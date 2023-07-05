package com.msr.utils;

import lombok.Data;

import java.util.List;

//封装通用的分页工具类
@Data
public class PageUtils<T> {
    // 1 总条数
    private Long total;
    // 2 每页显示的数据列表
    private List<T> rows;

    public PageUtils(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }
}
