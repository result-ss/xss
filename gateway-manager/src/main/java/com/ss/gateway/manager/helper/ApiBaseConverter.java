package com.ss.gateway.manager.helper;

import com.ss.gateway.dal.model.AddApiInfoDO;
import com.ss.gateway.service.api.model.AddApiReqDTO;
import com.ss.gateway.service.api.model.QueryApiDetailsDTO;
import com.ss.gateway.service.api.model.QueryApiDetailsReqDTO;

/**
 * @author xueshansheng
 * @date 2019/11/19 上午 11:19
 */
public class ApiBaseConverter {

    /**
     * 获取新增接口DO
     *
     * @param addApiReqDTO
     * @return
     */
    public static AddApiInfoDO getAddApiDOByDTO(AddApiReqDTO addApiReqDTO) {
        if (addApiReqDTO == null) {
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

    /**
     * 获取查询接口详情DO
     *
     * @param queryApiDetailsReqDTO
     * @return
     */
    public static AddApiInfoDO getQueryApiDOByDTO(QueryApiDetailsReqDTO queryApiDetailsReqDTO) {
        if (queryApiDetailsReqDTO == null) {
            return null;
        }
        AddApiInfoDO ddApiInfoDO = new AddApiInfoDO();
        ddApiInfoDO.setUrl(queryApiDetailsReqDTO.getUrl());
        ddApiInfoDO.setApiName(queryApiDetailsReqDTO.getApiName());
        ddApiInfoDO.setRequestDTO(queryApiDetailsReqDTO.getRequestDTO());
        ddApiInfoDO.setApiService(queryApiDetailsReqDTO.getApiService());
        ddApiInfoDO.setRequestMethod(queryApiDetailsReqDTO.getRequestMethod());
        ddApiInfoDO.setCreateBy(queryApiDetailsReqDTO.getCreateBy());
        ddApiInfoDO.setUpdateBy(queryApiDetailsReqDTO.getUpdateBy());
        return ddApiInfoDO;
    }

    /**
     * 获取查询接口详情DTO
     *
     * @param addApiInfoDO
     * @return
     */
    public static QueryApiDetailsDTO getDetailsDTO(AddApiInfoDO addApiInfoDO) {
        if (addApiInfoDO == null) {
            return null;
        }
        QueryApiDetailsDTO queryApiDetailsDTO = new QueryApiDetailsDTO();
        queryApiDetailsDTO.setUrl(addApiInfoDO.getUrl());
        queryApiDetailsDTO.setApiName(addApiInfoDO.getApiName());
        queryApiDetailsDTO.setRequestDTO(addApiInfoDO.getRequestDTO());
        queryApiDetailsDTO.setApiService(addApiInfoDO.getApiService());
        queryApiDetailsDTO.setRequestMethod(addApiInfoDO.getRequestMethod());
        queryApiDetailsDTO.setCreateBy(addApiInfoDO.getCreateBy());
        queryApiDetailsDTO.setCreateAt(addApiInfoDO.getCreateAt());
        queryApiDetailsDTO.setUpdateBy(addApiInfoDO.getUpdateBy());
        queryApiDetailsDTO.setUpdateAt(addApiInfoDO.getUpdateAt());
        return queryApiDetailsDTO;
    }
}
