package com.ss.gateway.manager.helper;

import com.ss.gateway.common.utils.MD5Util;
import com.ss.gateway.dal.model.UserDO;
import com.ss.gateway.service.api.model.request.LoginReqDTO;
import com.ss.gateway.service.api.model.request.UseReqDTO;

/**
 * @author xueshansheng
 * @date 2019/12/30 下午 3:17
 */
public class UserInfoConverter {

    /**
     * 获取UserDO
     *
     * @param useReqDTO
     * @return
     */
    public static UserDO getUserDOByDTO(UseReqDTO useReqDTO) {
        if (useReqDTO == null) {
            return null;
        }
        UserDO userDO = new UserDO();
        userDO.setUserName(useReqDTO.getUserName());
        userDO.setPassword(MD5Util.stringMD5(useReqDTO.getPassword()));
        userDO.setLoginNo(useReqDTO.getLoginNo());
        userDO.setUserStatus(useReqDTO.getUserStatus());
        userDO.setCreateBy(useReqDTO.getCreateBy());
        userDO.setUpdateBy(useReqDTO.getUpdateBy());
        return userDO;
    }

    /**
     * 获取登录DO
     * @param loginReqDTO
     * @return
     */
    public static UserDO getUserDOByLoginDTO(LoginReqDTO loginReqDTO) {
        if (loginReqDTO == null) {
            return null;
        }
        UserDO userDO = new UserDO();
        userDO.setUserName(loginReqDTO.getUserName());
        userDO.setPassword(MD5Util.stringMD5(loginReqDTO.getPassword()));
        userDO.setLoginNo(loginReqDTO.getLoginNo());
        return userDO;
    }

}