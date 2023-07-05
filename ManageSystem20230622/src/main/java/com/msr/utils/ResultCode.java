package com.msr.utils;

/**
 * @BelongsProject: springboot2020
 * @BelongsPackage: com.it.utils
 * @Description: 枚举 封装就是状态码
 */
public enum  ResultCode {

    PAGESUCCESS(0,"分页请求成功"),
    SUCCESS(200,"请求成功"),
    FILE_SUCCESS(201,"图片上传成功"),
    FILE_FAIL(202,"图片上传失败"),
    NO_DELETE(800,"数据在使用中，勿删除"),
    NO_DELETE_PARENT(801,"父级分类下有子分类，勿删除!"),
    NO_ONLINE(803,"该商品没有审核通过，不允许上下架!"),
    CART_200(804,"该商品在购物车中数量最多为200!"),
    FAIL(500,"请求失败"),
    TIMEOUT(505,"支付超时"),
    REGISTER_SUCCESS(200,"注册成功"),
    USERNAME_NO_REPEAT(200,"用户名可用"),
    ADD_FAV_SUCCESS(200,"收藏成功!"),
    REMOVE_SUCCESS(200,"移除成功!"),
    CODE_FAIL(9001,"验证码错误"),
    LOGIN_FAIL(9002,"用户名或密码错误"),
    LOGIN_SUCCESS(8000,"登录成功"),
    NO_LOGIN(9003,"请先登录"),
    NO_CHECK(9090,"验证失败"),
    REGISTER_FAIL(9005," 注册失败"),
    USERNAME_REPEAT(9006," 用户名重复"),
    LOGIN_FORBID(9007,"用户被禁用"),
    NO_RIGTHS(403,"暂无权限操作"),
    @SuppressWarnings("all")
    REPASSWORD_ERROR(9004,"两次密码不一致"),
    PASSWORD_ERROR(9008,"原密码错误"),
    PASSWORD_EMPTY(9009,"密码不能为空"),
    STOCK_NO(9010,"库存不足");

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    ResultCode(int code, String message){
        this.code=code;
        this.message=message;
    }
}