package com.example.queue;

import com.example.stack.CustomStack;
import com.example.stack.DynamicStack;

public class QueueMain {

	public static void main(String[] args) throws Exception{
		CustomQueue numbers = new CustomQueue();
		numbers.insert(12);
		numbers.insert(8);
		numbers.insert(20);
		numbers.insert(18);
		numbers.insert(15);
		numbers.insert(10);
		numbers.insert(2);
		
		numbers.display();
		
		numbers.remove();
		numbers.display();
		
		numbers.insert(1);
		numbers.insert(90);
		numbers.insert(80);
		numbers.insert(16);
		
		numbers.display();
		System.out.println(numbers.peek());
		
		numbers.display();
		
	    CircularQueue numbers2 = new CircularQueue(); 
	    numbers2.insert(12);
	    numbers2.insert(8); 
	    numbers2.insert(20);
	    numbers2.insert(18);
	    numbers2.insert(15);
	    numbers2.insert(10); 
	    numbers2.insert(2); 
	    numbers2.remove(); 
	    numbers2.insert(1);
	    numbers2.insert(90); 
	    numbers2.insert(80); 
	    numbers2.insert(16);
		  
		numbers2.insert(25); 
		numbers2.insert(30); 
		numbers2.insert(35); 
		numbers2.insert(85);
		  
		numbers2.display(); 
		  
		System.out.println(numbers2.peek());
	 
	}
	
}
