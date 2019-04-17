package com.util;/*
 * @author :张
 * Date  : 2019/4/16
 * @Description: AnnotationAOP
 */

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;

@Component

@Aspect//AOP的切面注解版
public class AnnotationAOP {

    @Autowired
    private TransactionUtil transactionUtil;

    private TransactionStatus begin;

    //将Userservice类，和add方法改为*，意思是service包下的全部类，全部方法
    // execution 执行的方程式：方法返回值类型  包名.类名.方法名(..) 参数
    @Before("execution(* com.service.*.*(..))")
    public void doBefore(){

        System.out.println("前置通知");
    }

    @After("execution(* com.service.*.*(..))")
    public void doAfter(){
        System.out.println("后置通知");
    }

    @AfterReturning("execution(* com.service.*.*(..))")
    public void runtime(){
        System.out.println("运行通知");
    }

    @AfterThrowing("execution(* com.service.*.*(..))" )
    public void throwing(){

        System.out.println("异常通知");
    }

    //    proceedingJoinPoint切入点
    @Around("execution(* com.service.*.*(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//开启事务，要用到transactionUtil，所以类中创建了一个TransactionUtil类的属性。
        TransactionStatus begin = transactionUtil.begin();
        System.out.println("事务开启");
        System.out.println("环绕通知前");
//执行方法，放行
     proceedingJoinPoint.proceed();

        System.out.println("环绕通知后");

        transactionUtil.commit(begin);
        System.out.println("事务提交");
    }


}
