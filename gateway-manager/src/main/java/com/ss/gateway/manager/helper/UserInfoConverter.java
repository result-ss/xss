package com.ss.gateway.manager.helper;

import com.ss.gateway.dal.model.UserDO;
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
        userDO.setPassword(useReqDTO.getPassword());
        userDO.setLoginNo(useReqDTO.getLoginNo());
        userDO.setUserStatus(useReqDTO.getUserStatus());
        userDO.setCreateBy(useReqDTO.getCreateBy());
        userDO.setUpdateBy(useReqDTO.getUpdateBy());
        return userDO;
    }
}
