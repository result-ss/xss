package com.ss.gateway;

import com.alibaba.fastjson.JSONObject;
import com.ss.gateway.common.utils.Result;
import com.ss.gateway.service.api.ApiManagerService;
import com.ss.gateway.service.api.model.request.AddApiReqDTO;
import com.ss.gateway.service.api.model.request.PageQueryReqDTO;
import com.ss.gateway.service.api.model.response.PageDTO;
import com.ss.gateway.service.api.model.response.PageQueryApiInfoDTO;
import com.ss.gateway.service.api.model.response.QueryApiDetailsDTO;
import com.ss.gateway.service.api.model.request.QueryApiDetailsReqDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DecimalFormat;
import java.util.UUID;

/**
 * @author xueshansheng
 * @date 2019/11/19 上午 10:31
 */
@Slf4j
public class ApiManagerServiceTest extends BaseSpringTest {

    @Autowired
    private ApiManagerService apiManagerService;

    /**
     * 新增接口配置测试
     */
    @Test
    public void testAddApiInfo() {
        AddApiReqDTO addApiReqDTO = new AddApiReqDTO();
        addApiReqDTO.setTraceLogId(UUID.randomUUID().toString());
        addApiReqDTO.setUrl("/aa/aa/aac");
        addApiReqDTO.setApiName("新的测试2");
        addApiReqDTO.setApiService("com.aa.aa.AaService");
        addApiReqDTO.setRequestDTO("com.aa.aa.req.AaDTO");
        addApiReqDTO.setRequestMethod("testA");
        addApiReqDTO.setCreateBy("ss");
        addApiReqDTO.setUpdateBy("ss");
        Result<Boolean> result = apiManagerService.addApi(addApiReqDTO);
        log.info("接口新增结果{}", JSONObject.toJSON(result));
    }

    /**
     * 接口详情查询测试
     */
    @Test
    public void testQueryApiInfo() {
        QueryApiDetailsReqDTO queryApiDetailsReqDTO = new QueryApiDetailsReqDTO();
        queryApiDetailsReqDTO.setTraceLogId(UUID.randomUUID().toString());
        queryApiDetailsReqDTO.setUrl("/aa/aa/aac0");
//        queryApiDetailsReqDTO.setApiName("流程测试3");
//        queryApiDetailsReqDTO.setApiService("com.aa.aa.AaService");
//        queryApiDetailsReqDTO.setRequestDTO("com.aa.aa.req.AaDTO");
//        queryApiDetailsReqDTO.setRequestMethod("testA");
//        queryApiDetailsReqDTO.setCreateBy("ss");
//        queryApiDetailsReqDTO.setUpdateBy("ss");
        Result<QueryApiDetailsDTO> result = apiManagerService.queryApiDetails(queryApiDetailsReqDTO);
        log.info("接口详情查询结果{}", JSONObject.toJSON(result));
    }

    /**
     * 接口分页查询测试
     */
    @Test
    public void testPageQuery() {
        PageQueryReqDTO pageQueryReqDTO = new PageQueryReqDTO();
        pageQueryReqDTO.setTraceLogId(UUID.randomUUID().toString());
        pageQueryReqDTO.setCurrentPage(1);
        pageQueryReqDTO.setPageCount(3);
        Result<PageDTO<PageQueryApiInfoDTO>> result = apiManagerService.queryPageApi(pageQueryReqDTO);
        log.info("接口分页查询结果{}", JSONObject.toJSON(result));
    }


    @Test
    public void test() {
        int a = 20;
        int b = 33;
    }

    @Test
    public void getTableTag() {
        String entityType = "BANKCARD";
        String entityNo = "128";
        int i = entityNo.hashCode();
        if (entityType.equals("BANKCARD")) {
            String format = new DecimalFormat("00").format(Math.abs((long) i) % 64);
            log.info("result------>{}", format);
        } else {
            String format = new DecimalFormat("00").format(Long.parseLong(entityNo) % 64);
            log.info("result------>{}", format);
        }
    }


}
