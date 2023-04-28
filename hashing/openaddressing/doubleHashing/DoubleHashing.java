package com.example.hashing.openaddressing.doubleHashing;

import java.util.ArrayList;

public class DoubleHashing {
	
	public String[] hashTable;
	public int cellLastUsed;
	
	public DoubleHashing(int size) {
		this.hashTable = new String[size];
		this.cellLastUsed = 0;
	}
	
	public int simpleASCIIHashFunction(String word, int M) {
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
	
	public void reHashing(String word) {
		ArrayList<String> tempData = new ArrayList<String>();
		for(String hashTable: hashTable) {
			if(hashTable != null) {
				tempData.add(hashTable);
			}
		}
		
		tempData.add(word);
		
		hashTable = new String [2*hashTable.length];
		for(String temp: tempData) {
			insertInHashTable(word);
		}
		
	}
	
	private int addAllDigitsTogether(int sum) {
		int value = 0;
		while(sum > 0) {
			value = sum % 10;
			sum = sum / 10;
		}
		return value;
	}
	
	public int secondHashFunction(String word, int M) {
		char[] ch = word.toCharArray();
		int total = 0;
		for(char c: ch) {
			total = total + c;
		}
		
		if(total > hashTable.length) {
			total = addAllDigitsTogether(total);
		}
		
		return total % M;
	}
	
	public void insertInHashTable(String word) {
		double loadfactor = loadFactor();
		if(loadfactor >= 0.75) {
			reHashing(word);;
		} else {
			int x = simpleASCIIHashFunction(word, hashTable.length);
			int y = secondHashFunction(word, hashTable.length);
			for(int i = 0; i < hashTable.length; i++) {
				int newIndex = (x + i*y) % hashTable.length;
				if (hashTable[newIndex] == null) {
					hashTable[newIndex] = word;
					break;
				} else {
					System.out.println(newIndex+" is already occupied . Trying next empty cell");
				}
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
		int x = simpleASCIIHashFunction(word, hashTable.length);
		int y = secondHashFunction(word, hashTable.length);
		
		for(int i = 0; i < hashTable.length; i++) {
			int newIndex = (x+i*y) % hashTable.length;
			if(hashTable[newIndex] != null && hashTable[newIndex].equals(word)) {
				return newIndex;
			}
		}
		return -1;
	}
	
	public void deleteKeyHashTable(String word) {
		int x = simpleASCIIHashFunction(word, hashTable.length);
		int y = secondHashFunction(word, hashTable.length);
		
		for(int i =0; i < hashTable.length; i++) {
			int newIndex = (x+i*y) % hashTable.length;
			if(hashTable[newIndex] != null && hashTable[newIndex].equals(word)) {
				hashTable[newIndex] = null;
				return;
			}
		}
		cellLastUsed--;
	}

}
