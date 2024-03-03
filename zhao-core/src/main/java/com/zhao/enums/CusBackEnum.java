package com.zhao.enums;

public enum CusBackEnum implements CodedItem{
    USER_EXCEPTION("99995","用户异常");

    private String code;
    private String message;

    CusBackEnum(String code,String message){
        this.code=code;
        this.message=message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message=message;
    }
}
