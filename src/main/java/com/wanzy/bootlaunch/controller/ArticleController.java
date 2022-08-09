package com.wanzy.bootlaunch.controller;


import com.wanzy.bootlaunch.AjaxResponse;
import com.wanzy.bootlaunch.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
                .author("Zuyong Wan")
                .content("This is my first Spring boot Programing.")
                .title("My Book")
                .createTime(new Date())
                .build();
        log.info("article:" + article);

        return AjaxResponse.success(article,1);
    }
}
