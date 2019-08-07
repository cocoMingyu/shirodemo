package com.example.shirodemo.config.shiro;

import com.example.shirodemo.model.Dto.JwtToken;
import com.example.shirodemo.model.dao.Users;
import com.example.shirodemo.service.UserService;
import com.example.shirodemo.utils.JwtUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ Author kn
 * @ Description
 * @ Date 2019/8/3 16:56
 */
public class AuthRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;


    /**
     * 大坑！，必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Users user = (Users) principalCollection.fromRealm(this.getClass().getName()).iterator().next();
        List<Integer> role = userService.getRoleByUserid(user.getId());
        List<String> collect = role.stream().map(a -> {
            String s = a.toString();
            return s;
        }).collect(Collectors.toList());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(collect);
        return info;
    }

    //认证登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getPrincipal();
        if (token!=null){
            String username = JwtUtil.getUsername(token);
            if (username == null) {
                throw new AuthenticationException("token invalid");
            }
            Users user = userService.getUserByName(username);
            if (user==null){
                throw new AuthenticationException("User didn't existed!");
            }
            if (! JwtUtil.verify(token,user.getId())) {
                throw new AuthenticationException("Username or password error");
            }
            return new SimpleAuthenticationInfo(user.getNickname(),user.getId(),this.getClass().getName());
        }
        return null;
    }

    /**
     * 设置认证加密方式
     */
    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        JwtCredentialsMatch jwtCredentialsMatch = new JwtCredentialsMatch();
        super.setCredentialsMatcher(jwtCredentialsMatch);
    }
}
