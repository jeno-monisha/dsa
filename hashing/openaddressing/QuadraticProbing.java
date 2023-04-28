package com.example.hashing.openaddressing;

import java.util.ArrayList;

public class QuadraticProbing {
	
	public String[] hashTable;
	public int cellLastUsed;
	
	public QuadraticProbing(int size) {
		this.hashTable = new String[size];
		this.cellLastUsed = 0;
	}
	
	public int modASCIIhashFunction(String word, int M) {
		char[] ch = word.toCharArray();
		int total = 0;
		for(char c: ch) {
			total = total + c;
		}
		return total % M;
	}
	
	public double loadFactor() {
		return cellLastUsed * 1.0 / hashTable.length;
	}
	
	public void reHashKeys(String word) {
		ArrayList<String> temporaryData = new ArrayList<String>();
		for(String hashTable: hashTable) {
			if(hashTable != null) {
				temporaryData.add(hashTable);
			}
		}
		temporaryData.add(word);
		
		hashTable = new String[2*hashTable.length];
		for(String tempData: temporaryData) {
			
		}
	}
    
	public void insertInHashTable(String word) {
		double loadfactor = loadFactor();
		if(loadfactor >= 0.75) {
			reHashKeys(word);
		} else {
			int index = modASCIIhashFunction(word, hashTable.length);
			int counter = 0;
			for(int i=index; i < index + hashTable.length; i++) {
				int newIndex = index + (counter * counter) % hashTable.length;
				if(hashTable[newIndex] == null) {
					hashTable[newIndex] = word;
					break;
				} else {
					 System.out.println(newIndex+" is already occupied . Trying next empty cell");
				}
				counter++;
			}
		}
		cellLastUsed++;
	}
	
	 public void displayHashTable() {
		    if (hashTable == null) {
		      System.out.println("\nHashTable does not exists");
		      return;
		    } else {
		      System.out.println("\n----------HashTable----------");
		      for (int i=0; i<hashTable.length; i++) {
		        System.out.println("Index " + i + ", key:" + hashTable[i]);
		      }
		   }
	 }
	 
	 public int search(String word) {
		 int index = modASCIIhashFunction(word, hashTable.length);
		 int counter = 0;
		 for(int i = index; i < index + hashTable.length; i++) {
			 int newIndex = index + (counter*counter) % hashTable.length;
			 if(hashTable[newIndex] != null && hashTable[newIndex].equals(word)) {
				 return newIndex;
			 } 
			 counter++;
		 }
		 return -1;
	 }
	 
	 public void deleteKeyHashTable(String word) {
		 int index = modASCIIhashFunction(word, hashTable.length);
		 int counter = 0;
		 for(int i = index; i < index + hashTable.length; i++) {
			 int newIndex = index + (counter*counter) % hashTable.length;
			 if(hashTable[newIndex] != null && hashTable[newIndex].equals(word)) {
				 hashTable[newIndex] = null;
				 return;
			 }
			 counter++;
		 }
		 cellLastUsed--;
	 }
}
