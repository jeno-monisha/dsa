package com.example.queue;

import java.util.Stack;

public class QueueViaStack {
	
	public Stack<Integer> newestStack;
	public Stack<Integer> oldestStack;
	
	public QueueViaStack() {
		this.newestStack = new Stack<Integer>();
		this.oldestStack = new Stack<Integer>();
	}
	
	public void enqueue(int value) {
		newestStack.push(value);
	}
	
	private void shiftStacks() {
		if(oldestStack.isEmpty()) {
			while(!newestStack.isEmpty()) {
				oldestStack.push(newestStack.pop());
			}
		}
	}
	
	public int dequeue() {
		shiftStacks();
	    return oldestStack.pop();
	}
	
	public int peek() {
		shiftStacks();
	    return oldestStack.peek();
	}

}
