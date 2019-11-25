package com.ss.gateway.manager.helper;

import com.ss.gateway.dal.model.AddApiInfoDO;
import com.ss.gateway.service.api.model.AddApiReqDTO;

/**
 * @author xueshansheng
 * @date 2019/11/19 上午 11:19
 */
public class ApiBaseConverter {

    public static AddApiInfoDO getAddApiDOByDTO(AddApiReqDTO addApiReqDTO){
        if(addApiReqDTO == null){
            return null;
        }
        AddApiInfoDO ddApiInfoDO = new AddApiInfoDO();
        ddApiInfoDO.setUrl(addApiReqDTO.getUrl());
        ddApiInfoDO.setApiName(addApiReqDTO.getApiName());
        ddApiInfoDO.setApiService(addApiReqDTO.getApiService());
        ddApiInfoDO.setRequestDTO(addApiReqDTO.getRequestDTO());
        ddApiInfoDO.setRequestMethod(addApiReqDTO.getRequestMethod());
        ddApiInfoDO.setCreateBy(addApiReqDTO.getCreateBy());
        ddApiInfoDO.setUpdateBy(addApiReqDTO.getUpdateBy());
        return ddApiInfoDO;
    }
}
