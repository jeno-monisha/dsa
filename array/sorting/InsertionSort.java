package com.example.array.sorting;

import java.util.Arrays;

public class InsertionSort {
	
	public static void main(String args[]) {
		int arr[] = {10,5,8,2,16, 25,1,4};
		System.out.println(Arrays.toString(insertionSort(arr)));
	}
	
	public static int[] insertionSort(int arr[]) {
		for(int i=1; i < arr.length; i++) {
			int element = arr[i];//element variable contains the data we intended over to the sorted area.
			int j=i-1;//j variable points to the index position of the last value in the sorted area.
			while(j>=0 && arr[j] > element) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = element;
		}
		return arr;
	}

}
