package com.example.hashing.openaddressing.doubleHashing;

public class DoubleHashingMain {
	
	public static void main(String[] args) {
		DoubleHashing hashTable = new DoubleHashing(15);
		
		hashTable.insertInHashTable("Robert");
		hashTable.insertInHashTable("Richard");
		hashTable.insertInHashTable("Richard");
		
		hashTable.displayHashTable();
		
		System.out.println(hashTable.search("Robert"));
		
		hashTable.deleteKeyHashTable("Richard");
		
		hashTable.displayHashTable();
	}

}
