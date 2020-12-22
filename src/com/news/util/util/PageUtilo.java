package com.news.util.util;

//分页
/**
 * 分页--类PageSupport   工具类
 * 涉及到哪些方面--->成员变量
 * 当前页码 currentPageNo  第1页 第2页
 * 页容量  pageSize    每页显示多少条记录
 * 总记录数  totalCount  需要查询的所有记录是多少
 * 总页数  totalPageCount
 *
 * 通过计算：总记录数除以页容量
 * 总记录 1000
 * 页容量 100  商为10 ，余数为0
 * 总页数 10
 *
 * 总页码 999
 * 页容量 100
 * 总页数  10  商为9 ，余数为99>0
 *
 * 总页码 1001
 * 页容量 100  商为10 余数为1>0
 * 总页数  11
 */
public class PageUtilo {
    private int currentPageNo=1;//当前页码 第几页
    private int pageSize;//页容量 没有显示多少记录
    private int totalCount;//总记录数
    private int totalPageCount;//总页数

    public int getCurrentPageNo() {
        return currentPageNo;
    }

    public void setCurrentPageNo(int currentPageNo) {
        if (currentPageNo>0&& currentPageNo<=this.totalPageCount) {
            this.currentPageNo = currentPageNo;
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize>=0&&pageSize<=this.totalCount) {
            this.pageSize = pageSize;
        }
    }

    public int getTotalCount() {
        return totalCount;
    }
//通过查询数据库得来的
    public void setTotalCount(int totalCount) {
        if (totalCount>=0) {
            this.totalCount = totalCount;
        }
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }
//通过计算，总记录数totalcount和页容量pagesize计算得来的totalCount/pageSize
    public void setTotalPageCount() {
        if (this.totalCount%this.pageSize==0) {//取余数
            this.totalPageCount = this.totalCount/this.pageSize;//取商值
        }else if (this.totalCount%this.pageSize>0){
            this.totalPageCount = this.totalCount/this.pageSize+1;
        }
    }


}
