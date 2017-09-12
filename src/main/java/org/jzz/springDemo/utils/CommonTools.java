package org.jzz.springDemo.utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletResponse;


public class CommonTools {
	
	/* 组合返回的json串 */
	public static String  constructJsonStr(HashMap<String, String> rspMap) throws IOException {
		if (rspMap.isEmpty()) {
			return null;
		}
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append("{");
		for (Entry<String,String> msg: rspMap.entrySet() ) {
			strBuffer.append("\"");
			strBuffer.append(msg.getKey());
			strBuffer.append("\":\"");
			strBuffer.append(msg.getValue());
			strBuffer.append("\"");
			strBuffer.append(",");
		}
		String returnStr= strBuffer.substring(0, strBuffer.length() - 1);
		returnStr = returnStr.concat("}");
		return returnStr;
	}
	
	/* 组合返回的json串, 简易版 */
	public static String constructJsonStr(String key, String value) {
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append("{\"");
		strBuffer.append(key);
		strBuffer.append("\":\"");
		strBuffer.append(value);
		strBuffer.append("\"}");
		return strBuffer.toString();
	}
	
    public static String findFileSavePathByFileName(String filename,String saveRootPath){
        int hashcode = filename.hashCode();
        int dir1 = hashcode&0xf;  //0--15 (低1-4位)
        int dir2 = (hashcode&0xf0)>>4;  //0-15(低5-8位)
        String dir = saveRootPath + "\\" + dir1 + "\\" + dir2;  //upload\2\3  upload\3\5
        File file = new File(dir);
        if(!file.exists()){
            //创建目录
            file.mkdirs();
        }
        return dir;
    }
}
