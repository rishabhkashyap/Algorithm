package com.algo.graph.model;

import java.util.*;

public class Graph {
    private List<Vertex> vertices;
    private Map<String, List<Vertex>> adjacencyMap;
    private int size;

    public Graph(int size) {
        vertices = new ArrayList<>(size);
        adjacencyMap = new HashMap<>();
    }

    public void addVertex(Vertex vertex) {
        this.vertices.add(vertex);
    }

    public void addVertices(List<Vertex> vertexList) {
        this.vertices.addAll(vertexList);
    }

    public void addEdge(Vertex source, Vertex destination) {
        List<Vertex> neighbours;
        if (adjacencyMap.containsKey(source.getLabel())) {
            neighbours = adjacencyMap.get(source.getLabel());
            neighbours.add(destination);
            adjacencyMap.put(source.getLabel(), neighbours);
        } else {
            neighbours = new ArrayList<>();
            neighbours.add(destination);
            adjacencyMap.put(source.getLabel(), neighbours);
        }
    }

    public List<Vertex> getVertices() {
        return Collections.unmodifiableList(vertices);
    }

    public Map<String, List<Vertex>> getAdjacencyMap() {
        return Collections.unmodifiableMap(adjacencyMap);
    }

    public List<Vertex> getNeighbours(Vertex vertex) {
        List<Vertex> neighbours = adjacencyMap.get(vertex.getLabel());
        if (neighbours != null && !neighbours.isEmpty()) {
            return Collections.unmodifiableList(neighbours);
        }
        return null;
    }

    public int getSize() {
        return size;
    }

    public Graph getTranspose() {
        Graph graph = new Graph(vertices.size());
        this.vertices.forEach(e -> e.setVisited(false));
        graph.addVertices(vertices);
        for (Vertex vertex : vertices) {
            List<Vertex> neighbours = getNeighbours(vertex);
            if (neighbours != null && !neighbours.isEmpty()) {
                for (Vertex neighbour : neighbours) {
                    graph.addEdge(neighbour, vertex);
                }
            }
        }
        return graph;


    }

}
