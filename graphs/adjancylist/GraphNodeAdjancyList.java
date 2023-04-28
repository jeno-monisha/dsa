package com.example.graphs.adjancylist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class GraphNodeAdjancyList {
	
	public ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
	
	public GraphNodeAdjancyList(ArrayList<GraphNode> nodeList) {
		this.nodeList = nodeList;
	}
	
	public void addUndirectedEdge(int i, int j) {
		GraphNode first = nodeList.get(i);
		GraphNode second = nodeList.get(j);
		first.neighbors.add(second);
		second.neighbors.add(first);
	}
	
	// For printing Graph to the console
	  public String toString() {
	    StringBuilder s = new StringBuilder();
	    for (int i = 0; i < nodeList.size(); i++) {
	      s.append(nodeList.get(i).name + ": ");
	      for (int j =0; j < nodeList.get(i).neighbors.size(); j++) {
	        if (j == nodeList.get(i).neighbors.size()-1 ) {
	          s.append((nodeList.get(i).neighbors.get(j).name) );
	        } else {
	          s.append((nodeList.get(i).neighbors.get(j).name) + " -> ");
	        }
	      }
	      s.append("\n");
	    }
	    return s.toString();
	  }
    
	  public void bfsVisit(GraphNode node) {
		  LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
		  queue.add(node);
		  while(!queue.isEmpty()) {
			  GraphNode presentNode = queue.remove(0);
			  System.out.print(presentNode.name + " ");
			  presentNode.isVisited = true;
			  if(presentNode.neighbors != null && presentNode.neighbors.size() > 0) {
				  for(GraphNode neigbor: node.neighbors) {
					  if(!neigbor.isVisited) {
						  queue.add(neigbor);
						  neigbor.isVisited = true;
					  }
				  }
			  }
		  }
	  }
	  
	  //UnDirected and Queue
	  public void bfs() {
		  for(GraphNode node: nodeList) {
			  if(!node.isVisited) {
				  bfsVisit(node);
			  }
		  }
	  }
	  
	  public void dfsVisit(GraphNode node) {
		  Stack<GraphNode> stack = new Stack<GraphNode> ();
		  stack.push(node);
		  while(!stack.isEmpty()) {
			  GraphNode presentNode = stack.pop();
			  presentNode.isVisited = true;
			  System.out.print(presentNode.name + " ");
			  for(GraphNode neighbor: presentNode.neighbors) {
				  if(!neighbor.isVisited) {
					  stack.push(neighbor);
					  neighbor.isVisited = true;
				  }
			  }
		  }
	  }
	  
	  //UnDirected Edge Stack
	  public void dfs() {
		  for(GraphNode node: nodeList) {
			  if(!node.isVisited) {
				  dfsVisit(node);
			  }
		  }
	  }
	  
	  public void addDirectedEdge(int i, int j) {
		  GraphNode first = nodeList.get(i);
		  GraphNode second = nodeList.get(j);
		  first.neighbors.add(second);
	  }
	  
	  public void topologicalVisit(GraphNode node) {
		  Stack<GraphNode> stack = new Stack<GraphNode> ();
		  stack.push(node);
		  while(!stack.isEmpty()) {
			  GraphNode presentNode = stack.pop();
			  presentNode.isVisited = true;
			  System.out.print(presentNode.name + " ");
			  for(GraphNode neighbor: presentNode.neighbors) {
				  if(!neighbor.isVisited) {
					  stack.push(neighbor);
					  neighbor.isVisited = true;
				  }
			  }
		  }
	  }
	  
	  //Directed and Stack
	  public void topologicalSort() {
		  for(GraphNode node: nodeList) {
			  if(!node.isVisited) {
				  dfsVisit(node);
			  }
		  }
	  }
}
