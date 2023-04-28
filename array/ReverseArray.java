package com.example.array;

import java.util.Arrays;

public class ReverseArray {
	
	public static void main(String args[]) {
		int a[] = new int[] {1,10,8,2,12,6,18};
		
		for(int i=0; i<a.length/2; i++) {
			
			int numberFromLast = a.length-i-1;
			int temp = a[i];
			a[i] = a[numberFromLast];
			a[numberFromLast] = temp;
			
		}
		
		System.out.println(Arrays.toString(a));
		
		reverseArray(a, a.length-1);
		
	}
	
	public static void reverseArray(int[] arr, int index) {
		if(index < 0) {
			return;
		}
		System.out.print(arr[index] + " ");
		reverseArray(arr, index-1);
	}
	

}
