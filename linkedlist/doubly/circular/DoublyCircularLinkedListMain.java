package com.example.linkedlist.doubly.circular;

public class DoublyCircularLinkedListMain {
	
	public static void main(String[] args) {
		DoublyCircularLinkedList dll = new DoublyCircularLinkedList();
		
		dll.insertAtFirst(8);
		dll.insertAtFirst(95);
		
		dll.insertAtLast(95);
		dll.insertAtLast(8);
		dll.insertAtLast(25);
		dll.insertAtLast(25);
		
		dll.insertAtLast(12); 
		dll.insertAtFirst(20); 
		dll.insertAtFirst(18);
		dll.insertAtLast(25);
		  
		dll.insertAtIndex(80, 2); 
		dll.insertAtIndex(85, 3); 
		dll.insertAtIndex(75, 4);
		dll.insertAtIndex(90, 1);
		
		System.out.println();
		dll.display();
		
		System.out.println();
		dll.displayReverse();
		  
		System.out.println(); 
		dll.deleteAtLast(); 
		dll.display();
		  
		System.out.println(); 
		dll.deleteAtFirst(); 
		dll.display();
		  
		System.out.println();
		dll.deleteAtIndex(3);
		 
		dll.display();
		
	}

}
