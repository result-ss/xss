package com.ss.gateway.service.impl.convert;

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
public class ApiBaseConverter {

    /**
     * AddApiReqDTO ---> ApiInfoBO
     *
     * @param addApiReqDTO
     * @return
     */
    public static ApiInfoBO getApiBOByDTO(AddApiReqDTO addApiReqDTO) {
        if (addApiReqDTO == null) {
            return null;
        }
        ApiInfoBO apiInfoBO = new ApiInfoBO();
        apiInfoBO.setUrl(addApiReqDTO.getUrl());
        apiInfoBO.setApiName(addApiReqDTO.getApiName());
        apiInfoBO.setApiService(addApiReqDTO.getApiService());
        apiInfoBO.setRequestDTO(addApiReqDTO.getRequestDTO());
        apiInfoBO.setRequestMethod(addApiReqDTO.getRequestMethod());
        apiInfoBO.setCreateBy(addApiReqDTO.getCreateBy());
        apiInfoBO.setUpdateBy(addApiReqDTO.getUpdateBy());
        return apiInfoBO;
    }

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
        queryApiDetailsDTO.setStatus(addApiInfoDO.getStatus());
        queryApiDetailsDTO.setCreateBy(addApiInfoDO.getCreateBy());
        queryApiDetailsDTO.setCreateAt(addApiInfoDO.getCreateAt());
        queryApiDetailsDTO.setUpdateBy(addApiInfoDO.getUpdateBy());
        queryApiDetailsDTO.setUpdateAt(addApiInfoDO.getUpdateAt());
        return queryApiDetailsDTO;
    }

    /**
     * 获取查询接口详情DO
     *
     * @param pageQueryReqDTO
     * @return
     */
    public static AddApiInfoDO getPageQueryApiDOByDTO(PageQueryReqDTO pageQueryReqDTO) {
        if (pageQueryReqDTO == null) {
            return null;
        }
        AddApiInfoDO ddApiInfoDO = new AddApiInfoDO();
        ddApiInfoDO.setUrl(pageQueryReqDTO.getUrl());
        ddApiInfoDO.setApiName(pageQueryReqDTO.getApiName());
        ddApiInfoDO.setRequestDTO(pageQueryReqDTO.getRequestDTO());
        ddApiInfoDO.setApiService(pageQueryReqDTO.getApiService());
        ddApiInfoDO.setRequestMethod(pageQueryReqDTO.getRequestMethod());
        ddApiInfoDO.setCurrentPage(pageQueryReqDTO.getCurrentPage());
        ddApiInfoDO.setPageCount(pageQueryReqDTO.getPageCount());
        ddApiInfoDO.setCreateBy(pageQueryReqDTO.getCreateBy());
        ddApiInfoDO.setUpdateBy(pageQueryReqDTO.getUpdateBy());
        return ddApiInfoDO;
    }

    /**
     * 获取分页返回DTO
     *
     * @param addApiInfoDOS
     * @return
     */
    public static List<PageQueryApiInfoDTO> getPageQueryRespDTO(List<AddApiInfoDO> addApiInfoDOS) {
        if (addApiInfoDOS == null) {
            return null;
        }
        List<PageQueryApiInfoDTO> list = new ArrayList<>();
        for (AddApiInfoDO addApiInfoDO : addApiInfoDOS) {
            PageQueryApiInfoDTO pageQueryApiInfoDTO = new PageQueryApiInfoDTO();
            pageQueryApiInfoDTO.setUrl(addApiInfoDO.getUrl());
            pageQueryApiInfoDTO.setApiName(addApiInfoDO.getApiName());
            pageQueryApiInfoDTO.setApiService(addApiInfoDO.getApiService());
            pageQueryApiInfoDTO.setRequestMethod(addApiInfoDO.getRequestMethod());
            pageQueryApiInfoDTO.setStatus(addApiInfoDO.getStatus());
            pageQueryApiInfoDTO.setCreateBy(addApiInfoDO.getCreateBy());
            pageQueryApiInfoDTO.setCreateAt(addApiInfoDO.getCreateAt());
            pageQueryApiInfoDTO.setUpdateBy(addApiInfoDO.getUpdateBy());
            pageQueryApiInfoDTO.setUpdateAt(addApiInfoDO.getUpdateAt());
            list.add(pageQueryApiInfoDTO);
        }
        return list;
    }
}