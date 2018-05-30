package com.vole.service;

import com.vole.entity.BlogType;

import java.util.List;

/**
 * 编写者： vole
 * Time： 2018/5/30.17:21
 * 内容：博客类型 Service 接口
 */
public interface BlogTypeService {

    /**
     * 查询所有博客类型，以及对应的博客数量
     * @return BlogType
     */
    List<BlogType> countList();
}
