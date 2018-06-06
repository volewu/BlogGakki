package com.vole.controller.admin;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.vole.entity.Link;
import com.vole.entity.PageBean;
import com.vole.service.LinkService;
import com.vole.service.impl.InitComponent;
import com.vole.util.ResponseUtil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ContextLoader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * 编写者： vole
 * Time： 2018/6/1.13:59
 * 内容：Link 后台 controller 层
 */
@Controller
@RequestMapping("/admin/link")
public class LinkAdminController {

    @Resource
    private LinkService linkService;

    @Resource
    private InitComponent initComponent;

    /**
     * 根据条件分页查询帖子友情链接
     *
     * @param page     页数
     * @param rows     大小
     * @param response 响应
     * @return null
     * @throws Exception n
     */
    @RequestMapping("/list")
    public String list(@RequestParam(value = "page", required = false) String page,
                       @RequestParam(value = "rows", required = false) String rows,
                       HttpServletResponse response) throws Exception {
        PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
        Map<String, Object> map = new HashMap<>();
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<Link> linkList = linkService.list(map);
        Long total = linkService.getTotal(map);
        JSONObject result = new JSONObject();
        String s = JSONArray.toJSONString(linkList);
        JSONArray jsonArray = JSONArray.parseArray(s);
        result.put("rows", jsonArray);
        result.put("total", total);
        ResponseUtil.write(response, result);
        return null;
    }

    /**
     * 添加或者修改帖子友情链接
     *
     * @param link     实体
     * @param response 响应
     * @return null
     * @throws Exception n
     */
    @RequestMapping("/save")
    public String save(Link link, HttpServletResponse response) throws Exception {
        int resultTotal; // 操作的记录条数
        if (link.getId() == null)  // 添加
            resultTotal = linkService.add(link);
        else
            resultTotal = linkService.update(link);
        JSONObject result = new JSONObject();
        result.put("success", resultTotal > 0);
        initComponent.refreshSystem(ContextLoader.getCurrentWebApplicationContext().getServletContext());
        ResponseUtil.write(response, result);
        return null;
    }

    /**
     * 删除友情链接
     *
     * @param ids      参数
     * @param response 响应
     * @return null
     * @throws Exception n
     */
    @RequestMapping("/delete")
    public String delete(@RequestParam(value = "ids") String ids, HttpServletResponse response) throws Exception {
        String[] idsStr = ids.split(",");
        JSONObject result = new JSONObject();
        for (String anIdsStr : idsStr) {
            linkService.delete(Integer.parseInt(anIdsStr));
        }
        initComponent.refreshSystem(ContextLoader.getCurrentWebApplicationContext().getServletContext());
        result.put("success", true);
        ResponseUtil.write(response, result);
        return null;
    }

}
