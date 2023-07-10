package com.msr.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author bruce
 * @since 2023-06-29
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Proprietor implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 编号
     */
    private String pno;

    /**
     * 姓名
     */
    @Excel(name="业主姓名",width = 20,needMerge = true)
    private String name;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 性别（0：代表男  1：代表女）
     */
    private Integer sex;

    /**
     * 电话
     */
    private String phone;

    /**
     * 入住时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")  //后端往前端显示过程的时间处理
    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")  前端向后端显示过程的时间处理
    private LocalDateTime entrytime;

    /**
     * 入住人数
     */
    private Integer entrycount;

    /**
     * 户型图
     */
    private String pimg;

    /**
     * 关联楼房
     */
    private Long floorid;

    @TableField(exist = false)
    private Floor floor;

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
        return "Proprietor{" +
            "id=" + id +
            ", pno=" + pno +
            ", name=" + name +
            ", pwd=" + pwd +
            ", sex=" + sex +
            ", phone=" + phone +
            ", entrytime=" + entrytime +
            ", entrycount=" + entrycount +
            ", pimg=" + pimg +
            ", floorid=" + floorid +
            ", createDate=" + createDate +
            ", updateDate=" + updateDate +
            ", isdel=" + isdel +
        "}";
    }
}
