package org.jzz.springDemo.utils;

import java.security.MessageDigest;  
import org.apache.commons.codec.binary.Hex; 

public class PasswordUtil {
	
	public static String getSalt() {
		String salt = null;
		salt = md5Hex(String.valueOf(System.currentTimeMillis()));
		if (salt == null){
			salt = new String("ddfc4d18cb058291975e6bc8313d7b93");
        }  
		return salt;
	}
	
	public static  boolean verify(String password, String salt, String md5) {
		return md5Hex(password + salt).equals(md5);  
	}
	
    public static String md5Hex(String src) {  
        try {  
            MessageDigest md5 = MessageDigest.getInstance("MD5");  
            byte[] bs = md5.digest(src.getBytes());  
            return new String(new Hex().encode(bs));  
        } catch (Exception e) {  
            return null;  
        }  
    }
    
}
