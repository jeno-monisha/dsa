package com.example.linkedlist.singly.circular;

import com.example.linkedlist.singly.Node;

public class CircularSinglyLinkedList {
	
	public Node head;
	public Node tail;
	
	public int size;
	
	public void insertAtFirst(int value) {
		Node node = new Node(value);
		
		if(head == null) {
			node.next = node;
			head = node;
			tail = node;
			
		} else {
			node.next = head;
			head = node;
			tail.next = head;
		}
		
		size++;
	}
	
	public void insertAtLast(int value) {
		Node node = new Node(value);
		
		if(head == null) {	
			insertAtFirst(value);
		} else {
			node.next = head;
			tail.next = node;
			tail = node;
			
			tail.next = head;
		}
		
		size++;
	}
	
	public void insertAtIndex(int value, int index) {
		if(index == 0) {
			insertAtFirst(value);
		} else if(index == size -1) {
			insertAtLast(value);
		} else {
			Node tempNode = get(index-1); 
			Node node = new Node(value, tempNode.next);
			tempNode.next = node;
			size++;
		}
	}
	
	public int deleteAtFirst() {
		int value = head.value;
		if(size == 1) {
			head = null;
			tail =null;
			size--; 
			return value;
		} 
		
		head = head.next;
		tail.next =head;
		
		size--;
		return head.value;
		
	}
	
	public int deleteAtLast() {
		int value = tail.value;
		if(size == 1) {
			head = null;
			tail =null;
			size--;
			return value;
		} 
		
		Node previous = get(size-3);
		previous.next = head;
		
		tail = previous;
		tail.next = head;
		
		size--;
		return value;
		
	}
	
	public int deleteAtIndex(int index) {
		int value = 0;
		if(index == 0) {
			deleteAtFirst();
		} else if (index == size-1) {
			deleteAtLast();
		} else {
			Node tempNode = get(index-1);
			value = tempNode.next.value;
			tempNode.next = tempNode.next.next;	
		}
		size--;
		return value;
	}
	
	//also check node != tail
	public void display() {
		Node tempNode = head;
		for(int i =0; i < size; i++) {
			System.out.print(tempNode.value + " -> ");
			tempNode = tempNode.next;
		}
		System.out.print("END");
	}
	
	//-1 means current node, -2 means previous node
	public Node get(int index) {
		Node tempNode = head;
		//index 0 included becuase we take next element
		for(int i = 0; i < index; i++) {
			tempNode = tempNode.next;
		}
		return tempNode;
	}
	
	public boolean find(int searchValue) {
		Node tempNode = head;
		if(head == null) {
			System.out.println("Singly Circular List not found");
		}
		for(int i =0; i< size; i++) {
			if(tempNode.value == searchValue) {
				System.out.println("Value find at the location of " + i);
				return true;
			}
			tempNode = tempNode.next;
		}
		return false;
	}

}
