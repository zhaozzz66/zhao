package com.zhao.utils;

import com.zhao.enums.CommonEnum;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class R<T> {

    private String code; // 返回码
    private String message; // 返回消息
    private T data; // 返回数据

    public R() {

    }

    public R(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public R(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    public R(T data) {
        this.data = data;
    }

    public static <T> R<T> success(T data){
        return new R<>(CommonEnum.SUCCESS.getCode(), CommonEnum.SUCCESS.getMessage(),data);
    }

    public static <T> R<T> success(){
        return new R<>(CommonEnum.SUCCESS.getCode(), CommonEnum.SUCCESS.getMessage());
    }

    public static <T> R<T> fail(){
        return new R<>(CommonEnum.FAIL.getCode(), CommonEnum.FAIL.getMessage());
    }

    public static <T> R<T> fail(String code,String message){
        return new R<>(code,message);
    }

    public static <T> R<T> fail(String message){
        return new R<>(CommonEnum.FAIL.getCode(),message);
    }
}
