package com.ss.gateway.manager;

import com.ss.gateway.dal.mapper.ApiManagerInfoMapper;
import com.ss.gateway.dal.model.AddApiInfoDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xueshansheng
 * @date 2019/11/20 下午 2:54
 */
@Component
public class ApiManagerServiceManager {

    @Autowired
    private ApiManagerInfoMapper apiManagerInfoMapper;

    /**
     * 新增接口
     *
     * @param addApiInfoDO
     * @return
     */
    public boolean addApiInfo(AddApiInfoDO addApiInfoDO) {
        return apiManagerInfoMapper.addApiInfo(addApiInfoDO) > 1;
    }

    /**
     * 接口详情查询
     *
     * @param addApiInfoDO
     * @return
     */
    public AddApiInfoDO queryApiDetails(AddApiInfoDO addApiInfoDO) {
        return apiManagerInfoMapper.selectOneApiInfo(addApiInfoDO);
    }
}
