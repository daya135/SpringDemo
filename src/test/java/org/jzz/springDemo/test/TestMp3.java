package org.jzz.springDemo.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jzz.springDemo.utils.*;
import org.jzz.webUtils.FileCompare;
import org.jzz.webUtils.MP3Analysis;
import org.jzz.springDemo.domain.Song;

public class TestMp3 {
	public static void main(String args[]) throws FileNotFoundException{
		

		//查找指定目录下的mp3文件列表
//			ProcessHtml processHtml = new ProcessHtml();
//			List<SongBean> list = processHtml.findSong();
//			for (int i = 0; i < list.size(); i++) {
//				if (list.get(i).getSongName().equals("創聖のアクエリオン")) {
//					System.out.println(i);
//				}
//			}
//			byte buf[] = {(byte)0x49, (byte)0x44, (byte)0x33};
//			byte buf2[] = {(byte)0xff, (byte)0xfe, (byte)0x54, (byte)0x00, (byte)0x68,  (byte)0x00,(byte)0x65,  (byte)0x00};
//			//byte Size[] = {(byte)0x01, (byte)0x00, (byte)0x00, (byte)0x00};
//	        System.gc();
//	        long total = Runtime.getRuntime().totalMemory(); // byte
//	        long m1 = Runtime.getRuntime().freeMemory();
//	        System.out.println("1:" + (total - m1));
//			byte Size[] = new byte[0x01000000];
//	       //byte Size[] = new byte[0x00010000];
//	        long total1 = Runtime.getRuntime().totalMemory();
//	        long m2 = Runtime.getRuntime().freeMemory();
//	        System.out.println("2:" + (total1 - m2));

//			 Size[1] = (byte)0x05;
//			 Size[2] = (byte)0x37;
//			 Size[3] = (byte)0x5a;
//			 Size[4] = (byte)0x54;
//			String str1 = new String(buf,  "ASCII");	
//			String str2 = new String(buf2, 0, 8, "unicode");
//			System.out.println(str1);
//			System.out.println(str2);
			
//			System.out.println((Size[0]&0x7F)*0x200000+ (Size[1]&0x7F)*0x400 + (Size[2]&0x7F)*0x80 +(Size[3]&0x7F) );
//			System.out.println(((Size[0]&0xff)*0x1000000) + ((Size[1]&0xff)*0x10000)+ ((Size[2]&0xff)*0x100) + (Size[3]&0xff));
//			System.out.println((Size[0]&0xff)*0x1000000 + (Size[1]&0xff)*0x10000+ (Size[2]&0xff)*0x100 + (Size[3]&0xff));

//	        System.out.println("3:" + 0x00100000);
		
			MP3Analysis analysis = new MP3Analysis();
			String fileName = "D:\\Audio\\めらみぽっぷ - 竹ノ花 - 译名竹之花.mp3";
			analysis.mp3Info(fileName);
//
//			byte buf[] = {(byte)0x49, (byte)0x44, (byte)0x33};
//			for (byte b:buf) {
//				System.out.print(Integer.toHexString(b));
//				System.out.print(" ");
//			}
		
		FileCompare fileCompare = new FileCompare(analysis);
		fileCompare.readLocalMP3("D:\\Audio\\虾米音乐");
		
	}
}
