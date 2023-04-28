package com.example.linkedlist.doubly.circular;

import com.example.linkedlist.doubly.Node;

public class DoublyCircularLinkedList {
	
	public Node head;
	public Node tail;
	
	public int size;
	
	public void insertAtFirst(int value) {
		Node node = new Node(value);
		
		//initially head null
		if(head == null) {
			
			node.next = node;
			node.previous = node;
			
			head = node;
			tail = node;
			
		} else {
			node.next = head;
			node.previous = head;
			head.previous = tail;
			
			tail.next = head;
			
			head = node;
		}
		
		size++;
	}
	
	public void insertAtLast(int value) {
		if(head == null) {
			insertAtFirst(value);
		}
		Node node = new Node(value, tail, head);
		tail.next = node;
		tail = node;
		size++;
	}
	
	public void insertAtIndex(int value, int index) {
		if(index == 0) {
			insertAtFirst(value);
		} else if(index == size-1) {
			insertAtLast(value);
		} else {
			Node tempNode = get(index-1);
			
			Node node = new Node(value);
			node.next = tempNode.next;
			node.previous = tempNode;
			
			tempNode.next = node;
			tempNode.next.next.previous = node;
			
		}
		size++;
	}
	
	public int deleteAtFirst() {
		int value = head.value;
		if(size == 1) {
			head = null;
			tail = null;
			size--;
			return value;
		}
		head = head.next;
		head.next.previous = head;
		tail.next = head;
		size--;
		return value;
	}
	
	public int deleteAtLast() {
		int value = tail.value;
		if(size == 1) {
			head = null;
			tail = null;
			size--;
			return value;
		}
		tail.previous.next = head;
		tail = tail.previous;
		tail.next = head;
		size--;
		return value;
	}
	
	public int deleteAtIndex(int index) {
		int value = 0;
		if(index == 0) {
			deleteAtFirst();
		} else if(index == size-1) {
			deleteAtLast();
		} else {
			Node tempNode = get(index-1);
			value = tempNode.value;
			
			tempNode.next = tempNode.next.next;
			tempNode.next.previous = tempNode;
		}
		size--;
		return value;
	}
	
	public void display() {
		Node tempNode = head;
		for(int i=0; i< size; i++) {
			System.out.print(tempNode.value + " -> ");
			tempNode = tempNode.next;
		}
		System.out.print("END");
	}
	
	public void displayReverse() {
		Node tempNode = tail;
		for(int i=0; i< size; i++) {
			System.out.print(tempNode.value + " -> ");
			tempNode = tempNode.previous;
		}
		System.out.print("START");
	}
	
	public Node get(int index) {
		Node tempNode = head;
		for(int i=0; i<index; i++) {
			tempNode = tempNode.next;
		}
		return tempNode;
	}
	
}
