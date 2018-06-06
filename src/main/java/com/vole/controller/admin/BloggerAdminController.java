package com.vole.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.vole.entity.Blogger;
import com.vole.service.BloggerService;
import com.vole.service.impl.InitComponent;
import com.vole.util.DateUtil;
import com.vole.util.MD5Util;
import com.vole.util.ResponseUtil;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    @Resource
    private InitComponent initComponent;


    @RequestMapping("/find")
    @ResponseBody
    public Blogger find() throws Exception {
        return bloggerService.find();
    }

    @RequestMapping("/save")
    public Map<String, Object> save(@RequestParam(value = "imageFile") MultipartFile imageFile,
                                    Blogger blogger, HttpServletRequest request ,HttpServletResponse response) throws Exception {
        System.out.println(blogger);
        JSONObject result = new JSONObject();
        if (!imageFile.isEmpty()) {
            String filePath = request.getServletContext().getRealPath("/");
            String imageName = DateUtil.getCurrentDateStr() + "." + imageFile.getOriginalFilename().split("\\.")[1];
            imageFile.transferTo(new File(filePath + "static/userImages/" + imageName)); //在项目目录中看不到，放在 tomcat 的内存中了
            blogger.setImageName(imageName);
        }
        int resultTotal = bloggerService.update(blogger);
        result.put("success", resultTotal > 0);
        initComponent.refreshSystem(ContextLoader.getCurrentWebApplicationContext().getServletContext());
        ResponseUtil.write(response,result);
        return null;
    }

    /**
     * 修改密码
     *
     * @param newPassword 传过来的新密码
     * @return json
     * @throws Exception e
     */
    @RequestMapping("/modifyPassword")
    @ResponseBody
    public Map<String, Object> modifyPassword(String newPassword, HttpServletResponse response) throws Exception {
        JSONObject result = new JSONObject();
        Blogger blogger = new Blogger();
        blogger.setPassword(MD5Util.md5(newPassword, "vole"));
        int resultTotal = bloggerService.update(blogger);
        result.put("success", resultTotal > 0);
        ResponseUtil.write(response, result);
        return null;
    }

    /**
     * 注销
     *
     * @return 重定向到登入页面
     * @throws Exception e
     */
    @RequestMapping("/logout")
    public String logout() throws Exception {
        SecurityUtils.getSubject().logout();
        return "redirect:/login.jsp";
    }
}
