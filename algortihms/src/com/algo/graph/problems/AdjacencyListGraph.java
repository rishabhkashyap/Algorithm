package com.algo.graph.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.algo.graph.model.Vertex;

public class AdjacencyListGraph {
	private int noOfVertices;
	private List<Vertex> vertices;
	private Map<Vertex, List<Vertex>> adjList;

	public AdjacencyListGraph(int noOfVertices) {
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
		
		neighbours = adjList.get(destination);
		neighbours.add(source);
		adjList.put(destination, neighbours);

	}
	public List<Vertex>getConnectedVertices(Vertex source){
		return adjList.get(source);
	}

}
