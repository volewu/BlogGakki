package com.vole.dao;

import com.vole.entity.BlogType;

import java.util.List;

/**
 * 编写者： vole
 * Time： 2018/5/30.17:16
 * 内容：博客类型 Dao 接口
 */
public interface BlogTypeDao {

    /**
     * 查询所有博客类型，以及对应的博客数量
     * @return BlogType
     */
    List<BlogType> countList();

    /**
     * 根据 id 查找类型
     * @param id id
     * @return BlogType
     */
    BlogType findById(Integer id);
}
