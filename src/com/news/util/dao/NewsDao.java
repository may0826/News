package com.news.util.dao;

import com.news.util.pojo.Newscomment;

import java.sql.ResultSet;
import java.util.List;

public interface NewsDao {

    //查询所有的新闻记录
    public ResultSet getNewsList();
    //分页查询新闻列表
    public ResultSet getNewsList_page(int from, int pageSize);
    //查询新闻记录数
    public ResultSet getNewsCount();
    //分页查询评论列表
    public ResultSet getNewsCommentList(int from, int PageSize);

}
