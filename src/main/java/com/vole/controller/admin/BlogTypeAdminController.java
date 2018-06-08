package com.vole.controller.admin;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.vole.entity.BlogType;
import com.vole.entity.PageBean;
import com.vole.service.BlogService;
import com.vole.service.BlogTypeService;
import com.vole.service.impl.InitComponent;
import com.vole.util.ConstantUtil;
import com.vole.util.ResponseUtil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * 编写者： vole
 * Time： 2018/6/5.16:25
 * 内容：管理员博客类别 Controller 层
 */
@Controller
@RequestMapping("/admin/blogType")
public class BlogTypeAdminController {

    @Resource
    private BlogTypeService blogTypeService;

    @Resource
    private BlogService blogService;

    @Resource
    private InitComponent initComponent;

    /**
     * 分页查询博客类别信息
     *
     * @param page     页数
     * @param rows     总数
     * @param response 响应
     * @return json
     * @throws Exception e
     */
    @RequestMapping("/list")
    public String list(@RequestParam(value = "page", required = false) String page,
                       @RequestParam(value = "rows", required = false) String rows,
                       HttpServletResponse response) throws Exception {
        PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
        Map<String, Object> map = new HashMap<>();
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<BlogType> blogTypeList = blogTypeService.list(map);
        Long total = blogTypeService.getTotal(map);
        JSONObject result = new JSONObject();
        String s = JSONArray.toJSONString(blogTypeList);
        JSONArray jsonArray = JSONArray.parseArray(s);
        result.put("rows", jsonArray);
        result.put("total", total);
        ResponseUtil.write(response, result);
        return null;
    }

    /**
     * /**
     * 添加或者修改博客类别信息
     *
     * @param blogType 博客类别
     * @param response 响应
     * @return json
     * @throws Exception e
     */
    @RequestMapping("/save")
    public String save(BlogType blogType, HttpServletResponse response) throws Exception {
        int resultTotal;
        if (blogType.getId() == null)
            resultTotal = blogTypeService.add(blogType);
        else
            resultTotal = blogTypeService.update(blogType);
        JSONObject result = new JSONObject();
        result.put("success", resultTotal > 0);
        ResponseUtil.write(response, result);
        initComponent.refreshSystem(ContextLoader.getCurrentWebApplicationContext().getServletContext());
        return null;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Map<String, Object> delete(@RequestParam(value = "ids", required = false) String ids) throws Exception {
        Map<String, Object> result = new HashMap<>();
        String[] idsStr = ids.split(",");
        for (String anIds : idsStr) {
            Integer typeId = Integer.parseInt(anIds);
            if (blogService.getBlogByTypeId(typeId) > 0)
                result.put("exist", ConstantUtil.DELETE_EXIST);
            else
                blogTypeService.delete(typeId);
        }
        initComponent.refreshSystem(ContextLoader.getCurrentWebApplicationContext().getServletContext());
        result.put("success", true);
        return result;
    }
}
