package com.mns.emos.wx.aop;

import cn.hutool.core.util.StrUtil;
import com.mns.emos.wx.common.util.R;
import com.mns.emos.wx.config.shiro.ThreadLocalToken;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TokenAspect {

    @Autowired
    ThreadLocalToken threadLocalToken;

    @Pointcut("execution(public * com.mns.emos.wx.controller.*.*(..)))")
    public void aspect() {

    }

    @Around("aspect()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        R r = (R) point.proceed();
        String token = threadLocalToken.getToken();
        if(token!=null){
            r.put("token", token);
            threadLocalToken.clear();
        }
        return r;
    }
}