package com.algo.graph.bfs;

import com.algo.graph.model.Vertex;

import java.util.*;

public class ShortestPath {

    public static void main(String[] args) {
        Vertex v0 = new Vertex('0');
        Vertex v1 = new Vertex('1');
        Vertex v2 = new Vertex('2');
        Vertex v3 = new Vertex('3');
        Vertex v4 = new Vertex('4');
        Vertex v5 = new Vertex('5');
        BfsShortesDistance bfsShortesDistance = new BfsShortesDistance(6);
        bfsShortesDistance.addVertex(v0);
        bfsShortesDistance.addVertex(v1);
        bfsShortesDistance.addVertex(v2);
        bfsShortesDistance.addVertex(v3);
        bfsShortesDistance.addVertex(v4);
        bfsShortesDistance.addVertex(v5);

        bfsShortesDistance.addEdge(v0, v1);
        bfsShortesDistance.addEdge(v0, v4);
        bfsShortesDistance.addEdge(v1, v0);
        bfsShortesDistance.addEdge(v1, v2);
        bfsShortesDistance.addEdge(v2, v1);
        bfsShortesDistance.addEdge(v2, v4);
        bfsShortesDistance.addEdge(v4, v2);
        bfsShortesDistance.addEdge(v2, v3);
        bfsShortesDistance.addEdge(v3, v2);
        bfsShortesDistance.addEdge(v3, v4);
        bfsShortesDistance.addEdge(v4, v3);
        bfsShortesDistance.addEdge(v3, v5);
        bfsShortesDistance.addEdge(v4, v0);
        bfsShortesDistance.addEdge(v5, v3);

        bfsShortesDistance.shortestPath(v1);

    }


    static class BfsShortesDistance {

        private int size;
        private List<Vertex> vertices;
        private Map<Character, List<Vertex>> adjacencyMap;

        public BfsShortesDistance(int size) {
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

        public void shortestPath(Vertex root) {
            Map<Character, Integer> distanceMap = new HashMap<>();
            distanceMap.put(root.getLabel(), 0);
            Queue<Vertex> queue = new LinkedList<>();
            queue.add(root);
            root.setVisited(true);
            while (!queue.isEmpty()) {
                Vertex vertex = queue.remove();
                List<Vertex> neighbours = adjacencyMap.get(vertex.getLabel());
                for (Vertex vtx : neighbours) {
                    if (!distanceMap.containsKey(vtx.getLabel())) {
                        queue.add(vtx);
                        int distance = distanceMap.get(vertex.getLabel());
                        distanceMap.put(vtx.getLabel(), distance + 1);

                    }
                }

            }

            Set<Character> vertices = distanceMap.keySet();
            for (Character vtx : vertices) {
                System.out.println("Distance between  " + root.getLabel() + "  and  " + vtx + "  =  " + distanceMap.get(vtx));
            }

        }

    }
}
