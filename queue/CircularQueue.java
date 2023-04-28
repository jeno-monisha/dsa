package com.example.queue;

public class CircularQueue {
	
	public int[] data;
	public static final int DEFAULT_SIZE = 10;
	
	public int start = 0;
	public int end = 0;
	
	public int size;
	
	public CircularQueue() {
		this(DEFAULT_SIZE);
	}
	
	public CircularQueue(int size) {
		this.data = new int[size];
	}
	
	public boolean insert(int value) throws Exception{
		if(isFull()) {
			throw new Exception("Stack is Full");
		}
		data[end] = value;
		end++;
		end = end % data.length;
		size++;
		return true;
	}
	
	public int remove() throws Exception{
		if(isEmpty()) {
			throw new Exception("Stack is Empty");
		}
		start++;
		int removed = data[start];
		start = start % data.length;
		size--;
		return removed;
	}
	
	public boolean isFull() {
		return size == data.length;
	}
	
	public boolean isEmpty() {
		return end == -1;
	}
	
	public int peek() throws Exception{
		if(isEmpty()) {
			throw new Exception("Stack is Empty");
		}
		return data[start];
	}
	
	public void display() {
		if(isEmpty()) {
			System.out.println("Stack is Empty");
		}
		int i = start;
		do {
			System.out.println(data[i] + " -> ");
			i++;
			i %= data.length;
		} while(i!=end);
		System.out.println("END");
	}
	
	public int get(int index) throws Exception{
		if(isEmpty()) {
			throw new Exception("Stack is Empty");
		}
		return data[index];
	}


}
