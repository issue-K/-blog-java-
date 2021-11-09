package com.cl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.cl.dao.mapper.TagMapper;
import com.cl.dao.pojo.Tag;
import com.cl.dao.vo.params.TagVo;
import com.cl.service.TagService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagMapper tagMapper;

    public TagVo copy(Tag tag){
        TagVo tagVo = new TagVo();
        BeanUtils.copyProperties(tag,tagVo);
        return tagVo;
    }
    public List<TagVo> copyList(List<Tag> tagList){
        List<TagVo> tagVoList = new ArrayList<>();
        for (Tag tag : tagList) {
            tagVoList.add(copy(tag));
        }
        return tagVoList;
    }

    @Override
    public List<TagVo> findHotTags( int limit ) {
        List<Long> hotsTagIds = tagMapper.findHotsTagIds( limit );
        if( CollectionUtils.isEmpty( hotsTagIds ) ){
            return Collections.emptyList();
        }
        List<Tag> tagList = tagMapper.findTagsByTagIds( hotsTagIds );
        return copyList( tagList );
    }

    @Override
    public List<TagVo> findTagsByArticleId(Long id) {
        List<Tag> tags = tagMapper.findTagsByArticleId(id);
        return copyList(tags);
    }
}