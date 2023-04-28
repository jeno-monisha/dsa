package com.example.tree.binary.heap;

public class BinaryHeap {
	
	public int[] data;
	public int sizeOfTree;
	
	public static final int DEFAULT_MAX_SIZE = 10;
	
	public BinaryHeap() {
		this(DEFAULT_MAX_SIZE + 1);
	}
	
	public BinaryHeap(int size) {
		this.sizeOfTree =0;
		this.data = new int[size+1];
	}
	
	public int peek() {
		if(isEmpty()) {
			System.out.println("Binary Heap is empty");
			return -1;
		}
		return data[1];
	}
	
	public int size() {
		return sizeOfTree;
	}
	
	public void levelOrder() {
		for(int i=1; i<=sizeOfTree; i++) {
			System.out.print(data[i] + " ");
		}
	}
	
	//Heapify for insert
	//we check the constraints of binary heap from bottom to top that means child to root. Becuase we need to insert child node.
	//It works based on the heap Type. In min heap, root node is small, max values in right tree
	//In max heap, root node is big, min values in left tree
	public void heapifyBottomToTop(int index, String heapType) {
		int parent = index /2;
		if(index<=1) {
			return;
		}
		
		//Min heap - parent node is small. if it is not small, swap
		if(heapType.equals("Min")) {
			if(data[index] < data[parent]) {
				int temp = data[index];
				data[index] = data[parent];
				data[parent] = temp;
			}
	    //Max heap - parent node is large. if it not large, swap
		} else if(heapType.equals("Max")) {
			if(data[index] > data[parent]) {
				int temp = data[index];
				data[index] = data[parent];
				data[parent] = temp;
			}
		}
		heapifyBottomToTop(parent, heapType);
	}
	
	
	//insert at last vacant value
	//call heapify method to check the binary heap property is maintained or not
	public void insert(int value, String heapType) {
		data[sizeOfTree+1] = value;
		sizeOfTree++;
		
		//sizeofTree is the last inserted node
		heapifyBottomToTop(sizeOfTree, heapType);
	}
	
	//Heapify for deletion
	//we check the constraints of binary heap from top to bottom that means root to child. Becuase we need to delete root node.
	public void heapifyTopToBottom(int index, String heapType) {
	    int left = index*2;
	    int right = index*2 + 1;
	    int swapChild = 0;
	    //It means no child, return. Right is there if left is present. So no left means. no child
	    if (sizeOfTree < left) {
	      return;
	    }
	    if (heapType == "Max") {
	      //Case 1 : only one child(left child)
	      //if last index of value equal to left means. this is the last node. so only one child
	      if (sizeOfTree == left) {
	    	//In Max Heap, root node is high. Here index is the root node. If root node is less than swap
	        if (data[index] < data[left]) {
	          int tmp = data[index];
	          data[index] = data[left];
	          data[left] = tmp;
	        }
	        return;
	      } else {
	    	//Case 2: 2 child and take the max child. Swapchild is the max index. left and right children should be less than root node  
	        if (data[left]>data[right]) {
	          swapChild = left;
	        } else {
	          swapChild = right;
	        }
	        //If root node is less than children, we need to swap
	        if (data[index] < data[swapChild]) {
	          int tmp = data[index];
	          data[index] = data[swapChild];
	          data[swapChild] = tmp;
	        }
	      }
	    } else if (heapType == "Min") {
	      //Case 1 : only one child(left child)
		  //if last index of value equal to left means. this is the last node. so only one child
	      if (sizeOfTree == left) {
	    	//In Min Heap, root node is less. Here index is the root node. If root node is greater than swap
	        if (data[index] > data[left]) {
	          int tmp = data[index];
	          data[index] = data[left];
	          data[left] = tmp;
	        }
	        return;
	      } else {
	    	//Case 2: 2 child and take the min child. Swapchild is the min index. left and right children should be greater than root node  
	        if (data[left] < data[right]) {
	          swapChild = left;
	        } else {
	          swapChild = right;
	        }
	        //If root node is greater than children, we need to swap
	        if (data[index] > data[swapChild]) {
	          int tmp = data[index];
	          data[index] = data[swapChild];
	          data[swapChild] = tmp;
	        }
	      }
	    }
	    heapifyTopToBottom(swapChild, heapType);
	}
	
	
	//In Binary Heap, we can able to delete only root node
    //If root node is deleted, the root node's position will be empty
	//So we need to take the last node and assign th
	//In this case, root node index is 1, last node index is sizeOfIndex
	//After updating the root node's value with last node's value, we need to delete the last node by decreasing sizeOfIndex
	//After deleting the last node, we need to check binary heap's constraints, so we need to call heapify
	public int extractHeadOfBP(String heapType) {
	    if (isEmpty()) {
	      return -1;
	    } else {
	      //we need to delete the root node
	      int extractedValue = data[1];
	      //we need to assign the root node's value with last node. sizeOfIndex is the last node
	      data[1] = data[sizeOfTree];
	      sizeOfTree--;
	      heapifyTopToBottom(1, heapType);
	      return extractedValue;
	    }
	}
	
	public int min(String heapType)  {
		//In Min Heap, root node is minimum. index 1 is the root node
		if(heapType.equals("Min")) {
			return data[1];
		//In Max Heap, last node is minimum. sizeOfTree is the last node
		} else if(heapType.equals("Max")) {
			return data[sizeOfTree];
		}
		return -1;
	}
	
	public int max(String heapType)  {
		//In Min Heap, last node is maximum. sizeOfTree is the last node
		if(heapType.equals("Min")) {
			return data[sizeOfTree];
		//In Max Heap, root node is maximum. Index 1 is the root node
		} else if(heapType.equals("Max")) {
			return data[1];
		}
		return -1;
	}
	
	public boolean isFull() {
		return sizeOfTree == data.length-1;
	}
	
	public boolean isEmpty() {
		return sizeOfTree == 0;
	}

}
