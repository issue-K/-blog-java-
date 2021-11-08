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

    @PostMapping()
    public Result listArticle(@RequestBody PageParams pageParams){
        System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkk");
        System.out.println(  pageParams.toString() );
        return articleService.listArticle( pageParams );
    }
}
