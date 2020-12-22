package com.news.util.pojo;

import java.util.Date;

public class NewsDetail {
    private  int id;  //新闻详情id
    private int categoryId;//新闻类别id
    private String title;//varchar(100) NULL新闻标题
    private String summary;//varchar(200) NULL新闻摘要

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    private  String content;//text NULL新闻内容
    private String  picPath;//varchar(50) NULL新闻图片路径
    private String author;//varchar(50) NULL发表者
    private Date createDate;//datetime NULL 创建时间
    private  Date modifyDate;//datetime NULL 修改时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
