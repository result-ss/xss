package com.ss.gateway.dal.mapper;

import com.ss.gateway.dal.model.AddApiInfoDO;
import org.springframework.stereotype.Repository;

/**
 * @author xueshansheng
 * @date 2019/11/19 上午 10:58
 */
@Repository
public interface ApiManagerInfoMapper {

    /**
     * 新增接口
     * @param addApiInfoDO
     * @return
     */
    int addApiInfo(AddApiInfoDO addApiInfoDO);
}
