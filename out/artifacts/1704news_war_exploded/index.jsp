<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.news.util.service.NewsService" %>
<%@ page import="com.news.util.service.NewsServiceImpl" %>
<%@ page import="com.news.util.pojo.NewsDetail" %>
<%@ page import="com.news.util.util.PageUtilo" %>
<%@ page import="com.news.util.pojo.Newscomment" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'doUserCreate.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<%--      引进css文件--%>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/common.css">

  </head>
<body>
<!--页面顶部-->
<div id="header">
<%--    页眉--%>
    <div class="main-top">
        <div class="logo"><a href=""><span>新闻大视野</span></a></div>
        <div class="login-box">
                <form action="<%=request.getContextPath()%>/LoginServlet1" method="post">
                    <label>用户名</label><input type="text" name="uname" value="" />
                    <label>密码</label><input type="text" name="upassword" />
                    <button> 登陆</button>
                </form>
            <a href="pages/userCreate.jsp">若无用户名请点此进行注册</a>
                <a href="<%=request.getContextPath() %>/LoginOutServlet">注销</a>
                <span>
                    <% String username = (String) session.getAttribute("usernamekey");
                    if(username!=null && !username.equals("")){
                       out.println("恭喜您，登陆成功！用户名："+username);
                    }
                    %>
                </span>

        	<br/>

        </div>
        <div class="nav">
            <ul class="clearfix">
                <li><a href="">要闻</a></li>
                <li><a href="">明星 </a></li>
                <li><a href="">美图</a></li>
                <li><a href="">电影</a></li>
                <li><a href="">电视剧</a></li>
            </ul>
        </div>
    </div>
    <!--banner-->
    <div class="main-banner">
    <img src="<%=request.getContextPath() %>/images/4.png" />
    </div>	
    <!--搜索横框-->
    <div class="search-box">
        <div class="sl">
            <div class="sr clearfix">
            
                <span class="left-search clearfix">
                    <label>站内搜索</label><input type="text" name="keyword" value="关键词" /><button class="go-btn"></button>
                </span>
                <span class="right-link">
                    <label>快速链接</label><select><option>-----专题选择-----</option></select><button class="go-btn"></button>
                </span>
                
            </div>
        </div>    
    </div>
</div>
<!--d页面主体-->
<div id="content" class="main-content clearfix">
	<!--主体的的左边部分-->
    <div class="main-content-left">
        <!--新闻专题分类-->
        <div class="class-box">
            <div class="class-box-header">
               <span class="fr"><a href="#">更多...</a></span>
               <h3>新闻专题</h3>
            </div>
            <div class="class-box-content">
                <ul>
                    <li><a href="#">综艺</a></li>
                    <li><a href="#">电影</a></li>
                    <li><a href="#">电视</a></li>
                    <li><a href="#">音乐</a></li>
                    <li><a href="#">美图</a></li>
                    <li class="clear-bottom-line"><a href="#">韩娱</a></li>
                </ul>
            </div>
        </div>
        <!--最新新闻-->
        <div class="left-box">
            <div class="left-box-tbg">
                <div class="left-box-bbg">
                    <div class="left-box-header"><h3><a href="#">最新新闻</a></h3></div>
                    <div class="left-box-content">
                        <ul>
                           <%
                               NewsService newsService2=new NewsServiceImpl();
                               List<NewsDetail> newsDetails1= newsService2.getNewsList_page(1,5);
                               for (NewsDetail newsDetail:newsDetails1){
                           %><li><a href="<%=request.getContextPath()%>/pages/newsDetail.jsp?newsDetailId=<%=newsDetail.getId() %>">
                            <%=newsDetail.getTitle() %></a></li>
                            <% }%>

                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!--最新评论-->
        <div class="left-box">
            <div class="left-box-tbg">
                <div class="left-box-bbg">
                    <div class="left-box-header"><h3>最新评论</h3></div>
                    <div class="left-box-content">
                        <ul>
                            <%
                                NewsService newsService1=new NewsServiceImpl();
//
                                List<Newscomment> newscomments= newsService1.getNewsCommentList(1,5);
                                for (Newscomment newscomment:newscomments){
                            %><li><a href="<%=request.getContextPath()%>/pages/newsDetail.jsp?newsDetailId=<%=newscomment.getId() %>">
                            <%=newscomment.getContent() %></a></li>
                            <% }%>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--页面主体的右部，包括新闻的列表和评论内容 -->
    <div class="main-content-right">
        <!--各专题的新闻列表-->
        <div class="main-text-box">
            <div class="main-text-box-tbg">
                <div class="main-text-box-bbg">
                    
                    <div class="main-text-box-header">
                        <h3>即时新闻</h3>
                    </div>
                    <div class="main-text-box-content">
                      <ul class="news-list-ul clearfix">
                        <%
                            NewsService newsService=new NewsServiceImpl();
                            int currentPageNo=0;
