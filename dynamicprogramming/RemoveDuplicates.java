package com.example.dynamicprogramming;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicates {
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 2, 3, 8, 8, 10};
		Set<Integer> uniqueSet = Arrays.stream(arr).boxed().collect(Collectors.toSet());
		arr = uniqueSet.stream().mapToInt(Integer::intValue).toArray();
		System.out.println(Arrays.toString(arr));

	}

}
