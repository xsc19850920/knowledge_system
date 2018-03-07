package com.knowledge.web.domain;

import java.math.BigInteger;

/**
 * Created by zhangfulong on 17/12/26.
 */
public class InfoRole {
    private BigInteger infoRoleId;
    private BigInteger userId;
    private String url;
    private Integer status;

    public BigInteger getInfoRoleId() {
        return infoRoleId;
    }

    public void setInfoRoleId(BigInteger infoRoleId) {
        this.infoRoleId = infoRoleId;
    }

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
