package dn.web.girl.enums;

/**
 * @Author: 邓宁
 * @Date: Created in 23:51 2018/10/26
 */

public enum ResultEnum{
    UNKNOW_ERROR(-1,"未知错误"),
    SUCCESS(1,"成功"),
    SMALL_SCHOOL(100,"你还在上小学"),
    HIGH_SCHOOL(101,"你还在上初中")
    ;
    private Integer code;

    private String msg;


    //构造方法

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
