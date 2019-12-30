package com.ss.gateway;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ss.gateway.common.utils.Result;
import com.ss.gateway.service.api.UserService;
import com.ss.gateway.service.api.model.request.UseReqDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xueshansheng
 * @date 2019/12/30 下午 3:37
 */
@Slf4j
public class UserInfoTest extends BaseSpringTest {

    @Autowired
    UserService userService;

    /**
     * 用户注册测试
     */
    @Test
    public void testAddUser() {
        UseReqDTO useReqDTO = new UseReqDTO();
        useReqDTO.setReferralCode("16698039806");
        useReqDTO.setUserName("c");
        useReqDTO.setPassword("123456");
        useReqDTO.setLoginNo("16621122151");
        useReqDTO.setCreateBy("ss");
        useReqDTO.setUpdateBy("ss");
        log.info("用户注册请求参数，{}", JSONObject.toJSON(useReqDTO));
        Result<Boolean> result = userService.addUser(useReqDTO);
        log.info("用户注册响应参数,{}", JSON.toJSON(result));
    }

    /**
     * 登录测试
     */
    @Test
    public void testLogin() {
        UseReqDTO useReqDTO = new UseReqDTO();
        useReqDTO.setUserName("sss");
        useReqDTO.setPassword("123456");
        useReqDTO.setLoginNo("16621122151");
        useReqDTO.setCreateBy("ss");
        useReqDTO.setUpdateBy("ss");
        log.info("用户登录请求参数，{}", JSONObject.toJSON(useReqDTO));
        Result<Boolean> result = userService.login(useReqDTO);
        log.info("用户登录响应参数,{}", JSON.toJSON(result));
    }
}
