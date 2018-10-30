package dn.web.girl.util;

import dn.web.girl.entity.Result;

/**
 * @Author: 邓宁
 * @Date: Created in 21:39 2018/10/26
 */
//封装返回信息工具类
public class ResultUtil {

    //成功(包含data)
    public static Result success(Object object){
        Result result=new Result();
        result.setCode(1);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    //成功(不包含data)
    public static Result success(){
        return success(null);
    }

    //失败
    public static Result error(Integer code,String msg){
        Result result=new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
