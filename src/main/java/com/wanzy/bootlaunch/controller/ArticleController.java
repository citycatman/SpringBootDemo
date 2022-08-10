package com.wanzy.bootlaunch.controller;


import com.wanzy.bootlaunch.AjaxResponse;
import com.wanzy.bootlaunch.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@Slf4j
@RestController
public class ArticleController {
    // 根据id查询文章
    @RequestMapping(value = "/articles/{id}",method = RequestMethod.GET)
    public AjaxResponse getArticle(@PathVariable("id") Long id){
        Article article = Article.builder()
                .id(1L)
                .author("Hogan Wan")
                .content("This is my first Spring boot Programing.")
                .title("My Book")
                .createTime(new Date())
                .build();
        log.info("article:" + article);

        return AjaxResponse.success(article,1);
    }

    // 新建文章
    @RequestMapping(value = "/articles",method = RequestMethod.POST)
    public AjaxResponse saveArticle(@RequestBody Article article){
        log.info("article:" + article);
        return AjaxResponse.success(article,1);
    }

    // 修改文章
    @RequestMapping(value = "/articles",method = RequestMethod.PUT)
    public AjaxResponse updateArticle(@RequestBody Article article){
        if(article.getId() == null){
            return AjaxResponse.error400(article);
        }else{
            log.info("article:" + article);
            return AjaxResponse.success(article,1);
        }
    }

    // 删除文章
    @RequestMapping(value ="/articles/{id}",method = RequestMethod.DELETE)
    public AjaxResponse deleteArticle(@PathVariable Long id){
        if(id == null){
            return AjaxResponse.error400("object id is null");
        }else{
            log.info("Delete done: article id =>" + id.toString());
            return AjaxResponse.success("Delete done: article id =>" + id.toString());
        }
    }
}
