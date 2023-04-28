package com.example.linkedlist.doubly;

public class Questions {
	
	public static void main(String[] args) {
        DoublyLinkedList ll1 = new DoublyLinkedList();
        ll1.insertAtLast(7);
        ll1.insertAtLast(1);
        ll1.insertAtLast(6);
        
        DoublyLinkedList ll2 = new DoublyLinkedList();
        ll2.insertAtLast(5);
        ll2.insertAtLast(9);
        ll2.insertAtLast(2);
        
        ll1.display();
        System.out.println();
        ll2.display();
        
        System.out.println();
        DoublyLinkedList ll3 = sumLists1(ll1, ll2);
        ll3.display();
        
    }
    
    public static DoublyLinkedList sumLists(DoublyLinkedList ll1, DoublyLinkedList ll2) {
        DoublyLinkedList result = new DoublyLinkedList();
        
        int sum = reverseNumber(convertToDigit(ll1)) + reverseNumber(convertToDigit(ll2));
        
        while(sum > 0) {
            int remainder = sum % 10;
            result.insertAtLast(remainder);
            sum = sum / 10;
        }
        return result;
        
    }
    
    public static int convertToDigit(DoublyLinkedList ll) {
        Node tempNode = ll.head;
        int digit = 0;
        while(tempNode!= null) {
            int value = tempNode.value;
            digit = (digit*10) + value;
            tempNode = tempNode.next;
        }
        return digit;
    }
    
    public static int reverseNumber(int number) {
        int result = 0;
        while(number > 0) {
            int remainder = number % 10;
            result = (result * 10) + remainder;
            number = number / 10;
        }
        return result;
    }
    
    public static DoublyLinkedList sumLists1(DoublyLinkedList llA, DoublyLinkedList llB) {
        Node n1 = llA.head;
        Node n2 = llB.head;
        int carry = 0;
        DoublyLinkedList resultLL = new DoublyLinkedList();
        while (n1 != null || n2 != null) {
          int result = carry;
          if (n1 != null) {
            result += n1.value;
            n1 = n1.next;
          }
          if (n2 != null) {
            result += n2.value;
            n2 = n2.next;
          }
          resultLL.insertAtLast(result%10);
          carry = result / 10;
        }
        return resultLL;
      }

}
