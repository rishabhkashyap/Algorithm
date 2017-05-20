package com.graph.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.graph.model.Vertex;

public class GraphBFS {
	private Queue<Vertex>queue;
	private List<Vertex>vertices;
	private int noOfvertices;
	private int[][]adjacencyMatrix;
	
	public GraphBFS(int noOfvertices){
		this.noOfvertices=noOfvertices;
		queue=new LinkedList<>();
		vertices=new ArrayList<>();
		adjacencyMatrix=new int[noOfvertices][noOfvertices];
		
	}
	
	public void addVertex(Vertex vertex){
		vertices.add(vertex);
		
	}
	public void addEdge(Vertex source,Vertex destination){
		int i=vertices.indexOf(source);
		int j=vertices.indexOf(destination);
		adjacencyMatrix[i][j]=1;
	}
	
	private List<Vertex> getNeighbourVertices(Vertex vertex){
		int i=vertices.indexOf(vertex);
		List<Vertex>neighbours=new ArrayList<>();
		for(int j=0;j<noOfvertices;j++){
			if(adjacencyMatrix[i][j]==1 && vertices.get(j).isVisited()==false){
				neighbours.add(vertices.get(j));
			}
			
		}
		return neighbours;
	}
	
	public void performBFS(Vertex vertex){
		queue.add(vertex);
		vertex.setVisited(true);
		while(!queue.isEmpty()){
			Vertex element=queue.remove();
			System.out.print(element.getLabel()+"\t");
			List<Vertex>neighbours=getNeighbourVertices(element);
			for(Vertex neighbour:neighbours){
				queue.add(neighbour);
				neighbour.setVisited(true);
			}
			
		}
		
	}
	
	public void displayAdjacencyMatrix(){
		for(int i=0;i<noOfvertices;i++){
			
			for(int j=0;j<noOfvertices;j++){
				System.out.print(adjacencyMatrix[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	

}
