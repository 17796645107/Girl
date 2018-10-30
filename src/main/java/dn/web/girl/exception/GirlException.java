package dn.web.girl.exception;

import dn.web.girl.enums.ResultEnum;

/**
 * @Author: 邓宁
 * @Date: Created in 23:16 2018/10/26
 */
//girl异常类
public class GirlException extends RuntimeException {

    //返回码
    private Integer code;

    //构造方法
    public GirlException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code=resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
