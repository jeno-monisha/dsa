package com.example.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapExample {
	
	public static void main(String[] args) {
		
		Map<Integer, String> studentDetail = new HashMap<Integer, String>();
		studentDetail.put(1, "James");
		studentDetail.put(2, "John");
		
		System.out.println(studentDetail.get(1));
		
		for(Integer id: studentDetail.keySet()) {
			System.out.println(studentDetail.get(id));
		}
		
		//insert value if key is not present
		studentDetail.putIfAbsent(2, "Oliver");
		
		studentDetail.compute(2, (key, value) -> value.concat(" Dong"));
		
		//getting keys
		for(Integer id: studentDetail.keySet()) {
			System.out.println(studentDetail.get(id));
		}
		
		studentDetail.computeIfAbsent(3, key -> "Oliver");
		
		for(Integer id: studentDetail.keySet()) {
			System.out.println(studentDetail.get(id));
		}
		
		studentDetail.computeIfPresent(1, (key, value) -> value.concat(" Parker"));
		
		for(Integer id: studentDetail.keySet()) {
			System.out.println(studentDetail.get(id));
		}
		
		//getting values
		Collection<String> values = studentDetail.values();
		System.out.println(values);
		
		Map<Integer, String> hashTable = new Hashtable<Integer, String>();
		hashTable.put(1, "Robert");
		hashTable.put(2, "Richard");
		
		Collection<String> values1 = hashTable.values();
		System.out.println(values1);
		
		Set<Integer> keys = hashTable.keySet();
		System.out.println(keys);
		
		System.out.println(hashTable.containsKey(1));
		System.out.println(hashTable.containsValue("Robert"));
		
		Set<Entry<Integer,String>> values2 =  hashTable.entrySet();
		for(Entry<Integer,String> entry1: values2) {
			entry1.getKey();
			entry1.getValue();
		}
		
		Collection<String> values8 = hashTable.values();
		for(String value : values8) {
		   System.out.println(value);
		}
		
	}

}
