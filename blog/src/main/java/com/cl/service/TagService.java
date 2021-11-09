package com.cl.service;

import com.cl.dao.vo.params.TagVo;

import java.util.List;

public interface TagService {
    List<TagVo> findTagsByArticleId( Long articleId );

    List<TagVo> findHotTags( int limit );
}
