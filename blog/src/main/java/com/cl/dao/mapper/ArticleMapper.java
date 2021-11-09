package com.cl.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cl.dao.pojo.Article;
import com.cl.dao.vo.params.Archives;

import java.util.List;

public interface ArticleMapper extends BaseMapper<Article> {
    List<Archives> listArchives();
}