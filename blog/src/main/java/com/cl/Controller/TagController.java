package com.cl.Controller;


import com.cl.dao.vo.params.Result;
import com.cl.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tags")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("hot")
    public Result HotTags(){
        int limit = 4;//找前4个出现次数最多的
        return Result.success( tagService.findHotTags( limit ) );
    }
}