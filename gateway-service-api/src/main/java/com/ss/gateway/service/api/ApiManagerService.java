package com.ss.gateway.service.api;

import com.ss.gateway.common.utils.Result;
import com.ss.gateway.service.api.model.AddApiReqDTO;
import com.ss.gateway.service.api.model.QueryApiDetailsDTO;
import com.ss.gateway.service.api.model.QueryApiDetailsReqDTO;

/**
 * @author xueshansheng
 * @date 2019/11/14 下午 4:28
 */
public interface ApiManagerService {

    /**
     * 新增接口配置
     *
     * @param addApiReqDTO
     * @return
     */
    Result<Boolean> addApi(AddApiReqDTO addApiReqDTO);

    /**
     * 接口详情查询
     *
     * @param queryApiDetailsReqDTO
     * @return
     */
    Result<QueryApiDetailsDTO> queryApiDetails(QueryApiDetailsReqDTO queryApiDetailsReqDTO);
}
