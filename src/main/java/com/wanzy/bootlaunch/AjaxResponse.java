package com.wanzy.bootlaunch;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AjaxResponse {
    private boolean success;
    private int code;
    private String msg;
    private Object plant;
    private Object items;
    private int totalProperty;

    public static AjaxResponse success(Object plant){
        return AjaxResponse.builder()
                .success(true)
                .code(200)
                .plant(plant)
                .msg("请求响应成功。")
                .build();
    }
    public static AjaxResponse success(Object plant,int totalProperty){
        return AjaxResponse.builder()
                .success(true)
                .code(200)
                .plant(plant)
                .totalProperty(totalProperty)
                .msg("请求响应成功。")
                .build();
    }

    public static AjaxResponse success(Object plant,int totalProperty,String msg){
        return AjaxResponse.builder()
                .success(true)
                .code(200)
                .plant(plant)
                .totalProperty(totalProperty)
                .msg(msg)
                .build();
    }

    public static AjaxResponse error400(Object error){
        return AjaxResponse.builder()
                .success(false)
                .code(400)
                .plant(error)
                .totalProperty(0)
                .msg("请求参数错误！")
                .build();
    }

    public static AjaxResponse error500(Object error){
        return AjaxResponse.builder()
                .success(false)
                .code(500)
                .plant(error)
                .totalProperty(0)
                .msg("服务器错误，请联系管理员！")
                .build();
    }
}
