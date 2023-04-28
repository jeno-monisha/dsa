package com.example.hashing.directchaining;

public class DirectChainingMain {
	
	public static void main(String[] args) {
		DirectChaining hashTable = new DirectChaining(15);
		hashTable.insertHashTable("Robert");
		hashTable.insertHashTable("Richard");
		hashTable.insertHashTable("Richard");
		
		hashTable.displayHashTable();
		
		System.out.println(hashTable.search("Robert"));
		
		hashTable.deleteKeyHashTable("Richard");
		
		hashTable.displayHashTable();
	}

}
