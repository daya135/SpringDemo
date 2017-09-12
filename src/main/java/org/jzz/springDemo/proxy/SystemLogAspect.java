package org.jzz.springDemo.proxy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;    
import org.springframework.web.context.request.RequestContextHolder;    
import org.springframework.web.context.request.ServletRequestAttributes;    
import javax.annotation.Resource;    
import javax.servlet.http.HttpServletRequest;    
import javax.servlet.http.HttpSession;    
import java.lang.reflect.Method;    
    
/**  
 * 切点类  
 * @author tiangai  
 * @since 2014-08-05 Pm 20:35  
 * @version 1.0  
 */    
@Aspect    
@Component    
public  class SystemLogAspect {    

	//Service层切入点, 注意切入位置是自定义注解
    @Pointcut("@annotation(org.jzz.springDemo.proxy.ServiceAopAnotation)")    
     public  void serviceAspect() {    
    }    
    
    //Controller层切点, 注意切入位置是自定义注解
    @Pointcut("@annotation(org.jzz.springDemo.proxy.ControllerAopAnotation)")    
     public  void controllerAspect() {    
    }    
    
    /**  
     * 前置通知 用于拦截Controller层记录用户的操作  
     *  
     * @param joinPoint 切点  
     */    
    @Before("controllerAspect()")    
     public  void doBefore(JoinPoint joinPoint) {    
    	System.out.println("AOP 拦截Controller! before");
    }    
    
    @After("controllerAspect()")
    public  void doAfter(JoinPoint joinPoint) {    
    	System.out.println("AOP 拦截Controller! after");
   }    
    
    @Before("serviceAspect()")    
    public  void doBeforeService(JoinPoint joinPoint) {    
   	System.out.println("AOP 拦截Service! before");
   }    
   
   @After("serviceAspect()")
   public  void doAfterService(JoinPoint joinPoint) {    
   	System.out.println("AOP 拦截Service! after");
  }   
} 