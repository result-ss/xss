package com.ss.gateway.dal.mapper;

import com.ss.gateway.dal.model.UserDO;
import org.springframework.stereotype.Repository;

/**
 * @author xueshansheng
 * @date 2019/12/30 下午 3:25
 */
@Repository
public interface UserMapper {

    /**
     * 用户注册
     *
     * @param userDO
     * @return
     */
    int addUser(UserDO userDO);

    /**
     * 根据登录号查询用户信息
     *
     * @param userDO
     * @return
     */
    UserDO queryUserByLoginNo(UserDO userDO);

}
