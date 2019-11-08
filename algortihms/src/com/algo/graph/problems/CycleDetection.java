package com.algo.graph.problems;

import java.util.List;

import com.algo.graph.model.Vertex;

public class CycleDetection {

	public static void main(String[] args) {
		Vertex vertex0=new Vertex("0");
		Vertex vertex1=new Vertex("1");
		Vertex vertex2=new Vertex("2");
		Vertex vertex3=new Vertex("3");
		Vertex vertex4=new Vertex("4");
		AdjacencyListGraph adjList=new AdjacencyListGraph(5);
		adjList.addVertex(vertex0);
		adjList.addVertex(vertex1);
		adjList.addVertex(vertex2);
		adjList.addVertex(vertex3);
		adjList.addVertex(vertex4);
		//Creating edges for vertex 0
		adjList.addEdge(vertex0, vertex1);
		adjList.addEdge(vertex0, vertex2);
		adjList.addEdge(vertex0, vertex3);
		//Creating edge for vertex1
		//adjList.addEdge(vertex1, vertex0);
		adjList.addEdge(vertex1, vertex2);
		//Creating edge for vertex 2
		adjList.addEdge(vertex2, vertex1);
		adjList.addEdge(vertex2, vertex0);
		//Creating edge for vertex 3
		adjList.addEdge(vertex3, vertex0);
		adjList.addEdge(vertex3, vertex4);
		//Creating edge for vertex 4
		adjList.addEdge(vertex4, vertex3);
		System.out.println("Cycle exist =  "+isCycleExist(adjList, null, vertex0));
		
				

	}
	
	private static boolean isCycleExist(AdjacencyListGraph adjList,Vertex parent,Vertex source){
		source.setVisited(true);		
		List<Vertex>neighbours=adjList.getConnectedVertices(source);
		if(neighbours!=null){
			for(Vertex neighbour:neighbours){
				if(!neighbour.isVisited()){
					isCycleExist(adjList, source,neighbour);
					//return true;
				}else if(neighbour!=parent){
					return true;
				}
			}
			
		}
		return false;
		
	}

}
