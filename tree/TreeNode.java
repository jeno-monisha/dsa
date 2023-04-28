package com.example.tree;

import java.util.*;

public class TreeNode {
	
	public String value;
	public List<TreeNode> children;
	
	public TreeNode(String value) {
		this.value = value;
		this.children = new ArrayList<TreeNode>();
	}
	
	public void addChild(TreeNode child) {
		this.children.add(child);
	}
	
	public String display(int level) {
		String displayString;
		
		displayString = "  " .repeat(level) + value+ "\n";
		
		for(TreeNode treeNode: children) {
			displayString += treeNode.display(level + 1);
		}
		
		return displayString;
	}

}
