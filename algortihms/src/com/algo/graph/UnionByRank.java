package com.algo.graph;

import com.algo.graph.model.Vertex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnionByRank {
    public static void main(String[] args) {

        Graph graph = new Graph(3, 3);
        Vertex vertex0 = new Vertex("0");
        Vertex vertex1 = new Vertex("1");
        Vertex vertex2 = new Vertex("2");
        //Vertex vertex3 = new Vertex("3");
        graph.addVertex(vertex0);
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
       // graph.addVertex(vertex3);
        graph.addEdge(vertex0, vertex1);
        graph.addEdge(vertex1, vertex2);
        graph.addEdge(vertex2, vertex1);
        System.out.println("Graph contains cycle = " + graph.isCyclic());


    }

    private static class Graph {

        private List<Vertex> vertices;
        private List<Edge> edges;
        private int nVertices;
        private int nEdges;
        private Map<String, Subset> subsetMap;

        private Graph(int nVertices, int nEdges) {
            this.nEdges = nEdges;
            this.nVertices = nVertices;
            this.vertices = new ArrayList<>(nVertices);
            this.edges = new ArrayList<>(nEdges);
            this.subsetMap = new HashMap<>();
        }

        private void addVertex(Vertex vertex) {
            if (this.vertices.size() < nVertices) {
                this.vertices.add(vertex);
                subsetMap.put(vertex.getLabel(), new Subset(vertex.getLabel(), 0));
            }
        }

        private void addEdge(Vertex source, Vertex destination) {
            if (this.edges.size() < nEdges) {
                Edge edge = new Edge(source.getLabel(), destination.getLabel());
                this.edges.add(edge);
            }
        }

        private void union(Vertex x, Vertex y) {
            String xRoot = find(x);
            String yRoot = find(y);
            Subset xSubset = subsetMap.get(xRoot);
            Subset ySubset = subsetMap.get(yRoot);
            if (xSubset.getRank() > ySubset.getRank()) {
                ySubset.setParent(xSubset.getParent());
                subsetMap.put(yRoot, ySubset);
            } else if (xSubset.getRank() < ySubset.getRank()) {
                xSubset.setParent(ySubset.getParent());
                subsetMap.put(xRoot, xSubset);
            } else {
                xSubset.setParent(ySubset.getParent());
                subsetMap.put(xRoot, xSubset);
                ySubset.setRank(ySubset.getRank() + 1);
                subsetMap.put(yRoot, ySubset);
            }

        }

        private String find(Vertex vertex) {
            Subset subset = subsetMap.get(vertex.getLabel());
            if (!subset.getParent().equals(vertex.getLabel())) {
                subset.setParent(find(new Vertex(subset.getParent())));
            }
            return subset.getParent();
        }


        public boolean isCyclic() {

            for (Edge edge : edges) {
                final Vertex sVertex = new Vertex(edge.getSource());
                final Vertex dVertex = new Vertex(edge.getDestination());
                if (find(sVertex).equals(find(dVertex))) {
                    return true;
                }
                union(sVertex, dVertex);
            }
            return false;
        }
    }


    private static class Edge {
        private String source;
        private String destination;

        private Edge(String source, String destination) {
            this.source = source;
            this.destination = destination;
        }

        public String getSource() {
            return source;
        }

        public String getDestination() {
            return destination;
        }
    }

    private static class Subset {
        private String parent;
        private int rank;

        private Subset(String parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }

        private Subset() {
            this.parent = null;
            this.rank = 0;
        }

        public String getParent() {
            return parent;
        }

        public void setParent(String parent) {
            this.parent = parent;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }
    }
}
