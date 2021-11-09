package com.cl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cl.dao.mapper.ArticleMapper;
import com.cl.dao.mapper.TagMapper;
import com.cl.dao.pojo.Article;
import com.cl.dao.vo.params.ArticleVo;
import com.cl.dao.vo.params.PageParams;
import com.cl.dao.vo.params.Result;
import com.cl.service.ArticleService;
import com.cl.service.SysUserService;
import com.cl.service.TagService;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private TagService tagService;
    @Autowired
    private SysUserService sysUserService;

    @Override
    //分页查询article数据库表得到结果
    public Result listArticle(PageParams pageParams) {
        Page<Article> page = new Page<>( pageParams.getPage(),pageParams.getPageSize() );
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc( Article::getCreateDate );//按照时间倒序排序
        Page<Article> articlePage = articleMapper.selectPage( page,queryWrapper );
        List<Article> records = articlePage.getRecords();
        List<ArticleVo> articleVoList = copyList( records,true,true );

        return Result.success( articleVoList );
    }
    private List<ArticleVo> copyList( List<Article> records,boolean isTag,boolean isAuthor ){
        List<ArticleVo> articleVoList = new ArrayList<>();
        for( Article record:records ){
            articleVoList.add( copy( record,isTag,isAuthor ) );
        }
        return articleVoList;
    }
    private ArticleVo copy(Article article,boolean isTag,boolean isAuthor){
        ArticleVo articleVo = new ArticleVo();
        BeanUtils.copyProperties( article,articleVo );

        articleVo.setCreateDate( new DateTime(article.getCreateDate() ).toString("yyyy-MM-dd HH:mm") );

        if( isTag ){
            Long articleId = article.getId();
            articleVo.setTags( tagService.findTagsByArticleId( articleId ) );
        }
        if( isAuthor ) {
            Long articleId = article.getId();
            articleVo.setAuthor( sysUserService.findUserById( articleId).getNickname() );
        }
        return articleVo;
    }
}
