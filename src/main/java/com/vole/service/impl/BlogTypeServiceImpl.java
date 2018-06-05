package com.vole.service.impl;

import com.vole.dao.BlogTypeDao;
import com.vole.entity.BlogType;
import com.vole.service.BlogTypeService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

/**
 * 编写者： vole
 * Time： 2018/5/30.17:24
 * 内容：博客类别 Service 实现类
 */
@Service("blogTypeService")
public class BlogTypeServiceImpl implements BlogTypeService {

    @Resource
    private BlogTypeDao blogTypeDao;

    public List<BlogType> countList() {
        return blogTypeDao.countList();
    }

    @Override
    public List<BlogType> list(Map<String, Object> map) {
        return blogTypeDao.list(map);
    }

    @Override
    public Long getTotal(Map<String, Object> map) {
        return blogTypeDao.getTotal(map);
    }

    @Override
    public Integer add(BlogType blogType) {
        return blogTypeDao.add(blogType);
    }

    @Override
    public Integer update(BlogType blogType) {
        return blogTypeDao.update(blogType);
    }

    @Override
    public Integer delete(Integer id) {
        return blogTypeDao.delete(id);
    }
}
