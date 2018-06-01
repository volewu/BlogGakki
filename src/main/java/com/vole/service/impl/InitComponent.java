package com.vole.service.impl;

import com.vole.entity.Blogger;
import com.vole.service.BlogService;
import com.vole.service.BlogTypeService;
import com.vole.service.BloggerService;
import com.vole.service.LinkService;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 编写者： vole
 * Time： 2018/5/30.15:56
 * 内容：初始化组件，用于系统缓存
 */
@Component("initComponent")
public class InitComponent implements ApplicationContextAware, ServletContextListener {

    //共享该对象
    private static ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        InitComponent.applicationContext = applicationContext;
    }

    //初始化时执行
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext application = sce.getServletContext();
        refreshSystem(application);
    }

    public void refreshSystem(ServletContext application) {
        BloggerService bloggerService = (BloggerService) applicationContext.getBean("bloggerService");
        Blogger blogger = bloggerService.find();// 获取博主信息
        blogger.setPassword(null);// 让密码为空
        application.setAttribute("blogger", blogger);

        LinkService linkService = (LinkService) applicationContext.getBean("linkService");
        application.setAttribute("linkList", linkService.list(null));// 查询所有的友情链接信息

        BlogTypeService blogTypeService = (BlogTypeService) applicationContext.getBean("blogTypeService");
        application.setAttribute("blogTypeCountList", blogTypeService.countList()); // 查询博客类别以及博客的数量

        BlogService blogService = (BlogService) applicationContext.getBean("blogService");
        application.setAttribute("blogCountList", blogService.countList()); // 根据日期分组查询博客
    }


    //销毁时执行
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
