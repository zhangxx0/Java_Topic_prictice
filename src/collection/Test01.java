package collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import java.util.Arrays;


public class Test01 {

	// Collection
	// Vector 
	void test() {
		List list = new ArrayList();
		
		List list2 = new LinkedList();
		
		Map map = new HashMap();
		
//		Map map2 = new 
		
		Date date = new Date();
		
		Set set = new HashSet();
	}
	
	
	public static void main(String[] args) {
		int oldValue = 10;
		int newValue = oldValue + (oldValue >> 1);
		// System.out.println(newValue);
		
		String test = "test";
		System.out.println(test.hashCode());
		
		Set set = new HashSet();
		set.add("111");
		set.add("222");
		
		System.out.println(set);
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());	
		}
		for (Iterator iter = set.iterator();iter.hasNext();) {
			System.out.println(iter.next());	
		}
		
	}
}
