package com.vole.service;

import com.vole.entity.Blogger;

/**
 * 编写者： Wu
 * Time： 2018/4/13.00:08
 * 内容：博主 service 接口
 */

public interface BloggerService {

    /**
     * 根据用户名查找 Blogger
     * @param userName
     * @return
     */
    Blogger getByUserName(String userName);
}
