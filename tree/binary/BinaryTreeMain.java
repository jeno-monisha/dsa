package com.example.tree.binary;

public class BinaryTreeMain {
	
	public static void main(String[] args) {
		BinaryTreeLL binarytreell = new BinaryTreeLL();
		
		//creating nodes
		BinaryTreeNode n1 = new BinaryTreeNode();
		n1.value = "N1";
		
		BinaryTreeNode n2 = new BinaryTreeNode();
		n2.value = "N2";
		
		BinaryTreeNode n3 = new BinaryTreeNode();
		n3.value = "N3";
		
		BinaryTreeNode n4 = new BinaryTreeNode();
		n4.value = "N4";
		
		BinaryTreeNode n5 = new BinaryTreeNode();
		n5.value = "N5";
		
		BinaryTreeNode n6 = new BinaryTreeNode();
		n6.value = "N6";
		
		BinaryTreeNode n7 = new BinaryTreeNode();
		n7.value = "N7";
		
		BinaryTreeNode n8 = new BinaryTreeNode();
		n8.value = "N8";
		
		BinaryTreeNode n9 = new BinaryTreeNode();
		n9.value = "N9";
		
		//creating links
		n1.left = n2;
		n1.right = n3;
		
		n2.left = n4;
		n2.right = n5;
		
		n3.left = n6;
		n3.right = n7;
		
		n4.left = n8;
		n4.right = n9;
		
		//assigning root
		binarytreell.root = n1;
		binarytreell.preOrder(n1);
		
		System.out.println();
		binarytreell.inOrder(n1);
		
		System.out.println();
		binarytreell.postOrder(n1);
		
		System.out.println();
		binarytreell.levelOrder();
		
		System.out.println();
		System.out.println(binarytreell.search("N4"));
		
		binarytreell.insert("N10");
		binarytreell.levelOrder();
		
		System.out.println();
		binarytreell.delete("N3");
		binarytreell.levelOrder();
	}

}
