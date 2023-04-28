package com.example.array.sorting;

import java.util.Arrays;

public class QuickSort {
	
	public static void main(String[] args) {
		
		int arr[] = {5,10,3,15,8,6,7,4,2};
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void quickSort(int[] inputArray, int start, int end) {
		if(end <= start) {
			return;
		}
		int pivot = partition(inputArray, start, end);//gives the index position of the correctly placed array
		quickSort(inputArray, start, pivot-1);//Sorts the left array. It is less than 1 because we exclude pivot value
		quickSort(inputArray, pivot+1, end);//Sorts the right array
	}
	
	public static int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		//In the first iteration, i starts from -1
		int i = start-1;
		
		for(int j=start; j<=end;j++) {
			if(arr[j] <= pivot) {
				i++;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		
		//put the pivot value in the correct slot next
		//int temp = arr[i+1];
		//arr[end] = temp;
		//here, placed pivot value is placed in the correct slot of array
		//arr[i+1] = pivot;//we can also use arr[end]
		return i;
	}

}
