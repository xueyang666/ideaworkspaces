package com.springboot.homework.springbootdemo01.entity;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.springframework.validation.BindingResult;

/**
 * <p>
 * 定义一个异常信息类
 * </p>
 *
 * @author YANGXUE01@hand-china.com 2019/12/5  19:04
 */
public class ErrorMessage {
    
    private  String  message;

    public String getMessage() {
        return message;
    }

    public String getMessage(String 用户id不能为空) {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public void setMessage(BindingResult br) {
        this.message = br.getAllErrors().get(0).getDefaultMessage();
    }

}
