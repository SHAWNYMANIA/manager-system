package com.msr.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class Feetype implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 编号
     */
    private String feeno;

    /**
     * 标题
     */
    private String title;

    /**
     * 单价
     */
    private Double stander;

    /**
     * 单位
     */
    private String unit;

    /**
     * 创建时间
     */
    private LocalDateTime createDate;

    /**
     * 更新时间
     */
    private LocalDateTime updateDate;

    /**
     * 是否删除
     */
    private Integer isdel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getFeeno() {
        return feeno;
    }

    public void setFeeno(String feeno) {
        this.feeno = feeno;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public Double getStander() {
        return stander;
    }

    public void setStander(Double stander) {
        this.stander = stander;
    }
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }

    @Override
    public String toString() {
        return "Feetype{" +
            "id=" + id +
            ", feeno=" + feeno +
            ", title=" + title +
            ", stander=" + stander +
            ", unit=" + unit +
            ", createDate=" + createDate +
            ", updateDate=" + updateDate +
            ", isdel=" + isdel +
        "}";
    }
}
