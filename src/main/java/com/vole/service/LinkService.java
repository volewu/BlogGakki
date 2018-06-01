package com.vole.service;

import com.vole.entity.Link;

import java.util.List;
import java.util.Map;

/**
 * 编写者： vole
 * Time： 2018/5/30.16:22
 * 内容：友情链接 Service
 */
public interface LinkService {

    /**
     * 分页查询友情链接
     * @param map map
     * @return list
     */
    List<Link> list(Map<String, Object> map);

    /**
     * 获取总记录数
     * @param map
     * @return
     */
    Long getTotal(Map<String,Object> map);

    /**
     * 添加友情链接
     * @param link
     * @return
     */
    Integer add(Link link);

    /**
     * 修改友情链接
     * @param link
     * @return
     */
    Integer update(Link link);

    /**
     * 删除友情链接
     * @param id
     * @return
     */
    Integer delete(Integer id);
}
