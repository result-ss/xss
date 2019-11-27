package com.ss.gateway.service.api.model.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;

/**
 * @author xueshansheng
 * @date 2019/11/27 上午 10:00
 */
@Setter
@Getter
@ToString
public class PageQueryReqDTO {

    /**
     * 接口路径
     */
//    @NotNull(message = "接口路径不能为空")
//    @NotBlank(message = "接口路径不能为空")
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
     * 更新人
     */
    private String updateBy;

    /**
     * 当前页
     */
    @NotNull(message = "当前页不能为空")
    @NotBlank(message = "当前页不能为空")
    private Integer currentPage;

    /**
     * 每页条数
     */
    @NotNull(message = "每页条数不能为空")
    @NotBlank(message = "每页条数不能为空")
    private Integer pageCount;

}
