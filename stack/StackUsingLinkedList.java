package com.example.stack;

import com.example.linkedlist.singly.*;

public class StackUsingLinkedList {
	public SinglyLinkedList data;
	
	public int index = -1;
	
	public StackUsingLinkedList() {
		this.data = new SinglyLinkedList();
	}
	
	public boolean push(int value) throws Exception{
		data.insertAtLast(value);
		index++;
		return true;
	}
	
	public int pop() throws Exception{
		if(isEmpty()) {
			throw new Exception("Stack is Empty");
		}
		index--;
		return data.deleteAtLast();
	}
	
	public boolean isEmpty() {
		return data.element() == null;
	}
	
	public int peek() throws Exception{
		if(isEmpty()) {
			throw new Exception("Stack is Empty");
		}
		return data.element().value;
	}
	
	public void display() {
		data.display();
	}
	
	public int get(int index) {
		return data.get(index).value;
	}

}
