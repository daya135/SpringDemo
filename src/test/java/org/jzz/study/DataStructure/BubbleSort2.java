package org.jzz.study.DataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.jzz.study.util.Print;

/* 泛型排序方法版本二
 * 进阶：不需要再额外配置比较器了，被排序的类型自身实现Comparable接口，才能运用于排序类泛型参数*/
//public class BubbleSort2 <T extends Comparable<T>>{

/* 泛型排序方法版本三，
 * 通用写法：只要T的父类实现了Comparable接口（不需要T类型自己再实现了），则T可作为排序类的泛型参数 */	
public class BubbleSort2 <T extends Comparable<? super T>>{	
	
	public T get(List<? extends T> list, int index) {
		return list.get(index);
	}
	
	public void set(List<? super T> list, int index, T arg) {
		list.set(index,arg);
	}
	
	public void Sort(List<T> list) {
		for (int i = 0; i < list.size() -1; i++) {
			Boolean overFlag = true;
			for(int j = 1; j < list.size() - i; j++) {	//每次都要从头开始扫描，截止到上一个冒出泡的位置
				if (get(list, j - 1).compareTo(get(list, j)) > 0) { //控制排序方向
					T t = get(list, j - 1);
					set(list, j - 1, get(list, j));
					set(list, j, t);
					overFlag = false;
				}
			}
			if (overFlag) break;
		}
	}
	
	public static <E extends Comparable<E>> void Sort(E[] arrayT) {
		for (int i = 0; i < arrayT.length -1; i++) {
			Boolean overFlag = true;
			for(int j = 1; j < arrayT.length - i; j++) {	//每次都要从头开始扫描，截止到上一个冒出泡的位置
				if (arrayT[j -1].compareTo(arrayT[j]) > 0) { //控制排序方向
					E e = arrayT[j -1];
					arrayT[j -1] = arrayT[j];
					arrayT[j] = e;
					overFlag = false;
				}
			}
			if (overFlag) break;
		}
	}
	
	public static void main(String[] args) {
		BubbleSort2<String> bubbleSort = new BubbleSort2<>();
		List<String> list= new ArrayList<>(Arrays.asList("bb", "aa", "cc"));
		bubbleSort.Sort(list);
		Print.print(list);
		Integer[] integers = {1,3,2,5,4};
		BubbleSort2.<Integer>Sort(integers);
		Print.print(Arrays.asList(integers));
	}
}
