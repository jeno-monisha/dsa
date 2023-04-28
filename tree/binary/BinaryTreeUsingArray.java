package com.example.tree.binary;

public class BinaryTreeUsingArray {
	
	public String[] data;
	
	public static final int DEFAULT_MAX_SIZE = 10;
	
	public int lastUsedIndex;
	
	public BinaryTreeUsingArray() {
		this(DEFAULT_MAX_SIZE + 1);
	}
	
	public BinaryTreeUsingArray(int size) {
		//because we don't use first index
		data = new String[size+1];
		this.lastUsedIndex = 0;
	}
	
	//insert method
	public void insert(String value) {
		if(!isFull()) {
			data[lastUsedIndex+1] = value;
			lastUsedIndex++;
			System.out.println(value + " has been successfully inserted");
		} else {
			System.out.println("Binary Tree is full");
		}
	}
	
	//Pre Order Traversal
	//index of root node
	public void preOrder(int index) {
		if(index > lastUsedIndex) {
			return;
		}
		
		//root node - root node in index 1
		System.out.print(data[index] + " ");
		preOrder(index * 2);
		preOrder(index * 2 +1);
		
	}
	
	//In Order Traversal
	public void inOrder(int index) {
		if(index > lastUsedIndex) {
			return;
		}
		inOrder(index * 2);
		System.out.print(data[index] + " ");
		inOrder(index * 2 + 1);
	}
	
	//Post Order Traversal
	public void postOrder(int index) {
		if(index > lastUsedIndex) {
			return;
		}
		postOrder(index * 2);
		postOrder(index * 2 + 1);
		System.out.print(data[index] + " ");
	}
	
	//Level Order Traversal
	public void levelOrder() {
		for(int i=1; i <= lastUsedIndex; i++) {
			System.out.print(data[i] + " ");
		}
	}
	
	//Search
	//Level Order Traversal
	public int search(String value) {
		for(int i=1; i< lastUsedIndex; i++) {
			if(data[i].equals(value)) {
				System.out.println(value + " found at the location of " + i);
				return i;
			}
		}
		System.out.println("The value does not exist in Binary Tree");
		return -1;
	}
	
	//delete method
	public String delete(String value)  {
		
		String removed = null;
		
		int location = search(value);
		if(location == -1) {
			return null;
		} else {
			removed = data[location];
			data[location] = data[lastUsedIndex];
			lastUsedIndex--;
			System.out.println("The node has been deleted successfully");
			return removed;
		}
		
	}
	
	public boolean isFull() {
		return lastUsedIndex == data.length-1;
	}
	
	public boolean isEmpty() {
		return lastUsedIndex == 0;
	}
	

}
