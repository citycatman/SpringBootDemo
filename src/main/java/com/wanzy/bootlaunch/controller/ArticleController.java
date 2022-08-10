package com.wanzy.bootlaunch.controller;


import com.wanzy.bootlaunch.AjaxResponse;
import com.wanzy.bootlaunch.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@Slf4j
@RestController
public class ArticleController {
    // 根据id查询文章
    //@RequestMapping(value = "/articles/{id}",method = RequestMethod.GET)
    @GetMapping(value = "/articles/{id}")
    public AjaxResponse getArticle(@PathVariable("id") Long id){
        if(id==1){
            Article article = Article.builder()
                    .id(1L)
                    .author("Hogan Wan")
                    .content("This is my first Spring boot Programing.")
                    .title("My Book")
                    .createTime(new Date())
                    .build();
            log.info("article:" + article);
            return AjaxResponse.success(article,1);
        }else{
            return AjaxResponse.error400("{id:"+id.toString()+"}");
        }
    }

    // 新建文章
    //@RequestMapping(value = "/articles",method = RequestMethod.POST)
    @PostMapping(value = "/articles")
    public AjaxResponse saveArticle(@RequestBody Article article){
        log.info("article:" + article);
        return AjaxResponse.success(article,1);
    }

    // 修改文章v1 by @RequestBody
    //@RequestMapping(value = "/articles",method = RequestMethod.PUT)
    @PutMapping(value = "/articles")
    public AjaxResponse updateArticle(@RequestBody Article article,
                                      @RequestHeader String token){
        if(article.getId() == null){
            return AjaxResponse.error400(article);
        }else{
            log.info("article:" + article);
            log.info("token:" + token);
            return AjaxResponse.success(article,1);
        }
    }
    // 修改文章v2 by @RequestParam
    @PutMapping(value = "/articles/v2")
    public AjaxResponse updateArticle(@RequestParam String author,
                                      @RequestParam Long id,
                                      @RequestParam String content,
                                      @RequestParam String title,
                                      @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                                      @RequestParam Date createTime){
        log.info("update article time: " + createTime);

        return AjaxResponse.success();
    }

    // 删除文章
    //@RequestMapping(value ="/articles/{id}",method = RequestMethod.DELETE)
    @DeleteMapping(value = "/articles/{id}")
    public AjaxResponse deleteArticle(@PathVariable("id") Long id){
        if(id == null){
            return AjaxResponse.error400("object id is null");
        }else{
            log.info("Delete done: article id =>" + id.toString());
            return AjaxResponse.success("Delete done: article id =>" + id.toString());
        }
    }
}
