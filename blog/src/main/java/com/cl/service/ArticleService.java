package com.cl.service;

import com.cl.dao.vo.params.PageParams;
import com.cl.dao.vo.params.Result;

public interface ArticleService {
    /*
    分页查询 文章列表
     */
    Result listArticle(PageParams pageParams );
}
