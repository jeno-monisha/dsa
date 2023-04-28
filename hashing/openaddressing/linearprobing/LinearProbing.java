package com.example.hashing.openaddressing.linearprobing;

import java.util.ArrayList;

public class LinearProbing {
	
	 String[] hashTable;
	  int usedCellNumber;

	  LinearProbing(int size) {
	    hashTable = new String[size];
	    usedCellNumber = 0;
	  }

	  public int modASCIIHashFunction(String word, int M) {
	    char ch[];
	    ch = word.toCharArray();
	    int i, sum;
	    for (sum=0,i=0; i<word.length(); i++) {
	      sum = sum + ch[i];
	    }
	    return sum % M;
	  }

	  public double getLoadFactor() {
	    double loadFactor = usedCellNumber * 1.0/hashTable.length;
	    return loadFactor;
	  }

	// Rehash
	  //To double the array if HashTable is full
	  public void rehashKeys(String word) {
	    usedCellNumber = 0;//If we double the array, we need to reinitialize the usedCellNumber to zero
	    //Store all hashtable values in temporary arrayList
	    ArrayList<String> data = new ArrayList<String>();
	    for (String s : hashTable) {
	      if (s != null) {
	        data.add(s);
	      }
	    }
	    data.add(word);
	    //doubling the array
	    hashTable = new String[hashTable.length * 2];
	    //insert all values from temporaray data back to Hash Table
	    for (String s : data) {
	      insertInHashTable(s);
	    }
	    
	  }

	  // Insert in HashTable
	  //We need to find the new index if index is already Occupied
	  //If hash table is full, we need to double the array
	  public void insertInHashTable(String word) {
	    double loadFactor = getLoadFactor();
	    if (loadFactor >= 0.75) {
	      //We need to double the array
	      rehashKeys(word);
	    } else {
	      //to find index
	      int index = modASCIIHashFunction(word, hashTable.length);
	      for (int i = index; i<index+hashTable.length; i++) {
	        int newIndex = i % hashTable.length;
	        //If index is not occupied, insert the value into index
	        if (hashTable[newIndex] == null) {
	          hashTable[newIndex] = word;
	          System.out.println("The " + word + " successfully inserted at location: "+newIndex);
	          break;
	        } else {
	          //If index is occupied, search for next available index
	          System.out.println(newIndex+" is already occupied . Trying next empty cell");
	        }
	      }
	    }
	    usedCellNumber++;

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
		  int index = modASCIIHashFunction(word, hashTable.length);
		  for(int i = index; i < index + hashTable.length; i++) {
			  int newIndex = i%hashTable.length;
			  if(hashTable[newIndex] != null && hashTable[newIndex].equals(word)) {
				  return newIndex;
			  }
		  }
		  return -1;
	  }
	  
	  public void deleteKeyHashTable(String word) {
		  int index = modASCIIHashFunction(word, hashTable.length);
		  for(int i = index; i < index + hashTable.length; i++) {
			  int newIndex = i%hashTable.length;
			  if(hashTable[newIndex] != null && hashTable[newIndex].equals(word)) {
				  hashTable[newIndex] = null;
				  usedCellNumber--;
				  return;
			  }
		  }
	  }

}
