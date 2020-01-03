package com.ss.gateway.service.api.model.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.sf.oval.constraint.MemberOf;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xueshansheng
 * @date 2019/12/30 下午 2:53
 */
@Setter
@Getter
@ToString
public class UseReqDTO implements Serializable {

    /**
     * 序列ID
     */
    private static final long serialVersionUID = -3516740715495035129L;

    /**
     * 日志号
     */
    @NotNull(message = "日志号不能为空")
    @NotBlank(message = "日志号不能为空")
    private String traceLogId;

    /**
     * 推荐码
     */
    @NotBlank(message = "推荐码不能为空")
    @NotNull(message = "推荐码不能为空")
    @MemberOf(value = {"16698039803"}, message = "推荐码错误")
    private String referralCode;

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

    /**
     * 用户状态
     */
    private String userStatus;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 更新人
     */
    private String updateBy;

}
