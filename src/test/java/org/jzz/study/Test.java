package org.jzz.study;

import java.lang.reflect.Array;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.jzz.study.util.Print;
import org.springframework.util.StringUtils;

public class Test {
	
	private static final int[] a = {1,2};
	
	
	public static void main(String[] args)  {
		//System.out.println();
		
		System.out.println(Arrays.toString(a));
		Object obj = null;
		String string = " ";
		System.out.println(StringUtils.isEmpty(string));
		String[] strings = "aa,bb,cc,dd".split(",");
		List<String> list = Arrays.asList(strings);	//产生基于固定数组的定长容器，不支持增删
		try {
			list.add("ee");
		} catch (UnsupportedOperationException e) {
			e.printStackTrace();
		}
		List<String> newList = new ArrayList<>(list); //可变长容器初始化之一
		//newList.addAll(list);  //可变长容器初始化之二
		newList.add("ee");
		
		newList.set(0, "ff");	
		newList.add(1, "gg");
		
		Print.print(list);
		Print.print(newList);
		
		strings = "aa,bb,cc,dd".split(",");
		Print.print(strings[0].compareTo(strings[1]));
		
	}
}

