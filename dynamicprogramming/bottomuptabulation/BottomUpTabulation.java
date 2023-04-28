package com.example.dynamicprogramming.bottomuptabulation;

import java.util.ArrayList;

public class BottomUpTabulation {
	
	public static void main(String[] args) {
		
		System.out.println(fibTab(4));
		
		System.out.println(factTab(4));
		
		System.out.println(waysToGetNBottomUp(8));
	}
	
	public static int fibTab(int n) {
		ArrayList<Integer> tb = new ArrayList<Integer>();
		tb.add(0); //If n == 1, return 0
		tb.add(1); //If n == 2, return 1
		
		//We have 0 in first index, we have 1 in second index
		for(int i = 2; i <= n; i++) {
			int n1 = tb.get(i - 1);
			int n2 = tb.get(i - 2);
			tb.add(n1 + n2);
		}
		return tb.get(n);
	}
	
	public static int factTab(int n) {
		ArrayList<Integer> tb = new ArrayList<Integer> ();
		tb.add(1);
		tb.add(2);
		
		
		for(int i =2; i <= n + 1; i++) {
			int n1 = (i+1) * tb.get(i-1);
			tb.add(n1);
		}
		return tb.get(n + 1);
	}
	
	 public static int waysToGetNBottomUp(int n) {
	     ArrayList<Integer> tab = new ArrayList<Integer>();
	     tab.add(1);
	     tab.add(1);
	     tab.add(1);
	     tab.add(2);
	     
	     for(int i = 4; i <= n; i++) {
	         int fact1 = tab.get(i-1);
	         int fact2 = tab.get(i-3);
	         int fact3 = tab.get(i-4);
	         tab.add(fact1 + fact2 + fact3);
	     }
	     return tab.get(n); 
	  }

}
