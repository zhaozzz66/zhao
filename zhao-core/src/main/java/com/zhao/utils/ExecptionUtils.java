package com.zhao.utils;


import com.zhao.enums.CodedItem;
import com.zhao.execption.BusinessException;
import com.zhao.execption.SystemException;

public class ExecptionUtils {
    /**
     * 业务处理异常
     * @param codedItem   异常码
     */
    public static BusinessException businessException(CodedItem codedItem) {
        return new BusinessException(createResult(codedItem));
    }

    /**
     * 业务处理异常
     * @param errCode   异常码
     * @param args  错误描述信息中的参数
     */
    public static BusinessException businessException(String errCode, String... args) {
        return new BusinessException(createResult(errCode, args));
    }

    /**
     * 系统级异常
     * @param codedItem   异常码
     */
    public static SystemException systemException(CodedItem codedItem) {
        return new SystemException(createResult(codedItem));
    }

    /**
     * 系统级异常
     * @param errCode   异常码
     * @param args  错误描述信息中的参数
     */
    public static SystemException systemException(String errCode, String... args) {
        return new SystemException(createResult(errCode, args));
    }


    private static R<Object> createResult(CodedItem codedItem) {
        return R.fail(codedItem.getCode(), codedItem.getMessage());
    }

    private static R<Object> createResult(String errCode, String msg) {
        return R.fail(errCode, msg);
    }

    private static R<Object> createResult(String errCode, String[] args) {
        return R.fail(errCode, getErrorMsg(errCode, args));
    }

    /**
     * 获取错误信息
     * @param errCode   错误码
     */
    private static String getErrorMsg(String errCode) {
        return ErrorUtils.getErrorDesc(errCode);
    }

    /**
     * 获取错误信息
     * @param errCode   错误码
     * @param args  错误描述信息中的参数
     */
    private static String getErrorMsg(String errCode, String[] args) {
        return ErrorUtils.getParseErrorDesc(errCode, args);
    }
}
