package com.example.tree;

public class TreeMain {
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode("Drinks");
		
		TreeNode hotNode = new TreeNode("Hot");
		TreeNode coldNode = new TreeNode("Cold");
		
		node.addChild(hotNode);
		node.addChild(coldNode);
		
		TreeNode teaNode = new TreeNode("Tea");
		TreeNode coffeeNode = new TreeNode("Coffee");
		
		TreeNode colaNode = new TreeNode("Cola");
		TreeNode pepsiNode = new TreeNode("Pepsi");
		
		hotNode.addChild(teaNode);
		hotNode.addChild(coffeeNode);
		
		coldNode.addChild(colaNode);
		coldNode.addChild(pepsiNode);
		
		System.out.println(node.display(0));
	}

}
