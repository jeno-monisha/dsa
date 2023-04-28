package com.example.array.sorting;

import java.util.Arrays;

public class MergeSort {
	
	public static void main(String args[]) {
		
		int arr[] = {3,2,8,15,1,10,4,12};
		mergeSort(arr, 0, arr.length-1);
		System.out.println("Array after sorting" + Arrays.toString(arr));
		
	}
	
	public static void mergeSort(int[] arr, int start, int end) {
		if(end <= start) {
			return;
		}
		int middle = (start+end)/2;
		mergeSort(arr, start, middle);//sort left array
		mergeSort(arr, middle+1, end);//sort right array
		merge(arr, start, middle, end);//merge sorted results into array
	}
	
	public static void merge(int[] array, int start, int middle, int end) {
		int tempArray[] = new int[end-start+1];//if start=0, end=3 , end =end-start = 3, but array length is 4
		
		//index Counter for the left side of array
		int leftSlot = start;
		
		//index counter for the right side of array
		int rightSlot = middle+1;
		
		int indexCounter = 0;
		
		while(leftSlot <= middle && rightSlot <= end) {
			if(array[leftSlot] < array[rightSlot]) {
				tempArray[indexCounter] = array[leftSlot];
				leftSlot++;
			} else {
				tempArray[indexCounter] = array[rightSlot];
				rightSlot++;
			}
			indexCounter++;
		}
		
		//when it's here, the above both loops are completed. 
		//So both the right and left arrays can be cosidered sorted.
		
		//consider the right side done being sorted. left must be sorted already
		if(leftSlot <= middle) {
			while(leftSlot <= middle) {
				tempArray[indexCounter] = array[leftSlot];
				leftSlot++;
				indexCounter++;
			}
		} else if(rightSlot <= end) {
			while(rightSlot <= end) {
				tempArray[indexCounter] = array[rightSlot];
				rightSlot++;
				indexCounter++;		
			}
		}
		
		//copy over the temp array into the appropriate array
		for(int i=0; i<tempArray.length; i++) {
			array[start+i] = tempArray[i];
		}
		
	}

}
