package com.ss.gateway.dal.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author xueshansheng
 * @date 2019/12/30 下午 3:11
 */
@Setter
@Getter
@ToString
public class UserDO {

    /**
     * 主键ID
     */
    private String id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 登录号
     */
    private String loginNo;

    /**
     * 用户状态
     */
    private String userStatus;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createAt;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateAt;
}
