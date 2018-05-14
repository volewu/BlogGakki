<%--
  User: vole
  Date: 2018/5/14 21:58
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/blog.css">
    <script src="${pageContext.request.contextPath}/static/bootstrap3/js/jquery-1.11.2.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap3/js/bootstrap.min.js" type="text/javascript"></script>
    <title>博主主页</title>
    <style type="text/css">
        body{
            padding-top: 10px;
            padding-bottom: 40px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-4">
            <div align="left" ><font color="black" size="6"> 伍记备忘录 </font>
            </div>
        </div>
        <div class="col-md-8">
            <iframe style="float: right;" width="420" scrolling="no" height="60" frameborder="0" allowtransparency="true" src="http://i.tianqi.com/index.php?c=code&id=12&icon=1&num=5"></iframe>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12" style="padding-top: 10px">
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#"><font color="black"><strong>首页</strong></font></a>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li><a href="#"><font color="black"><strong>关于博主</strong></font></a></li>
                            <li><a href="#"><font color="black"><strong>本站源码下载</strong></font></a></li>
                        </ul>
                        <form class="navbar-form navbar-right" role="search">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="请输入要查询的关键字...">
                            </div>
                            <button type="submit" class="btn btn-default">搜索</button>
                        </form>
                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->
            </nav>
        </div>
    </div>

    <div class="row">
        <div class="col-md-9">
            <div class="data_list">
                <div class="data_list_title">
                    <img src="${pageContext.request.contextPath}/static/images/list_icon.png"/>
                    最新博客</div>

                <div class="datas">
                    <ul>
                        <li style="margin-bottom: 30px">
                            <span class="date"><a href="${pageContext.request.contextPath}/blog/articles/52.html">2016年02月15日</a></span>
                            <span class="title"><a href="${pageContext.request.contextPath}/blog/articles/52.html">使用CXF开发WebService客户端</a></span>
                            <span class="summary">摘要: 前面一讲开发了webservice服务器端接口，今天的话，我们来开发webservice客户端，让大家来体验下过程；首先建一个Maven项目，项目名字，WS_Client；然后我们要用CXF给我们提供的工具wsdl2java 来根据请求的url生成客户端代码；wsdl2java工具在CXF开发包里；开发下载地...</span>
                            <span class="img">

						  		<a href="/blog/articles/52.html"><img src="${pageContext.request.contextPath}/static/userImages/a.jpg" alt="1455539511890048174.jpg"></a>
						  		&nbsp;&nbsp;

						  		<a href="/blog/articles/52.html"><img alt="QQ鎴浘20160215203213.jpg" src="${pageContext.request.contextPath}/static/userImages/c.png" title="1455539700734093102.jpg"></a>
						  		&nbsp;&nbsp;

						  		<a href="/blog/articles/52.html"><img alt="QQ鎴浘20160215203317.jpg" src="${pageContext.request.contextPath}/static/userImages/c.png" title="1455539761187019902.jpg"></a>
						  		&nbsp;&nbsp;

					  	</span>
                            <span class="info">发表于 2016-02-15 21:06 阅读(71) 评论(5) </span>

                        </li>
                        <hr style="height:5px;border:none;border-top:1px dashed gray;padding-bottom:  10px;" />

                    </ul>
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="data_list">
                <div class="data_list_title">
                    <img src="${pageContext.request.contextPath}/static/images/user_icon.png"/>
                    博主信息
                </div>
                <div class="user_image">
                    <img src="${pageContext.request.contextPath}/static/userImages/me.jpg"/>
                </div>
                <div class="nickName">vole</div>
                <div class="userSign">(知识改变命运，技术改变世界)</div>
            </div>

            <div class="data_list">
                <div class="data_list_title">
                    <img src="${pageContext.request.contextPath}/static/images/byType_icon.png"/>
                    按日志类别
                </div>
                <div class="datas">
                    <ul>

                        <li><span><a href="/index.html?typeId=1">Java核心基础(1)</a></span></li>

                        <li><span><a href="/index.html?typeId=2">Mysql(1)</a></span></li>

                        <li><span><a href="/index.html?typeId=3">Tomcat(1)</a></span></li>

                        <li><span><a href="/index.html?typeId=10">jsoup(1)</a></span></li>

                        <li><span><a href="/index.html?typeId=7">shiro(1)</a></span></li>

                        <li><span><a href="/index.html?typeId=9">webservice(2)</a></span></li>

                        <li><span><a href="/index.html?typeId=4">IT之路(3)</a></span></li>

                        <li><span><a href="/index.html?typeId=5">随心生活(2)</a></span></li>

                    </ul>
                </div>
            </div>



            <div class="data_list">
                <div class="data_list_title">
                    <img src="${pageContext.request.contextPath}/static/images/byDate_icon.png"/>
                    按日志日期
                </div>
                <div class="datas">
                    <ul>

                        <li><span><a href="/index.html?releaseDateStr=2016年02月">2016年02月(11)</a></span></li>

                        <li><span><a href="/index.html?releaseDateStr=2016年01月">2016年01月(1)</a></span></li>

                    </ul>
                </div>
            </div>

            <div class="data_list">
                <div class="data_list_title">
                    <img src="${pageContext.request.contextPath}/static/images/link_icon.png"/>
                    友情链接
                </div>
                <div class="datas">
                    <ul>

                        <li><span><a href="http://www.java1234.com/" target="_blank">Java知识分享网</a></span></li>

                        <li><span><a href="http://pan.java1234.com/" target="_blank">百度云搜索引擎</a></span></li>

                        <li><span><a href="http://www.easyicon.net/" target="_blank">小图标下载</a></span></li>

                        <li><span><a href="http://tieba.baidu.com/f?kw=java" target="_blank">Java贴吧</a></span></li>

                        <li><span><a href="http://www.uugai.com/" target="_blank">免费logo在线制作</a></span></li>

                    </ul>
                </div>
            </div>

        </div>
    </div>

    <div class="row">
        <div class="col-md-12" >
            <div align="center" style="padding-top: 120px" >
                <span style="float: left;">Powered by <a  href="http://wuvole.com" target="_blank">伍记备忘录</a> V1.0</span>
                Copyright © 2018-20?? 伍记 版权所有
            </div>
        </div>
    </div>


</div>
</body>
</html>