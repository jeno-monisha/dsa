package com.example.linkedlist.singly;

public class SinglyLinkedList {
	
	private Node head;
	private Node tail;
	
	private int size;
	
	public SinglyLinkedList() {
		
	}
	
	public void insertAtFirst(int value) {
		Node node = new Node(value);
		node.next = head;
		head = node;
		
		if(tail == null) {
			tail = node;
		}
		size++;
	}
	
	public void insertAtLast(int value) {
		if(tail == null) {
			insertAtFirst(value);
			return;
		}
		
		Node node = new Node(value);
		node.next = null;
		tail.next = node;
		tail = node;
		
		size++;
		
	}
	
	public void insertAtIndex(int value, int index) {
		
		if(index == 0) {
			insertAtFirst(value);
			return;
		} 
		
		if (index == size-1) {
			insertAtLast(value);
			return;
		}
		
		Node tempNode = get(index-1);
		
		Node node = new Node(value, tempNode.next);
		tempNode.next = node;
		size++;
		
	}
	
	public int deleteAtFirst() {
		int value = head.value;
		head = head.next;
		if(head == null) {
			tail = null;
		} 
		size--;
	    return value;
	}
	
	public int deleteAtLast() {
		int value = tail.value;
		
		//Get Last Previous Node
		Node previous = get(size-3);
		previous.next = null;
	    tail = previous;
		size--;
		return value;
	}
	
	public int deleteAtIndex(int index) {
		int value = 0;
		if(index == 0) {
			return deleteAtFirst();
		}
		if(index == size-1) {
			return deleteAtLast();
		}
		
		//Get Previous node of node want to be deleted
		Node previous = get(index-1);
		value = previous.next.value;
		previous.next =previous.next.next;
		size--;
		return value;
	}
	
	public void display() {
		Node tempNode = head;
		while(tempNode != null) {
			System.out.print(tempNode.value + " -> ");
			tempNode = tempNode.next;
		}
		
		System.out.println("END");
	}
	
	public Node get(int index) {
		Node tempNode = head;
		for(int i =0; i<= index; i++) {
			tempNode = tempNode.next;
		}
		return tempNode;
	}
	
	public Node find(int value) {
		if(head == null) {
			return null;
		}
		Node tempNode = head;
		while(tempNode != null) {
			if(tempNode.value == value) {
				return tempNode;
			}
			tempNode = tempNode.next;
		}
		return tempNode;
	}
	
	public Node element() {
		return head;
	}

}


