package com.algo.graph.bfs;

import com.algo.graph.model.Vertex;

import java.util.*;

public class BfsAdjacenecyList {

    private int size;
    private List<Vertex> vertices;
    private Map<String, List<Vertex>> adjacencyMap;

    public BfsAdjacenecyList(int size) {
        this.size = size;
        this.vertices = new ArrayList<>(this.size);
        this.adjacencyMap = new HashMap<>();

    }

    public void addVertex(Vertex vertex) {
        this.vertices.add(vertex);
    }

    public void addEdge(Vertex source, Vertex destination) {
        List<Vertex> neighbours = null;
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

    public void bfsSearch(Vertex root) {
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(root);
        root.setVisited(true);
        while (!queue.isEmpty()) {
            Vertex vertex = queue.remove();
            System.out.print(vertex.getLabel() + "\t");
            List<Vertex> neighbours = adjacencyMap.get(vertex.getLabel());
            for (Vertex vtx : neighbours) {
                if (!vtx.isVisited()) {
                    vtx.setVisited(true);
                    queue.add(vtx);
                }
            }

        }
    }

}
