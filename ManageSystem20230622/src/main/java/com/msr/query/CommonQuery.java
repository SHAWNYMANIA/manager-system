package com.msr.query;

import lombok.Data;

@Data
public class CommonQuery {
    // 1 分页的起始下标
    private Long offset;
    // 2 每页显示的条数
    private Long page;
}
