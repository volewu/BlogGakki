<%--
  编写者： vole 
  Time： 2018/5/31.10:31
  内容：
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="data_list">
    <div class="data_list_title">
        <img src="${pageContext.request.contextPath}/static/images/list_icon.png"/>
        最新博客</div>

    <div class="datas">
        <ul>
            <c:forEach var="blog" items="${blogList }">
                <li style="margin-bottom: 30px">
                    <span class="date"><a href="${pageContext.request.contextPath}/blog/articles/${blog.id}.html"><fmt:formatDate value="${blog.releaseDate }" type="date" pattern="yyyy年MM月dd日"/></a></span>
                    <span class="title"><a href="${pageContext.request.contextPath}/blog/articles/${blog.id}.html">${blog.title }</a></span>
                    <span class="summary" id="doc-content">
                        摘要: ${blog.summary }...
                        <%-- todo: 后期更改为 editor-md --%>
                         <textarea style="display:none;" placeholder="markdown语言">${blog.summary }</textarea>
                    </span>
                    <%--<span class="img">--%>
					  		<%--<c:forEach var="image" items="${blog.imageList }">--%>
                                <%--<a href="/blog/articles/52.html">${image}</a>--%>
                                <%--&nbsp;&nbsp;--%>
                            <%--</c:forEach>--%>
                    <%--</span>--%>
                    <span class="info">发表于 <fmt:formatDate value="${blog.releaseDate }" type="date" pattern="yyyy-MM-dd HH:mm"/> 阅读(${blog.clickHit }) </span>

                </li>
                <hr style="height:5px;border:none;border-top:1px dashed gray;padding-bottom:  10px;" />
            </c:forEach>
        </ul>
    </div>
</div>

<div>
    <nav>
        <ul class="pagination pagination-sm">
            ${pageCode }
        </ul>
    </nav>
</div>

<script type="text/javascript">
    editormd.markdownToHTML("content");

    var testEditor;
    $(function () {
        testEditor = editormd.markdownToHTML("doc-content", {//注意：这里是上面DIV的id
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