package com.algo.graph.bfs;

import com.algo.graph.model.Vertex;

import java.util.*;

//Board dimension = 36X36
public class SnakeLadder {

    public static void main(String[] args) {
        int[] board = new int[50];
        board[2] = 13;
        board[5] = 2;
        board[9] = 18;
        board[18] = 11;
        board[17] = -13;
        board[20] = -14;
        board[24] = -8;
        board[25] = -10;
        board[32] = -2;
        board[34] = -22;
        BfsShortesDistance bfsShortesDistance = new BfsShortesDistance(40);
        //Creating graph
        for (int i = 1; i <= 36; i++) {
            Vertex source = new Vertex(Integer.toString(i));
            bfsShortesDistance.addVertex(source);
            for (int move = 1; move <= 6; move++) {
                int destination = i + move + board[i + move];
                if (destination > 36) {
                    destination = 36;
                }
                Vertex dest = new Vertex(Integer.toString(destination));
                bfsShortesDistance.addVertex(dest);
                bfsShortesDistance.addEdge(source, dest);
            }
        }

        Vertex destination = new Vertex("36");
        System.out.println("Shortest distance = " + bfsShortesDistance.shortestPathLength(destination));
        List<String> shortestPath = bfsShortesDistance.getShortestPath(destination);
        System.out.println("\nShortest path ");
        shortestPath.forEach(e -> System.out.print(e + "\t"));


    }

    static class BfsShortesDistance {

        private int size;
        private List<Vertex> vertices;
        private Map<String, List<Vertex>> adjacencyMap;
        private List<String> shortestPath;

        public BfsShortesDistance(int size) {
            this.size = size;
            this.vertices = new ArrayList<>(this.size);
            this.adjacencyMap = new HashMap<>();
            this.shortestPath = new ArrayList<>();

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

        public int shortestPathLength(Vertex destination) {
            Vertex root = new Vertex("1");
            Map<String, Integer> distanceMap = new HashMap<>();
            Map<String, String> parentMap = new HashMap<>();
            distanceMap.put(root.getLabel(), 0);
            Queue<Vertex> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                Vertex vertex = queue.remove();
                List<Vertex> neighbours = adjacencyMap.get(vertex.getLabel());
                if (neighbours != null && !neighbours.isEmpty()) {
                    for (Vertex vtx : neighbours) {
                        if (!distanceMap.containsKey(vtx.getLabel())) {
                            queue.add(vtx);
                            int distance = distanceMap.get(vertex.getLabel());
                            distanceMap.put(vtx.getLabel(), distance + 1);
                            parentMap.put(vtx.getLabel(), vertex.getLabel());
                        }
                    }
                }

            }

            String temp = destination.getLabel();

            while (!root.getLabel().equals(temp)) {
                shortestPath.add(temp);
                temp = parentMap.get(temp);

            }
            shortestPath.add(root.getLabel());
            Collections.reverse(shortestPath);


            return distanceMap.get(destination.getLabel());

        }

        public List<String> getShortestPath(Vertex destination) {
            if (shortestPath == null || shortestPath.isEmpty()) {
                this.shortestPathLength(destination);
            }
            return shortestPath;
        }
    }
}