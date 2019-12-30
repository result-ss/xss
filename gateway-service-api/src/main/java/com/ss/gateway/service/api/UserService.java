package com.ss.gateway.service.api;

import com.ss.gateway.common.utils.Result;
import com.ss.gateway.service.api.model.request.LoginReqDTO;
import com.ss.gateway.service.api.model.request.UseReqDTO;

/**
 * @author xueshansheng
 * @date 2019/12/30 下午 2:39
 */
public interface UserService {

    /**
     * 登录
     *
     * @param loginReqDTO
     * @return
     */
    Result<Boolean> login(LoginReqDTO loginReqDTO);

    /**
     * 用户注册
     *
     * @param useReqDTO
     * @return
     */
    Result<Boolean> addUser(UseReqDTO useReqDTO);
}
