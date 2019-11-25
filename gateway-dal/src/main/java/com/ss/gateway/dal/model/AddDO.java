package com.ss.gateway.dal.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author xueshansheng
 * @date 2019/11/13 上午 9:27
 */
@Setter
@Getter
@ToString
public class AddDO {

    /**
     * 批次号
     */
    private String batchId;

    /**
     * 父商户号
     */
    private String merchantCode;

    /**
     * 产品号
     */
    private String productCode;

    /**
     * 产品名
     */
    private String productName;

    /**
     * 状态
     */
    private String status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 解决方案编号
     */
    private String solutionNo;

    /**
     * 解决方案名称
     */
    private String solutionName;

    /**
     * 是否收费标识
     */
    private String feeFlag;

    /**
     * 费率模板编号
     */
    private String feeModelNo;

    /**
     * 费率模板名称
     */
    private String feeModelName;

    /**
     * 计费模式
     */
    private String feeMode;

    /**
     * 计费方式
     */
    private String billingMode;

    /**
     * 费率值
     */
    private Long   billingValue;

    /**
     * 起费金额
     */
    private Long   feeBeginAmt;

    /**
     * 封底金额
     */
    private Long   bottomAmt;

    /**
     * 封顶金额
     */
    private Long   ceilingAmt;

    /**
     * 收费状态
     */
    private String feeStatus;

    /**
     * 分档标识
     */
    private String segmentFlag;

    /**
     * 金额累计周期
     */
    private String feeCycle;

    /**
     * 计费精度
     */
    private String calAcc;

    /**
     * 退款是否退原交易手续费标识
     */
    private String refundFeeFlag;

    /**
     * 产品码
     */
    private String prodCode;

    /**
     * 生效时间
     */
    private Date beginDate;

    /**
     * 失效时间
     */
    private Date   endDate;


    private String upBatchId;
    /**
     * 事业群推荐码
     */
    private String recommendCode;
    /**
     *线下协议上传DFS的方式最大长度32位
     */
    private String offlineAgreementPath;

    /**
     * 支付工具信息
     */
    private String payToolInfo;

    /**
     * 请求系统
     */
    private String requestSystem;

    /**
     * 请求流水
     */
    private String serialNumber;

    /**
     * 查询开始时间
     */
    private Date queryBeginDate;

    /**
     * 查询结束时间
     */
    private Date queryEndDate;

    /**
     * 当前页
     */
    private Integer currentPage;

    /**
     * 每页条数
     */
    private Integer pageCount;

    /**
     * 开始行
     */
    private Integer  startRow;

    /**
     * 开始行
     */
    public Integer getStartRow() {
        if( null== currentPage || null == pageCount){
            return 0;
        }
        return (currentPage - 1) * pageCount;
    }
}
