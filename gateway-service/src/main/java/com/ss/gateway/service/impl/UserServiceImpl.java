package com.ss.gateway.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ss.gateway.common.exception.ExceptionUtil;
import com.ss.gateway.common.utils.Result;
import com.ss.gateway.common.utils.VerifyUtil;
import com.ss.gateway.dal.model.AddApiInfoDO;
import com.ss.gateway.dal.model.UserDO;
import com.ss.gateway.manager.UserServiceManager;
import com.ss.gateway.manager.helper.ApiBaseConverter;
import com.ss.gateway.manager.helper.UserInfoConverter;
import com.ss.gateway.service.api.UserService;
import com.ss.gateway.service.api.model.request.LoginReqDTO;
import com.ss.gateway.service.api.model.request.UseReqDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xueshansheng
 * @date 2019/12/30 下午 3:06
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserServiceManager userServiceManager;

    /**
     * 登录
     *
     * @param useReqDTO
     * @return
     */
    @Override
    public Result<Boolean> login(LoginReqDTO loginReqDTO) {
        log.info("用户登录请求参数,{}", loginReqDTO);
        Result<Boolean> result;
        try {
            // 参数校验
            VerifyUtil.validateObject(loginReqDTO);
            UserDO userDO = UserInfoConverter.getUserDOByLoginDTO(loginReqDTO);
            result = userServiceManager.login(userDO);
            log.info("用户登录响应参数,{}", JSONObject.toJSON(result));
        } catch (Exception e) {
            log.error("用户登录异常,{}", e);
            result = ExceptionUtil.doExceptionService(e);
        }
        return result;
    }

    /**
     * 用户注册
     *
     * @param useReqDTO
     * @return
     */
    @Override
    public Result<Boolean> addUser(UseReqDTO useReqDTO) {
        log.info("用户注册请求参数,{}", useReqDTO);
        Result<Boolean> result;
        try {
            // 参数校验
            VerifyUtil.validateObject(useReqDTO);
            UserDO userDO = UserInfoConverter.getUserDOByDTO(useReqDTO);
            result = userServiceManager.addUser(userDO);
            log.info("用户注册响应参数,{}", JSONObject.toJSON(result));
        } catch (Exception e) {
            log.error("用户注册异常,{}", e);
            result = ExceptionUtil.doExceptionService(e);
        }
        return result;
    }
}
