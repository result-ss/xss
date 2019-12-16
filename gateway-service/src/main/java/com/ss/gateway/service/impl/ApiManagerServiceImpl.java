package com.ss.gateway.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ss.gateway.common.exception.ExceptionUtil;
import com.ss.gateway.common.utils.Result;
import com.ss.gateway.common.utils.VerifyUtil;
import com.ss.gateway.dal.model.AddApiInfoDO;
import com.ss.gateway.manager.ApiManagerServiceManager;
import com.ss.gateway.manager.helper.ApiBaseConverter;
import com.ss.gateway.service.api.ApiManagerService;
import com.ss.gateway.service.api.model.request.AddApiReqDTO;
import com.ss.gateway.service.api.model.request.PageQueryReqDTO;
import com.ss.gateway.service.api.model.response.PageDTO;
import com.ss.gateway.service.api.model.response.PageQueryApiInfoDTO;
import com.ss.gateway.service.api.model.response.QueryApiDetailsDTO;
import com.ss.gateway.service.api.model.request.QueryApiDetailsReqDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xueshansheng
 * @date 2019/11/19 上午 10:34
 */
@Slf4j
@Service
public class ApiManagerServiceImpl implements ApiManagerService {

    @Autowired
    private ApiManagerServiceManager apiManagerServiceManager;

    /**
     * 新增接口配置
     *
     * @param addApiReqDTO
     * @return
     */
    @Override
    public Result<Boolean> addApi(AddApiReqDTO addApiReqDTO) {
        log.info("新增接口配置请求参数,{}", addApiReqDTO);
        Result<Boolean> result;
        try {
            // 参数校验
            VerifyUtil.validateObject(addApiReqDTO);
            AddApiInfoDO addApiInfoDO = ApiBaseConverter.getAddApiDOByDTO(addApiReqDTO);
            result =apiManagerServiceManager.addApiInfo(addApiInfoDO);
            log.info("新增接口配置响应参数,{}", JSONObject.toJSON(result));
        } catch (Exception e) {
            log.error("新增接口配置异常,{}", e);
            result = ExceptionUtil.doExceptionService(e);
        }
        return result;

    }

    /**
     * 查询接口详情
     *
     * @param queryApiDetailsReqDTO
     * @return
     */
    @Override
    public Result<QueryApiDetailsDTO> queryApiDetails(QueryApiDetailsReqDTO queryApiDetailsReqDTO) {
        log.info("查询接口详情请求参数,{}", queryApiDetailsReqDTO);
        Result<QueryApiDetailsDTO> result = new Result<>();
        try {
            // 参数校验
            VerifyUtil.validateObject(queryApiDetailsReqDTO);
            AddApiInfoDO addApiInfoDO = ApiBaseConverter.getQueryApiDOByDTO(queryApiDetailsReqDTO);
            AddApiInfoDO apiInfo = apiManagerServiceManager.queryApiDetails(addApiInfoDO);
            QueryApiDetailsDTO detailsDTO = ApiBaseConverter.getDetailsDTO(apiInfo);
            result.setResult(detailsDTO);
            log.info("查询接口详情响应参数,{}", JSONObject.toJSON(result));
        } catch (Exception e) {
            log.error("查询接口详情异常,{}", e);
            result = ExceptionUtil.doExceptionService(e);
        }
        return result;
    }

    /**
     * 分页查询
     *
     * @param pageQueryReqDTO
     * @return
     */
    @Override
    public Result<PageDTO<PageQueryApiInfoDTO>> queryPageApi(PageQueryReqDTO pageQueryReqDTO) {
        log.info("接口分页查询请求参数,{}", pageQueryReqDTO);
        Result<PageDTO<PageQueryApiInfoDTO>> result = new Result<>();
        try {
            // 参数校验
            VerifyUtil.validateObject(pageQueryReqDTO);
            AddApiInfoDO addApiInfoDO = ApiBaseConverter.getPageQueryApiDOByDTO(pageQueryReqDTO);
            PageDTO<PageQueryApiInfoDTO> pageQueryApiInfoDTOPageDTO = apiManagerServiceManager.queryPageApiDetails(addApiInfoDO);
            result.setResult(pageQueryApiInfoDTOPageDTO);
            log.info("接口分页查询响应参数,{}", JSONObject.toJSON(result));
        } catch (Exception e) {
            log.error("接口分页查询异常,{}", e);
            result = ExceptionUtil.doExceptionService(e);
        }
        return result;
    }
}
