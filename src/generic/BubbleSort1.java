package generic;

import java.util.Arrays;

public class BubbleSort1 {
	
	

	public static void main(String[] args) {
//		int[] arrsort = {9,8,7,6,5};
		int[] arrsort = {9,1,2,3,4};
		// 
		
		for (int j = 0; j < arrsort.length-1 ; j++) {
			boolean sorted = true;
//			for (int i = 0; i < arrsort.length - 1; i++) {
			for (int i = 0; i < arrsort.length-1-j; i++) {
				if(arrsort[i] > arrsort[i+1]) {
					int temp = arrsort[i];
					arrsort[i] =  arrsort[i+1];
					arrsort[i+1] = temp;
					sorted =false;
				}
			}
			System.out.println("趟数：" + j +":"+ Arrays.toString(arrsort));
			if (sorted) {
				break;
			}
		}
		

		System.out.println(Arrays.toString(arrsort));
	}
	
}
