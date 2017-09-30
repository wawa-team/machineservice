package com.doll.util;

/**
 * Created by hexu on 2017/9/2.
 */
public enum ApiContents {

    NORMAL(200, "正常"),
    PARAMS_ERROR(1001, "参数错误"),
    BACK_ORDER_ERROR(4002, "回调订单失败");

    private Integer value;
    private String desc;

    ApiContents(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public Integer value() {
        return this.value;
    }

    public String desc() {
        return this.desc;
    }

}
