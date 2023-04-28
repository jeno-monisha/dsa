package com.example.tree.binary;

public class BinaryTreeUsingArrayMain {
	
	public static void main(String[] args) {
		
		BinaryTreeUsingArray binaryArray = new BinaryTreeUsingArray(10);
		binaryArray.insert("N1");
		binaryArray.insert("N2");
		binaryArray.insert("N3");
		binaryArray.insert("N4");
		binaryArray.insert("N5");
		binaryArray.insert("N6");
		binaryArray.insert("N7");
		binaryArray.insert("N8");
		binaryArray.insert("N9");
		
		System.out.println();
		binaryArray.preOrder(1);
		
		System.out.println();
		binaryArray.inOrder(1);
		
		System.out.println();
		binaryArray.postOrder(1);
		
		System.out.println();
		binaryArray.levelOrder();
		
		System.out.println();
		System.out.println(binaryArray.search("N2"));
		
		System.out.println();
		binaryArray.delete("N3");
		binaryArray.levelOrder();
	}

}
