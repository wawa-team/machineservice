package com.doll.util;

/**
 * Created by hexu on 2017/9/2.
 */
public enum ActionContents {

    UP(1, "上"),
    DOWN(2, "下"),
    LEFT(3, "左"),
    RIGHT(4, "右"),
    STOP(5, "停"),
    GRAB(6, "抓");

    private Integer value;
    private String desc;

    ActionContents(Integer value, String desc) {
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
