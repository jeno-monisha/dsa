package com.example.graphs.adjancymatrix;

import java.util.ArrayList;

public class GraphAdjacencyMatrixMain {
	
	public static void main(String[] args) {
		
		GraphNode node1 = new GraphNode("A", 0);
		GraphNode node2 = new GraphNode("B", 1);
		GraphNode node3 = new GraphNode("C", 2);
		GraphNode node4 = new GraphNode("D", 3);
		GraphNode node5 = new GraphNode("E", 4);
		
		ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
		nodeList.add(node1);
		nodeList.add(node2);
		nodeList.add(node3);
		nodeList.add(node4);
		nodeList.add(node5);
		
		
		GraphAdjacencyMatrix graph = new GraphAdjacencyMatrix(nodeList);
		graph.addUndirectedEdge(0, 1);
		graph.addUndirectedEdge(0, 2);
		graph.addUndirectedEdge(0, 3);
		
		graph.addUndirectedEdge(1, 4);
		
		graph.addUndirectedEdge(2, 3);
		
		graph.addUndirectedEdge(3, 4);
		
		System.out.println(graph);
		
		//graph.bfs();
		
		graph.dfs();
	}

}
