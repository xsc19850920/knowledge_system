package com.knowledge.web.domain;


import java.io.Serializable;
import java.math.BigInteger;

public class InfoFile implements Serializable {
    private BigInteger infoFileId;
    private BigInteger infoId;
    private Integer fileType;
    private String fileSrc;
    private Integer duration;
    private Integer displayOrder;
    private String title;
    private String detail;
    private String memo;

    public BigInteger getInfoFileId() {
        return infoFileId;
    }

    public void setInfoFileId(BigInteger infoFileId) {
        this.infoFileId = infoFileId;
    }

    public BigInteger getInfoId() {
        return infoId;
    }

    public void setInfoId(BigInteger infoId) {
        this.infoId = infoId;
    }

    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

    public String getFileSrc() {
        return fileSrc;
    }

    public void setFileSrc(String fileSrc) {
        this.fileSrc = fileSrc;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
