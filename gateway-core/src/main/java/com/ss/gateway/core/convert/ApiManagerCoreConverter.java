package com.ss.gateway.core.convert;

import com.ss.gateway.dal.model.AddApiInfoDO;
import com.ss.gateway.manager.model.ApiInfoBO;
import com.ss.gateway.service.api.model.request.AddApiReqDTO;
import com.ss.gateway.service.api.model.request.PageQueryReqDTO;
import com.ss.gateway.service.api.model.request.QueryApiDetailsReqDTO;
import com.ss.gateway.service.api.model.response.PageQueryApiInfoDTO;
import com.ss.gateway.service.api.model.response.QueryApiDetailsDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xueshansheng
 * @date 2019/11/19 上午 11:19
 */
public class ApiManagerCoreConverter {

    /**
     * ApiInfoBO ---> AddApiInfoDO
     *
     * @param apiInfoBO
     * @return
     */
    public static AddApiInfoDO getAddApiDOByBO(ApiInfoBO apiInfoBO) {
        if (apiInfoBO == null) {
            return null;
        }
        AddApiInfoDO ddApiInfoDO = new AddApiInfoDO();
        ddApiInfoDO.setUrl(apiInfoBO.getUrl());
        ddApiInfoDO.setApiName(apiInfoBO.getApiName());
        ddApiInfoDO.setApiService(apiInfoBO.getApiService());
        ddApiInfoDO.setRequestMethod(apiInfoBO.getRequestMethod());
        ddApiInfoDO.setRequestDTO(apiInfoBO.getRequestDTO());
        ddApiInfoDO.setCreateBy(apiInfoBO.getCreateBy());
        ddApiInfoDO.setUpdateBy(apiInfoBO.getUpdateBy());
        return ddApiInfoDO;
    }

}
