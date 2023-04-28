package com.example.tree.binary.search;

import java.util.Queue;
import java.util.LinkedList;

public class BinarySearchTree {
	
	public BinarySearchTreeNode root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	//In Binary Search tree, left node is less than or equal to root node, right node is greater than root node
    //value is less than means insert it into left tree. If the value is greater than, insert it into right tree.
	private BinarySearchTreeNode insert(BinarySearchTreeNode currentNode, int value) {
		if(currentNode == null) {
			BinarySearchTreeNode newNode = new BinarySearchTreeNode();
			newNode.value = value;
			System.out.println(value + " has been successfully inserted");
			return newNode;
		} else if(value <= currentNode.value) {
			currentNode.left = insert(currentNode.left, value);
			return currentNode;
		} else {
			currentNode.right = insert(currentNode.right, value);
			return currentNode;
		}
	}
	
	//insert method
	public void insert(int value) {
		root = insert(root, value);
	}
	
	//Pre Order Traversal
	public void preOrder(BinarySearchTreeNode node) {
		if(node == null) {
			return;
		}
		System.out.print(node.value + " ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	//In Order Traversal
	public void inOrder(BinarySearchTreeNode node) {
		if(node == null) {
			return;
		}
		
		inOrder(node.left);
		System.out.print(node.value + " ");
		inOrder(node.right);
	}
	
	//Post Order Traversal
	public void postIrder(BinarySearchTreeNode node) {
		if(node == null) {
			return;
		}
		postIrder(node.left);
		postIrder(node.right);
		System.out.print(node.value + " ");
	}
	
	//Level Order
	public void levelOrder() {
		Queue<BinarySearchTreeNode> binarySearchQueue = new LinkedList<BinarySearchTreeNode>();
		binarySearchQueue.add(root);
		
		while(!binarySearchQueue.isEmpty()) {
			BinarySearchTreeNode presentNode = binarySearchQueue.remove();
			System.out.print(presentNode.value + " ");
			
			if(presentNode.left != null) {
				binarySearchQueue.add(presentNode.left);
			}
			
			if(presentNode.right != null) {
				binarySearchQueue.add(presentNode.right);
			}
		}
	}
	
	//Search Method
	public BinarySearchTreeNode search(BinarySearchTreeNode node, int value) {
		if(node == null) {
			System.out.println("Value " + value + " not found in Binary Search Tree");
			return null;
		} else if(value == node.value) {
			System.out.println("Value " + value + " found in Binary Search Tree");
			return node;
		}else if(value < node.value) {
			return search(node.left, value);
		} else {
			return search(node.right, value);
		}
	}
	
	// Minimum node
	  public static BinarySearchTreeNode minimumNode(BinarySearchTreeNode node) {
	    if (node.left == null) {
	      return node;
	    } else {
	      return minimumNode(node.left);
	    }
	  }

	  // Delete node
	  public BinarySearchTreeNode deleteNode(BinarySearchTreeNode node, int value) {
	    if (node == null) {
	      System.out.println("Value not found in BST");
	      return null;
	    }
	    if (value < node.value) {
	    	node.left = deleteNode(node.left, value);
	    } else if (value > node.value) {
	    	node.right = deleteNode(node.right, value);
	    } else {
	    	//two childern. so the delete node to be in the right
	      if (node.left != null && node.right != null) {
	    	BinarySearchTreeNode temp = node;
	    	//Take right tree's last left
	    	BinarySearchTreeNode minNodeForRight = minimumNode(temp.right);
	    	node.value = minNodeForRight.value;
	    	node.right = deleteNode(node.right, minNodeForRight.value);
	    	//node has only one child. if it is left
	    	//assign the delete node left value to node
	      } else if (node.left != null) {
	    	  node = node.left;
	    	//node has only one child. if it is right
	    	//assign the delete node right value to node
	      } else if (root.right != null) {
	    	  node = node.right;
	    	  //leaf node
	      } else {
	    	  node = null;
	      }
	    }

	    return node;

	  }
	  
	  //In Binary Search Tree, left tree last node is always minimum
	  public int min(BinarySearchTreeNode node) {
		  if(node.left == null) {
			  return node.value;
		  }
		  return min(node.left);
	  }
	  
	  //In Binary Search Tree, right tree last node is always maximum
	  public int max(BinarySearchTreeNode node) {
		  if(node.right == null) {
			  return node.value;
		  }
		  return max(node.right);
	  }

}
