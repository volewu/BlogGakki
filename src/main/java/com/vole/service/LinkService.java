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
}
