<%--
  编写者： vole 
  Time： 2018/5/31.15:08
  内容：
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<div class="data_list">
    <div>
        <div class="blog_title"><h3><strong>${blog.title }</strong></h3></div>
        <div class="blog_info">
            发布时间：『 <fmt:formatDate value="${blog.releaseDate }" type="date"
                                   pattern="yyyy-MM-dd HH:mm"/>』&nbsp;&nbsp;博客类别：${blog.blogType.typeName }&nbsp;&nbsp;阅读(${blog.clickHit })
        </div>
        <div class="blog_content" id="blogContent">
            <textarea style="display:none;" placeholder="markdown语言">${blog.content }</textarea>
        </div>
        <div class="blog_keyWord">
            <font><strong>关键字：</strong></font>
            <c:choose>
                <c:when test="${keyWords==null }">
                    &nbsp;&nbsp;无
                </c:when>
                <c:otherwise>
                    <c:forEach var="keyWord" items="${keyWords }">
                        &nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/blog/q.html?q=${keyWord}" target="_blank">${keyWord }</a>&nbsp;&nbsp;

                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </div>
        <div class="blog_lastAndNextPage">
            ${pageCode }
        </div>

        <!--PC和WAP自适应版-->
        <div id="SOHUCS" sid="${blog.id}" ></div>
        <script type="text/javascript">
            (function(){
                var appid = 'cytFb7kj5';
                var conf = 'prod_39f5dc70220b387583e45a508c051367';
                var width = window.innerWidth || document.documentElement.clientWidth;
                if (width < 960) {
                    window.document.write('<script id="changyan_mobile_js" charset="utf-8" type="text/javascript" src="http://changyan.sohu.com/upload/mobile/wap-js/changyan_mobile.js?client_id=' + appid + '&conf=' + conf + '"><\/script>'); } else { var loadJs=function(d,a){var c=document.getElementsByTagName("head")[0]||document.head||document.documentElement;var b=document.createElement("script");b.setAttribute("type","text/javascript");b.setAttribute("charset","UTF-8");b.setAttribute("src",d);if(typeof a==="function"){if(window.attachEvent){b.onreadystatechange=function(){var e=b.readyState;if(e==="loaded"||e==="complete"){b.onreadystatechange=null;a()}}}else{b.onload=a}}c.appendChild(b)};loadJs("http://changyan.sohu.com/upload/changyan.js",function(){window.changyan.api.config({appid:appid,conf:conf})}); } })(); </script>

    </div>
</div>

<script type="text/javascript">

    var testEditor;
    $(function () {
        testEditor = editormd.markdownToHTML("blogContent", {//注意：这里是上面DIV的id
            htmlDecode: "style,script,iframe",
            emoji: true,
            taskList: true,
            tocm: true,
            tex: true, // 默认不解析
            flowChart: true, // 默认不解析
            sequenceDiagram: true, // 默认不解析
            codeFold: true
        });
    });
</script>
