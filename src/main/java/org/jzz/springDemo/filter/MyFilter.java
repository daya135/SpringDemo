package org.jzz.springDemo.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import  org.jzz.springDemo.domain.User;

import org.jzz.springDemo.domain.UserThreadLocal;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MyFilter extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request,    
            HttpServletResponse response, Object handler) {
		User user = new User();
		user.setMobile(request.getParameter("mobile"));
		user.setUsername(request.getParameter("username"));
		UserThreadLocal.setUser(user);
		return true;
	}
	
	@Override
	public void afterCompletion(
			HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("拦截完成，清理user对象");
		UserThreadLocal.clean();
	}
}
