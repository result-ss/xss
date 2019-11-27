package com.ss.gateway.service.api;

import com.ss.gateway.common.utils.Result;
import com.ss.gateway.service.api.model.request.AddApiReqDTO;
import com.ss.gateway.service.api.model.request.PageQueryReqDTO;
import com.ss.gateway.service.api.model.response.PageDTO;
import com.ss.gateway.service.api.model.response.PageQueryApiInfoDTO;
import com.ss.gateway.service.api.model.response.QueryApiDetailsDTO;
import com.ss.gateway.service.api.model.request.QueryApiDetailsReqDTO;

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

    /**
     * 接口分页查询
     * @param pageQueryReqDTO
     * @return
     */
    Result<PageDTO<PageQueryApiInfoDTO>> queryPageApi(PageQueryReqDTO pageQueryReqDTO);
}
