package com.ss.gateway.common.exception;

import com.ss.gateway.common.enums.CommonErrorCode;
import com.ss.gateway.common.utils.Result;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xueshansheng
 * @date 2019/11/26 下午 3:53
 */
@Slf4j
public class ExceptionUtil {

    private ExceptionUtil() {}

    /**
     * 统一异常处理
     *
     * @param err 异常
     * @return 外部响应对象
     */
    public static <T> Result<T> doExceptionService(Throwable err) {
        try {
            if (err instanceof BusinessException) {
                BusinessException e = (BusinessException) err;
                return new Result<>(e.getErrorCode(),e.getMessage());
            }
            if (err instanceof IllegalArgumentException) {
                return new Result<>(CommonErrorCode.PARAMETER_VALID_NOT_PASS.getCode(),
                        CommonErrorCode.PARAMETER_VALID_NOT_PASS.getDesc());
            }
        } catch (Exception e) {
            log.error("call ExceptionUtil doExceptionService：{}", e);
        }
        return new Result<>(CommonErrorCode.SYSTEM_INNER_ERROR.getCode(),
                CommonErrorCode.SYSTEM_INNER_ERROR.getDesc());

    }
}
