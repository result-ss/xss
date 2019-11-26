package com.ss.gateway.service.api.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;

import java.util.Date;

/**
 * @author xueshansheng
 * @date 2019/11/15 上午 10:21
 */
@Setter
@Getter
@ToString
public class QueryApiDetailsReqDTO {

    /**
     * 接口路径
     */
    @NotNull(message = "接口路径不能为空")
    @NotBlank(message = "接口路径不能为空")
    private String url;

    /**
     * 接口名称
     */
    private String apiName;

    /**
     * 接口服务
     */
    private String apiService;

    /**
     * 请求参数
     */
    private String requestDTO;

    /**
     * 请求方法
     */
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
