package com.algo.graph.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.algo.graph.model.Vertex;

public class GraphDfs {
	private int noOfNodes;
	private List<Vertex>vertices;
	private int[][] adjacencyMatrix;
	public GraphDfs(int noOfNodes) {		
		this.noOfNodes = noOfNodes;
		this.vertices = new ArrayList<>();
		this.adjacencyMatrix = new int[noOfNodes][noOfNodes];
	}
	
	public void addVertex(Vertex vertex){
		vertices.add(vertex);
	}
	
	public void addEdge(Vertex source,Vertex Detination){
		int i=vertices.indexOf(source);
		int j=vertices.indexOf(Detination);
		adjacencyMatrix[i][j]=1;
	}
	
	private Vertex getAdjacentUnvisitedVertex(Vertex vertex){
		Vertex neighbour=null;
		int i=vertices.indexOf(vertex);
		for(int j=0;j<noOfNodes;j++){
			if(adjacencyMatrix[i][j]==1 && vertices.get(j).isVisited()==false){
				neighbour=vertices.get(j);
				break;
			}
		}
		return neighbour;
		
	}
	
	public void performDfs(Vertex source){
		Stack<Vertex>stack=new Stack<>();
		stack.push(source);
		source.setVisited(true);
		System.out.print(source.getLabel()+"\t");
		while(!stack.isEmpty()){
			Vertex neighbour=getAdjacentUnvisitedVertex(stack.peek());
			if(neighbour==null){
				stack.pop();
			}else{
				stack.push(neighbour);
				neighbour.setVisited(true);
				System.out.print(neighbour.getLabel()+"\t");
				
			}
		}
	}
	
	

}
