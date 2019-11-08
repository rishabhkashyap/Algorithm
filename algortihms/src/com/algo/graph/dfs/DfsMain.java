package com.algo.graph.dfs;

import com.algo.graph.model.Vertex;

public class DfsMain {

    public static void main(String[] args) {
        GraphDfs dfs = new GraphDfs(5);

        Vertex v0 = new Vertex("0");
        Vertex v1 = new Vertex("1");
        Vertex v2 = new Vertex("2");
        Vertex v3 = new Vertex("3");
        Vertex v4 = new Vertex("4");
        Vertex v5 = new Vertex("5");
        dfs.addVertex(v1);
        dfs.addVertex(v2);
        dfs.addVertex(v3);
        dfs.addVertex(v4);
        dfs.addVertex(v5);

        dfs.addEdge(v1, v2);
        dfs.addEdge(v1, v3);
        dfs.addEdge(v2, v4);
        dfs.addEdge(v2, v5);

        dfs.performDfs(v1);
        System.out.println();


        DfsAdjacencyList dfsAdjacencyList = new DfsAdjacencyList(6);
        v0.setVisited(false);
        v1.setVisited(false);
        v2.setVisited(false);
        v3.setVisited(false);
        v4.setVisited(false);
        v5.setVisited(false);
        dfsAdjacencyList.addVertex(v0);
        dfsAdjacencyList.addVertex(v1);
        dfsAdjacencyList.addVertex(v2);
        dfsAdjacencyList.addVertex(v3);
        dfsAdjacencyList.addVertex(v4);
        dfsAdjacencyList.addVertex(v5);

        dfsAdjacencyList.addEdge(v0, v1);
        dfsAdjacencyList.addEdge(v0, v4);
        dfsAdjacencyList.addEdge(v1, v0);
        dfsAdjacencyList.addEdge(v1, v2);
        dfsAdjacencyList.addEdge(v2, v1);
        dfsAdjacencyList.addEdge(v2, v4);
        dfsAdjacencyList.addEdge(v4, v2);
        dfsAdjacencyList.addEdge(v2, v3);
        dfsAdjacencyList.addEdge(v3, v2);
        dfsAdjacencyList.addEdge(v3, v4);
        dfsAdjacencyList.addEdge(v4, v3);
        dfsAdjacencyList.addEdge(v3, v5);
        dfsAdjacencyList.addEdge(v4, v0);
        dfsAdjacencyList.addEdge(v5, v3);

        dfsAdjacencyList.performDFS(v0);


    }

}
