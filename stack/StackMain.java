package com.example.stack;

public class StackMain {
	
	public static void main(String[] args) throws Exception{
		CustomStack numbers = new CustomStack();
		numbers.push(12);
		numbers.push(8);
		numbers.push(20);
		numbers.push(18);
		numbers.push(15);
		numbers.push(10);
		numbers.push(2);
		numbers.pop();
		numbers.push(1);
		numbers.push(90);
		numbers.push(80);
		numbers.push(16);
		
		numbers.display();
		System.out.println(numbers.peek());
		
		DynamicStack numbers1 = new DynamicStack();
		numbers1.push(12);
		numbers1.push(8);
		numbers1.push(20);
		numbers1.push(18);
		numbers1.push(15);
		numbers1.push(10);
		numbers1.push(2);
		numbers1.pop();
		numbers1.push(1);
		numbers1.push(90);
		numbers1.push(80);
		numbers1.push(16);
		
		numbers1.push(25);
		numbers1.push(30);
		numbers1.push(35);
		numbers1.push(85);
		
		numbers1.display();
		System.out.println(numbers1.peek());
		
		StackUsingLinkedList numbers2 = new StackUsingLinkedList();
		numbers2.push(12);
		numbers2.push(8);
		numbers2.push(20);
		numbers2.push(18);
		numbers2.push(15);
		numbers2.push(10);
		numbers2.push(2);
		numbers2.pop();
		numbers2.push(1);
		numbers2.push(90);
		numbers2.push(80);
		numbers2.push(16);
		
		numbers2.push(25);
		numbers2.push(30);
		numbers2.push(35);
		numbers2.push(85);
		
		numbers2.display();
		System.out.println(numbers1.peek());
		
		MinStack min = new MinStack();
		min.push(1);
		min.push(2);
		
		System.out.println(min.min());
		
	}

}
