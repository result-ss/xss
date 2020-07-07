package com.ss.gateway.manager;

import com.ss.gateway.common.enums.CommonErrorCode;
import com.ss.gateway.common.utils.Result;
import com.ss.gateway.dal.mapper.UserMapper;
import com.ss.gateway.dal.model.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xueshansheng
 * @date 2019/12/30 下午 3:10
 */
@Component
public class UserServiceManager {

    @Autowired
    private UserMapper userMapper;

    /**
     * 登录
     *
     * @param userDO
     * @return
     */
    public Result<Boolean> login(UserDO userDO) {
        UserDO user = userMapper.queryUserByLoginNo(userDO);
        if (user == null) {
            return new Result<>(CommonErrorCode.USER_NON_EXISTENT.getDesc(), CommonErrorCode.USER_NON_EXISTENT.getCode());
        }
        if (!user.getPassword().equals(userDO.getPassword())) {
            return new Result<>(CommonErrorCode.PASSWORD_ERROR.getDesc(), CommonErrorCode.PASSWORD_ERROR.getCode());
        }
        return new Result<>(true);
    }

    /**
     * 用户注册
     *
     * @param userDO
     * @return
     */
    public Result<Boolean> addUser(UserDO userDO) {
        UserDO user = userMapper.queryUserByLoginNo(userDO);
        if (user != null) {
            return new Result<>(CommonErrorCode.USER_EXISTENT.getDesc(), CommonErrorCode.USER_EXISTENT.getCode());
        }
        return new Result<>(userMapper.addUser(userDO) > 0);
    }
    
}