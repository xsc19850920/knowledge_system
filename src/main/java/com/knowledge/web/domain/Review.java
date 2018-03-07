package com.knowledge.web.domain;


import sun.rmi.server.InactiveGroupException;

import java.math.BigInteger;
import java.util.Date;

public class Review {
    private BigInteger createTime;
    private BigInteger modifyTime;
    private Integer operIp;
    private BigInteger operUserId;
    private Boolean delFlag;
    private BigInteger reviewId;
    private String fileSrc;
    private Integer stateType;
    private String title;

    public BigInteger getCreateTime() {
        return createTime;
    }

    public void setCreateTime(BigInteger createTime) {
        this.createTime = createTime;
    }

    public BigInteger getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(BigInteger modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getOperIp() {
        return operIp;
    }

    public void setOperIp(Integer operIp) {
        this.operIp = operIp;
    }

    public BigInteger getOperUserId() {
        return operUserId;
    }

    public void setOperUserId(BigInteger operUserId) {
        this.operUserId = operUserId;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public BigInteger getReviewId() {
        return reviewId;
    }

    public void setReviewId(BigInteger reviewId) {
        this.reviewId = reviewId;
    }

    public String getFileSrc() {
        return fileSrc;
    }

    public void setFileSrc(String fileSrc) {
        this.fileSrc = fileSrc;
    }

    public Integer getStateType() {
        return stateType;
    }

    public void setStateType(Integer stateType) {
        this.stateType = stateType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
