package com.titans.mobile.security;

import java.lang.reflect.Method;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.titans.mobile.annotation.IgnoreSecurity;
import com.titans.mobile.service.TokenManager;
import com.titans.mobile.utils.Constants;
import com.titans.mobile.utils.ResponseResult;
import com.titans.mobile.utils.ResultCode;
import com.titans.mobile.utils.WebContextUtil;

@Component
@Aspect
public class SecurityAspect {
	 /** Log4j日志处理 */
    private static final Logger log = Logger.getLogger(SecurityAspect.class);
    
    @Autowired
    private TokenManager tokenManager;


    @Around("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public Object execute(ProceedingJoinPoint pjp) throws Throwable {
        // 从切点上获取目标方法
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        System.out.println(methodSignature);
        log.debug("methodSignature : " + methodSignature);
        Method method = methodSignature.getMethod();
        System.out.println(method.getName());
        log.debug("Method : " + method.getName() + " : "
                +  method.isAnnotationPresent(IgnoreSecurity.class));
        // 若目标方法忽略了安全性检查,则直接调用目标方法
        if (method.isAnnotationPresent(IgnoreSecurity.class)) {
            return pjp.proceed();
        }
        // 从 request header 中获取当前 token
        String token = WebContextUtil.getRequest().getHeader(
                Constants.DEFAULT_TOKEN_NAME);
        // 检查 token 有效性
        if (!tokenManager.checkToken(token)) {
            String message = String.format("token [%s] is invalid", token);
            log.debug("message : " + message);
            return new ResponseEntity<ResponseResult>(new ResponseResult(ResultCode.INVALID_AUTHCODE), HttpStatus.OK);  
        }
        // 调用目标方法
        return pjp.proceed();
    }
}
