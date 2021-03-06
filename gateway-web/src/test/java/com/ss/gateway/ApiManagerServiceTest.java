package com.ss.gateway;

import com.ss.gateway.service.api.ApiManagerService;
import com.ss.gateway.service.api.model.AddApiReqDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xueshansheng
 * @date 2019/11/19 上午 10:31
 */
@Slf4j
public class ApiManagerServiceTest extends BaseSpringTest{

    @Autowired
    private ApiManagerService apiManagerService;

    @Test
    public void testAddApiInfo(){
        AddApiReqDTO addApiReqDTO = new AddApiReqDTO();
        addApiReqDTO.setUrl("/aa/aa/aa");
        addApiReqDTO.setApiName("流程测试");
        addApiReqDTO.setApiService("com.aa.aa.AaService");
        addApiReqDTO.setRequestDTO("com.aa.aa.req.AaDTO");
        addApiReqDTO.setRequestMethod("testA");
        addApiReqDTO.setCreateBy("ss");
        addApiReqDTO.setUpdateBy("ss");
        Boolean aBoolean = apiManagerService.addApi(addApiReqDTO);
        log.info("接口新增结果{}",aBoolean);
    }

}
