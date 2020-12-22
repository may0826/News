package com.news.util.test;

import com.news.util.pojo.NewsDetail;
import com.news.util.service.NewsService;
import com.news.util.service.NewsServiceImpl;
import org.junit.Test;

import java.util.List;

public class NewsTest {
    NewsService newsService = new NewsServiceImpl();

    //查询所有的新闻记录
    @Test
    public void getNewsListTest(){
        List<NewsDetail> newsList = newsService.getNewsList();

        //增强for循环遍历
        for(NewsDetail news:newsList){
            System.out.println(news.getId()+"\t"+news.getTitle());
        }
    }

    //分页查询新闻列表
    @Test
    public void getNewsList_pageTest(){
        List<NewsDetail> newsList = newsService.getNewsList_page(1, 5);
        //增强for循环遍历
        for(NewsDetail news:newsList){
            System.out.println(news.getId()+"\t"+news.getTitle());
        }
    }

    //查询新闻记录数
    @Test
    public void getNewsCountTest(){
        int count = newsService.getNewsCount();
        System.out.println("count-->"+count);
    }
}
