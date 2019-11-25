package com.ss.gateway.service.impl;

import com.ss.gateway.dal.model.AddApiInfoDO;
import com.ss.gateway.manager.ApiManagerServiceManager;
import com.ss.gateway.manager.helper.ApiBaseConverter;
import com.ss.gateway.service.api.ApiManagerService;
import com.ss.gateway.service.api.model.AddApiReqDTO;
import com.ss.gateway.service.api.model.QueryApiDetailsDTO;
import com.ss.gateway.service.api.model.QueryApiDetailsReqDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xueshansheng
 * @date 2019/11/19 上午 10:34
 */
@Service
public class ApiManagerServiceImpl implements ApiManagerService {

    @Autowired
    private ApiManagerServiceManager apiManagerServiceManager;

    @Override
    public Boolean addApi(AddApiReqDTO addApiReqDTO) {
        AddApiInfoDO addApiInfoDO = ApiBaseConverter.getAddApiDOByDTO(addApiReqDTO);
        return apiManagerServiceManager.addApiInfo(addApiInfoDO);
    }

    @Override
    public QueryApiDetailsDTO queryApiDetails(QueryApiDetailsReqDTO queryApiDetailsReqDTO) {
        return null;
    }
}
