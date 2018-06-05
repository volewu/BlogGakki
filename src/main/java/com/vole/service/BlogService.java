package com.vole.service;

import com.vole.entity.Blog;

import java.util.List;
import java.util.Map;

/**
 * 编写者： vole
 * Time： 2018/5/30.17:22
 * 内容：博客 Service 接口
 */
public interface BlogService {
    /**
     * 根据日期分月分组查询
     * @return Blog
     */
    List<Blog> countList();

    /**
     * 分页查询博客
     * @param map map
     * @return list
     */
    List<Blog> list(Map<String, Object> map);

    /**
     * 获取总记录数
     * @param map map
     * @return 总记录数
     */
    Long getTotal(Map<String, Object> map);

    /**
     * 根据 id 查询博客
     * @param id
     * @return
     */
    Blog findById(Integer id);

    /**
     * 更新博客
     * @param blog
     */
    Integer update(Blog blog);

    /**
     * 获取上一个博客
     * @param id
     * @return
     */
    Blog getLastBlog(Integer id);

    /**
     * 获取下一个博客
     * @param id
     * @return
     */
    Blog getNextBlog(Integer id);

    /**
     * 添加博客
     * @param blog
     * @return
     */
    Integer add(Blog blog);

    /**
     * 删除
     * @param id 博客 id
     * @return 一条记录
     */
    Integer delete(Integer id);
}
