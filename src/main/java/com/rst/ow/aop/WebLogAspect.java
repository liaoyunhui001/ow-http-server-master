package com.rst.ow.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by hujia on 2017/4/5.
 */
@Aspect
@Component
public class WebLogAspect {

    @Value("${log-enable:true}")
    private boolean enableLog;

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("@within(org.springframework.stereotype.Controller)" +
            "||@within(org.springframework.web.bind.annotation.RestController)")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        if (!enableLog) {
            return;
        }
        Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());

        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        String[] paramNames = methodSignature.getParameterNames();
        Object[] params = joinPoint.getArgs();
        StringBuilder msg = new StringBuilder("【Call】 " + signature.getName() + "(");

        for (int i = 0; i < params.length - 1; i++) {
            msg.append(paramNames[i] + ":" + params[i] + ",");
        }

        if (params.length > 0) {
            msg.append(paramNames[params.length - 1] + ":" + params[params.length - 1] + ")");
        } else {
            msg.append(")");
        }

        logger.info(msg.toString());
        startTime.set(System.currentTimeMillis());
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(JoinPoint joinPoint, Object ret) throws Throwable {
        if (!enableLog) {
            return;
        }
        Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        logger.info("【Return】{}(time cost: {} ms): {}", joinPoint.getSignature().getName(),
                System.currentTimeMillis() - startTime.get(), ret.toString());
    }
}
