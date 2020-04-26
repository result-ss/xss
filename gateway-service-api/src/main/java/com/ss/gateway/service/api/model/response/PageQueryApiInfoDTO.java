package com.ss.gateway.service.api.model.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author xueshansheng
 * @date 2019/11/27 上午 9:50
 */
@Setter
@Getter
@ToString
public class PageQueryApiInfoDTO {

    /**
     * 接口路径
     */
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
     * 接口状态
     */
    private String status;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private String createAt;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private String updateAt;
}
