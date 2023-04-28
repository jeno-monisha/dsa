package com.example.stack;

import com.example.linkedlist.singly.Node;

public class StackMin {
	  Node top;
	  Node min;

	  public StackMin() {
	    top = null;
	    min = null;
	  }

	  public int min() {
	    return min.value;
	  }

	  public void push(int value) {
	    if (min == null) {
	      min = new Node(value, min);
	    } else if (min.value < value) {
	      min = new Node(min.value, min);
	    } else {
	      min = new Node(value, min);
	    }
	    top = new Node(value, top);
	  }

	  public int pop() {
	    min = min.next;
	    int result = top.value;
	    top = top.next;
	    return result;
	  }
	  
	  public static void main(String[] args) {
		  StackMin s = new StackMin();
		  s.push(25);
		  s.push(12);
		  s.push(20);
		  
		  System.out.println(s.pop());
		}
	}

