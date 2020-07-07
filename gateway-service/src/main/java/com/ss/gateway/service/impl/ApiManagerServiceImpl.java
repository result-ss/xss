package com.ss.gateway.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import com.ss.gateway.biz.ApiManagerBiz;
import com.ss.gateway.common.exception.ExceptionUtil;
import com.ss.gateway.common.utils.Result;
import com.ss.gateway.common.utils.VerifyUtil;
import com.ss.gateway.dal.model.AddApiInfoDO;
import com.ss.gateway.manager.ApiManagerServiceManager;
import com.ss.gateway.manager.model.ApiInfoBO;
import com.ss.gateway.service.api.ApiManagerService;
import com.ss.gateway.service.api.model.request.AddApiReqDTO;
import com.ss.gateway.service.api.model.request.PageQueryReqDTO;
import com.ss.gateway.service.api.model.response.PageDTO;
import com.ss.gateway.service.api.model.response.PageQueryApiInfoDTO;
import com.ss.gateway.service.api.model.response.QueryApiDetailsDTO;
import com.ss.gateway.service.api.model.request.QueryApiDetailsReqDTO;
import com.ss.gateway.service.impl.convert.ApiBaseConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xueshansheng
 * @date 2019/11/19 上午 10:34
 */
@Slf4j
@Service
@Component
public class ApiManagerServiceImpl implements ApiManagerService {

    @Autowired
    private ApiManagerServiceManager apiManagerServiceManager;

    @Autowired
    private ApiManagerBiz apiManagerBiz;

    /**
     * 新增接口配置
     *
     * @param addApiReqDTO
     * @return
     */
    @Override
    public Result<Boolean> addApi(AddApiReqDTO addApiReqDTO) {
        log.info("新增接口配置请求参数,{}", addApiReqDTO);
        Result<Boolean> result = new Result<>();
        Long begin = System.currentTimeMillis();
        try {
            // 参数校验
            VerifyUtil.validateObject(addApiReqDTO);
            ApiInfoBO apiInfoBO = ApiBaseConverter.getApiBOByDTO(addApiReqDTO);
            Boolean aBoolean = apiManagerBiz.addApiInfo(apiInfoBO);
            result.setResult(aBoolean);
            Long end = System.currentTimeMillis();
            log.info("新增接口配置成功，耗时{}ms，响应参数{}", (end - begin), JSONObject.toJSON(result));
        } catch (Exception e) {
            Long end = System.currentTimeMillis();
            log.error("新增接口配置发生异常耗时{}ms，响应参数{},异常信息{}", (end - begin), result, e);
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
        Long begin = System.currentTimeMillis();
        try {
            // 参数校验
            VerifyUtil.validateObject(queryApiDetailsReqDTO);
            AddApiInfoDO addApiInfoDO = ApiBaseConverter.getQueryApiDOByDTO(queryApiDetailsReqDTO);
            AddApiInfoDO apiInfo = apiManagerServiceManager.queryApiDetails(addApiInfoDO);
            QueryApiDetailsDTO detailsDTO = ApiBaseConverter.getDetailsDTO(apiInfo);
            result.setResult(detailsDTO);
            Long end = System.currentTimeMillis();
            log.info("查询接口详情成功，耗时{}ms，响应参数{}", (end - begin), JSONObject.toJSON(result));
        } catch (Exception e) {
            Long end = System.currentTimeMillis();
            log.error("查询接口详情发生异常耗时{}ms，响应参数{},异常信息{}", (end - begin), result, e);
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