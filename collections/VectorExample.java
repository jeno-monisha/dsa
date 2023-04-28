package com.example.collections;

import java.util.Vector;

public class VectorExample {
	
public static void main(String[] args) {
		
		Vector<Integer> numbers = new Vector<Integer>();
		numbers.add(8);
		numbers.add(5);
		numbers.add(3);
		numbers.add(9);
		numbers.add(2);
		numbers.add(4);
		numbers.add(10);
		numbers.add(15);
		
		for(Integer number: numbers) {
			System.out.print(number + " ");
		}
		
		System.out.println();
		System.out.println("Value of particular object is " + numbers.get(numbers.size()-1));
		
		System.out.println("Index from particular index is " + numbers.indexOf(4));
		
		numbers.remove(2);
		
		numbers.forEach(number -> System.out.print(number + " "));
		
		System.out.println();
		
		numbers.subList(0, 4).forEach(subList -> System.out.print(subList + " "));
		
		numbers.firstElement();
		numbers.addElement(25);
		numbers.insertElementAt(18, 4);
		
		
	}

}
