package com.example.demo.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class LogAspect {

    private final static Logger logger = LoggerFactory.getLogger(LogAspect.class);

    // * 表示所有返回类型  ..表示包及子包 * 表示所有类 .* 指类所有方法 （..） 代表所有参数
    @Pointcut("execution(public * com.example.demo.controller..*.*(..))")
    public void controllerMethod() {
    }


    @Before("controllerMethod()")
    public void LogRequestInfo(JoinPoint joinPoint) throws Exception {

        logger.info("请求结果： Before  " );

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        StringBuffer requestLog = new StringBuffer();
        requestLog.append("请求信息：")
                .append("URL = {" + request.getRequestURI() + "},\t")
                .append("HTTP_METHOD = {" + request.getMethod() + "},\t")
                .append("IP = {" + request.getRemoteAddr() + "},\t")
                .append("CLASS_METHOD = {" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() + "},\t");

        if(joinPoint.getArgs().length == 0) {
            requestLog.append("ARGS = {} ");
        } else {
            /*requestLog.append("ARGS = " + new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL)
                    .writeValueAsString(joinPoint.getArgs()[0]) + "");*/
        }

        logger.info(requestLog.toString());
    }


    @AfterReturning( pointcut = "controllerMethod()")
    public void logResultVOInfo() throws Exception {
        logger.info("请求结果： after return " );
    }

    @After("controllerMethod()")
    public void logAfter(JoinPoint joinPoint){
        logger.info("请求结果： after  " );
    }


    @AfterThrowing("controllerMethod()")
    public void logException(JoinPoint joinPoint){
        logger.info("请求结果： after AfterThrowing " );
    }

    @Around("controllerMethod()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws  Throwable{

        Object s=null;
        if(joinPoint.getArgs().length>0){
            s=joinPoint.getArgs()[0];
            logger.info("Around： 打印传参 "+s.toString() );
        }
        logger.info("Around  1");
        Object obj=joinPoint.proceed(new Object[]{"黄豆酱的 "+s.toString()});
        logger.info("Around 2");
        return  obj;

    }

}