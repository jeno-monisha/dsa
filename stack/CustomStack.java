package com.example.stack;

public class CustomStack {
	
	public int[] data;
	public static final int DEFAULT_SIZE = 10;
	
	public int index = -1;
	
	public CustomStack() {
		this(DEFAULT_SIZE);
	}
	
	public CustomStack(int size) {
		this.data = new int[size];
	}
	
	public boolean push(int value) throws Exception{
		if(isFull()) {
			throw new Exception("Stack is Full");
		}
		index++;
		data[index] = value;
		return true;
	}
	
	public int pop() throws Exception{
		if(isEmpty()) {
			throw new Exception("Stack is Empty");
		}
		return data[index--];
	}
	
	public boolean isFull() {
		return index == data.length - 1;
	}
	
	public boolean isEmpty() {
		return index == -1;
	}
	
	//gets an top element of an array
	public int peek() throws Exception{
		if(isEmpty()) {
			throw new Exception("Stack is Empty");
		}
		return data[index];
	}
	
	public void display() {
		for(int i = 0; i <= index; i++) {
			System.out.print(data[i] + " -> ");
		}
		System.out.print("END");
		System.out.println();
	}
	
	public int get(int index) throws Exception{
		if(isEmpty()) {
			throw new Exception("Stack is Empty");
		}
		return data[index];
	}

}
