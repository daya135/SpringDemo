package org.jzz.springDemo.dao;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jzz.springDemo.domain.User;

public class UserMapper_Old implements RowMapper<User>{

	public User mapRow(ResultSet rs, int rownum) throws SQLException {  
		User user = new User();
		user.setLoginid(rs.getString("loginid"));
		user.setPassword(rs.getString("password"));
		user.setSalt(rs.getString("salt"));
		user.setMobile(rs.getString("mobile"));
		user.setEmail(rs.getString("email"));
		user.setState(rs.getString("state"));
		user.setBirthday(rs.getDate("birthday"));
		user.setUsername(rs.getString("username"));
		user.setCreateTime(rs.getTimestamp("create_time"));
		user.setUpdateTime(rs.getTimestamp("update_time"));
		
		return user;
	}
}