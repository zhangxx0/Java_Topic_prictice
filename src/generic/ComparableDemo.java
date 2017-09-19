package generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class ComparableDemo {

	public static void main(String[] args) {
		// Comparable
		// 内置应用类型的比较
		Integer integer;
		Character character;
		String string;
		
		Date data = new Date();
		
		// 自定义类型
		// List转为Array之后再进行比较
		String[] arr = {"a","bc","abc"};
		System.out.println((Comparable)arr[0].compareTo("acd"));
		
		
		
		
		// Comparator 独立与实体类；方便实现各种规则
		// 使用Comparator排序数组
		
		// 
		Collections.sort(new ArrayList<String>());
		
		
		
	}
}

class StringComp implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		
		int len1 = o1.length();
		int len2 = o2.length();
		
		return len1 - len2;
	}

	
}






