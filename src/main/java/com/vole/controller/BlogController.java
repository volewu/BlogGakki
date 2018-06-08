package com.vole.controller;

import com.vole.entity.Blog;
import com.vole.lucene.BlogIndex;
import com.vole.service.BlogService;
import com.vole.util.PageUtil;
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

    private BlogIndex blogIndex = new BlogIndex();

    /**
     * 请求博客详细信息
     *
     * @param id      接受传过来的 id 参数
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
            mav.addObject("keyWords", null);
        }
        mav.addObject("blog", blog);
        mav.addObject("pageCode", PageUtil.getUpAndDownPageCode(blogService.getLastBlog(id),
                blogService.getNextBlog(id),
                request.getServletContext().getContextPath()));
        mav.addObject("pageTitle", blog.getTitle());
        mav.addObject("mainPage", "foreground/blog/view.jsp");
        mav.setViewName("mainTemp");
        return mav;
    }

    /**
     *
     * @param q 参数
     * @param page 页数
     * @param request 请求
     * @return 模型和视图
     * @throws Exception e
     */
    @RequestMapping("/q")
    public ModelAndView search(@RequestParam(value = "q", required = false) String q,
                               @RequestParam(value = "page", required = false) String page, HttpServletRequest request) throws Exception {
        // 搜索页数，可以放入配置文件中去
        int pageSize = 5;
        if (StringUtil.isEmpty(page)) page = "1";
        ModelAndView mav = new ModelAndView();
        mav.addObject("pageTitle", "搜索关键字'" + q + "'结果页面");
        mav.addObject("mainPage", "foreground/blog/result.jsp");
        List<Blog> blogList = blogIndex.searchBlog(q);
        Integer toIndex = blogList.size() >= Integer.parseInt(page) * pageSize ? Integer.parseInt(page) * pageSize : blogList.size();
        mav.addObject("blogList", blogList.subList((Integer.parseInt(page) - 1) * pageSize, toIndex));
        mav.addObject("pageCode", PageUtil.genUpAndDownPageCode(Integer.parseInt(page), blogList.size(), q, pageSize,
                request.getServletContext().getContextPath()));
        mav.addObject("q", q);
        mav.addObject("resultTotal", blogList.size());
        mav.setViewName("mainTemp");
        return mav;
    }

}

