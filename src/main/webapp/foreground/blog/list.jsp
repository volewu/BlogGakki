<%--
  编写者： vole 
  Time： 2018/5/31.10:31
  内容：
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

    <div class="datas">
        <ul>
            <c:forEach var="blog" items="${blogList }">
                <li style="margin-bottom: 30px">

                    <div class="blog-holder shadow radius-full post-122 post type-post status-publish format-link hentry category-blog post_format-post-format-link" id="post-122">
                        <div class="article">
                            <h2 class="headline">
                                <span class="title"><a href="${pageContext.request.contextPath}/blog/articles/${blog.id}.html">${blog.title }</a></span>
                                <span class="info">
                                    <i class="fa fa-calendar-o"></i>
                                    发表于: <fmt:formatDate value="${blog.releaseDate }" type="date" pattern="yyyy-MM-dd HH:mm"/>
                                    |
                                    <i class="fa fa-folder-o"></i>
                                    分类于:  <a href="${pageContext.request.contextPath}/index.html?typeId=${blog.blogType.id}">${blog.blogType.typeName }</a>
                                    |
                                    <i class="fa fa-comment-o"></i>
                                    阅读: (${blog.clickHit })
                                </span>
                            </h2>
                            <div id="${blog.id}">
                            <textarea style="display:none;" placeholder="markdown语言">${blog.summary }</textarea>
                            </div>
                        </div>
                    </div>

                </li>
                <script type="text/javascript">

                    var testEditor;
                    $(function () {
                        testEditor = editormd.markdownToHTML("${blog.id}", {//注意：这里是上面DIV的id
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
            </c:forEach>
        </ul>
    </div>

<div>
    <nav>
        <ul class="pagination pagination-sm">
            ${pageCode }
        </ul>
    </nav>
</div>

