package com.ss.gateway.dal.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author xueshansheng
 * @date 2019/11/19 上午 10:59
 */
@Setter
@Getter
@ToString
public class AddApiInfoDO {

    private Long id;

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
