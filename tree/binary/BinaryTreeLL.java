package com.example.tree.binary;

import java.util.Queue;
import java.util.LinkedList;

public class BinaryTreeLL {
	
	public BinaryTreeNode root;
	
	public BinaryTreeLL() {
		this.root = null;
	}
	
	//Pre Order Traversal
	public void preOrder(BinaryTreeNode node) {
		 if(node == null) {
			 return;
		 }
		 System.out.print(node.value + " ");
		 preOrder(node.left);
		 preOrder(node.right);
	}
	
	//In Order Traversal
	public void inOrder(BinaryTreeNode node) {
		if(node == null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.value + " ");
		inOrder(node.right);
	}
	
	//Post Order 
	public void postOrder(BinaryTreeNode node) {
		if(node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.value + " ");
	}
	
	//Level Order 
	//create queue and add first root and removed it.Because queue is first in first out. then add left and right and remove
	public void levelOrder() {
		Queue<BinaryTreeNode> binaryQueue = new LinkedList<BinaryTreeNode>();
		binaryQueue.add(root);
		
		while(!binaryQueue.isEmpty()) {
			BinaryTreeNode presentNode = binaryQueue.remove();
		    System.out.print(presentNode.value + " ");
		    
		    if(presentNode.left != null) {
		    	binaryQueue.add(presentNode.left);
		    }
		    
		    if(presentNode.right != null) {
		    	binaryQueue.add(presentNode.right);
		    }
		}
			
	}
	
	//Search Method
	public boolean search(String value) {
		
		Queue<BinaryTreeNode> binaryQueue = new LinkedList<>();
		binaryQueue.add(root);
		
		while(!binaryQueue.isEmpty()) {
			BinaryTreeNode presentNode = binaryQueue.remove();
			if(presentNode.value.equals(value)) {
				return true;
			}
			if(presentNode.left != null) {
				binaryQueue.add(presentNode.left);
			}
			if(presentNode.right != null) {
				binaryQueue.add(presentNode.right);
			}
		}
		return false;
	}
	
	//insert method
	public void insert(String value) {
		BinaryTreeNode newNode = new BinaryTreeNode();
		newNode.value = value;
		
		//first check if root is null, then insert and assign that value into root
		if(root == null) {
			root = newNode;
			System.out.println("Inserted the value as root node");
			return;
		} 
		
		//otherwise we loop through level order traversal until we find first vacant node. if node has already node in left, insert the value in right.
		Queue<BinaryTreeNode> binaeryQueue = new LinkedList<>();
		binaeryQueue.add(root);
		
		while(!binaeryQueue.isEmpty()) {
			BinaryTreeNode presentNode = binaeryQueue.remove();
			
			//inserting the value
			if(presentNode.left == null) {
				presentNode.left = newNode;
				System.out.println("Successfully inserted");
				return;
			} else if(presentNode.right == null) {
				presentNode.right = newNode;
				System.out.println("Successfully inserted");
				return;
			}  else {
				binaeryQueue.add(presentNode.left);
				binaeryQueue.add(presentNode.right);
			}
		}
	}
	
	//Get Deepest Node
	//If I using level traversal it always returns the last child(right)
	public BinaryTreeNode getDeepestNode() {
		if(root == null) {
			return null;
		}
		
		BinaryTreeNode presentNode = null;
		
		Queue<BinaryTreeNode> binaryQueue = new LinkedList<>();
		binaryQueue.add(root);
		
		while(!binaryQueue.isEmpty()) {
			presentNode = binaryQueue.remove();
			
			if(presentNode.left != null) {
				binaryQueue.add(presentNode.left);
			}
			if(presentNode.right != null) {
				binaryQueue.add(presentNode.right);
			}
		}
		return presentNode;
	}
	
	//delete deepest node
	public void deleteDeepestNode() {
		Queue<BinaryTreeNode> binaryQueue = new LinkedList<>();
		binaryQueue.add(root);
		
		BinaryTreeNode previousNode, presentNode = null;
		while(!binaryQueue.isEmpty()) {
			previousNode = presentNode;
			presentNode = binaryQueue.remove();
			if(presentNode.left == null) {
				previousNode.right = null;
				return;
			} else if(presentNode.right == null) {
				presentNode.left = null;
				return;
			}
			
			binaryQueue.add(presentNode.left);
			binaryQueue.add(presentNode.right);
		}
	}
	
	//Delete Method
	public String delete(String value) {
		String removed = null;
		if(root == null) {
			System.out.println("Binary Tree is empty");
			return null;
		}
		
		//level order traversal
		Queue<BinaryTreeNode> binaryQueue = new LinkedList<>();
		binaryQueue.add(root);
		while(!binaryQueue.isEmpty()) {
			BinaryTreeNode presentNode = binaryQueue.remove();
			
			//Finds the Node wants to be deleted
			if(presentNode.value.equals(value)) {
				removed = presentNode.value;
				presentNode.value = getDeepestNode().value;
				deleteDeepestNode();
				System.out.println("Successfully deleted");
				return removed;
			}
			
			if(presentNode.left != null) {
				binaryQueue.add(presentNode.left);
			}
			if(presentNode.right != null) {
				binaryQueue.add(presentNode.right);
			}
		}
		
		return removed;
	}
}
