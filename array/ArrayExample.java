package com.example.array;

import java.util.Arrays;
import java.util.Collections;

public class ArrayExample {
	
	public static void main(String[] args) {
		ArrayExample example = new ArrayExample();
        
        int[] firstArray = {1,2,3,4,5,6,8,9,10};
        int[] secondArray = {1,2,3,4,5,6,7,8,9,10};
        example.missingNumber(firstArray);
        example.missingNumber(firstArray, secondArray);
        System.out.println(example.maxProduct(firstArray));
        
        int[] intArray = {1,2,3,4,5,6,7,8,9,10,11,12};
        System.out.println(example.isUnique(intArray));
        
        int a1[] = {2,1,5,4,6,3};
        int a2[] = {4,1,3,6,2,5};
        System.out.println(example.isPermutated(a1, a2));
        
        System.out.println(Arrays.toString(middle(intArray)));
        System.out.println(Arrays.toString(middleFunction(intArray)));
        
        int myArray[] = {84,85,86,87,85,90,85,83,23,45,84,1,2,0};
        System.out.println(firstSecond(myArray));
        
        int a16[] = {1,2,3,4,6};
        System.out.println(missingNumber(a16, 6));
        
    }
	
	//Find the missing Number of given array values between 1-10 or 1 to 100
    public void missingNumber(int[] intArray) { 	
    	int sum1 = sum(intArray);
    	//calculate sum of numbers upto 10 : fprmula is n*(n+1)/2
    	int sum2 = 10*(10+1)/2;
        int missingNumber = sum2 - sum1;
        System.out.println(missingNumber);
	    
    }
    
    //To Calculate the missing number between two arrays, calculate the sum of two arrays and find the difference
    public void missingNumber(int[] firstArray, int[] secondArray) { 	
    	int sum1 = sum(firstArray);
    	//calculate sum of numbers upto 10 : formula is n*(n+1)/2
    	int sum2 = sum(secondArray);
        int missingNumber = sum2 - sum1;
        System.out.println(missingNumber);
	    
    }
    
    public int sum(int[] array) {
    	int sum = 0;
    	for(int i=0; i<array.length; i++) {
    		sum = sum + array[i];
    	}
    	return sum;
    }
    
    public int product(int[] array) {
    	int product = 0;
    	for(int i=0; i<array.length; i++) {
    		product = product + array[i];
    	}
    	return product;
    }
    
    public int[] twoSum(int[] nums, int target) {
        int[] pairs = new int[2];
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    pairs[0] = i;
                    pairs[1] = j;
                    return pairs;
                }
            }
        }
        return pairs;
    }
    
    public String maxProduct(int[] intArray) {
        int maxProduct = 0;
        String returnValue = null;
        for(int i=0; i<intArray.length; i++) {
            for(int j=i+1; j<intArray.length; j++) {
                if((intArray[i]* intArray[j]) > maxProduct) {
                    maxProduct = intArray[i]* intArray[j];
                    returnValue = intArray[i] + "," +  intArray[j] ;
                }
            }
        }
        return returnValue;
    }
    
    //check duplicate
    public boolean isUnique(int[] intArray) {
        for(int i=0; i<intArray.length; i++) {
            for(int j=i+1; j<intArray.length;j++) {
                if(intArray[i] == intArray[j]) {
                    return false;
                } 
            }
        }
        return true;
    }
    
    //permutation
    public boolean isPermutated(int[] firstArray, int[] secondArray) {
    	if(firstArray.length != secondArray.length) {
    		return false;
    	}
    	int sum1 = sum(firstArray);
    	int sum2 = sum(secondArray);
    	
    	int product1 = product(firstArray);
    	int product2 = product(secondArray);
    	
    	if(sum1 == sum2 && product1 == product2) {
    		return true;
    	}
    	return false;
    	
    }
    
    public static int[] middle(int[] arr) {
        if(arr.length == 0) {
            return null;
        }
        int start = 0;
        int end = arr.length;
        int middle = (start+end)/2;
        int middleArray[] = {arr[middle-1], arr[middle] };
        return middleArray;
    }
    
    //Write a function called middle that takes a list and returns a new list that contains all but the first and last elements.
    public static int[] middleFunction(int[] arr) {
        return Arrays.copyOfRange(arr, 1, arr.length-1); 
    }
    
    public static String firstSecond(int[] myArray) {
        for(int i=0;i<myArray.length;i++) {
            for(int j=1; j<myArray.length;j++) {
                if(myArray[j-1] > myArray[j]) {
                    int temp = myArray[j-1];
                    myArray[j-1] = myArray[j];
                    myArray[j] = temp;
                }
            }
        }
        return myArray[myArray.length-1] + " " + myArray[myArray.length-1-1];
    }
    
    //find First and Second Mark
    public static String firstSecond(Integer[] myArray) {
        Integer[] arr = myArray;
        Arrays.sort(arr, Collections.reverseOrder());
        int first = arr[0];
        Integer second = null;
        for (int i=0; i<arr.length; i++) {
          if (arr[i] != first) {
            second = arr[i];
            break;  
          }
        }
        return first+" "+second;
    }
    
    public static int missingNumber(int[] arr, int totalCount) {
        int sum1 = 0;
        for(int i=0; i<arr.length; i++) {
            sum1 = sum1 + arr[i];
        }
        int sum2 = totalCount*(totalCount+1)/2;
        int difference = sum2- sum1;
        return difference;
    }
    
    //Write a function to find all pairs of an integer array whose sum is equal to a given number.
    public static String pairSum(int[] myArray, int sum) {
        String returnValue = "";
          for(int i=0;i<myArray.length;i++) {
              for(int j=i+1; j<myArray.length; j++) {
                  if(myArray[i] + myArray[j] == sum) {
                      returnValue = returnValue +  "" + myArray[i] + ":" + myArray[j] + " ";
                  }
              }
          }
         return returnValue;
    }



}
