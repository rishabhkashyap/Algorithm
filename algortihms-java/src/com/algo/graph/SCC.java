package com.algo.graph;


import com.algo.graph.model.Graph;
import com.algo.graph.model.Vertex;

import java.util.List;
import java.util.Stack;

public class SCC {
    public static void main(String[] args) {

        com.algo.graph.model.Graph graph = new com.algo.graph.model.Graph(5);
        Vertex v0 = new Vertex("0");
        Vertex v1 = new Vertex("1");
        Vertex v2 = new Vertex("2");
        Vertex v3 = new Vertex("3");
        Vertex v4 = new Vertex("4");
        Vertex v5 = new Vertex("5");
        Vertex v6 = new Vertex("6");
        Vertex v7 = new Vertex("7");


        graph.addVertex(v0);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);
        graph.addVertex(v6);
        graph.addVertex(v7);
        graph.addEdge(v0, v1);
        graph.addEdge(v1, v2);
        graph.addEdge(v2, v3);
        graph.addEdge(v3, v0);
        graph.addEdge(v2, v4);
        graph.addEdge(v4, v5);
        graph.addEdge(v5, v6);
        graph.addEdge(v6, v4);
        graph.addEdge(v6, v7);
        findConnectedComponents(v0, graph);


    }

    private static void findConnectedComponents(Vertex source, Graph graph) {
        Stack<Vertex> finishTime = new Stack<>();
        dfs(source, graph, finishTime);
        Graph transposedGraph = graph.getTranspose();
        while (!finishTime.isEmpty()) {
            dfs(finishTime.pop(), transposedGraph);
            System.out.println();
        }
    }

    private static void dfs(Vertex source, Graph graph, Stack<Vertex> finishTime) {
        if (source.isVisited()) {
            return;
        }
        source.setVisited(true);
        List<Vertex> neighbours = graph.getNeighbours(source);
        if (neighbours != null && !neighbours.isEmpty()) {
            for (Vertex neighbour : neighbours) {
                dfs(neighbour, graph, finishTime);
            }
        }
        finishTime.push(source);

    }

    private static void dfs(Vertex source, Graph graph) {
        if (source.isVisited()) {
            return;
        }
        source.setVisited(true);
        System.out.print(source.getLabel() + "\t");
        List<Vertex> neighbours = graph.getNeighbours(source);
        if (neighbours != null && !neighbours.isEmpty()) {
            for (Vertex neighbour : neighbours) {
                dfs(neighbour, graph);
            }
        }

    }


}
