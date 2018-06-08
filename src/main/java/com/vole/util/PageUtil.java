package com.vole.util;

import com.vole.entity.Blog;

/**
 * 编写者： vole
 * Time： 2018/5/31.11:19
 * 内容：分页工具类
 */
public class PageUtil {


    /**
     * 首页分页代码
     * @param targetUrl   目标地址
     * @param totalNum    总记录数
     * @param currentPage 当前页
     * @param pageSize    每页大小
     * @return s
     */
    public static String genPagination(String targetUrl, long totalNum, int currentPage, int pageSize, String param) {
        long totalPage = totalNum % pageSize == 0 ? totalNum / pageSize : totalNum / pageSize + 1;
        if (totalPage == 0) {
            return "未查询到数据";
        } else {
            StringBuffer pageCode = new StringBuffer();
            pageCode.append("<li><a href='").append(targetUrl).append("?page=1&").append(param).append("'>首页</a></li>");
            if (currentPage > 1) {
                pageCode.append("<li><a href='").append(targetUrl).append("?page=").append(currentPage - 1).append("&").append(param).append("'>上一页</a></li>");
            } else {
                pageCode.append("<li class='disabled'><a href='").append(targetUrl).append("?page=").append(currentPage - 1).append("&").append(param).append("'>上一页</a></li>");
            }
            for (int i = currentPage - 2; i <= currentPage + 2; i++) {
                if (i < 1 || i > totalPage) {
                    continue;
                }
                if (i == currentPage) {
                    pageCode.append("<li class='active'><a href='").append(targetUrl).append("?page=").append(i).append("&").append(param).append("'>").append(i).append("</a></li>");
                } else {
                    pageCode.append("<li><a href='").append(targetUrl).append("?page=").append(i).append("&").append(param).append("'>").append(i).append("</a></li>");
                }
            }
            if (currentPage < totalPage) {
                pageCode.append("<li><a href='").append(targetUrl).append("?page=").append(currentPage + 1).append("&").append(param).append("'>下一页</a></li>");
            } else {
                pageCode.append("<li class='disabled'><a href='").append(targetUrl).append("?page=").append(currentPage + 1).append("&").append(param).append("'>下一页</a></li>");
            }
            pageCode.append("<li><a href='").append(targetUrl).append("?page=").append(totalPage).append("&").append(param).append("'>尾页</a></li>");
            return pageCode.toString();
        }
    }

    /**
     * 获取上一篇博客和下一篇博客
     *
     * @param lastBlog       上一篇博客
     * @param nextBlog       下一篇博客
     * @param projectContext 请求地址
     * @return 博客首页的上下篇博客
     */
    public static String getUpAndDownPageCode(Blog lastBlog, Blog nextBlog, String projectContext) {
        StringBuffer pageCode = new StringBuffer();
        if (lastBlog == null || lastBlog.getId() == null) {
            pageCode.append("<p>上一篇：没有了</p>");
        } else {
            pageCode.append("<p>上一篇：<a href='").append(projectContext).append("/blog/articles/").append(lastBlog.getId()).append(".html'>").append(lastBlog.getTitle()).append("</a></p>");
        }

        if (nextBlog == null || nextBlog.getId() == null) {
            pageCode.append("<p>下一篇：没有了</p>");
        } else {
            pageCode.append("<p>下一篇：<a href='").append(projectContext).append("/blog/articles/").append(nextBlog.getId()).append(".html'>").append(nextBlog.getTitle()).append("</a></p>");
        }
        return pageCode.toString();
    }

    /**
     * 获取上一页，下一页代码
     *
     * @param page           当前页
     * @param totalNum       总搜索数
     * @param q              搜索参数
     * @param pageSize       页数
     * @param projectContext 地址
     * @return 博客搜索的上下页
     */
    public static String genUpAndDownPageCode(Integer page, Integer totalNum, String q, Integer pageSize, String projectContext) {
        long totalPage = totalNum % pageSize == 0 ? totalNum / pageSize : totalNum / pageSize + 1;
        StringBuffer pageCode = new StringBuffer();
        if (totalPage == 0) {
            return "";
        } else {
            pageCode.append("<nav>");
            pageCode.append("<ul class='pager'>");
            if (page > 1) {
                pageCode.append("<li><a href='").append(projectContext).append("/blog/q.html?page=").append(page - 1).append("&q=").append(q).append("'>上一页</a></li>");
            } else {
                pageCode.append("<li class='disabled'><a href='#'>上一页</a></li>");
            }
            if (page < totalPage) {
                pageCode.append("<li><a href='").append(projectContext).append("/blog/q.html?page=").append(page + 1).append("&q=").append(q).append("'>下一页</a></li>");
            } else {
                pageCode.append("<li class='disabled'><a href='#'>下一页</a></li>");
            }
            pageCode.append("</ul>");
            pageCode.append("</nav>");
        }
        return pageCode.toString();
    }
}

