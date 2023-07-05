package com.msr.utils;

public class Results<T> {

    private int code;
    private String message;
    private T data;

    public Results() {

    }

    private Results(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static Results success(ResultCode resultCode){
        Results resultCommon = new Results(resultCode.getCode(), resultCode.getMessage());
        return resultCommon;
    }

    public static Results success(ResultCode resultCode, Object data){
        Results success = success(resultCode);
        success.setData(data);
        return success;
    }

    public static Results fail(ResultCode resultCode){
        return success(resultCode);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
