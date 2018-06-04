package com.vole.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.vole.entity.Blog;
import com.vole.lucene.BlogIndex;
import com.vole.service.BlogService;
import com.vole.service.impl.InitComponent;
import com.vole.util.DateUtil;
import com.vole.util.ResponseUtil;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * 编写者： vole
 * Time： 2018/6/1.16:15
 * 内容：博客内容后台 controller
 */
@Controller
@RequestMapping("/admin/blog")
public class BlogAdminController {

    @Resource
    private BlogService blogService;

    @Resource
    private InitComponent initComponent;

    private BlogIndex blogIndex = new BlogIndex();

    @RequestMapping("/save")
    public String save(Blog blog, HttpServletResponse response) throws Exception {
        int resultTotal; // 操作的记录条数
        if (blog.getId() == null) { // 添加
            resultTotal = blogService.add(blog);
            blogIndex.addIndex(blog);
        } else { // 修改
            resultTotal = blogService.update(blog);
        }
        JSONObject result = new JSONObject();
        if (resultTotal > 0) {
            result.put("success", true);
        } else {
            result.put("success", false);
        }
        initComponent.refreshSystem(ContextLoader.getCurrentWebApplicationContext().getServletContext());
        ResponseUtil.write(response, result);
        return null;
    }

    @RequestMapping("/uploadimg")
    @ResponseBody
    public Map<String, Object> editormdPic(@RequestParam(value = "editormd-image-file", required = false) MultipartFile file,
                                           HttpServletResponse response) throws Exception {
        JSONObject result = new JSONObject();
        String fileName = file.getOriginalFilename();// 获取文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));// 获取文件的后缀
        String newFileName = DateUtil.getCurrentDateStr() + suffixName;
        try {
            String UPLOADED_FOLDER = "E:\\githubSample\\BlogGakki\\src\\main\\webapp\\static\\userImages\\";
            FileUtils.copyInputStreamToFile(file.getInputStream(),
                    new File(UPLOADED_FOLDER + newFileName));
            result.put("success", 1);
            result.put("message", "上传成功！");
            result.put("url", "http://localhost:5555/static/userImages/" + newFileName);
        } catch (Exception e) {
            result.put("success", 0);
            result.put("message", "上传失败！");
            e.printStackTrace();
        }
        ResponseUtil.write(response, result);
        return null;
    }

}
