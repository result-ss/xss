package com.ss.gateway.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ss.gateway.common.utils.Result;
import com.ss.gateway.manager.core.CoreBusinessManager;
import com.ss.gateway.service.api.CoreBusinessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author xueshansheng
 * @date 2019/12/31 下午 5:47
 */

@Service
@Slf4j
@Component
public class CoreBusinessServiceImpl implements CoreBusinessService {

    @Autowired
    private CoreBusinessManager coreBusinessManager;

    /**
     * 请求转换
     *
     * @param request
     */
    @Override
    public Result<String> doBusiness(HttpServletRequest request) {
        StopWatch sw = new StopWatch();
        log.info("开始请求的转换，需要处理的请求是，{}", request);
        sw.start();
        Result<String> result = null;
        try {
            result = coreBusinessManager.doRequestConverter(request);
            sw.stop();
            log.info("响应成功[{}],耗时[{}]ms,", result, sw.getTotalTimeMillis());
        } catch (IOException e) {
            log.info("响应失败,异常信息：[{}],耗时[{}]ms,", e, sw.getTotalTimeMillis());
            e.printStackTrace();
        }
        return result;
    }
}
