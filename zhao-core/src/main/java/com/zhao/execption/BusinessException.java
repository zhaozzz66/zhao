package com.zhao.execption;

import com.zhao.utils.R;
import lombok.Getter;
import lombok.Setter;

/**
 * 业务处理异常类
 */
@Setter
@Getter
public class BusinessException extends RuntimeException {

    private R<Object> result = new R<>();

    public BusinessException(R<Object> result) {
        super(result.getCode() + ":" + result.getMessage());
        this.result = result;
    }

    public BusinessException(String code, String msg) {
        super(code + ":" + msg);
        this.result.setCode(code);
        this.result.setMessage(msg);
    }

    public BusinessException(R<Object> result, Throwable cause) {
        super(result.getCode() + ":" + result.getMessage(), cause);
        this.result = result;
    }

    public BusinessException(String code, String msg, Throwable cause) {
        super(code + ":" + msg, cause);
        this.result.setCode(code);
        this.result.setMessage(msg);
    }

}
