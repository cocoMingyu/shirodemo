package com.example.shirodemo.config.shiro;

import com.example.shirodemo.utils.JwtUtil;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.springframework.stereotype.Component;

/**
 * @ Author kn
 * @ Description 自定义shiro密码比较器，
 * @ Date 2019/8/7 10:21
 */

public class JwtCredentialsMatch extends SimpleCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        String jwtToken = (String) token.getCredentials();
        Integer userid = JwtUtil.getUserid(jwtToken);
        if (userid!=null){
            Integer id = (Integer) info.getCredentials();
            return userid.equals(id);
        }
        return false;
    }
}
