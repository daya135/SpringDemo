package org.jzz.springDemo.test;

import org.jzz.springDemo.dao.IUserDao;
import org.jzz.springDemo.domain.User;
import org.jzz.springDemo.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class testDao {
	
	public static void main(String[] args) throws Exception {
		
		//一般将配置文件放置在class目录，即resource目录（编译后自动进入class目录）
		//ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//当把Spring配置文件放在WEB-INF目录时,则必须使用FileSystemXmlApplicationContext来读取配置文件
		ApplicationContext context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/applicationContext.xml");

//		IUserDao dao = (IUserDao) context.getBean("userDao");
//		System.out.println(dao.queryUserByPasswd("jzz", "123"));
		
	}
}
