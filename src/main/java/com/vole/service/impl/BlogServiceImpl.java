package com.vole.service.impl;

import com.vole.dao.BlogDao;
import com.vole.entity.Blog;
import com.vole.service.BlogService;

import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.Resource;

/**
 * 编写者： vole
 * Time： 2018/5/30.17:23
 * 内容：博客 Service 实现类
 */
@Service("blogService")
public class BlogServiceImpl implements BlogService {

    @Resource
    private BlogDao blogDao;

    public List<Blog> countList() {
        return blogDao.countList();
    }
}
