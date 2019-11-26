package com.ss.gateway.common.enums;

import com.ss.gateway.common.exception.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author xueshansheng
 * @date 2019/11/26 上午 11:16
 */
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public enum CommonErrorCode implements ErrorCode {

    /**
     * 亲，系统内部异常，请稍后重试
     */
    SYSTEM_INNER_ERROR("SYSTEM_INNER_ERROR", "亲，系统内部异常，请稍后重试"),

    /**
     * 参数校验不通过
     */
    PARAMETER_VALID_NOT_PASS("PARAMETER_VALID_NOT_PASS", "参数校验不通过");

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误描述
     */
    private String desc;
}
