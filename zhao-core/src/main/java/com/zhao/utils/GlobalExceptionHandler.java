package com.zhao.utils;

import com.zhao.execption.BusinessException;
import com.zhao.execption.SystemException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 业务逻辑异常。
     */
    @ExceptionHandler(value = BusinessException.class)
    public Object businessExceptionHandler(BusinessException e, HttpServletRequest req) {
        R<Object> result = e.getResult();
        log.error("业务异常：{},异常路径：{}", e.getMessage(), req.getRequestURI());
        return R.fail(result.getCode(), result.getMessage());
    }

    /**
     * 系统异常。
     */
    @ExceptionHandler(value = SystemException.class)
    public Object systemExceptionHandler(SystemException e, HttpServletRequest req) {
        R<Object> result = e.getResult();
        log.error("系统异常：{},异常路径：{}", e.getMessage(), req.getRequestURI());
        return R.fail(result.getCode(), result.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e, HttpServletRequest req) {
        log.error("系统异常：{},异常路径：{}", e.getMessage(), req.getRequestURI());
        return R.fail(e.getMessage());
    }


    @ExceptionHandler(
            {NoHandlerFoundException.class,
            HttpRequestMethodNotSupportedException.class,
            HttpMediaTypeNotSupportedException.class,
            MissingPathVariableException.class,
            MissingServletRequestParameterException.class,
            TypeMismatchException.class,
            HttpMessageNotReadableException.class,
            HttpMessageNotWritableException.class,
            HttpMediaTypeNotAcceptableException.class,
            ServletRequestBindingException.class,
            ConversionNotSupportedException.class,
            MissingServletRequestPartException.class,
            AsyncRequestTimeoutException.class}
    )
    public Object handleServletException(Exception e, HttpServletRequest req) {
        log.error("系统异常：{},异常路径：{}", e.getMessage(), req.getRequestURI());
        return new R<>("99999", e.getMessage());
    }
}
