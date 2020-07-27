package com.algo.graph;

import com.algo.graph.model.Vertex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Kruskal {
    public static void main(String[] args) {
        Vertex vertex0 = new Vertex("0");
        Vertex vertex1 = new Vertex("1");
        Vertex vertex3 = new Vertex("3");
        Vertex vertex2 = new Vertex("2");
        Graph graph = new Graph(4, 5);
        graph.addVertex(vertex0);
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        graph.addVertex(vertex3);
        graph.addEdge(vertex0, vertex1, 10);
        graph.addEdge(vertex1, vertex3, 15);
        graph.addEdge(vertex2, vertex3, 4);
        graph.addEdge(vertex0, vertex2, 6);
        graph.addEdge(vertex0, vertex3, 5);
        List<Edge> result = graph.getMinSpanningTree();
        result.forEach(edge ->
                System.out.print("\n" + edge.source + "------>" + edge.getDestination() + "\t" + edge.getWeight()));

    }

    static class Graph {
        private List<Vertex> vertices;
        private List<Edge> edges;
        private Map<String, Subset> subsetMap;
        private Integer nVertices;
        private Integer nEdges;

        public Graph(Integer nVertices, Integer nEdges) {
            this.vertices = new ArrayList<>(nVertices);
            this.edges = new ArrayList<>(nEdges);
            this.subsetMap = new HashMap<>();
            this.nVertices = nVertices;
            this.nEdges = nEdges;
        }

        public void addVertex(Vertex vertex) {
            if (this.vertices.size() < nVertices) {
                this.vertices.add(vertex);
                this.subsetMap.put(vertex.getLabel(), new Subset(vertex.getLabel(), 0));
            } else {
                throw new RuntimeException("Number of vertices has exceeded defined size of vertices");
            }
        }

        public void addEdge(Vertex source, Vertex destination, Integer weight) {
            if (this.edges.size() < nEdges) {
                edges.add(new Edge(source.getLabel(), destination.getLabel(), weight));
            } else {
                throw new RuntimeException("Number of edges has exceeded defined size of edges");
            }
        }

        public List<Edge> getMinSpanningTree() {
            List<Edge> spanningTree = new ArrayList<>();
            sortEdges();
            int i = 0;
            int edgesCovered = 0;
            while (edgesCovered < nVertices && i < edges.size()) {
                Edge edge = edges.get(i++);
                if (!isCyclePresent(edge)) {
                    union(new Vertex(edge.getSource()), new Vertex(edge.getDestination()));
                    spanningTree.add(edge);
                    ++edgesCovered;
                }
            }
            return spanningTree;
        }

        private void sortEdges() {
            this.edges.sort((e1, e2) -> e1.getWeight() - e2.getWeight());
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


        private boolean isCyclePresent(Edge edge) {


            final Vertex sVertex = new Vertex(edge.getSource());
            final Vertex dVertex = new Vertex(edge.getDestination());
            if (find(sVertex).equals(find(dVertex))) {
                return true;
            }


            return false;
        }


    }

    private static final class Edge {
        private String source;
        private String destination;
        private Integer weight;

        public Edge(String source, String destination, Integer weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        public String getSource() {
            return source;
        }

        public String getDestination() {
            return destination;
        }

        public Integer getWeight() {
            return weight;
        }
    }

    private static class Subset {
        private String parent;
        private Integer rank;

        Subset(String parent, Integer rank) {
            this.parent = parent;
            this.rank = rank;
        }

        public String getParent() {
            return parent;
        }

        public void setParent(String parent) {
            this.parent = parent;
        }

        public Integer getRank() {
            return rank;
        }

        public void setRank(Integer rank) {
            this.rank = rank;
        }
    }
}
