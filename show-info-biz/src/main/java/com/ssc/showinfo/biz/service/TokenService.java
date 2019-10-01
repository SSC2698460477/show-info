package com.ssc.showinfo.biz.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.ssc.showinfo.dao.entity.UserInfo;
import org.springframework.stereotype.Service;

/**
 * @program: show-info
 * @description: 生成token的service方法
 * @author: ssc
 * @create: 2019/9/29 15:48
 **/
@Service
public class TokenService {
    public String getToken(UserInfo user) {
        String token="";
        token= JWT.create().withAudience(user.getId().toString())// 将 user id 保存到 token 里面
                .sign(Algorithm.HMAC256(user.getPassword()));// 以 password 作为 token 的密钥
        return token;
    }
}
