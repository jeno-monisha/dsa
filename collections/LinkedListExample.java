package com.example.collections;

import java.util.LinkedList;

public class LinkedListExample {
	
public static void main(String[] args) {
		
		LinkedList<Integer> numbers = new LinkedList<Integer>();
		numbers.add(8);
		numbers.add(5);
		numbers.add(3);
		numbers.add(9);
		numbers.add(12);
		numbers.add(10);
		numbers.add(12);
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
		
		System.out.println();
		System.out.println(numbers.getFirst());
		System.out.println(numbers.getLast());
		
		//it removes the head of the list
		System.out.println("Head of the List is " + numbers.peek());
		
		//removes the first element of the list
		numbers.pop();
		
		numbers.forEach(number -> System.out.print(number + " "));
		
		System.out.println();
		
		numbers.push(8);
		
		numbers.forEach(number -> System.out.print(number + " "));
		
		numbers.removeFirst();
		numbers.removeFirstOccurrence(10);
		numbers.removeLast();
		numbers.removeLastOccurrence(12);
		
		System.out.println();
		numbers.forEach(number -> System.out.print(number + " "));
		
		//It does not support getFirstElement and insertElementAt(value, index) methods.
		
		LinkedList<Integer> ll1 = new LinkedList<Integer>();
		ll1.add(5);
		ll1.add(3);
		ll1.add(2);
		
		LinkedList<Integer> ll2 = new LinkedList<Integer>();
		ll2.add(3);
		ll2.add(5);
		ll2.add(8);
		
		sumOfDigits(ll1, ll2);
	}

    public static void sumOfDigits(LinkedList<Integer> ll1, LinkedList<Integer> ll2) {
   
    	int total = reverseNumber(converttoDigit(ll1)) + reverseNumber(converttoDigit(ll2));
    
    	LinkedList<Integer> totalList = new LinkedList<>();
    	while(total > 0) {
    		int remainder = total % 10;
    		totalList.add(remainder);
    		total = total / 10;
    	}
    	
    	System.out.println();
    	for(Integer number: totalList) {
    		System.out.print(number + " ");
    	}
    	
    }
    
    public static int reverseNumber (int number) {
    	int reversedNumber = 0;
    	while(number > 0) {
    		int remainder = number % 10;
    		reversedNumber = (reversedNumber*10) + remainder;
    		number = number / 10;
    	}
    	return reversedNumber;
    }
    
    public static int converttoDigit(LinkedList<Integer> ll) {
    	int digit = 0;
    	for(Integer number: ll) {
    		digit = (digit*10) + number;
    	}
    	return digit;
    }
    
}
