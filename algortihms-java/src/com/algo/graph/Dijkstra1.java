package com.algo.graph;


import java.util.*;

public class Dijkstra1 {
    public static void main(String[] args) {
        Vertex vertexA = new Vertex("A");
        Vertex vertexB = new Vertex("B");
        Vertex vertexC = new Vertex("C");
        Vertex vertexD = new Vertex("D");
        Vertex vertexE = new Vertex("E");
        Graph graph = new Graph(5);
        graph.addVertex(vertexA);
        graph.addVertex(vertexB);
        graph.addVertex(vertexC);
        graph.addVertex(vertexD);
        graph.addVertex(vertexE);
        graph.addEdge(vertexA, vertexC, 10);
        graph.addEdge(vertexA, vertexB, 17);
        graph.addEdge(vertexC, vertexB, 5);
        graph.addEdge(vertexC, vertexD, 9);
        graph.addEdge(vertexC, vertexE, 11);
        graph.addEdge(vertexB, vertexD, 1);
        graph.addEdge(vertexD, vertexE, 6);
        Map<String, Integer> shortestPathMap = graph.computeShortestDistance(vertexA);
        shortestPathMap.forEach((label, distance) -> System.out.println("Shortest distance between A and " + label + " => " + distance));
        graph.printShortestPath(vertexA);

//        Vertex vertexA = new Vertex("A");
//        Vertex vertexB = new Vertex("B");
//        Vertex vertexC = new Vertex("C");
//        Vertex vertexD = new Vertex("D");
//        Vertex vertexE = new Vertex("E");
//        Graph graph = new Graph(5);
//        graph.addVertex(vertexA);
//        graph.addVertex(vertexB);
//        graph.addVertex(vertexC);
//        graph.addVertex(vertexD);
//        graph.addVertex(vertexE);
//        graph.addEdge(vertexA, vertexB, 3);
//        graph.addEdge(vertexB, vertexE, 1);
//        graph.addEdge(vertexE, vertexD, 7);
//        graph.addEdge(vertexD, vertexC, 2);
//        graph.addEdge(vertexC, vertexD, 2);
//        graph.addEdge(vertexC, vertexA, 1);
//        graph.addEdge(vertexA, vertexC, 1);
//        graph.addEdge(vertexC, vertexB, 7);
//        graph.addEdge(vertexD, vertexB, 5);
//        Map<String, Integer> shortestPathMap = graph.computeShortestDistance(vertexC);
//        shortestPathMap.forEach((label, distance) -> System.out.println("Shortest distance between C and " + label + " => " + distance));
//        graph.printShortestPath(vertexC);


    }

    private static class Vertex implements Comparable<Vertex> {
        private final String label;
        private Integer distanceFromParent;
        private Vertex parent;
        private Boolean visited;

        public Vertex(String label) {
            this.label = label;
            this.distanceFromParent = Integer.MAX_VALUE;
            this.visited = false;

        }


        public String getLabel() {
            return label;
        }

        public Integer getDistanceFromParent() {
            return distanceFromParent;
        }

        public void setDistanceFromParent(Integer distanceFromParent) {
            this.distanceFromParent = distanceFromParent;
        }

        public Boolean isVisited() {
            return visited;
        }

        public void setVisited(Boolean visited) {
            this.visited = visited;
        }

        public Vertex getParent() {
            return parent;
        }

        public void setParent(Vertex parent) {
            this.parent = parent;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vertex vertex = (Vertex) o;
            return Objects.equals(label, vertex.label);
        }

        @Override
        public int hashCode() {
            return Objects.hash(label);
        }

        @Override
        public int compareTo(Vertex o) {
            return this.distanceFromParent - o.getDistanceFromParent();
        }
    }

    private static class Graph {
        private List<Vertex> vertices;
        private Map<String, Integer> edgeMap;
        private Map<String, List<Vertex>> adjListMap;
        private Integer nVertices;

        public Graph(Integer nVertices) {
            this.nVertices = nVertices;
            this.vertices = new ArrayList<>(nVertices);
            this.edgeMap = new HashMap<>();
            this.adjListMap = new HashMap<>();
        }

        public void addVertex(Vertex vertex) {
            if (this.vertices.size() == nVertices) {
                return;
            }
            this.vertices.add(vertex);
        }

        public void addEdge(Vertex source, Vertex destination, Integer weight) {
            List<Vertex> vertices = adjListMap.getOrDefault(source.getLabel(), new ArrayList<>());
            vertices.add(destination);
            this.adjListMap.put(source.getLabel(), vertices);
            this.edgeMap.put(source.getLabel() + destination.getLabel(), weight);
        }

        public Map<String, Integer> computeShortestDistance(Vertex source) {
            Queue<Vertex> queue = new PriorityQueue<>();
            source.setDistanceFromParent(0);
            queue.add(source);
            while (!queue.isEmpty()) {
                Vertex vertex = queue.remove();
                List<Vertex> neighbours = adjListMap.get(vertex.getLabel());
                if (neighbours != null && !neighbours.isEmpty()) {
                    for (Vertex neighbour : neighbours) {
                        if (getDistance(vertex, neighbour) < neighbour.getDistanceFromParent()) {
                            neighbour.setDistanceFromParent(getDistance(vertex, neighbour));
                            neighbour.setParent(vertex);
                            if (queue.contains(neighbour)) {
                                queue.remove(neighbour);
                            }
                            queue.add(neighbour);
                        }
                    }
                }
            }
            Map<String, Integer> shortestPath = new HashMap<>();
            this.vertices.forEach(e -> shortestPath.put(e.getLabel(), e.getDistanceFromParent()));
            return shortestPath;


        }

        private int getDistance(Vertex vertex, Vertex neighbour) {
            return this.edgeMap.get(vertex.getLabel() + neighbour.getLabel()) + vertex.getDistanceFromParent();
        }

        public void printShortestPath(Vertex source) {
            List<String> path = new ArrayList<>();
            for (Vertex destination : this.vertices) {
                String destinationLabel = destination.getLabel();
                while (destination.getParent() != null) {
                    path.add(destination.getLabel());
                    destination = destination.getParent();
                }
                path.add(source.getLabel());
                Collections.reverse(path);
                System.out.println("Path from " + source.getLabel() + " to " + destinationLabel + " = " + path);
                path.clear();
            }
        }
    }
}
