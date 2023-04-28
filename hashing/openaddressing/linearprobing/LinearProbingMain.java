package com.example.hashing.openaddressing.linearprobing;

public class LinearProbingMain {
	
	public static void main(String[] args) {
		LinearProbing hashTable = new LinearProbing(15);
		
		hashTable.insertInHashTable("Robert");
		hashTable.insertInHashTable("Richard");
		hashTable.insertInHashTable("Richard");
		
		hashTable.displayHashTable();
		
		System.out.println(hashTable.search("Robert"));
		
		hashTable.deleteKeyHashTable("Richard");
		
		hashTable.displayHashTable();
	}

}
