package com.qianfeng.action;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

/**
 * Created by MY on 2017/7/10.
 */
public class JdbcShiro {
    public static void login(){

        try {
            IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro.ini");
            SecurityManager manager = factory.getInstance();
            SecurityUtils.setSecurityManager(manager);
            Subject user =SecurityUtils.getSubject();
            //令牌
            UsernamePasswordToken token = new UsernamePasswordToken("aa", "aa");
            user.login(token);
            boolean b = user.isAuthenticated();
           System.out.println(b);
           boolean bo=user.hasRole("经理");
            System.out.println(bo);
        }catch ( Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        login();
    }
}
