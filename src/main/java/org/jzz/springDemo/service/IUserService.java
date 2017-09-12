package org.jzz.springDemo.service;

import java.sql.Date;

import org.jzz.springDemo.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    
	public boolean regist(User user);
	public boolean login(String loginid, String password);
	
	public void userInfo(String loginid);
	
}
