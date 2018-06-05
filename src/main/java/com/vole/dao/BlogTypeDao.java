package com.vole.dao;

import com.vole.entity.BlogType;

import java.util.List;
import java.util.Map;

/**
 * 编写者： vole
 * Time： 2018/5/30.17:16
 * 内容：博客类型 Dao 接口
 */
public interface BlogTypeDao {

    /**
     * 查询所有博客类型，以及对应的博客数量
     *
     * @return BlogType
     */
    List<BlogType> countList();

    /**
     * 根据 id 查找类型
     *
     * @param id id
     * @return BlogType
     */
    BlogType findById(Integer id);

    /**
     * 分页查询博客
     *
     * @param map map
     * @return List<BlogType>
     */
    List<BlogType> list(Map<String, Object> map);

    /**
     * 总个数
     *
     * @param map map
     * @return long
     */
    Long getTotal(Map<String, Object> map);

    /**
     * 添加备忘录类别
     * @param blogType
     * @return
     */
    Integer add(BlogType blogType);

    /**
     * 更新备忘录类别
     * @param blogType
     * @return
     */
    Integer update(BlogType blogType);

    /**
     * 删除备忘录类别
     * @param id
     * @return
     */
    Integer delete(Integer id);
}
