package com.example.linkedlist.doubly;

import java.util.List;

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class SinglyLinkedList {
	public ListNode head;
	public ListNode tail;
}


class SumOfList {
	
	
	public static void main(String[] args) {
		
		SumOfList s = new SumOfList();

        ListNode head = new ListNode(2, null);
        ListNode l1 = new ListNode(3, new ListNode(4, head));

        ListNode head2 = new ListNode(5, null);
        ListNode l2 = new ListNode(4, new ListNode(6, head2));

        ListNode resultNode = s.addTwoNumbers(l1, l2);
        
        while(resultNode != null) {
        	System.out.println(resultNode.val);
        	resultNode = resultNode.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tempNode1 = l1;
        ListNode tempNode2 = l2;
     
        SinglyLinkedList sll =  new SinglyLinkedList();
        
		int carry = 0;
        while(tempNode1 != null && tempNode2 != null) {
		   int result = carry;
           result = result + tempNode1.val + tempNode2.val;
           tempNode1 = tempNode1.next;
           tempNode2 = tempNode2.next;
		   insertAtLast(result%10, sll);
		   carry = result / 10;
        }
        return sll.head;
    }  

   public void insertAtLast(int value, SinglyLinkedList sll) {
	   ListNode node = new ListNode(value);
       if(sll.head == null) {
    	 node.next = null;
    	 sll.head = node;
    	 sll.tail = node;
	   } else {
	     sll.tail.next = node;
	     node.next = null;
	     sll.tail = node;
	   }
     }
    
  }
