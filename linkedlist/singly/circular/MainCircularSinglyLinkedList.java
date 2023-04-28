package com.example.linkedlist.singly.circular;

public class MainCircularSinglyLinkedList {
  public static void main(String[] args) {
		
	  CircularSinglyLinkedList cll = new CircularSinglyLinkedList();
	  
	  cll.insertAtFirst(8);
	  cll.insertAtLast(12);
	  cll.insertAtFirst(20);
	  cll.insertAtFirst(18);
	  cll.insertAtLast(25);
	  
	  cll.insertAtIndex(80, 2);
	  cll.insertAtIndex(85, 3);
	  cll.insertAtIndex(75, 4);
	  cll.insertAtIndex(90, 1);
	  
	  cll.display();
	  
	  System.out.println();
	  cll.deleteAtLast();
	  cll.display();
	  
	  System.out.println();
	  cll.deleteAtFirst();
	  cll.display();
	  
	  System.out.println();
	  cll.deleteAtIndex(3);
	  cll.display();
			  

  }
}
