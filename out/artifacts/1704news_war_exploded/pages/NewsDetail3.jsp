<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>吴尊六一与小朋友一起过</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/common.css">
</head>
<body>
<!--页面的头部-->
<div id="header">
    <!--页面顶部-->
    <div class="main-top">
        <div class="logo"><a href=""><span>新闻大视野</span></a></div>
        <div class="login-box">
            <%
                Object objUser =session.getAttribute("user");
                if(objUser!=null){
                    out.println("欢迎您："+objUser.toString());
                    out.println(session.getId());
                }else{
            %>
            <label>用户名</label><input type="text" name="uname" /><label>密码</label><input type="text" name="upassword" /><button>登录</button>
            <%}%>
        </div>
        <!--导航-->
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
    <div class="main-banner"><img src="<%=request.getContextPath() %>/images/4.png" /></div>
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
<!--页面的主体-->
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
                    <div class="left-box-header"><h3>最新新闻</h3></div>
                    <div class="left-box-content">
                        <ul>
                            <li><a href="#">相信未来义演</a></li>
                            <li><a href="#">赌王何鸿燊去世</a></li>
                            <li><a href="#">罗志祥周扬青分手</a></li>
                            <li><a href="#">有我陪你线上音乐节</a></li>
                            <li><a href="#">阿娇赖弘国离婚</a></li>
                            <li><a href="#">绿洲星闻联播</a></li>
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
                            <li><a href="#">如何强迫孩子过儿童节</a></li>
                            <li><a href="#">《2020微信聊天能力测试》（成人版）</a></li>
                            <li><a href="#">12张图了解不堪入目的当代年轻人</a></li>
                            <li><a href="#">UNINE自曝月入百万 是持久力最强男团</a></li>
                            <li><a href="#">肖战发新歌获内地榜冠军 罗志祥周扬青情断</a></li>
                            <li><a href="#">神话成员Junjin参加节目 公开与准新娘的爱情故事</a></li>
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
            <div class="article-place"><a href="#">新闻中心</a> > <a href="#">国内</a></div>
            <div class="main-text-box-tbg">
                <div class="main-text-box-bbg">
                    <div class="article-box">
                        <!--新闻的标题-->
                        <%String title = "吴尊\"六一\"与小朋友一起";%>
                        <h1><%=title%></h1>
                        <div class="source-bar">
                            <%String author = "小g童鞋";%>
                            发布者：<%=author%> 分类：新闻信息 更新时间：
                            <%
                                Date date = new Date();
                                String time = new SimpleDateFormat("yyyy-MM-dd").format(date);
                            %>
                            <%=time %>

                        </div>
                        <div class="article-content">
                            <span class="article-summary"><b>摘要：</b><%out.print("吴尊儿童节快乐当回“小孩” 晒一双儿女萌照感慨多");%></span>
                            <p>
<%--                                <img src="<%=request.getContextPath() %>/images/news-3.jpg" />--%>
                                <%out.print("  6月1日，吴尊在微博晒出和小朋友们一起玩耍的照片，<br/>以及NeiNei和Max从小到大的萌照，<br/>写道：“小时候很想赶快长大...长大后，最想当个小孩！ <br/>但长大后，也很难保持一颗童心...好奇，善良，纯真，阳光...<br/>很感恩有NeiNei，Max跟很多可爱的小朋友们把我拉回当个小孩！</br>" +
                                    "每个人在父母的心中永远都是小孩...小朋友大朋友们，儿童节快乐。”" );%>
<%--                                <img src="<%=request.getContextPath() %>/images/news-2.jpg" />--%>
                            </P>
                        </div>
                        <div class="comment">
                            <dl>
                                <dt class="comment-top">
                                    <span class="fr">2011-09-25 13:33:55</span>
                                    <b>1楼</b> <b>水上漂</b>
                                </dt>
                                <dd class="comment-body">
                                    可爱的neinei和max！
                                </dd>
                            </dl>
                            <dl>
                                <dt class="comment-top">
                                    <span class="fr">2011-09-25 13:33:55</span>
                                    <b>2楼</b> <b>拉娜</b>
                                </dt>
                                <dd class="comment-body">
                                    长大了也想变成小孩子了！
                                </dd>
                            </dl>
                        </div>
                        <div class="comment-form">
                            <div class="comment-form-header">
                                <span>用户：Landod</span>
                                <h3>发表评论：</h3>
                            </div>
                            <div class="comment-form-content">
                                <textarea class="comment-textarea"></textarea>
                                <button type="submit" class="comment-btn">评论</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--//-->

    </div>
</div>
<!--页面底部-->
<div class="main-footer-box">
    24小时客户服务热线：010-68988888 常见问题解答 新闻热线：010-627488888<br />
    文明办网文明上网举报电话：010-627488888 举报邮箱：jubao@kgc.com.cn<br />
    Coyright&copy;1999-2007 News China gov,All Right Reserved.<br />
    新闻中心版权所有
</div>
</body>
</html>