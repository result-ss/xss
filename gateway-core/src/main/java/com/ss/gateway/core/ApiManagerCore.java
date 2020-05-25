package com.ss.gateway.core;

import com.ss.gateway.common.enums.CommonErrorCode;
import com.ss.gateway.common.exception.BusinessException;
import com.ss.gateway.common.utils.Result;
import com.ss.gateway.core.convert.ApiManagerCoreConverter;
import com.ss.gateway.dal.mapper.ApiManagerInfoMapper;
import com.ss.gateway.dal.model.AddApiInfoDO;
import com.ss.gateway.manager.ApiManagerServiceManager;
import com.ss.gateway.manager.model.ApiInfoBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xueshansheng
 * @date 2020/5/25 下午 7:21
 */
@Slf4j
@Component
public class ApiManagerCore {

    @Autowired
    private ApiManagerServiceManager apiManagerServiceManager;

    /**
     * 新增接口
     *
     * @param apiInfoBO
     * @return
     */
    public Boolean addApiInfo(ApiInfoBO apiInfoBO) {
        return apiManagerServiceManager.addApiInfo(ApiManagerCoreConverter.getAddApiDOByBO(apiInfoBO));
    }
}
