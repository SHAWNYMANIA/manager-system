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
    private LocalDateTime jftime;

    /**
     * 欠费时间
     */
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

    /**
     * 关联业主
     */
    private Long proprietorid;

    /**
     * 创建时间
     */
    private LocalDateTime createDate;

    /**
     * 修改时间
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
    public String getQfno() {
        return qfno;
    }

    public void setQfno(String qfno) {
        this.qfno = qfno;
    }
    public LocalDateTime getJftime() {
        return jftime;
    }

    public void setJftime(LocalDateTime jftime) {
        this.jftime = jftime;
    }
    public LocalDateTime getQftime() {
        return qftime;
    }

    public void setQftime(LocalDateTime qftime) {
        this.qftime = qftime;
    }
    public Double getQfmoney() {
        return qfmoney;
    }

    public void setQfmoney(Double qfmoney) {
        this.qfmoney = qfmoney;
    }
    public String getQfremark() {
        return qfremark;
    }

    public void setQfremark(String qfremark) {
        this.qfremark = qfremark;
    }
    public Double getQfuse() {
        return qfuse;
    }

    public void setQfuse(Double qfuse) {
        this.qfuse = qfuse;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public Integer getFeetypeid() {
        return feetypeid;
    }

    public void setFeetypeid(Integer feetypeid) {
        this.feetypeid = feetypeid;
    }
    public Long getProprietorid() {
        return proprietorid;
    }

    public void setProprietorid(Long proprietorid) {
        this.proprietorid = proprietorid;
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
        return "Qfee{" +
            "id=" + id +
            ", qfno=" + qfno +
            ", jftime=" + jftime +
            ", qftime=" + qftime +
            ", qfmoney=" + qfmoney +
            ", qfremark=" + qfremark +
            ", qfuse=" + qfuse +
            ", status=" + status +
            ", feetypeid=" + feetypeid +
            ", proprietorid=" + proprietorid +
            ", createDate=" + createDate +
            ", updateDate=" + updateDate +
            ", isdel=" + isdel +
        "}";
    }
}
