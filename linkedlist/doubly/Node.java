package com.example.linkedlist.doubly;

public class Node {
	
	public int value;
	public Node previous;
	public Node next;
	
	public Node() {
		
	}
	
	public Node(int value) {
		this.value = value;
	}
	
	public Node(int value, Node previous, Node next) {
		this.value = value;
		this.previous = previous;
		this.next = next;
	}

}
