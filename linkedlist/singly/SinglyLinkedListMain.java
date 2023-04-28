package com.example.linkedlist.singly;

public class SinglyLinkedListMain {

	public static void main(String args[]) {

		SinglyLinkedList linkedList1 = new SinglyLinkedList();
		linkedList1.insertAtFirst(15);
		linkedList1.insertAtFirst(20);
		linkedList1.insertAtLast(35);
		linkedList1.insertAtFirst(30);
		linkedList1.insertAtFirst(80);
		linkedList1.insertAtIndex(90, 1);

		linkedList1.display();

		linkedList1.deleteAtFirst();
		linkedList1.display();

		linkedList1.deleteAtLast();
		linkedList1.display();

		linkedList1.deleteAtIndex(1);
		linkedList1.display();
	}

}
