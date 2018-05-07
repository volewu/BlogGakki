package com.vole.controller.admin;

import com.vole.service.BloggerService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * 编写者： Wu
 * Time： 2018/4/13.00:14
 * 内容：管理员博主 Controller 层
 */
@Controller
@RequestMapping("/admin/blogger")
public class BloggerAdminController {

    @Resource
    private BloggerService bloggerService;
}
