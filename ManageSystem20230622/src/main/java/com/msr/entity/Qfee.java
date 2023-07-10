package com.msr.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
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
    @Excel(name="费用ID",width = 10)
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 编号
     */
    @Excel(name="编号",width = 10)
    private String qfno;

    /**
     * 缴费时间
     */
    @Excel(name="缴费时间",width = 30,format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "jftime",updateStrategy = FieldStrategy.IGNORED)
    private LocalDateTime jftime;

    /**
     * 欠费时间
     */
    @Excel(name="欠费时间",width = 30,format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime qftime;

    /**
     * 欠费金额
     */
    @Excel(name="欠费金额",width = 10)
    private Double qfmoney;

    /**
     * 欠费说明
     */
    @Excel(name="欠费说明",width = 20)
    private String qfremark;

    /**
     * 用量
     */
    @Excel(name="用量",width = 10)
    private Double qfuse;

    /**
     * 缴费状态
     */
    @Excel(name="缴费状态",width = 20, replace = {"未缴纳_0","已缴纳_1"})
    private Integer status;

    /**
     * 关联欠费种类
     */
    @Excel(name="费用id",width = 10)
    private Integer feetypeid;
    @ExcelEntity()
    @TableField(exist = false)
    private Feetype feetype;

    /**
     * 关联业主
     */
    @Excel(name="业主id",width = 10)
    private Long proprietorid;
    @ExcelEntity()
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
