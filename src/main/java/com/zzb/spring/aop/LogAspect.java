package com.zzb.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Author by 张志斌 .
 * @Date 13:56 2019/10/21
 */
@Aspect
@Component
public class LogAspect {
    private static final String POINT_CUT = "execution(* com.zzb.spring.aop..*(..))";
    @Pointcut(POINT_CUT)
    public void pointCut(){}

    @Before("pointCut()")
    public void before(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("方法名是："+name+",参数是："+ Arrays.toString(args));
        System.out.println("我是前置通知啊");
    }
    @After("pointCut()")
    public void after(){
        System.out.println("我是后置通知啊");
    }
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("@Around：切点方法环绕start.....");
        Object proceed = joinPoint.proceed();
        System.out.println("@Around：切点方法环绕end.....");

        return proceed;
    }
}
