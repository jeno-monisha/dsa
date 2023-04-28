package com.example.dynamicprogramming.topdownmemoization;

import java.util.HashMap;

public class TopDownMemoization {
	public static void main(String[] args) {
		
		HashMap<Integer, Integer> fibMemo = new HashMap<Integer, Integer>();
		System.out.println(fibMemo(6, fibMemo));
		
		HashMap<Integer, Integer> factMemo = new HashMap<Integer, Integer> ();
		System.out.println(findfact(6, factMemo));
		
	}
	
	public static int fibMemo(int n, HashMap<Integer, Integer> memo) {
		
		if(n==1) {
			return 0;
		}
		if(n == 2) {
			return 1;
		}
		
		if(!memo.containsKey(n)) {
			memo.put(n, (fibMemo(n-1, memo) + fibMemo(n-2, memo)));
		}
		return memo.get(n);
	}
	
	public static int findfact(int n, HashMap<Integer, Integer> memo) {
		if(n == 1) {
			return 1;
		}
		if(!memo.containsKey(n)) {
			memo.put(n, (n*findfact(n-1, memo)));
		}
		
		return memo.get(n);
	}
	
	public int waysToGetNTopDown(int[] arr, int n) {
		   if(n == 0 || n == 1 || n==2) {
		       return 1;
		   }
		   if(n == 3) {
		       return 2;
		   }
		   
		   if(arr[n] == 0) {
	    	   int fact1 = waysToGetNTopDown(arr, n-1);
	    	   int fact2 = waysToGetNTopDown(arr, n-3);
	    	   int fact3 = waysToGetNTopDown(arr, n-4);
	    	   
	    	   arr[n] = fact1 + fact2 + fact3;
		   }
		   
		   return arr[n];
		}
		
		public int waysToGetNTopDown(int n) {
		    int[] array = new int[n+1];
		    return waysToGetNTopDown(array, n);
		}

}
