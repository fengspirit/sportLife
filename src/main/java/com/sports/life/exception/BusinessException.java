package com.sports.life.exception;

import com.sports.life.exception.code.ResponseCodeInterface;

/**
 * 自定义一次
 */
public class BusinessException extends RuntimeException{
    /**
     * 异常编号
     */
    private final int messageCode;
    /**
     * 对messageCode 异常信息进行补充说明
     */
    private final String detailMessage;

    public BusinessException(int messageCode,String message) {
        super(message);
        this.messageCode = messageCode;
        this.detailMessage = message;
    }

    public BusinessException(ResponseCodeInterface code) {
        this(code.getCode(), code.getMsg());
   }

    public int getMessageCode() {
        return messageCode;
    }
    public String getDetailMessage() {
        return detailMessage;
    }
}
