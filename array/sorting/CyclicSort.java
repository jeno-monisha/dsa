package com.example.array.sorting;

import java.util.Arrays;

public class CyclicSort {
	
	public static void main(String[] args) {
		int arr[] = {30, 20, 10, 40, 60, 50};
		cyclicSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void cyclicSort(int[] arr) {
		int start =10;
		for(int i =0; i < arr.length; i++) {
			if(arr[i] != start) {
				arr[i] = start;
				start = start + 10;
			}
		}
	}

}
