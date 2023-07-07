package com.msr.entity;

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
 * @since 2023-07-08
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Qfee implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 编号
     */
    private String qfno;

    /**
     * 缴费时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime jftime;

    /**
     * 欠费时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime qftime;

    /**
     * 欠费金额
     */
    private Double qfmoney;

    /**
     * 欠费说明
     */
    private String qfremark;

    /**
     * 用量
     */
    private Double qfuse;

    /**
     * 缴费状态
     */
    private Integer status;

    /**
     * 关联欠费种类
     */
    private Integer feetypeid;

    @TableField(exist = false)
    private Feetype feetype;

    /**
     * 关联业主
     */
    private Long proprietorid;

    @TableField(exist=false)
    private Proprietor proprietor;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDate;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateDate;

    /**
     * 是否删除
     */
    @TableLogic
    private Integer isdel;


}