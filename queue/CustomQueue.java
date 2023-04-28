package com.example.queue;

public class CustomQueue {
	
	public int[] data;
	public static final int DEFAULT_SIZE = 10;
	
	public int end = -1;
	
	public CustomQueue() {
		this(DEFAULT_SIZE);
	}
	
	public CustomQueue(int size) {
		this.data = new int[size];
	}
	
	public boolean insert(int value) throws Exception{
		if(isFull()) {
			throw new Exception("Stack is Full");
		}
		end++;
		data[end] = value;
		return true;
	}
	
	public int remove() throws Exception{
		if(isEmpty()) {
			throw new Exception("Stack is Empty");
		}
		int removed = data[0];
		int index = 0;
		
		//shifting array elements to before
		for(int i =1; i < end; i++) {
			data[index] = data[i];
			index++;
		}
		end--;
		return removed;
	}
	
	public boolean isFull() {
		return end == data.length - 1;
	}
	
	public boolean isEmpty() {
		return end == -1;
	}
	
	//gets the first element of the array
	public int peek() throws Exception{
		if(isEmpty()) {
			throw new Exception("Stack is Empty");
		}
		return data[0];
	}
	
	public void display() {
		for(int i = 0; i <= end; i++) {
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
