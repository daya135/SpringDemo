package org.jzz.springDemo.service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.xml.registry.infomodel.EmailAddress;
import org.jzz.springDemo.dao.UserMapper;
import org.jzz.springDemo.domain.User;
import org.jzz.springDemo.proxy.ServiceAopAnotation;
import org.jzz.springDemo.utils.PasswordUtil;
import org.jzz.springDemo.utils.Sendmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service("UserService")
//不指定名称默认为类名的小写开头作为id!!!
//如果类名已两个大写字母开头则直接使用类名！！大坑！
@Service
public class UserServiceImpl implements UserService{
	
	/* 使用自动按类型装配*/
	@Autowired
	private UserMapper userDao;
	private SimpleDateFormat dateFormat;
	
	public UserServiceImpl() {
		dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
	}

//	@ServiceAopAnotation(description = "注册用户")
	public boolean regist(User user) {
		

//		userDao.addUser(user);
		Sendmail send = new Sendmail(user);
		send.start();
		return true;
	}
	
	public boolean login(String loginid, String password) {
////		List<User> users = userDao.queryUserById(loginid);
//		if (users.isEmpty()) {
//			System.out.println("loginid不存在");
//			return false;
//		}
////		User user = users.get(0);
//		if (PasswordUtil.verify(password, user.getSalt(), user.getPassword())) {
			return true;
//		} else {
//			System.out.println("验证密码失败");
//			return false;
//		}
	}
	
	public void userInfo(String loginid) {
		
	}

}
