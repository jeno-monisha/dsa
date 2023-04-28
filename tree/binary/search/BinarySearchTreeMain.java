package com.example.tree.binary.search;

public class BinarySearchTreeMain {
	
	public static void main(String[] args) {
		
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(70);
		bst.insert(50);
		bst.insert(90);
		bst.insert(30);
		bst.insert(60);
		bst.insert(80);
		bst.insert(100);
		bst.insert(20);
		bst.insert(40);
		//bst.insert(95);
		
		bst.preOrder(bst.root);
		
		System.out.println();
		bst.inOrder(bst.root);
		
		System.out.println();
		bst.postIrder(bst.root);
		
		System.out.println();
		bst.levelOrder();
		
		System.out.println();
		System.out.println(bst.search(bst.root, 80).value);
		
		System.out.println();
		bst.deleteNode(bst.root, 90);
		bst.levelOrder();
		
		System.out.println();
		System.out.println(bst.min(bst.root));
		System.out.println(bst.max(bst.root));	
		
	}

}
