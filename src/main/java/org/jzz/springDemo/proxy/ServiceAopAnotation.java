package org.jzz.springDemo.proxy;

import java.lang.annotation.*;    

/**  
 *自定义注解 拦截service  
 */    
    
@Target({ElementType.PARAMETER, ElementType.METHOD})    
@Retention(RetentionPolicy.RUNTIME)    
@Documented   
public @interface ServiceAopAnotation {
	String description()  default "";    
}
