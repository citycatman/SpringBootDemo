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
                .msg("查询成功。")
                .build();
    }
    public static AjaxResponse success(Object plant,int totalProperty){
        return AjaxResponse.builder()
                .success(true)
                .code(200)
                .plant(plant)
                .totalProperty(totalProperty)
                .msg("查询成功。")
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
}
