<%--
  编写者： vole 
  Time： 2018/6/4.16:57
  内容：
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="data_list">
    <div class="data_list_title">
        搜索&nbsp;<font color="red">${q }</font>&nbsp;的结果 &nbsp;(总共搜索到&nbsp;${resultTotal }&nbsp;条记录)
    </div>
    <div class="datas search">
        <ul>
            <c:choose>
                <c:when test="${blogList.size()==0 }">
                    <div align="center" style="padding-top: 20px">未查询到结果，请换个关键字试试看！</div>
                </c:when>
                <c:otherwise>
                    <c:forEach var="blog" items="${blogList}">
                        <li style="margin-bottom: 20px">
                            <span class="summary"><a href="${pageContext.request.contextPath}/blog/articles/${blog.id }.html" target="_blank">${blog.title }</a></span>
                            <span class="summary">摘要:${blog.content }...</span>
                            <span class="link"><a href="${pageContext.request.contextPath}/blog/articles/${blog.id }.html">http://wuvole.com/blog/articles/${blog.id }.html</a>&nbsp;&nbsp;&nbsp;&nbsp;发布日期：${blog.releaseDateStr }</span>
                        </li>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
    ${pageCode }
</div>