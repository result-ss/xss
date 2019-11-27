package com.ss.gateway.service.api.model.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author xueshansheng
 * @date 2019/11/27 上午 9:47
 */
@Setter
@Getter
@ToString
public class PageDTO<T> implements Serializable {

    /**
     * 总条数
     */
    private Integer totalRow;

    /**
     * 当前页
     */
    private Integer currentPage;

    /**
     * 每页显示数量
     */
    private Integer pageSize;

    /**
     * 查询结果集
     */
    private List<T> dataList;

    /**
     * @return 总页数
     */
    public int getTotalPage() {
        if (totalRow == 0) {
            return 0;
        }
        if (pageSize == 0) {
            return 0;
        }
        return totalRow % pageSize == 0 ? totalRow / pageSize : totalRow / pageSize + 1;
    }
}
