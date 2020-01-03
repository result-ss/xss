package com.ss.gateway.service.api.model.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;

import java.io.Serializable;

/**
 * @author xueshansheng
 * @date 2019/12/30 下午 5:12
 */
@Setter
@Getter
@ToString
public class LoginReqDTO implements Serializable {

    /**
     * 序列ID
     */
    private static final long serialVersionUID = 5593148184388518352L;

    /**
     * 日志号
     */
    @NotNull(message = "日志号不能为空")
    @NotBlank(message = "日志号不能为空")
    private String traceLogId;

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    @NotNull(message = "用户名不能为空")
    private String userName;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    @NotNull(message = "密码不能为空")
    private String password;

    /**
     * 登录号
     */
    @NotBlank(message = "登录号不能为空")
    @NotNull(message = "登录号不能为空")
    private String loginNo;

}
