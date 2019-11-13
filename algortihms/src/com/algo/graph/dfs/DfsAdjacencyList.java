package com.algo.graph.dfs;


import com.algo.graph.model.Vertex;

import java.util.*;

public class DfsAdjacencyList {

    private List<Vertex> vertices;
    private Map<String, List<Vertex>> adjacencyMap;
    private int size;

    public DfsAdjacencyList(int size) {
        vertices = new ArrayList<>(size);
        adjacencyMap = new HashMap<>();
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

    public void performDFS(Vertex source) {
        Stack<Vertex> stack = new Stack<>();
        source.setVisited(true);
        System.out.print(source.getLabel() + "\t");
        stack.push(source);
        while (!stack.isEmpty()) {
            Vertex vertex = stack.peek();
            Vertex unvisitedVtx = getUnvisitedNeighbour(vertex);
            if (unvisitedVtx != null) {
                unvisitedVtx.setVisited(true);
                System.out.print(unvisitedVtx.getLabel() + "\t");
                stack.push(unvisitedVtx);
            } else {
                stack.pop();
            }
        }
    }


    public void performRecursiveDFS(Vertex source) {
        if (source.isVisited()) {
            return;
        }
        source.setVisited(true);
        System.out.print(source.getLabel() + "\t");
        List<Vertex> neighbours = this.adjacencyMap.get(source.getLabel());
        if (neighbours != null && !neighbours.isEmpty()) {
            for (Vertex neighbour : neighbours) {
                if (!neighbour.isVisited()) {
                    performRecursiveDFS(neighbour);
                }
            }

        }

    }

    private Vertex getUnvisitedNeighbour(Vertex vertex) {
        List<Vertex> neighbours = this.adjacencyMap.get(vertex.getLabel());
        if (neighbours != null && !neighbours.isEmpty()) {
            for (Vertex neighbour : neighbours) {
                if (!neighbour.isVisited()) {
                    return neighbour;
                }
            }
        }
        return null;
    }
}
