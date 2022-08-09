package com.wanzy.bootlaunch.controller;


import com.wanzy.bootlaunch.model.UserModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(String name){
        UserModel user = new UserModel();
        user.FirstNameEn = "Wan";
        user.LastNameEn = "Hogan";
        return "Hello World: 【 " + user.UserNameEn() + " 】!";
    }
}
