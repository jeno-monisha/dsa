package com.example.array.sorting;

import java.util.Arrays;

public class BubbleSort {
	
	public static void main(String args[]) {
		int[] numbers = {10, 5, 3, 8, 2,9};
		
		int n = numbers.length;
		for(int i=0; i < n-1; i++) {
			for(int j=0; j < n-i-1; j++) {
				if(numbers[j] > numbers[j + 1]) {
					var temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(numbers));
		
		
		System.out.println(Arrays.toString(reverseSorting(numbers)));
	}
	
	public static int[] reverseSorting(int a[]) {	
		int n= a.length;
		for(int i=0; i < n-1; i++) {	
			for(int j=0; j <n-i-1; j++) {
				if(a[j] < a[j+1]) {
					var temp = a[j+1];
					a[j+1] = a[j];
					a[j] = temp;
					
				}
			}
		}
		return a;	
	}

}
