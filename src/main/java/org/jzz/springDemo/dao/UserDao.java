package org.jzz.springDemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.jzz.springDemo.domain.User;
import org.jzz.springDemo.domain.UserMapper;

/* 相当于<bean id= "userDao" .../>*/
@Repository
public class UserDao implements IUserDao {
	
	//@Autowired
	private JdbcTemplate jdbcTemplateObject ;
	
	@Override
	public void addUser(User user) {
		 String sql = "INSERT INTO user_test(loginid, `password`, salt, username, mobile, email,"
		 		+ " state, birthday, create_time, update_time) VALUES(?,?,?,?,?,?,?,?,?,?)";  
		 jdbcTemplateObject.update(sql, user.getLoginid(), user.getPassword(), user.getSalt(),
				 user.getUsername(), user.getMobile(), user.getEmail(), user.getState(), user.getBirthday(),
				 user.getCreate_time(), user.getUpdate_time()); 
		 return;
	}

	@Override
	public void delUserById(String loginid) {
		String sql = "DELETE FROM user_test WHERE loginid=?";  
		jdbcTemplateObject.update(sql, loginid);  
		return;
	}

	@Override
	public List<User> queryUserById(String loginid) {
		List<User> userList = null;  
		String sql = "SELECT * FROM user_test WHERE loginid=?"; 
		userList = jdbcTemplateObject.query(sql, new Object[]{loginid}, new UserMapper());  
		return userList;
	}
	
//	public String queryUserByPasswd(String loginid, String password){
//		String id = null;
//		String sql = "SELECT loginid FROM user_test WHERE loginid=? and `password`=?"; 
//		try {
//			id = jdbcTemplateObject.queryForObject(sql, new Object[] {loginid, password}, java.lang.String.class );
//		} catch (EmptyResultDataAccessException e) {
//			System.out.println("未根据密码查到指定用户!");
//		}
//		return id;
//	}
//	
////	public String querySalt(String loginid) {
////		String salt = null;
////		String sql = "SELECT salt FROM user_test WHERE loginid=?"; 
////		try {
////			salt = jdbcTemplateObject.queryForObject(sql, new Object[] {loginid}, java.lang.String.class );
////		} catch (EmptyResultDataAccessException e) {
////			System.out.println("未查到指定用户salt!");
////		}
////		return salt;
////	}
	
}
