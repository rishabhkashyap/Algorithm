package com.graph.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.graph.model.Vertex;

public class AdjacencyListForDirectedGraph {
	private int noOfVertices;
	private List<Vertex> vertices;
	private Map<Vertex, List<Vertex>> adjList;

	public AdjacencyListForDirectedGraph(int noOfVertices) {
		super();
		this.noOfVertices = noOfVertices;
		this.vertices = new ArrayList<>();
		this.adjList = new HashMap<>();
	}

	public void addVertex(Vertex vertex) {
		vertices.add(vertex);
		adjList.put(vertex, new ArrayList<>());
	}

	public void addEdge(Vertex source, Vertex destination) {
		List<Vertex> neighbours = adjList.get(source);
		neighbours.add(destination);
		adjList.put(source, neighbours);
		
		

	}
	public List<Vertex>getConnectedVertices(Vertex source){
		return adjList.get(source);
	}

}
