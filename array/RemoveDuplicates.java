package com.example.array;

import java.util.Arrays;

public class RemoveDuplicates {
	
	public static void main(String args[]) {
		int[] arr = {1, 1, 2, 2, 3, 4, 5};
		System.out.println(Arrays.toString(removeDuplicates(arr)));
	}
	
	public static int[] removeDuplicates(int[] arr) {
		
	    int duplicatesCount = 0;
	    
	    //Remove Duplicates by assign Integer.MIN_VALUE to the duplicate value
	    for(int i=0;i<arr.length;i++) {
	        for(int j=i+1; j<arr.length; j++) {
	            if(arr[i] == arr[j]) {
	                arr[i] = Integer.MIN_VALUE;
	                duplicatesCount++;
	            } 
	        }
	    }
	    
	    int newArrayLength = arr.length - duplicatesCount;
	    return generateNewArrayWithoutDuplicates(arr, newArrayLength);
	   
	    
	  }
	
	public static int[] generateNewArrayWithoutDuplicates (int[] oldArray, int newArrayLength) {
		
		
		int[] newArray = new int[newArrayLength];
		
		//We need newArrayIndex because oldArray contains Integer.MIN_VALUE value in the duplicate field. Two array sizes are different
	    for(int oldArrayIndex=0, newArrayIndex=0; oldArrayIndex < oldArray.length; oldArrayIndex++) {
	        if(oldArray[oldArrayIndex] != Integer.MIN_VALUE) {
	            newArray[newArrayIndex] = oldArray[oldArrayIndex];
	            newArrayIndex++;
	        }
	    }
	    return newArray;
	}


}
