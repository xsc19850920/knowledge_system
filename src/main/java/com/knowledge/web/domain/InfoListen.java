package com.knowledge.web.domain;

import java.math.BigInteger;
import java.util.Date;

public class InfoListen {

    private BigInteger createTime;
    private BigInteger modifyTime;
    private Integer operIp;
    private BigInteger operUserId;
    private Boolean delFlag;
    private BigInteger infoId;
    private Integer categoryId;
    private String title;
    private Integer flagNew;
    private Integer flagTop;
    private Integer stateType;
    private InfoFile infoFile;

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

    public BigInteger getInfoId() {
        return infoId;
    }

    public void setInfoId(BigInteger infoId) {
        this.infoId = infoId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getFlagNew() {
        return flagNew;
    }

    public void setFlagNew(Integer flagNew) {
        this.flagNew = flagNew;
    }

    public Integer getFlagTop() {
        return flagTop;
    }

    public void setFlagTop(Integer flagTop) {
        this.flagTop = flagTop;
    }

    public Integer getStateType() {
        return stateType;
    }

    public void setStateType(Integer stateType) {
        this.stateType = stateType;
    }

    public InfoFile getInfoFile() {
        return infoFile;
    }

    public void setInfoFile(InfoFile infoFile) {
        this.infoFile = infoFile;
    }
}
