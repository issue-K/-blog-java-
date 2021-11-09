package com.cl.Controller;


import com.cl.dao.vo.params.PageParams;
import com.cl.dao.vo.params.Result;
import com.cl.service.ArticleService;
import com.cl.service.impl.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping()  //返回文章概述显示在页面上,类似csdn的个人首页,一条一条记录下来
    public Result listArticle(@RequestBody PageParams pageParams){
        return articleService.listArticle( pageParams );
    }

    @PostMapping("hot")
    public Result HotArticle(){
        int limit = 3;
        return Result.success( articleService.HotArticle(limit) );
    }

    @PostMapping("new")
    public Result NewArticle(){
        int limit = 3;
        return Result.success( articleService.NewArticle(limit) );
    }
    @PostMapping("listArchives")
    public Result listArchives(){
        return Result.success( articleService.listArchives() );
    }
}