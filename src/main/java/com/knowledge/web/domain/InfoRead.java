package com.knowledge.web.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public class InfoRead implements Serializable {

    private BigInteger createTime;
    private BigInteger modifyTime;
    private Integer operIp;
    private String ip;
    private BigInteger operUserId;
    private Boolean delFlag;
    private BigInteger infoId;
    private String title;
    private String infoDate;
    private Boolean flagNew;
    private Integer stateType;
    private List<InfoFile> infoFiles;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfoDate() {
        return infoDate;
    }

    public void setInfoDate(String infoDate) {
        this.infoDate = infoDate;
    }

    public Boolean getFlagNew() {
        return flagNew;
    }

    public void setFlagNew(Boolean flagNew) {
        this.flagNew = flagNew;
    }

    public Integer getStateType() {
        return stateType;
    }

    public void setStateType(Integer stateType) {
        this.stateType = stateType;
    }

    public List<InfoFile> getInfoFiles() {
        return infoFiles;
    }

    public void setInfoFiles(List<InfoFile> infoFiles) {
        this.infoFiles = infoFiles;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
