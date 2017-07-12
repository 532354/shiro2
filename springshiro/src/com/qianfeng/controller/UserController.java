package com.qianfeng.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by MY on 2017/7/10.
 */
@Controller
public class UserController {
    @RequestMapping("login.do")
    public String login(String account,String pwd){

        try {
            Subject user=SecurityUtils.getSubject();
            UsernamePasswordToken token=new UsernamePasswordToken(account,pwd);
            user.login(token);
            System.out.println("login");
            return "ss";

        } catch (Exception e) {
            return "login";
        }
    }
    @RequestMapping("toLogin.do")
    @ResponseBody
    public String toLogin(){
        System.out.println("toLogin");
        return "login";
    }
    @RequestMapping("toNoqx.do")
    @ResponseBody
    public String toNoqx(){
        return "noqx";
    }
    @RequiresRoles("经理")
    @RequestMapping("toRole")
    @ResponseBody
    public String toRole(){
        return "toRole";
    }
}
