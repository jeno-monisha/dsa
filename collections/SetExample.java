package com.example.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {
	
	public static void main(String[] args) {
		
		//it does not maintain the insertion order
		Set<Integer> numbers = new HashSet<Integer> ();
		numbers.add(15);
		numbers.add(20);
		numbers.add(5);
		numbers.add(35);
		numbers.add(60);
		numbers.add(80);
		numbers.add(80);
		numbers.add(80);
		numbers.add(10);
		numbers.add(90);
		
		for(Integer number: numbers) {
			System.out.print(number + " ");
		}
		
		System.out.println();
		
		//it maintains the insertion order
		LinkedHashSet<Integer> numbers1 = new LinkedHashSet<Integer> ();
		numbers1.add(15);
		numbers1.add(20);
		numbers1.add(5);
		numbers1.add(35);
		numbers1.add(60);
		numbers1.add(80);
		numbers1.add(80);
		numbers1.add(80);
		numbers1.add(10);
		numbers1.add(90);
		
		for(Integer number: numbers1) {
			System.out.print(number + " ");
		}
		
        System.out.println();
		
		//sorted set
		TreeSet<Integer> numbers2 = new TreeSet<Integer> ();
		numbers2.add(15);
		numbers2.add(20);
		numbers2.add(5);
		numbers2.add(35);
		numbers2.add(60);
		numbers2.add(80);
		numbers2.add(80);
		numbers2.add(80);
		numbers2.add(10);
		numbers2.add(90);
		
		for(Integer number: numbers2) {
			System.out.print(number + " ");
		}
	}

}
