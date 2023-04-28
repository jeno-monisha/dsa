package com.example.array;

public class SearchAlgorithm {
	
	public static void main(String[] args) {
		int unSortedArray[] = {15,78,48,52,38,72,88,72,18,22};
		int sortedArray[] = {8,16,24,32,40,48,56,64,72,80};
		
		System.out.println(linearSearch(unSortedArray, 38));
		System.out.println(binarySearch(sortedArray, 56));
	}
	
	public static int linearSearch(int unSortedArray[], int value) {
		for(int i=0; i<unSortedArray.length; i++) {
			if(unSortedArray[i]==value) {
				return i;
			}
		}
		return -1;
	}
	
	public static int binarySearch(int sortedArray[], int value) {
		int start=0;
		int end = sortedArray.length -1;
		
		while(start <= end) {
			
			int middle = (start + end)/2;
			
			if (value == sortedArray[middle]) {
				return middle;
			} else if (value<sortedArray[middle]) {
				end = middle - 1;
			} else {
				start = middle + 1;
			}
			
		}
		
		return -1;
	}

}
