package org.jzz.study.util;

import java.io.File;

public class FileUtil {
	public static void ListFile(String dirStr, String spliteStr) {
		File dirFile = new File(dirStr);
		if (!dirFile.exists() || !dirFile.isDirectory() )
			System.out.println("文件不存在或不是目录!!" + dirStr);
		File[] files = dirFile.listFiles();
		for (File file : files) {
			System.out.print(file.getName());
			System.out.print(spliteStr);
		}
	}
	
	public static void main(String[] args) {
		String dirStr = "D:/Document/eclipse-/UnitTest/target/lib";
		ListFile(dirStr, " ./lib/");
	}
	
}
