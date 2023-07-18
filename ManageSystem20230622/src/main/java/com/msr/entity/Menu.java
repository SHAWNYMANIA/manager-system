package com.msr.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author bruce
 * @since 2023-07-18
 */
@Data
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String name;

    private String url;

    private Long pid;

    private String icon;

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

    //扩展两个对象
    @TableField(exist = false)
    private Menu parent; //父菜单

    @TableField(exist = false)
    private List<Menu> childs; //子菜单

    @Override
    public String toString() {
        return "Menu{" +
            "id=" + id +
            ", name=" + name +
            ", url=" + url +
            ", pid=" + pid +
            ", icon=" + icon +
            ", createDate=" + createDate +
            ", updateDate=" + updateDate +
            ", isdel=" + isdel +
        "}";
    }
}
