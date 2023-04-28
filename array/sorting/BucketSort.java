package com.example.array.sorting;

import java.util.*;
import java.util.stream.Collectors;

public class BucketSort {
	
	public static void main(String[] args) {
		
		int arr[] = {5,3,4,7,2,8,6,9,1};
		System.out.println(Arrays.toString(bucketSort(arr)));
	}
	
	public static int[] bucketSort(int[] arr) {
		
		//Create Buckets
		int numberOfElements = arr.length;
		int numberOfBuckets = (int) Math.ceil(Math.sqrt(numberOfElements));
		List<List<Integer>> buckets = createBuckets(numberOfBuckets);
		
		//Distribute buckets
		int maxElementOfArray = Collections.max(Arrays.stream(arr).boxed().collect(Collectors.toList()));
		
		distributeArrayElementsToBucket(arr, numberOfBuckets, maxElementOfArray, buckets);
		
		System.out.println("Printing buckets before sorting");
		printBuckets(buckets);
		
		//Sorting each bucket
		sortBucket(buckets);
		
		System.out.println("Printing buckets after sorting");
		printBuckets(buckets);
        
		arr = mergeBucketsIntoArray(arr, buckets);
		
		return arr;
		
		
	}
	
	
	private static List<List<Integer>> createBuckets(int numberOfBuckets) {
		//List<Integer> buckets = new ArrayList<Integer>(numberOfBuckets);
		//ArrayList<Integer>[] buckets = new ArrayList[numberOfBuckets];
		List<List<Integer>> buckets = new ArrayList<List<Integer>>();
		for(int i=0; i<numberOfBuckets; i++) {
			buckets.add(new ArrayList<Integer>());
		}
		System.out.println(buckets);
		return buckets;
	}
	
	public static void distributeArrayElementsToBucket(int[] arr, int numberOfBuckets, int maxElementOfArray, List<List<Integer>> buckets) {
		for(int element: arr) {
			int bucketNumber = (int) Math.ceil(((float)element*numberOfBuckets)/(float)maxElementOfArray);
			List<Integer> bucket = buckets.get(bucketNumber-1);
			bucket.add(element);
		}
	}
	
	public static void printBuckets(List<List<Integer>> buckets) {
		buckets.forEach(bucket -> System.out.println(bucket));
	}
	
	public static void sortBucket(List<List<Integer>> buckets) {
		for(List<Integer> bucket: buckets) {
			Collections.sort(bucket);
		}
	}
	
	public static int[] mergeBucketsIntoArray(int[] arr, List<List<Integer>> buckets) {
		int index=0;
		for(List<Integer> bucket: buckets) {
			for(Integer element: bucket) {
				arr[index] = element;
				index++;
			}
		}
		return arr;
	}

}
