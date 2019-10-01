package com.ssc.showinfo.web.controller;

import com.ssc.showinfo.biz.service.RoleService;
import com.ssc.showinfo.biz.service.TokenService;
import com.ssc.showinfo.biz.service.UserService;
import com.ssc.showinfo.common.jwt.annotation.PassToken;
import com.ssc.showinfo.common.jwt.annotation.UserLoginToken;
import com.ssc.showinfo.common.util.BaseResponse;
import com.ssc.showinfo.dao.entity.RoleInfo;
import com.ssc.showinfo.dao.entity.UserInfo;
import com.ssc.showinfo.web.entity.LoginUser;
import com.ssc.showinfo.web.entity.RegisterUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: show-info
 * @description: 登录controller类
 * @author: ssc
 * @create: 2019/9/10 15:37
 **/
@RequestMapping("api/user")
@RestController
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(LoggerFactory.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private TokenService tokenService;

    /**
     * 登录信息的验证接口
     *
     * @param userInfo
     * @return
     */
    @PostMapping
    @PassToken
    @RequestMapping("login")
    public ResponseEntity login(@RequestBody LoginUser userInfo){
        if(logger.isInfoEnabled()){
            logger.info("调用login接口，email={}，password={}",userInfo.getEmail(),userInfo.getPassword());
        }
        try{
            Map<String,Object> resultMap = new HashMap<String,Object>();
            UserInfo record = new UserInfo();
            BaseResponse<UserInfo> result = new BaseResponse<UserInfo>();
            record.setEmail(userInfo.getEmail());
            record.setPassword(userInfo.getPassword());
            UserInfo user = userService.queryOne(record);
            if(user == null){
                // 登录失败
                result.setSuccess(false);
                result.setMsg("登录失败，用户不存在！");
                result.setData(null);
                resultMap.put("result",result);
                resultMap.put("token","");
            }else{
                // 登录成功
                String token = tokenService.getToken(user);
                result.setSuccess(true);
                result.setMsg("登录成功！");
                result.setData(user);
                resultMap.put("result",result);
                resultMap.put("token",token);
            }
            return ResponseEntity.ok().body(resultMap);
        }catch (Exception e){
            logger.error("调用login接口出错",e);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    @PostMapping
    @PassToken
    @RequestMapping("register")
    public ResponseEntity register(@RequestBody RegisterUser registerUser){
        if(logger.isInfoEnabled()){
            logger.info("调用register接口，userName={}，email={}",registerUser.getName(),registerUser.getEmail());
        }
        try{
            UserInfo user = new UserInfo();
            user.setUsername(registerUser.getName());
            user.setPassword(registerUser.getPassword());
            user.setEmail(registerUser.getEmail());
            user.setState("1");
            user.setPhone("");

            RoleInfo role = new RoleInfo();
            role.setType(registerUser.getIdentity());
            role.setName(registerUser.getIdentity());
            role.setState("1");
            role.setDesc("");
            role.setRemark("");

            Integer result2 = roleService.save(role);
            Integer result1 = userService.save(user);

            if(result1 == 1 && result2 == 1){
                return ResponseEntity.status(HttpStatus.CREATED).build();
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }catch(Exception e){
            logger.error("调用register接口出错", e);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @UserLoginToken
    @GetMapping("getMessage")
    public String getMessage(){
        return "你已通过验证";
    }
}
