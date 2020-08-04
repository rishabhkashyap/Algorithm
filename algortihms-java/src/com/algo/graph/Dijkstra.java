package com.algo.graph;


import java.util.*;

public class Dijkstra {

    public static void main(String[] args) {

        Vertex vertexA = new Vertex("A");
        Vertex vertexB = new Vertex("B");
        Vertex vertexC = new Vertex("C");
        Vertex vertexD = new Vertex("D");
        Vertex vertexE = new Vertex("E");
        vertexA.addNeighbour(new Neighbour(vertexC, 10));
        vertexA.addNeighbour(new Neighbour(vertexB, 17));
        vertexC.addNeighbour(new Neighbour(vertexB, 5));
        vertexC.addNeighbour(new Neighbour(vertexD, 9));
        vertexC.addNeighbour(new Neighbour(vertexE, 11));
        vertexB.addNeighbour(new Neighbour(vertexD, 1));
        vertexD.addNeighbour(new Neighbour(vertexE, 6));

        Graph graph = new Graph();
        graph.addVertex(vertexA);
        graph.addVertex(vertexB);
        graph.addVertex(vertexC);
        graph.addVertex(vertexD);
        graph.addVertex(vertexE);
        graph.computeShortestPath(vertexA);
        System.out.println("Shortest distance between A and B = " + vertexB.getDistance());
        System.out.println("Shortest distance between A and C = " + vertexC.getDistance());
        System.out.println("Shortest distance between A and D = " + vertexD.getDistance());
        System.out.println("Shortest distance between A and E = " + vertexE.getDistance());

        System.out.println("\nShortest path between A and E");
        System.out.println(graph.shortestPath(vertexE));


    }

    private static class Vertex implements Comparable<Vertex> {
        private String label;
        private Vertex predecessor;
        private Integer distance;
        private List<Neighbour> neighbours;
        private Boolean visited;

        public Vertex(String label) {
            this.label = label;
            this.distance = Integer.MAX_VALUE;
            this.neighbours = new ArrayList<>();
            this.visited = false;
        }

        public void addNeighbour(Neighbour neighbour) {
            this.neighbours.add(neighbour);
        }

        public List<Neighbour> getNeighbours() {
            return Collections.unmodifiableList(this.neighbours);
        }

        public void setNeighbours(List<Neighbour> neighbours) {
            this.neighbours = neighbours;
        }

        public String getLabel() {
            return label;
        }


        public Vertex getPredecessor() {
            return predecessor;
        }

        public void setPredecessor(Vertex predecessor) {
            this.predecessor = predecessor;
        }

        public Integer getDistance() {
            return distance;
        }

        public void setDistance(Integer distance) {
            this.distance = distance;
        }

        public Boolean isVisited() {
            return visited;
        }

        public void setVisited(Boolean visited) {
            this.visited = visited;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vertex vertex = (Vertex) o;
            return label.equals(vertex.label) &&
                    predecessor.equals(vertex.predecessor) &&
                    visited.equals(vertex.visited);
        }

        @Override
        public int hashCode() {
            return Objects.hash(label, predecessor, visited);
        }

        @Override
        public int compareTo(Vertex o) {
            return this.distance - o.distance;
        }

        @Override
        public String toString() {
            return label + " ";
        }
    }

    private static class Neighbour {
        private Vertex destination;
        private Integer distance;

        public Neighbour(Vertex vertex, Integer distance) {
            this.destination = vertex;
            this.distance = distance;
        }

        public Vertex getDestination() {
            return destination;
        }

        public void setDestination(Vertex destination) {
            this.destination = destination;
        }

        public Integer getDistance() {
            return distance;
        }


    }

    private static class Graph {
        Map<String, List<Neighbour>> neighbourMap;
        private List<Vertex> vertices;

        public Graph() {
            this.neighbourMap = new HashMap<>();
            this.vertices = new ArrayList<>();
        }

        public void addVertex(Vertex vertex) {
            this.vertices.add(vertex);
        }

        public void addNeighbour(Vertex vertex, Neighbour neighbour) {
            if (neighbourMap.containsKey(vertex.getLabel())) {
                List<Neighbour> neighbours = neighbourMap.get(vertex.getLabel());
                neighbours.add(neighbour);
                neighbourMap.put(vertex.getLabel(), neighbours);
            } else {
                List<Neighbour> neighbours = new ArrayList<>();
                neighbours.add(neighbour);
                neighbourMap.put(vertex.getLabel(), neighbours);

            }
        }


        public void computeShortestPath(Vertex source) {
            Queue<Vertex> queue = new PriorityQueue<>();
            source.setDistance(0);
            queue.add(source);
            while (!queue.isEmpty()) {
                Vertex vertex = queue.remove();
                List<Neighbour> neighbours = vertex.getNeighbours();
                if (neighbours != null && !neighbours.isEmpty()) {
                    for (Neighbour neighbour : neighbours) {
                        Vertex destination = neighbour.getDestination();
                        if (getDistance(vertex, neighbour.getDistance()) < destination.getDistance()) {
                            queue.remove(destination);
                            destination.setDistance(getDistance(vertex, neighbour.getDistance()));
                            destination.setPredecessor(vertex);
                            queue.add(destination);

                        }

                    }
                }
            }
        }

        private int getDistance(Vertex vertex, int distance) {
            return vertex.getDistance() + distance;
        }

        public List<Vertex> shortestPath(Vertex desination) {
            List<Vertex> path = new ArrayList<>();
            while (desination != null) {
                path.add(desination);
                desination = desination.getPredecessor();
            }
            Collections.reverse(path);
            return path;
        }

    }
}
