package com.zhao.execption;

import com.zhao.utils.R;
import lombok.Getter;
import lombok.Setter;

/**
 * 系统级异常。
 * 指系统级别的，如：网络通信时连接中断、系统连接、超时等异常
 */
@Setter
@Getter
public class SystemException extends BaseException {

    private R<Object> result = new R<>();

    public SystemException(R<Object> result) {
        super(result.getCode()+ ":" + result.getMessage());
        this.result = result;
    }

    public SystemException(String code, String msg) {
        super(code + ":" + msg);
        this.result.setCode(code);
        this.result.setMessage(msg);
    }

    public SystemException(R<Object> result, Throwable cause) {
        super(result.getCode() + ":" + result.getMessage(), cause);
        this.result = result;
    }

    public SystemException(String code, String msg, Throwable cause) {
        super(code + ":" + msg, cause);
        this.result.setCode(code);
        this.result.setMessage(msg);
    }

}
