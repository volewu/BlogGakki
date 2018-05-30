package com.vole.dao;

import com.vole.entity.Blog;

import java.util.List;

/**
 * 编写者： vole
 * Time： 2018/5/30.17:16
 * 内容： 博客 Dao 接口
 */
public interface BlogDao {

    /**
     * 根据日期分月分组查询
     * @return Blog
     */
     List<Blog> countList();
}
