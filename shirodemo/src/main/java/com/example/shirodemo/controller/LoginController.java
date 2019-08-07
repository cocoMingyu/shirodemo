package com.example.shirodemo.controller;

import com.example.shirodemo.model.Dto.LoginDto;
import com.example.shirodemo.model.ResponseBean;
import com.example.shirodemo.model.dao.Users;
import com.example.shirodemo.service.UserService;
import com.example.shirodemo.utils.JwtUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @ Author kn
 * @ Description
 * @ Date 2019/8/5 11:22
 */
@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseBean login(@RequestBody Users user){
        ResponseBean<Object> bean = new ResponseBean<>();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getNickname(), user.getPassword());
        try {
            subject.login(token);
            bean=ResponseBean.successed("登陆成功");
        } catch (IncorrectCredentialsException e) {
            bean=ResponseBean.failed( 501,"密码错误");
        } catch (LockedAccountException e) {
            bean=ResponseBean.failed(502, "登录失败，该用户已被冻结");
        } catch (AuthenticationException e) {
            bean=ResponseBean.failed(503, "该用户不存在");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    @PostMapping("/jwtlogin")
    public ResponseBean jwtLogin(@Valid @RequestBody LoginDto dto){
        Users user = userService.getUserByName(dto.getNickname());
        if (user.getPassword().equals(dto.getPassword())){
            return ResponseBean.successed("登陆成功", JwtUtil.sign(dto.getNickname(),user.getId()));
        }
        return ResponseBean.failed(504,"账号密码错误");
    }

    @GetMapping("/unlogin")
    public ResponseBean unLogin(){
        return ResponseBean.failed(504,"请登录");
    }

    @GetMapping("/user/info")
    public ResponseBean userInfo(@RequestParam("name")String name){
        System.out.println("SESSION ID = " + SecurityUtils.getSubject().getSession().getId());
        System.out.println("用户名：" + SecurityUtils.getSubject().getPrincipal());
        System.out.println("HOST：" + SecurityUtils.getSubject().getSession().getHost());
        System.out.println("TIMEOUT ：" + SecurityUtils.getSubject().getSession().getTimeout());
        System.out.println("START：" + SecurityUtils.getSubject().getSession().getStartTimestamp());
        System.out.println("LAST：" + SecurityUtils.getSubject().getSession().getLastAccessTime());
        Users user = userService.getUserByName(name);
        if (user==null){
            return ResponseBean.failed(500,"未找到用户");
        }
        return ResponseBean.successed(user);
    }
}
