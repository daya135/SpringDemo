package org.jzz.springDemo.test;

import java.util.HashMap;

import org.jzz.springDemo.domain.Song;
import org.jzz.springDemo.service.*;
import org.jzz.springDemo.utils.CommonTools;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/*
create table user_test (
		loginid varchar(50),
		`password`	varchar(50),
		username varchar(50),
		mobile	varchar(20),
		birthday datetime,
		create_time	datetime,
		update_time	datetime
	);
*/

public class testService {
	public void testGit(){
		System.out.println("处理冲突测试!");
	}
	public static void main(String[] args) throws Exception {
		
		//一般将配置文件放置在class目录，即resource目录（编译后自动进入class目录）
		//ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//当把Spring配置文件放在WEB-INF目录时,则必须使用FileSystemXmlApplicationContext来读取配置文件
		ApplicationContext context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/applicationContext.xml");

		//IUserService service = (IUserService) context.getBean("UserService");
		//IUserService service = (IUserService) context.getBean("userService");
		//IUserService service = (IUserService) context.getBean("userService",org.jzz.springDemo.service.IUserService.class);
		
		//System.out.println(service.login("jzz", "123"));
		//service.regist("jz2", "123", "jz2", null, null);
		
//		ISongService songService = (ISongService) context.getBean("songService");
//		String dirName = "D:/Audio";
//		songService.initLocalSongs(dirName);
//		songService.xiamiSynchronize();
	}
}
