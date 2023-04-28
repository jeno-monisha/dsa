package com.example.stack;

import java.util.Stack;

public class StackSortUsingRecursion {
	
	public static void main(String[] args) {
		Stack<Integer> numbers = new Stack<Integer>();
		numbers.push(18);
		numbers.push(5);
		numbers.push(25);
		numbers.push(12);
		numbers.push(30);
		numbers.push(8);
		numbers.push(11);
		numbers.push(10);
		
		System.out.println(numbers);
		
		sortStack(numbers);
		
		System.out.println(numbers);
	}
	
	 static void sortedInsert(Stack<Integer> s, int x)
	    {
	        // Base case: Either stack is empty or newly
	        // inserted item is greater than top (more than all
	        // existing)
	        if (s.isEmpty() || x > s.peek()) {
	            s.push(x);
	            return;
	        }
	 
	        // If top is greater, remove the top item and recur
	        int temp = s.pop();
	        sortedInsert(s, x);
	 
	        // Put back the top item removed earlier
	        s.push(temp);
	    }
	 
	    // Method to sort stack
	    static void sortStack(Stack<Integer> s)
	    {
	        // If stack is not empty
	        if (!s.isEmpty()) {
	            // Remove the top item
	            int x = s.pop();
	 
	            // Sort remaining stack
	            sortStack(s);
	 
	            // Push the top item back in sorted stack
	            sortedInsert(s, x);
	        }
	    }
	    
	    public static Stack<Integer> sortstack(Stack<Integer> input){
			Stack<Integer> tmpStack = new Stack<Integer>();
			while(!input.isEmpty())
				{
				// pop out the first element
				int tmp = input.pop();
				
				// while temporary stack is not empty and
				// top of stack is greater than temp
				while(!tmpStack.isEmpty() && tmpStack.peek()> tmp)
				{
					// pop from temporary stack and
					// push it to the input stack
					input.push(tmpStack.pop());
				}
					
				// push temp in temporary of stack
				tmpStack.push(tmp);
				}
				return tmpStack;
			}

}
