package com.zhao.enums;

public enum CommonEnum implements CodedItem{
    SUCCESS("00000","成功"),
    FAIL("99999","失败");

    private String code;
    private String message;

    CommonEnum(String code, String message){
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
