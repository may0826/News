package com.news.util.service;

import com.news.util.dao.NewsDao;
import com.news.util.dao.NewsDaoImpl;
import com.news.util.pojo.NewsDetail;
import com.news.util.pojo.NewsUser;
import com.news.util.pojo.Newscomment;
import com.news.util.util.MySqlUtil;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NewsServiceImpl implements NewsService {

    private NewsDao newsDao = new NewsDaoImpl();
    private ResultSet resultSet;
    private MySqlUtil mysqlUtil=new MySqlUtil();
//公共代码
    public List<NewsDetail> getResultSet(){
        List<NewsDetail> newsList = new ArrayList<>();
        try{
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                int categoryId = resultSet.getInt("categoryId");
                String title = resultSet.getString("title");
                String summary = resultSet.getString("summary");
                String content = resultSet.getString("content");
                String picPath = resultSet.getString("picPath");
                String author = resultSet.getString("author");
                Date createDate = resultSet.getDate("createDate");
                Date modifyDate = resultSet.getDate("modifyDate");

                NewsDetail news = new NewsDetail();

                news.setId(id);
                news.setCategoryId(categoryId);
                news.setTitle(title);
                news.setSummary(summary);
                news.setContent(content);
                news.setPicPath(picPath);
                news.setAuthor(author);
                news.setCreateDate(createDate);
                news.setModifyDate(modifyDate);

                newsList.add(news);


            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            mysqlUtil.closeResource();
        }
return  newsList;
    }
    //comment代码
    public List<Newscomment> getResult(){
        List<Newscomment> newsList1 = new ArrayList<>();
        try{
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                int newsId = resultSet.getInt("newsId");
                String content = resultSet.getString("content");
                String author = resultSet.getString("author");
                Date createDate = resultSet.getDate("createDate");
                String ip=resultSet.getString("ip");

                Newscomment news1 = new Newscomment();
                news1.setAuthor(author);
                news1.setContent(content);
                news1.setCreatedate(createDate);
                news1.setId(id);
                news1.setIp(ip);
                news1.setNewsid(newsId);
                newsList1.add(news1);


            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            mysqlUtil.closeResource();
        }
        return  newsList1;
    }
    //查询所有的新闻列表
    public List<NewsDetail> getNewsList() {
        resultSet = newsDao.getNewsList();
      List<NewsDetail> newsDetails= this.getResultSet();

        return newsDetails;
    }
//分页查询新闻列表
    @Override
    public List<NewsDetail> getNewsList_page(int currentPageNo, int PageSize) {
        //currentPageNo 和 from（记录索引）有什么关系？
        //(当前页码-1）*页容量=记录索引
        int from=(currentPageNo-1)*PageSize;
        resultSet = this.newsDao.getNewsList_page(from,PageSize);
        List<NewsDetail> newsDetails= this.getResultSet();
        return  newsDetails;
    }

//查询新闻记录数
    @Override
    public int getNewsCount() {
        resultSet = this.newsDao.getNewsCount();
        int count=0;
        try{
            while(resultSet.next()){
                count = resultSet.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return count;
    }

    @Override
    public List<Newscomment> getNewsCommentList(int currentPageNo, int PageSize) {
        //currentPageNo 和 from（记录索引）有什么关系？
        //(当前页码-1）*页容量=记录索引
        int from=(currentPageNo-1)*PageSize;
        resultSet = this.newsDao.getNewsCommentList(from,PageSize);
        List<Newscomment> newscomments=this.getResult();
        return  newscomments;
    }
}
