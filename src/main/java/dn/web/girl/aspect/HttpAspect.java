package dn.web.girl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: 邓宁
 * @Date: Created in 11:41 2018/10/25
 */
@Aspect
@Component
//Aop切面类
public class HttpAspect {

    /*日志记录*/
    private static final Logger logger= LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * dn.web.girl.controller.HelloController.*(..))")
    public void log(){ }

    @Before("log()")
    //在方法之前调用
    public void logBefore(JoinPoint joinPoint){
        ////获取ServletRequest
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //获取HttpServletRequest
        HttpServletRequest request=attributes.getRequest();
        //url
            logger.info("url={}",request.getRequestURL());
        //action
            logger.info("action={}",request.getMethod());
        //ip
            logger.info("ip={}",request.getRemoteAddr());
        //method
            logger.info("method={}",joinPoint.getSignature().getDeclaringTypeName() +"."+
                    joinPoint.getSignature().getName());
        //params
            logger.info("params={}",joinPoint.getArgs());
    }

    /*@After("log()")
    //在方法之后调用
    public void logAfter(){
        logger.info("22222");
    }*/

    //获取返回信息
    @AfterReturning(returning = "object",pointcut = "log()")
    public void logAfterReturning(Object object){
        logger.info("response={}",object);
    }
}
