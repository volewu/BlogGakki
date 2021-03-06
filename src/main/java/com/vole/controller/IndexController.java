package com.vole.controller;

import com.vole.entity.Blog;
import com.vole.entity.PageBean;
import com.vole.service.BlogService;
import com.vole.util.ConstantUtil;
import com.vole.util.PageUtil;
import com.vole.util.StringUtil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 编写者： vole
 * Time： 2018/5/31.10:37
 * 内容：主页 Controller
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @Resource
    private BlogService blogService;


    @RequestMapping("/index")
    public ModelAndView index(@RequestParam(value = "page", required = false) String page,
                              @RequestParam(value = "typeId", required = false) String typeId,
                              @RequestParam(value = "releaseDateStr", required = false) String releaseDateStr,
                              HttpServletRequest request) throws Exception {
        ModelAndView mav = new ModelAndView();
        if (StringUtil.isEmpty(page)) page = "1";
        PageBean pageBean = new PageBean(Integer.parseInt(page), 10);
        Map<String, Object> map = new HashMap<>();
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        map.put("typeId", typeId);
        map.put("releaseDateStr", releaseDateStr);
        List<Blog> blogList = blogService.list(map);
        mav.addObject("blogList", blogList);
        mav.addObject("pageTitle", ConstantUtil.BLOG_NAME);
        StringBuffer param = new StringBuffer();
        if (StringUtil.isNotEmpty(typeId))
            param.append("typeId=" + typeId);

        if (StringUtil.isNotEmpty(releaseDateStr))
            param.append("releaseDateStr=" + releaseDateStr);

        mav.addObject("pageCode", PageUtil.genPagination(
                request.getContextPath() + "/index.html",
                blogService.getTotal(map),
                Integer.parseInt(page),
                10,
                param.toString()));
        mav.addObject("mainPage", "foreground/blog/list.jsp");
        mav.setViewName("mainTemp");
        return mav;
    }
}
