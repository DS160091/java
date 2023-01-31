package com.shiro.ds.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class MyController {
    @RequestMapping({"/","/index"})
    public String toIndex(Model model){
        model.addAttribute("msg","shiro");
        return "index";
    }

    @RequestMapping("/user/add")
    public String toAdd(){
        return "user/add";
    }

    @RequestMapping("/user/update")
    public String toUpdate(){
        return "user/update";
    }

    @RequestMapping("/tologin")
    public String tologin(){
        System.out.println("跳转登录");
        return "login";
    }

    @RequestMapping("/login")
    public String login1(String username,String password,Model model){
//        获取用户对象
        Subject subject = SecurityUtils.getSubject();
        System.out.println("用户对象已经获取");
//        封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
//        执行登陆方法
        try{
//            System.out.println("1");
            subject.login(token);
            model.addAttribute("result","登录成功");
            return "index";
        }catch (UnknownAccountException ue){
//            System.out.println("2");
//            ue.printStackTrace();
            model.addAttribute("result","用户名错误！");
            return "login";
        }catch (IncorrectCredentialsException ie){
            model.addAttribute("result","密码错误");
            return "login";
        }

    }

//    @RequestMapping("/unauth")
//    public String unautho(){
//        return "unauthc";
//    }


    @RequestMapping("/unauth")
    @ResponseBody
    public String unautho(){
        return "未授权页面啊哈";
    }


}
