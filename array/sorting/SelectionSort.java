package com.example.array.sorting;

import java.util.Arrays;

public class SelectionSort {
	
	public static void main(String args[]) {
		int arr[] = {10,5,8,2,16, 25,1,4};
		System.out.println(Arrays.toString(selectionSort(arr)));
	}
	
	public static int[] selectionSort(int arr[]) {
		for(int i=0; i < arr.length; i++) {
			int minimumIndex=i;
			for(int j=i+1; j<arr.length; j++) {
				if(arr[j] < arr[minimumIndex]) {
					minimumIndex = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[minimumIndex];
			arr[minimumIndex] = temp;
		}
		return arr;
	}

}
