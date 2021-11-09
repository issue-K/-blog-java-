package com.cl.service;

import com.cl.dao.pojo.Article;
import com.cl.dao.vo.params.Archives;
import com.cl.dao.vo.params.PageParams;
import com.cl.dao.vo.params.Result;

import java.util.List;

public interface ArticleService {
    /*
    分页查询 文章列表
     */
    Result listArticle(PageParams pageParams );

    List<Article> HotArticle(int limit);

    List<Article> NewArticle(int limit);

    List<Archives> listArchives();
}
