package org.jzz.springDemo.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Session;

import org.jzz.springDemo.domain.User;

public class Sendmail extends Thread{
	//用于给用户发送邮件的邮箱
	private String username = "1352064451@qq.com";
	private String password = "qmptjlgahoedfgig";
	//发送邮件的服务器地址
	private String host = "smtp.qq.com";
	private String port = "587";
	
	private User user;
	
	public Sendmail(User user) {
		this.user = user;
	}
	
	@Override
    public void run() {
		
        try{
            final Properties prop = new Properties();
            prop.setProperty("mail.smtp.auth", "true");
            prop.setProperty("mail.host", host);
            prop.put("mail.smtp.port", port);
            prop.put("mail.user", username);
            prop.put("mail.password", password);
            prop.setProperty("mail.transport.protocol", "smtp");
            
            //构建授权信息
            Authenticator authenticator = new Authenticator() {

                protected PasswordAuthentication getPasswordAuthentication() {
                    // 用户名、密码
                    String userName = prop.getProperty("mail.user");
                    String password = prop.getProperty("mail.password");
                    return new PasswordAuthentication(userName, password);
                }
            };
            
           
            Session session = Session.getInstance(prop);
            session.setDebug(true);	//设置获取 debug 信息
            
    		MimeMessage message = new MimeMessage(session);	//用session初始化MimeMessage对象
    		message.setFrom(new InternetAddress(prop.getProperty("mail.user")));	//设置邮件发送人的名字
    		message.setRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));	//设置邮件接收人,还可用addRecipient添加多个地址
    		
    		//设置邮件主题
    		message.setSubject("用户注册邮件");	
    		
    		//设置邮件文本内容, ，设置编码方式
    		String info = "恭喜您注册成功，您的登陆名：" + user.getLoginid();
    		message.setContent(info, "text/html;charset=UTF-8");	
    		
    		message.saveChanges();
    		
    		Transport ts = session.getTransport(); 
    		ts.connect(host, username, password);
            ts.sendMessage(message, message.getAllRecipients());
            ts.close();
            
        }catch (Exception e) {
        	System.out.println("发送邮件失败!");
            throw new RuntimeException(e);
        }
    }
	
}
