package com.vole.dao;

import com.vole.entity.Blogger;

/**
 * 编写者： Wu
 * Time： 2018/4/13.00:08
 * 内容：博主 Dao 接口
 */

public interface BloggerDao {

    /**
     * 根据用户名查找 Blogger
     * @param userName 用户名
     * @return 博主内容
     */
    Blogger getByUserName(String userName);

    /**
     * 查找 Blogger
     * @return 博主内容
     */
    Blogger find();


    /**
     * 更新 Blogger
     * @param blogger 博主内容
     * @return 一条数据
     */
    Integer update(Blogger blogger);
}
