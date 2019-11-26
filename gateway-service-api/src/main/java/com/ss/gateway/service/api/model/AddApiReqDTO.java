package com.ss.gateway.service.api.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;

import java.util.Date;

/**
 * @author xueshansheng
 * @date 2019/11/14 下午 4:31
 */
@Setter
@Getter
@ToString
public class AddApiReqDTO {

    /**
     * 路径
     */
    @NotNull(message = "接口路径不能为空")
    @NotBlank(message = "接口路径不能为空")
    private String url;

    /**
     * 接口名称
     */
    @NotNull(message = "接口名称不能为空")
    @NotBlank(message = "接口名称不能为空")
    private String apiName;

    /**
     * 接口服务
     */
    @NotNull(message = "接口服务不能为空")
    @NotBlank(message = "接口服务不能为空")
    private String apiService;

    /**
     * 请求参数类型
     */
    @NotNull(message = "请求参数类型不能为空")
    @NotBlank(message = "请求参数类型不能为空")
    private String requestDTO;

    /**
     * 请求方法
     */
    @NotNull(message = "请求方法不能为空")
    @NotBlank(message = "请求方法不能为空")
    private String requestMethod;

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
