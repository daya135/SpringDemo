package org.jzz.springDemo.domain;

//create table user_test (
//		loginid varchar(50),
//		`password`	varchar(50),
//		salt	varchar(50),
//		username varchar(50),
//		mobile	varchar(20),
//		email varchar(50),
//		state varchar(1),
//		birthday date,
//		create_time	timestamp,
//		update_time	timestamp
//	);

import java.sql.Date;
import java.sql.Timestamp;

public class User {
	
	private String loginid;
	private String password;
	private String salt;
	private String username;
	private String mobile;
	private String email;
	private Date birthday;
	private String state;
	private Timestamp create_time;
	private Timestamp update_time;
	
	public User() {}
	
	public User(String loginid, String password, String salt, String username,
			String mobile, String email, String state, Date birthday) {
		this.loginid = loginid;
		this.password = password;
		this.salt = salt;
		this.username = username;
		this.mobile = mobile;
		this.birthday = birthday;
		this.email = email;
		this.state = state;
	}

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Timestamp getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Timestamp update_time) {
		this.update_time = update_time;
	}

	public Timestamp getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}
