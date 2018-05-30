package com.vole.entity;

/**
 * 编写者： vole
 * Time： 2018/5/30.16:10
 * 内容：友情链接
 */
public class Link {
    private Integer id;
    private String linkName;
    private String linkUrl;
    private Integer orderNo; //排序

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }
}
