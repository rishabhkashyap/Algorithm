package com.algo.graph.bfs;

import com.algo.graph.model.Vertex;

import java.util.*;

public class BipartiteGraph {

    public static void main(String[] args) {
        Vertex v1 = new Vertex("1");
        Vertex v2 = new Vertex("2");
        Vertex v3 = new Vertex("3");
        Vertex v4 = new Vertex("4");
        Graph graph = new Graph(4);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addEdge(v1, v2);
        graph.addEdge(v1, v4);
        graph.addEdge(v3, v2);
        graph.addEdge(v3, v4);
//        graph.addEdge(v1, v3);
        System.out.println("Bipartite graph = " + graph.isBipartite(v1));

    }

    private static class Graph {
        private List<Vertex> vertices;
        private Map<String, List<Vertex>> adjacencyMap;


        public Graph(int size) {
            this.vertices = new ArrayList<>(size);
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

        public boolean isBipartite(Vertex source) {
            Queue<Vertex> queue = new LinkedList<>();
            source.setColour("red");
            queue.add(source);
            while (!queue.isEmpty()) {
                Vertex vertex = queue.remove();
                List<Vertex> neighbours = this.adjacencyMap.get(vertex.getLabel());
                if (neighbours != null && !neighbours.isEmpty()) {
                    for (Vertex neighbour : neighbours) {
                        colourNeighbour(vertex, neighbour);
                        if (vertex.getColour().equals(neighbour.getColour())) {
                            return false;
                        }
                        queue.add(neighbour);
                    }
                }
            }
            return true;

        }

        private void colourNeighbour(Vertex source, Vertex neighbour) {
            if (neighbour.getColour() != null) {
                return;
            }
            if (source.getColour().equals("red")) {
                neighbour.setColour("green");
            } else if (source.getColour().equals("green")) {
                neighbour.setColour("red");
            }

        }

    }
}
