<%--
  User: vole
  Date: 2018/5/14 21:58
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>${pageTitle }</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/blog.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/editor-md/css/editormd.preview.css"/>
    <script src="${pageContext.request.contextPath}/static/bootstrap3/js/jquery-1.11.2.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap3/js/bootstrap.min.js" type="text/javascript"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/static/editor-md/lib/marked.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/editor-md/lib/prettify.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/editor-md/lib/raphael.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/editor-md/lib/underscore.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/editor-md/lib/sequence-diagram.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/editor-md/lib/flowchart.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/editor-md/lib/jquery.flowchart.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/editor-md/js/editormd.min.js"></script>

    <style type="text/css">
        body {
            padding-top: 0px;
            padding-bottom: 40px;
        }
    </style>
</head>
<body background="${pageContext.request.contextPath}/static/userImages/${blogger.imageName}">

<jsp:include page="/foreground/common/menu.jsp"/>

<div class="container" style="padding-top: 100px">


    <div class="row">
        <div class="col-md-9">
            <jsp:include page="${mainPage }"/>
        </div>


        <div class="col-md-3">
            <div class="data_list">
                <div class="data_list_title">
                    <%--<img src="${pageContext.request.contextPath}/static/images/user_icon.png"/>--%>
                   About Me
                </div>
                <div class="user_image">
                    <img src="${pageContext.request.contextPath}/static/userImages/${blogger.imageName}"/>
                </div>
                <div class="nickName">${blogger.nickName}</div>
                <div class="slogan">${blogger.slogan}</div>
            </div>

            <div class="data_list">
                <div class="data_list_title">
                    Tags
                </div>
                <div class="datas">
                    <ul>
                        <c:forEach var="blogTypeCount" items="${blogTypeCountList }">
                            <li><span><a
                                    href="${pageContext.request.contextPath}/index.html?typeId=${blogTypeCount.id}">${blogTypeCount.typeName}(${blogTypeCount.blogCount})</a></span>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>


            <div class="data_list">
                <div class="data_list_title">
                  Archives
                </div>
                <div class="datas">
                    <ul>
                        <c:forEach var="blogCount" items="${blogCountList }">
                            <li><span><a
                                    href="${pageContext.request.contextPath}/index.html?releaseDateStr=${blogCount.releaseDateStr}">${blogCount.releaseDateStr }(${blogCount.blogCount })</a></span>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>

            <div class="data_list">
                <div class="data_list_title">
                    Links
                </div>
                <div class="datas">
                    <ul>
                        <c:forEach var="link" items="${linkList }">
                            <li><span><a href="${link.linkUrl}" target="_blank">${link.linkName}</a></span>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>

        </div>
    </div>

    <jsp:include page="/foreground/common/foot.jsp"/>


</div>
</body>
</html>