package com.vole.service.impl;

import com.vole.dao.BloggerDao;
import com.vole.entity.Blogger;
import com.vole.service.BloggerService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 编写者： Wu
 * Time： 2018/4/13.00:11
 * 内容：博主 service 实现类
 */
@Service("bloggerService")
public class BloggerServiceImpl implements BloggerService {

    @Resource
    private BloggerDao bloggerDao ;

    public Blogger getByUserName(String userName) {
        return bloggerDao.getByUserName(userName);
    }

    public Blogger find() {
        return bloggerDao.find();
    }

    @Override
    public Integer update(Blogger blogger) {
        return bloggerDao.update(blogger);
    }
}
