package com.sports.life.exception.handler;

import com.sports.life.exception.BusinessException;
import com.sports.life.exception.code.BaseResponseCode;
import com.sports.life.utils.DataResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理类
 */
@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {

    /**
     * 所有异常都能处理的方法
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public DataResult handleException(Exception e){
        log.info("handlerException:{}",e);
        return DataResult.getResult(BaseResponseCode.SYSTEM_ERROR);
    }

    /**
     * 运行时异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    public DataResult handlerBusinessException(BusinessException e){
        log.error("自定义BusinessException ...{}",e);
        return DataResult.getResult(e.getMessageCode(),e.getMessage());
    }
}
