package org.jzz.springDemo.proxy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;

/** 
 * Advice通知类 
 * 测试after,before,around,throwing,returning Advice. 
 * @author Admin 
 * 
 */ 

@Component
//声明这是一个切面Bean
@Aspect
public class ServiceAop {
  
	@Pointcut("execution(* org.jzz.springDemo.service.UserService.*(..))")
	private void anyMethod(){}//定义一个切入点  
	
    @Before("anyMethod() && args(name)")  
    public void doAccessCheck(String name){
        System.out.println(name);  
        System.out.println(" before advice");  
    }  
      
    @AfterReturning("anyMethod()")  
    public void doAfter(){
        System.out.println("after advice");  
    }  
      
    @After("anyMethod()")  
    public void after(){  
        System.out.println("最终通知");  
    }  
      
    @AfterThrowing("anyMethod()")  
    public void doAfterThrow(){  
        System.out.println("例外通知");  
    }  
      
    @Around("anyMethod()")  
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable{  
        System.out.println("进入环绕通知");  
        Object object = pjp.proceed();//执行该方法  
        System.out.println("退出方法");  
        return object;  
    }  
}  
