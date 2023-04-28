package com.example.stack;

import java.util.Stack;

public class StackParanthesis {
	
	
	//If the character is open brackets like {[(, then add it to stack.
	//Else if the character is close brackets like ]}) and then equal to the open braces of the top of the stack, then remove it from stack
	//Else add it to stack
	public static void main(String[] args) {
		//String str = "{()}[]";
		String str = "{[]}]";
		
		Stack<Character> chars = new Stack<Character>();
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == '{' ||
					str.charAt(i) == '[' || 
					str.charAt(i) == '(') {
				chars.push(str.charAt(i));
			} else if(!chars.isEmpty() && 
					((str.charAt(i) == '}' && chars.peek() == '{') ||
					(str.charAt(i) == ']' && chars.peek() == '[') ||
					(str.charAt(i) == ')' && chars.peek() == '('))) {
				chars.pop();
		    } else {
		    	chars.push(str.charAt(i));
		    }
		}
		
		if(chars.isEmpty()) {
			System.out.println("It is Valid");
		} else {
			System.out.println("It is not valid");
		}
	}

}
