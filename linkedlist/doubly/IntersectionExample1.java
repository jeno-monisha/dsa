package com.example.linkedlist.doubly;

public class IntersectionExample1 {
    
    public static void main(String[] args) {
      DoublyLinkedList llA = new DoublyLinkedList();
	   llA.insertAtLast(3);
	   llA.insertAtLast(1);
	   llA.insertAtLast(5);
	   llA.insertAtLast(9);
	   DoublyLinkedList llB = new DoublyLinkedList();
	   llB.insertAtLast(2);
	   llB.insertAtLast(4);
	   llB.insertAtLast(6);
	   IntersectionExample1 ex = new IntersectionExample1();
	   ex.addSameNode(llA, llB, 7);
	   ex.addSameNode(llA, llB, 2);
	   ex.addSameNode(llA, llB, 1);
	   Node inter = ex.findIntersection(llA, llB);
	   System.out.println(inter.value);
	    }
	    // Add same node 
	  void addSameNode(DoublyLinkedList llA, DoublyLinkedList llB, int nodeValue) {
	    Node newNode = new Node();
	    newNode.value = nodeValue;
	    llA.tail.next = newNode;
	    llA.tail = newNode;
	    llB.tail.next = newNode;
	    llB.tail = newNode;
	
	  }
	  
	  public static Node findIntersection(DoublyLinkedList llA, DoublyLinkedList llB) {
	      Node node1 = llA.head;
	      while(node1 != null) {
	    	  Node node2 = llB.head;
	          while(node2 != null) {
	              if(node1 == node2) {
	                  return node2;
	              }
	              node2 = node2.next;
	          }
	          node1 = node1.next;
	      }
	      return null;
	  }
	  
	  //TODO

}