package com.ss.gateway.manager;

import com.ss.gateway.common.enums.CommonErrorCode;
import com.ss.gateway.common.exception.BusinessException;
import com.ss.gateway.common.utils.Result;
import com.ss.gateway.dal.mapper.ApiManagerInfoMapper;
import com.ss.gateway.dal.model.AddApiInfoDO;
import com.ss.gateway.manager.helper.ApiBaseConverter;
import com.ss.gateway.service.api.model.response.PageDTO;
import com.ss.gateway.service.api.model.response.PageQueryApiInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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
    public Boolean addApiInfo(AddApiInfoDO addApiInfoDO) {
        AddApiInfoDO addApiInfo = queryApiDetails(addApiInfoDO);
        if (addApiInfo != null) {
            throw  new BusinessException(CommonErrorCode.API_URL_REPETITION.getDesc(), CommonErrorCode.API_URL_REPETITION.getCode());
        }
        return apiManagerInfoMapper.addApiInfo(addApiInfoDO) > 0;
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

    /**
     * 接口分页查询
     *
     * @param addApiInfoDO
     * @return
     */
    public PageDTO<PageQueryApiInfoDTO> queryPageApiDetails(AddApiInfoDO addApiInfoDO) {
        List<AddApiInfoDO> addApiInfoDOS = apiManagerInfoMapper.selectApiInfo(addApiInfoDO);
        int totalRow = apiManagerInfoMapper.selectApiInfoCount(addApiInfoDO);
        List<PageQueryApiInfoDTO> pageQueryRespDTO = ApiBaseConverter.getPageQueryRespDTO(addApiInfoDOS);
        PageDTO<PageQueryApiInfoDTO> page = new PageDTO<>();
        page.setDataList(pageQueryRespDTO);
        page.setTotalRow(totalRow);
        page.setCurrentPage(addApiInfoDO.getCurrentPage());
        page.setPageSize(addApiInfoDO.getPageCount());
        return page;
    }
}