//                            List<NewsDetail> newsDetails=newsService.getNewsList();
                       String pageIndexVal= request.getParameter("pageIndex");
                       if (pageIndexVal==null){
                           //首次访问.../index.jsp
                           currentPageNo=1;
                       }else {
                           //.../index.jsp?pageIndex=2
                           currentPageNo=  Integer.valueOf(pageIndexVal);
                       }
                            PageUtilo pageUtilo=new PageUtilo();
                       //设置总记录数
                            int totalCount=newsService.getNewsCount();
                            pageUtilo.setTotalCount(totalCount);
                       //设置页容量
                       int pageSize=5;
                       pageUtilo.setPageSize(pageSize);
                       //进行计算
                            pageUtilo.setTotalPageCount();
                            //获得总页数
                            int totalPageCount=pageUtilo.getTotalPageCount();

                       List<NewsDetail> newsDetails= newsService.getNewsList_page(currentPageNo,pageSize);
                       for (NewsDetail newsDetail:newsDetails){
                        %><li><span><%=newsDetail.getCreateDate()  %></span><a href="<%=request.getContextPath()%>/pages/newsDetail.jsp?newsDetailId=<%=newsDetail.getId() %>">
                          <%=newsDetail.getTitle() %></a></li>
                      <% }%>

                      </ul>
                    </div>
                    <!--图片新闻-->
                    <div class="news-pic">
                        <dl>
                            <dt><img src="<%=request.getContextPath() %>/images/new-1.png" /></dt>
                            <dd><a href="pages/newsDetail.jsp">袁姗姗在线教学烈儿宝贝瘦身秘诀 还公开自己的健身食谱</a></dd>
                        </dl>
                        <dl>
                            <dt><img src="<%=request.getContextPath() %>/images/new-2.png" /></dt>
                            <dd><a href="pages/NewsDetail2.jsp">吴亦凡六一发图</a></dd>
                        </dl>
                        <dl>
                            <dt><img src="<%=request.getContextPath() %>/images/new-3.png" /></dt>
                            <dd><a href="pages/NewsDetail3.jsp">吴尊六一与小朋友一起过</a></dd>
                        </dl>
                        <dl>
                            <dt><img src="<%=request.getContextPath() %>/images/new-4.png" /></dt>
                            <dd><a href="pages/NewsDetail4.jsp">汤唯在线秀女儿照片</a></dd>
                        </dl>
                    </div>
                    <div class="page-bar">
                        <ul class="page-num-ul clearfix">
                            <li><a href="index.jsp?pageIndex=1">首页</a><li>
                                <%
                                if(currentPageNo-1>0){%>
                            <li><a href="index.jsp?pageIndex=<%=currentPageNo-1 %>">上一页</a><li>
                                <% }
                                %>
                                <%
                                       if(currentPageNo+1<=totalPageCount){%>
                            <li><a href="index.jsp?pageIndex=<%=currentPageNo+1 %>">下一页</a><li>

                                <%   }
                        %>

                            <li><a href="index.jsp?pageIndex<%=totalPageCount %>">最后一页</a><li>
                        </ul>
                        <span class="page-go-form"><label>跳转至</label>
                            <input type="text" name="numkey" id="page-key" class="page-key" value="" />页
                            <input type="hidden" id="totalPageCount" value="<%=totalPageCount %>">
                            <button type="submit" class="page-btn" onclick="jump_to()">GO</button></span>
                        <script type="text/javascript">
                            function  jump_to() {
                                //获得总页数 ,string类型  ???
                                var totalPageCount = document.getElementById("totalPageCount").value;

                                var inputO = document.getElementById("page-key");
                                //此值必须为正整数，小于总页数totalPageCount
                                var pageValue = inputO.value;
                                //pageValue>0 表示正数 正则表达式
                                var regExp=/^[1-9]\d*$/;
                                if(regExp.test(pageValue)){
                                    if(pageValue-totalPageCount<0){
                                        window.location.href="index.jsp?pageIndex="+pageValue;
                                    }else{
                                        alert("请输入的页数小于总页数");
                                    }

                                }else{
                                    alert("请输入正整数");
                                }
                            }
                        </script>

                    </div>
                </div>
            </div>
        </div>
        <!--合作媒体-->
        <div class="main-text-box">
            <div class="main-text-box-tbg">
                <div class="main-text-box-bbg">
                    <div class="main-text-box-header">
                        <h3>合作媒体</h3>
                    </div>
                    <div class="main-text-box-content">
                      <ul class="link-text-ul clearfix">
                        <li><a href="http://www.gov.cn">中国政府网</a></li>
                      </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>           
<!--页面底部-->
<div id="footer" class="main-footer-box">
    24小时客户服务热线：010-68988888 常见问题解答 新闻热线：010-627488888<br />
    文明办网文明上网举报电话：010-627488888 举报邮箱：jubao@bj-aptech.com.cn<br />
    Coyright&copy;1999-2007 News China gov,All Right Reserved.<br />
    新闻中心版权所有
</div>
</body></html>