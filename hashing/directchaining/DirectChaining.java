package com.example.hashing.directchaining;

import java.util.LinkedList;

public class DirectChaining {
	
	LinkedList<String>[] hashTable;
	
	//We should limit the Linked List size. If we use several nodes in linked list, it is not good
	public static final int DEFAULT_MAX_SIZE =5;
	
	public DirectChaining(int size) {
		hashTable = new LinkedList[size];
	}
	
	//Hash Function
	public int modASCIIHashFunction(String word, int M) {
		int total = 0;
		char ch[] = word.toCharArray();
		for(Character character: ch) {
			total = total + character;
		}
		return total % M;
	}
	
	public void insertHashTable(String word) {
		int newIndex = modASCIIHashFunction(word, hashTable.length);
		if(hashTable[newIndex] == null) {
			hashTable[newIndex] = new LinkedList<String>();
			hashTable[newIndex].add(word);
		} else {
			hashTable[newIndex].add(word);
		}
	}
	
	public void displayHashTable() {
		if(hashTable == null) {
			System.out.println("Hash Table Does not Exist");
			return;
		}
		
		for(int i = 0; i <hashTable.length; i++) {
			System.out.println("Index " + i + " Key " + hashTable[i]);
		}
	}
	
	public int search(String word) {
		int newIndex = modASCIIHashFunction(word, hashTable.length);
		if(hashTable[newIndex] != null && hashTable[newIndex].contains(word)) {
			return newIndex;
		} else {
			return -1;
		}
	}
	
	public void deleteKeyHashTable(String word) {
		int index = search(word);
		if(index > 0) {
			hashTable[index].remove(word);
			System.out.println("Value " + word + " has been deleted successfully");
		} else {
			System.out.println("Value not found");
		}
	}

}
