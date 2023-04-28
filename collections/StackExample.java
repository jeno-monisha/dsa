package com.example.collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class StackExample {
	
public static void main(String[] args) {
		
		Stack<Integer> numbers = new Stack<Integer>();
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
		
		numbers.insertElementAt(20, 1);
		
		System.out.println("");
		
		numbers.forEach(number -> System.out.print(number + " "));
		
		//removes the top element - last index value
		numbers.pop();
		
		System.out.println("");
		
		numbers.forEach(number -> System.out.print(number + " "));
		
		//insert value at end
		numbers.push(25);
		
		System.out.println("");
		
		numbers.forEach(number -> System.out.print(number + " "));
		
		System.out.println();
		
		System.out.println("First Index value is " + numbers.firstElement());
		
		System.out.println("Index position of search value is " + numbers.search(2));
		
        System.out.println(Arrays.toString(numbers.toArray()));
        
	}

}
