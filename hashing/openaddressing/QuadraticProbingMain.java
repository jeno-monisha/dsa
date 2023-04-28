package com.example.hashing.openaddressing;

public class QuadraticProbingMain {
	
	public static void main(String[] args) {
		QuadraticProbing hashTable = new QuadraticProbing(15);
		
		hashTable.insertInHashTable("Robert");
		hashTable.insertInHashTable("Richard");
		hashTable.insertInHashTable("Richard");
		
		hashTable.displayHashTable();
		
		System.out.println(hashTable.search("Robert"));
		
		hashTable.deleteKeyHashTable("Richard");
		
		hashTable.displayHashTable();
	}

}
