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
     * @return 博客内容
     */
    Blogger find();
}
