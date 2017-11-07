package org.jzz.study.DataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.jzz.study.util.Print;


/* 泛型排序方法版本一 */
/* 测试类的比较方器, 每种需要排序的类型需要额外配置一个比较器，用于在泛型方法中实现比较*/
public class BubbleSort <T>{
	
	/* 这里BubbleSort实际上充当了适配器的角色 ,实现对泛型容器的读取和写入 */
	public T get(List<? extends T> list, int index) {
		return list.get(index);
	}
	public void set(List<? super T> list, int index, T arg) {
		list.set(index,arg);
	}
	
	/* 对容器进行排序 */
	public void Sort(List<T> list, Comparator<T> comparator) {
		for (int i = 0; i < list.size() -1; i++) {
			Boolean overFlag = true;
			for(int j = 1; j < list.size() - i; j++) {	//每次都要从头开始扫描，截止到上一个冒出泡的位置
				if (comparator.compare(get(list, j - 1), get(list, j)) > 0) { //控制排序方向
					T t = get(list, j - 1);
					set(list, j - 1, get(list, j));
					set(list, j, t);
					overFlag = false;
				}
			}
			if (overFlag) break;
		}
	}
	
	/* 对数组进行排序 */
	public static <E> void Sort(E[] arrayT, Comparator<E> comparator) {
		for (int i = 0; i < arrayT.length -1; i++) {
			Boolean overFlag = true;
			for(int j = 1; j < arrayT.length - i; j++) {	//每次都要从头开始扫描，截止到上一个冒出泡的位置
				if (comparator.compare(arrayT[j -1], arrayT[j]) > 0) { //控制排序方向
					E e = arrayT[j -1];
					arrayT[j -1] = arrayT[j];
					arrayT[j] = e;
					overFlag = false;
				}
			}
			if (overFlag) break;
		}
	}
	
	/* 为测试类型配置的比较器 */
	class CompareStr implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {
			return o1.compareTo(o2);
		}
	}
	class CompareInt implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o1.compareTo(o2);
		}
	}
	
	public static void main(String[] args) {
		BubbleSort<String> bubbleSort = new BubbleSort<>();
		//List<String> list = Arrays.asList(String[]);	//产生基于固定数组的定长容器(fix-size)，不支持增删
		List<String> list = new ArrayList<>(Arrays.asList("aab", "cbb", "bcc")); //这样容器变成可变长容器了！
		list.add("dd");
		Comparator compareStr = bubbleSort.new CompareStr();
		Comparator compareInt = bubbleSort.new CompareInt();
		Print.print(list);
		bubbleSort.Sort(list, compareStr);
		Print.print(list);
		//bubbleSort.Sort(list, compareInt);	//继承泛型接口后将继承其泛型参数
		
		
		Integer[] integers = {1,3,2,5,4};
		BubbleSort.Sort(integers, compareInt); //使用泛型方法对数组排序
		Print.print(Arrays.asList(integers));
		
	}
}
