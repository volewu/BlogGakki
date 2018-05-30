package com.vole.dao;

import com.vole.entity.Link;

import java.util.List;
import java.util.Map;

/**
 * 编写者： vole
 * Time： 2018/5/30.16:12
 * 内容：友情链接 Dao 接口
 */
public interface LinkDao {

    /**
     * 分页查询友情链接
     * @param map map
     * @return list
     */
    List<Link> list(Map<String, Object> map);
}
