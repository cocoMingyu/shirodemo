package com.example.shirodemo.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * @ Author kn
 * @ Description
 * @ Date 2019/8/5 20:54
 */
public class JwtUtil {
    private static final String secret="lvkenan";
    // 过期时间5分钟
    private static final long EXPIRE_TIME = 50*60*1000;

    /**
     * 校验token是否正确
     * @param token 密钥
     * @param userid 用户id
     * @return 是否正确
     */
    public static boolean verify(String token, Integer userid) {
        try {
            Integer jwtUserid = getUserid(token);
            return userid.equals(jwtUserid);
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     * @return token中包含的用户名
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    public static Integer getUserid(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("userid").asInt();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 生成签名,5min后过期
     * @param username 用户名
     * @param id  用户ID
     * @return 加密的token
     */
    public static String sign(String username,Integer id) {
        try {
            Date date = new Date(System.currentTimeMillis()+EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            // 附带username信息
            return JWT.create()
                    .withClaim("username", username)
                    .withClaim("userid", id)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }
}
