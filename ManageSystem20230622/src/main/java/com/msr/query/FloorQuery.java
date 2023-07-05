package com.msr.query;

import lombok.Data;

@Data
public class FloorQuery extends CommonQuery{

    // 3 楼号
    private String no;
    // 4 楼层
    private Integer floor;
}
