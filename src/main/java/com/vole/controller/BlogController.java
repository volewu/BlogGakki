package com.vole.controller;

import com.vole.entity.Blog;
import com.vole.lucene.BlogIndex;
import com.vole.service.BlogService;
import com.vole.util.StringUtil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 编写者： vole
 * Time： 2018/5/31.15:02
 * 内容：博客 Controller 层
 */
@Controller
@RequestMapping("/blog")
public class BlogController {

    @Resource
    private BlogService blogService;

    private BlogIndex blogIndex=new BlogIndex();

    /**
     * 请求博客详细信息
     * @param id 接受传过来的 id 参数
     * @param request 请求
     * @return ModelAndView
     * @throws Exception s
     */
    @RequestMapping("/articles/{id}")
    public ModelAndView details(@PathVariable("id") Integer id, HttpServletRequest request) throws Exception {
        ModelAndView mav = new ModelAndView();
        Blog blog = blogService.findById(id);
        blog.setClickHit(blog.getClickHit() + 1);
        blogService.update(blog);
        String keyWords = blog.getKeyWord();
        if (StringUtil.isNotEmpty(keyWords)) {
            String arr[] = keyWords.split(" ");
            mav.addObject("keyWords", StringUtil.filterWhite(Arrays.asList(arr)));
        } else {
            mav.addObject("keyWords",null);
        }
        mav.addObject("blog", blog);
        mav.addObject("pageCode", this.getUpAndDownPageCode(blogService.getLastBlog(id),
                blogService.getNextBlog(id),
                request.getServletContext().getContextPath()));
        mav.addObject("pageTitle", blog.getTitle());
        mav.addObject("mainPage", "foreground/blog/view.jsp");
        mav.setViewName("mainTemp");
        return mav;
    }

    /**
     * 获取上一篇博客和下一篇博客
     * @param lastBlog 上一篇博客
     * @param nextBlog 下一篇博客
     * @param projectContext 请求地址
     * @return
     */
    private String getUpAndDownPageCode(Blog lastBlog, Blog nextBlog, String projectContext) {
        StringBuffer pageCode = new StringBuffer();
        if (lastBlog == null || lastBlog.getId() == null) {
            pageCode.append("<p>上一篇：没有了</p>");
        } else {
            pageCode.append("<p>上一篇：<a href='" + projectContext + "/blog/articles/" + lastBlog.getId() + ".html'>" + lastBlog.getTitle() + "</a></p>");
        }

        if (nextBlog == null || nextBlog.getId() == null) {
            pageCode.append("<p>下一篇：没有了</p>");
        } else {
            pageCode.append("<p>下一篇：<a href='" + projectContext + "/blog/articles/" + nextBlog.getId() + ".html'>" + nextBlog.getTitle() + "</a></p>");
        }
        return pageCode.toString();
    }


    @RequestMapping("/q")
    public ModelAndView search(@RequestParam(value = "q",required = false) String q)throws Exception{
        ModelAndView mav=new ModelAndView();
        mav.addObject("pageTitle", "搜索关键字'"+q+"'结果页面");
        mav.addObject("mainPage", "foreground/blog/result.jsp");
        List<Blog> blogList=blogIndex.searchBlog(q);
        mav.addObject("blogList", blogList);
        mav.addObject("q", q);
        mav.addObject("resultTotal", blogList.size());
        mav.setViewName("mainTemp");
        return mav;
    }
}

