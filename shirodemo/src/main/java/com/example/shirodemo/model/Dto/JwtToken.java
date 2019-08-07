package com.example.shirodemo.model.Dto;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @ Author kn
 * @ Description
 * @ Date 2019/8/6 15:35
 */
public class JwtToken implements AuthenticationToken {
    private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
