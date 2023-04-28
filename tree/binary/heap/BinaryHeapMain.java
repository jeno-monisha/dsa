package com.example.tree.binary.heap;

public class BinaryHeapMain {
	
   public static void main(String[] args) {
	  BinaryHeap heap = new BinaryHeap();
	  heap.insert(5, "Min");
	  heap.insert(10, "Min");
	  heap.insert(20, "Min");
	  heap.insert(30, "Min");
	  heap.insert(40, "Min");
	  heap.insert(50, "Min");
	  heap.insert(60, "Min");
	  heap.insert(60, "Min");
	  
	  heap.levelOrder();
	  
	  System.out.println();
	  heap.extractHeadOfBP("Min");
	  heap.levelOrder();
	  
	  System.out.println();
	  System.out.println(heap.min("Min"));
	  System.out.println(heap.max("Min"));
	  
   }
}
