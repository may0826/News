package com.news.util.dao;

import com.news.util.util.MySqlUtil;

import java.sql.ResultSet;

public class NewsDaoImpl implements NewsDao {
    private MySqlUtil mysqlUtil = new MySqlUtil();
    private ResultSet resultSet;

    //查询所有的新闻记录
    public ResultSet getNewsList() {
        String sql="select * from news_detail";
        Object[] params=null;
        resultSet = this.mysqlUtil.executeQuerySql(sql, params);
        return resultSet;
    }

    @Override

    //分页查询新闻列表
    public ResultSet getNewsList_page(int from, int pageSize) {
        String sql="select * from news_detail limit ?,?";
        Object params[]={from,pageSize};
        resultSet=this.mysqlUtil.executeQuerySql(sql,params);
        return resultSet;
    }
//查询新闻记录数
    @Override
    public ResultSet getNewsCount() {
        String sql="select count(1) from news_detail";
        Object params[]=null;
        resultSet=this.mysqlUtil.executeQuerySql(sql,params);
        return resultSet;
    }
//分页查询评论记录
    @Override
    public ResultSet getNewsCommentList(int from, int PageSize) {
        String  sql="select * from news_comment limit ?,?";
        Object params[]={from,PageSize};
        resultSet=this.mysqlUtil.executeQuerySql(sql,params);
        return resultSet;
    }
}
