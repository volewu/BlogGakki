package com.vole.entity;

/**
 * 编写者： vole
 * Time： 2018/5/30.17:13
 * 内容：博客类型实体
 */
public class BlogType {
    private Integer id; // 编号
    private String typeName; // 博客类型名称
    private Integer orderNo; // 排序序号 从小到大排序
    private Integer blogCount; // 数量 方便在首页显示数量

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getBlogCount() {
        return blogCount;
    }

    public void setBlogCount(Integer blogCount) {
        this.blogCount = blogCount;
    }
}
