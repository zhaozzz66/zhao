package com.zhao.execption;

import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * 异常基类
 */
@Slf4j
public class BaseException extends RuntimeException implements Serializable {
    public BaseException() {
    }

    public BaseException(String message) {
        super(message);

        if (log.isErrorEnabled()) {
            log.error(message);
        }
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
        if (log.isErrorEnabled()) {
            log.error(message, cause);
        }
    }
}
