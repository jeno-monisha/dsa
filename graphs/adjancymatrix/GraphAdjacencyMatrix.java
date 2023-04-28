package com.example.graphs.adjancymatrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class GraphAdjacencyMatrix {
    public ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();;
    public int[][] adjacencyMatrix;
    
    public GraphAdjacencyMatrix(ArrayList<GraphNode> nodeList) {
    	this.nodeList = nodeList;
    	this.adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
    }
    
    //creating links between first node and second node
    public void addUndirectedEdge(int i, int j) {
    	adjacencyMatrix[i][j] = 1;
    	adjacencyMatrix[j][i] = 1;
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("   ");
        for (int i = 0; i < nodeList.size(); i++) {
          s.append(nodeList.get(i).name + " ");
        }
        s.append("\n");
        for (int i = 0; i < nodeList.size(); i++) {
          s.append(nodeList.get(i).name + ": ");
          for (int j : adjacencyMatrix[i]) {
            s.append((j) + " ");
          }
          s.append("\n");
        }
        return s.toString();
   }
    
    public ArrayList<GraphNode> getNeighbors(GraphNode node) {
    	ArrayList<GraphNode> neighbors = new ArrayList<GraphNode>();
    	int nodeIndex = node.index;
    	for(int col = 0; col < adjacencyMatrix.length; col++) {
    		if(adjacencyMatrix[nodeIndex][col] == 1) {
    			neighbors.add(nodeList.get(col));
    		}
    	}
    	return neighbors;
    }
    
    public void bfsVisit(GraphNode node) {
    	LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
    	queue.add(node);
    	while(!queue.isEmpty()) {
    		GraphNode presentNode = queue.remove();
    		presentNode.isVisited = true;
    		System.out.print(presentNode.name + " -> ");
    		ArrayList<GraphNode> neighbors = getNeighbors(presentNode);
    		if(neighbors != null && neighbors.size() > 0) {
    			for(GraphNode neighbor: neighbors) {
                    if(!neighbor.isVisited) {
                    	queue.add(neighbor);
                    	neighbor.isVisited = true;
                    }
    			}
    		}
    	}
    			
    }
    
    
    public void bfs() {
    	for(GraphNode node: nodeList) {
    		if(!node.isVisited) {
    			bfsVisit(node);
    		}
    	}
    }
    
    public void dfsVisit(GraphNode node) {
    	Stack<GraphNode> stack = new Stack<GraphNode>();
    	stack.push(node);
    	while(!stack.isEmpty()) {
    		GraphNode presentNode = stack.pop();
    		System.out.print(presentNode.name + " ");
    		presentNode.isVisited = true;
    		for(GraphNode neighbor: getNeighbors(presentNode)) {
    			if(!neighbor.isVisited) {
    				stack.push(neighbor);
    				neighbor.isVisited = true;
    			}
    		}
    	}
    }
    
    public void dfs() {
    	for(GraphNode node: nodeList) {
    		if(!node.isVisited) {
    			dfsVisit(node);
    		}
    	}
    }
    
//  Topological Sort
  public void addDirectedEdge(int i, int j) {
    adjacencyMatrix[i][j] = 1;
  }

  void topologicalVisit(GraphNode node, Stack<GraphNode> stack) {
    ArrayList<GraphNode> neighbors = getNeighbors(node);
    for (GraphNode neighbor : neighbors) {
      if (!neighbor.isVisited) {
        topologicalVisit(neighbor, stack);
      }
    }
    node.isVisited = true;
    stack.push(node);
  }

  void topologicalSort() {
    Stack<GraphNode> stack = new Stack<>();
    for (GraphNode node : nodeList) {
      if (!node.isVisited) {
        topologicalVisit(node, stack);
      }
    }

    while (!stack.isEmpty()) {
      System.out.print(stack.pop().name + " ");
    }
  }

}
