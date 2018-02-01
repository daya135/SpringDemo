package org.jzz.springDemo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.jzz.springDemo.service.MyService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

//@Component
public class OriginFilter implements Filter{

//	@Autowired  不能使用注解注入，因为初始化的原因。
	private MyService myService;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		ServletContext servletContext = filterConfig.getServletContext();
		ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		myService = (MyService) applicationContext.getBean(MyService.class);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		myService.doService();
		System.out.println("OriginFilter：拦截到default请求！");
		chain.doFilter(request, response);
		return;
	}

	@Override
	public void destroy() {
		
		
	}
	
}
