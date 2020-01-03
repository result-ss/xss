package com.ss.gateway.manager.core;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ss.gateway.common.enums.CommonErrorCode;
import com.ss.gateway.common.utils.Result;
import com.ss.gateway.dal.mapper.ApiManagerInfoMapper;
import com.ss.gateway.dal.model.AddApiInfoDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xueshansheng
 * @date 2020/1/2 上午 11:14
 */
@Component
@Slf4j
public class CoreBusinessManager {

    @Autowired
    private ApiManagerInfoMapper apiManagerInfoMapper;

    /**
     * 请求装换
     *
     * @param request
     */
    public Result<String> doRequestConverter(HttpServletRequest request) throws IOException {

        // 获取请求路径
        String uri = request.getRequestURI();
        // 根据路径查询接口信息
        AddApiInfoDO addApiInfoDO = new AddApiInfoDO();
        addApiInfoDO.setUrl(uri);
        log.info("查询接口信息，{}", uri);
        AddApiInfoDO apiInfo = apiManagerInfoMapper.selectOneApiInfo(addApiInfoDO);
        if (apiInfo == null) {
            return new Result<>(CommonErrorCode.API_NON_EXISTENT.getDesc(), CommonErrorCode.API_NON_EXISTENT.getCode());
        }
        // 获取请求参数
        BufferedReader br = request.getReader();
        String str, data = "";
        while ((str = br.readLine()) != null) {
            data += str;
        }
        log.info("上游请求参数，{}", data);
        Object o = requestBusiness(apiInfo, data);
        String string = JSONObject.toJSON(o).toString();
        return new Result<>(string);
    }

    /**
     * 调用服务
     * @param apiInfo
     * @param data
     * @return
     */
    public static Object requestBusiness(AddApiInfoDO apiInfo, String data) {
        ReferenceConfig<GenericService> reference = new ReferenceConfig<GenericService>();
        // 当前dubbo consumer的application配置，不设置会直接抛异常
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("ss_test_service");
        // 注册中心配置
        RegistryConfig registryConfig = new RegistryConfig();
        // 注册中心这里需要配置上注册中心协议，例如下面的zookeeper
        registryConfig.setAddress("zookeeper://49.234.116.249:2181");
//        registryConfig.setAddress("zookeeper://172.17.45.14:2181");
//        registryConfig.setGroup("test_group");
        reference.setApplication(applicationConfig);
        reference.setRegistry(registryConfig);
        // 设置调用的reference属性，下面只设置了协议、接口名、版本、超时时间
        reference.setProtocol("dubbo");
//        reference.setInterface(apiInfo.getApiService());
        reference.setInterface(apiInfo.getApiService());
//        reference.setId("fileManagementService");
//        reference.setVersion("1.0.0");
        reference.setTimeout(3000);
        // 声明为泛化接口
        reference.setGeneric(true);
        // 封装请求map
        Map maps = (Map) JSONObject.parse(data);
        String[] type = new String[maps.size()];
        for (int i = 0; i < maps.size(); i++) {
            type[i] = "java.lang.String"+"";
        }
        // GenericService可以接住所有的实现
        GenericService genericService = reference.get();
        // 构造复杂参数，下面的示例中，头两个参数为string类型，后一个是一个复杂类型，但都可以通过map构造。
        Map map = (Map) JSONObject.parse(data);
        Object result = genericService.$invoke(apiInfo.getRequestMethod(), new String[]{apiInfo.getRequestDTO()},
                new Object[]{map});
        log.info("下游返回数据，{}",JSON.toJSONString(result));
        return result;
    }
}
