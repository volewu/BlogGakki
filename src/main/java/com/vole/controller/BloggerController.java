package com.vole.controller;

import com.vole.entity.Blogger;
import com.vole.util.ConstantUtil;
import com.vole.util.MD5Util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 编写者： Wu
 * Time： 2018/4/13.00:35
 * 内容：博主 Controller 层
 */

@Controller
@RequestMapping("/blogger")
public class BloggerController {

    @RequestMapping("/login")
    public String login(Blogger blogger, HttpServletRequest request) {
        UsernamePasswordToken token = new UsernamePasswordToken(blogger.getUserName(),
                MD5Util.md5(blogger.getPassword(), "vole"));
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return "redirect:/admin/main.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("blogger", blogger);
            request.setAttribute("errorInfo", ConstantUtil.LOGIN_ERROR_INFO);
            return "login";
        }
    }

    /**
     * 关于在下
     * @return 模型与视图
     * @throws Exception e
     */
    @RequestMapping("/aboutMe")
    public ModelAndView aboutMe()throws Exception{
        ModelAndView mav=new ModelAndView();
        mav.addObject("pageTitle", ConstantUtil.ABOUT_ME);
        mav.addObject("mainPage", "foreground/blogger/info.jsp");
        mav.setViewName("mainTemp");
        return mav;
    }
}
