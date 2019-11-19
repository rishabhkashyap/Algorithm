package com.algo.graph.bfs;

import com.algo.graph.model.Vertex;

import java.util.*;

public class BFSCycle {

    public static void main(String[] args) {
        Vertex v0 = new Vertex("0");
        Vertex v1 = new Vertex("1");
        Vertex v2 = new Vertex("2");
        Vertex v3 = new Vertex("3");
        Vertex v4 = new Vertex("4");
        Vertex v5 = new Vertex("5");
        Cycle cycle = new Cycle(6);
        cycle.addVertex(v0);
        cycle.addVertex(v1);
        cycle.addVertex(v2);
        cycle.addVertex(v3);
        cycle.addEdge(v0, v1);
        cycle.addEdge(v1, v0);
        cycle.addEdge(v1, v2);
        cycle.addEdge(v2, v1);
        cycle.addEdge(v2, v3);
        cycle.addEdge(v3, v2);
        cycle.addEdge(v3, v0);
        cycle.addEdge(v0, v3);
        System.out.println("Graph has cycle = " + cycle.isCyclicBFS(v0));


    }

    private static class Cycle {
        private int size;
        private List<Vertex> vertices;
        private Map<String, List<Vertex>> adjacencyMap;

        public Cycle(int size) {
            this.size = size;
            this.vertices = new ArrayList<>(this.size);
            this.adjacencyMap = new HashMap<>();

        }

        private void addVertex(Vertex vertex) {
            this.vertices.add(vertex);
        }

        private void addEdge(Vertex source, Vertex destination) {
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

        private boolean isCyclicBFS(Vertex source) {
            Map<String, Vertex> parentMap = new HashMap<>();
            Queue<Vertex> queue = new LinkedList<>();
            parentMap.put(source.getLabel(), source);
            source.setVisited(true);
            queue.add(source);
            while (!queue.isEmpty()) {
                Vertex vertex = queue.remove();
                List<Vertex> neighbours = this.adjacencyMap.get(vertex.getLabel());
                if (neighbours != null && !neighbours.isEmpty()) {
                    Vertex parent = parentMap.get(vertex.getLabel());
                    for (Vertex neighbour : neighbours) {
                        if (neighbour.isVisited() && parent != null && !parent.getLabel().equals(neighbour.getLabel())) {
                            return true;
                        } else if(!neighbour.isVisited()) {
                            parentMap.put(neighbour.getLabel(), vertex);
                            neighbour.setVisited(true);
                            queue.add(neighbour);
                        }
                    }
                }
            }
            return false;
        }


    }
}
