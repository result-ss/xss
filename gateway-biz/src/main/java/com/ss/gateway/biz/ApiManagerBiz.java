package com.ss.gateway.biz;

import com.ss.gateway.core.ApiManagerCore;
import com.ss.gateway.manager.model.ApiInfoBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xueshansheng
 * @date 2020/5/25 下午 7:16
 */

@Component
public class ApiManagerBiz {

    @Autowired
    private ApiManagerCore apiManagerCore;

    /**
     * 新增接口
     *
     * @param apiInfoBO
     * @return
     */
    public Boolean addApiInfo(ApiInfoBO apiInfoBO) {
        return apiManagerCore.addApiInfo(apiInfoBO);
    }

}