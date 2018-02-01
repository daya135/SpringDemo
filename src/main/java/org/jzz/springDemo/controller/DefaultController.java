package org.jzz.springDemo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jzz.springDemo.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.WebApplicationContextUtils;


@Controller
public class DefaultController {
	
	@Autowired
	private MyService myService;
	
	@RequestMapping(value="/default",method=RequestMethod.GET)
	public void defaultFuc(HttpServletRequest request, HttpServletResponse response) throws IOException {
		myService.doService();
		response.getWriter().write("this is defult controller");
	}
}
