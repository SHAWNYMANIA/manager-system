package com.msr.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author bruce
 * @since 2023-06-23
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Floor implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 楼号
     */
    private String no;

    /**
     * 户型
     */
    private String local;

    /**
     * 面积
     */
    private Double area;

    /**
     * 楼管
     */
    private Long userid;//楼管id

    @TableField(exist = false)//代表表中不存在此字段
    private User user;//楼管对象

    /**
     * 楼层
     */
    private Integer floor;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createDate;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateDate;

    /**
     * 是否删除（0：未删除 1：已删除）
     */
    @TableLogic
    private Integer isdel;


    @Override
    public String toString() {
        return "Floor{" +
            "id=" + id +
            ", no=" + no +
            ", local=" + local +
            ", area=" + area +
            ", userid=" + userid +
            ", floor=" + floor +
            ", createDate=" + createDate +
            ", updateDate=" + updateDate +
            ", isdel=" + isdel +
        "}";
    }
}
