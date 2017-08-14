package com.graph.problems;

import java.util.ArrayList;
import java.util.List;

import com.graph.model.Vertex;

public class PrintAllPaths {
	static int size=0;

	public static void main(String[] args) {
		Vertex vertex0=new Vertex('0');
		Vertex vertex1=new Vertex('1');
		Vertex vertex2=new Vertex('2');
		Vertex vertex3=new Vertex('3');
		AdjacencyListForDirectedGraph adjList=new AdjacencyListForDirectedGraph(4);
		adjList.addVertex(vertex0);
		adjList.addVertex(vertex1);
		adjList.addVertex(vertex2);
		adjList.addVertex(vertex3);
		
		adjList.addEdge(vertex0, vertex2);
		adjList.addEdge(vertex0, vertex1);
		adjList.addEdge(vertex0, vertex3);
		
		adjList.addEdge(vertex1, vertex3);
		
		adjList.addEdge(vertex2, vertex0);
		adjList.addEdge(vertex2, vertex1);
		
		printAllPaths(vertex2,vertex3,adjList);
		

	}

	private static void printAllPaths(Vertex source, Vertex destination,AdjacencyListForDirectedGraph adjList) {
		List<Vertex>path=new ArrayList<>();
		pathUtil(source,destination,adjList,path);
		
		
	}

	private static void pathUtil(Vertex source, Vertex destination, AdjacencyListForDirectedGraph adjList,List<Vertex> path) {
		
		source.setVisited(true);
		path.add(source);
		
		
		if(source==destination){
			path.forEach(e->System.out.print(e.getLabel()+"\t"));
			System.out.println();
			//source.setVisited(false);
			//path.remove(source);
		}else{
			List<Vertex>neighbours=adjList.getConnectedVertices(source);
			if(neighbours.size()>0){
				for(Vertex neighbour:neighbours){
					if(!neighbour.isVisited()){
						pathUtil(neighbour, destination, adjList, path);
						neighbour.setVisited(false);
						path.remove(neighbour);
						
					
					}
					
				}
			}
		}
		
	}

}
