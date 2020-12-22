package com.news.util.service;

import com.news.util.pojo.NewsDetail;
import com.news.util.pojo.Newscomment;

import java.util.List;

public interface NewsService {
    //查询所有的新闻列表
    public List<NewsDetail> getNewsList();
    //分页查询
    public List<NewsDetail> getNewsList_page(int currentPageNo,int PageSize);
//查询新闻记录数
   public    int getNewsCount();
   //查询新闻评论
    public List<Newscomment> getNewsCommentList(int currentPageNo,int PageSize);
}
