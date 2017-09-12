package org.jzz.springDemo.dao;

import java.util.List;

import org.jzz.springDemo.domain.*;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao {
	
	public void addUser(User user);
	
	public void delUserById(String loginid);
	
	public List<User> queryUserById(String loginid);
	
}
