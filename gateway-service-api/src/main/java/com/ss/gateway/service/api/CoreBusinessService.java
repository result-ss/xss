package com.ss.gateway.service.api;

import com.ss.gateway.common.utils.Result;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xueshansheng
 * @date 2019/12/31 下午 5:41
 */
public interface CoreBusinessService {

    /**
     * 请求转换
     *
     * @param req
     */
    Result<String> doBusiness(HttpServletRequest req);

}