package org.jzz.springDemo.domain;

/**
 * 测试ThreadLocal在web中的应用
 * @author Merin
 *
 */
public class UserThreadLocal {
	private static ThreadLocal<User> userLocal  = new ThreadLocal<User>();
	public static User getUser() {
		return userLocal.get();
	}
	public static void setUser(User user) {
		userLocal.set(user);
	}
	public static void clean() {
		userLocal.remove();
	}
}
