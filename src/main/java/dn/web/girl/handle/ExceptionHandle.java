package dn.web.girl.handle;

import dn.web.girl.controller.HelloController;
import dn.web.girl.entity.Result;
import dn.web.girl.exception.GirlException;
import dn.web.girl.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: 邓宁
 * @Date: Created in 22:59 2018/10/26
 */

@ControllerAdvice
public class ExceptionHandle {

    private static  final Logger logger= LoggerFactory.getLogger(ExceptionHandle.class);


    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result handle(Exception e){
        //判断是否为自定义异常
        if(e instanceof GirlException){
            GirlException exception= (GirlException) e;
            return ResultUtil.error(exception.getCode(),exception.getMessage());
        }
        //否则就返回-1.未知错误
        else{
            logger.error("【系统异常】={}",e);
            return ResultUtil.error(-1,"未知错误");
        }
    }
}
