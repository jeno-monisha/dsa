package com.example.array;

import java.util.Arrays;

public class SortedArrayRemoveDuplicates {
	
	public static void main(String args[]) {
		int[] arr = {5,2,2,4, 4};
		System.out.println(Arrays.toString(removeDuplicates(arr)));
	}
	
	 private static int removeDuplicates(int a[], int n) {
	        if (n == 0 || n == 1) {
	            return n;
	        }
	        int newArrayLength = 0;
	        for (int i = 0; i < n - 1; i++) {
	            if (a[i] != a[i + 1]) {
	                a[newArrayLength++] = a[i];	
	            }
	        }
	        a[newArrayLength++] = a[n - 1];
	        return newArrayLength;

	  }

	  public static int[] removeDuplicates(int[] arr) {
	    int result = removeDuplicates(arr, arr.length);
	    int[] newArray = new int[result];
	    for (int i = 0; i < result; i++) {
	            newArray[i] = arr[i];
	    }
	    return newArray;
	  }




}
