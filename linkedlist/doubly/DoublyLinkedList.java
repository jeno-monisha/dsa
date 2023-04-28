package com.example.linkedlist.doubly;

import java.util.HashSet;

public class DoublyLinkedList {
	
	public Node head;
	public Node tail;
	
	public int size;
	
	public void insertAtFirst(int value) {
		Node node = new Node(value);
		
		node.next = head;
		node.previous = null;
		
		//it is called when when add second element(2). Now head element contains current element(1). we are going to add 2 before 1. head.previois means =  2 <- 1 
		if(head != null) {
			head.previous = node;
		}
		
		head = node;
		
		if(tail == null) {
			tail = node;
		}
		
		size++;
		
	}
	
	public void insertAtLast(int value) {
		
		
		if(head == null) {
			insertAtFirst(value);
			return;
		}
		
		Node node = new Node(value, tail, null);
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
		head.previous = null;
		size--;
		return value;
	}
	
	public int deleteAtLast() {
		int value = tail.value;
		if(size == 1) {
			head = null;
			tail =null;
			size--;
			return value;
		} 
		Node tempNode = tail.previous;
		tempNode.next = null;
		tail = tempNode;
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
			value = tempNode.next.value;
			tempNode.next = tempNode.next.next;
			//we assign tempNode next to next node already
			tempNode.next.previous = tempNode;
		}
		size--;
		return value;
	}
	
	public void display() {
		Node tempNode = head;
		while(tempNode!= null) {
			System.out.print(tempNode.value + " -> ");
			tempNode = tempNode.next;
		}
		System.out.print("END");
	}
	
	public void displayReverse() {
		Node tempNode = tail;
		while(tempNode!= null) {
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
	
	public Node nthToLast(DoublyLinkedList ll, int n) {
        Node tempNode = ll.head;
        for(int i = 0; i< n; i++) {
        	if(tempNode != null) {
            tempNode = tempNode.next;
        	} else {
        		return null;
        	}
        }
        
        if(tempNode != null) {
	        Node fromNthToLast = tempNode;
	        while(fromNthToLast.next != null) {
	            fromNthToLast = fromNthToLast.next;
	        }
	        return fromNthToLast;
        }
        return null;
    }
	
	public void deleteDups(DoublyLinkedList dll) {
		HashSet<Integer> numbers = new HashSet<Integer>();
		Node tempNode = head;
		while(tempNode != null) {
			int value = tempNode.value;
			if(numbers.contains(tempNode.value)) {
				tempNode.previous.next = tempNode.next;
				if(tempNode.next != null) {
					tempNode.next.previous = tempNode.previous;
					size--;
				}
			} else {
				numbers.add(value);
			}
			tempNode = tempNode.next;
		}
	}
	
	//insert values less than n in head. if head means node.next = head and head =node. values greater than n in tail. tail.next = node and tail = node;
	public DoublyLinkedList partition(DoublyLinkedList ll, int n) {
		  Node currentNode = ll.head;
		    ll.tail = ll.head;
		    while (currentNode != null) {
		      Node next = currentNode.next;
		      if (currentNode.value < n) {
		        currentNode.next = ll.head;
		        ll.head = currentNode;
		      } else {
		        ll.tail.next = currentNode;
		        ll.tail = currentNode;
		      }
		      currentNode = next;
		    }
		    ll.tail.next = null;
		    return ll;
	}

}
