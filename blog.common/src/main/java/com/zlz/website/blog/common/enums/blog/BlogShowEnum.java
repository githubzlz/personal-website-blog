package com.zlz.website.blog.common.enums.blog;

/**
 * @author wb_zhulinzhong
 * @date 2021-06-08 11:52:32
 */
public enum BlogShowEnum {

    /**
     * 不展示
     */
    SHOW(0, "展示"),

    /**
     * 展示
     */
    HIDDEN(1, "不展示"),

    /**
     * 自己可见
     */
    SELF(2, "自己可见"),
    ;


    private int code;
    private String name;


    BlogShowEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static BlogShowEnum getEnumByCode(Integer code) {
        if (null == code) {
            return null;
        }
        for (BlogShowEnum enum1 : BlogShowEnum.values()) {
            if (enum1.getCode() == code) {
                return enum1;
            }
        }
        return null;
    }
}
