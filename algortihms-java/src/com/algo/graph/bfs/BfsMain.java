package com.algo.graph.bfs;

import com.algo.graph.model.Vertex;

public class BfsMain {

    public static void main(String[] args) {
        GraphBFS search = new GraphBFS(9);
        Vertex vA = new Vertex("A");
        Vertex vB = new Vertex("B");
        Vertex vC = new Vertex("C");
        Vertex vD = new Vertex("D");
        Vertex vE = new Vertex("E");
        Vertex vF = new Vertex("F");
        Vertex vG = new Vertex("G");
        Vertex vH = new Vertex("H");
        Vertex vI = new Vertex("I");

        search.addVertex(vA);
        search.addVertex(vB);
        search.addVertex(vC);
        search.addVertex(vD);
        search.addVertex(vE);
        search.addVertex(vF);
        search.addVertex(vG);
        search.addVertex(vH);
        search.addVertex(vI);

        search.addEdge(vA, vB);
        search.addEdge(vA, vC);
        search.addEdge(vA, vD);
        search.addEdge(vA, vE);
        search.addEdge(vB, vF);
        search.addEdge(vF, vH);
        search.addEdge(vD, vG);
        search.addEdge(vG, vI);

        search.displayAdjacencyMatrix();
        System.out.println("\n\n");
        search.performBFS(vA);
        System.out.println("\n");


        Vertex v0 = new Vertex("0");
        Vertex v1 = new Vertex("1");
        Vertex v2 = new Vertex("2");
        Vertex v3 = new Vertex("3");
        Vertex v4 = new Vertex("4");
        Vertex v5 = new Vertex("5");
        BfsAdjacenecyList bfsAdjacenecyList = new BfsAdjacenecyList(6);
        bfsAdjacenecyList.addVertex(v0);
        bfsAdjacenecyList.addVertex(v1);
        bfsAdjacenecyList.addVertex(v2);
        bfsAdjacenecyList.addVertex(v3);
        bfsAdjacenecyList.addVertex(v4);
        bfsAdjacenecyList.addVertex(v5);

        bfsAdjacenecyList.addEdge(v0, v1);
        bfsAdjacenecyList.addEdge(v0, v4);
        bfsAdjacenecyList.addEdge(v1, v0);
        bfsAdjacenecyList.addEdge(v1, v2);
        bfsAdjacenecyList.addEdge(v2, v1);
        bfsAdjacenecyList.addEdge(v2, v4);
        bfsAdjacenecyList.addEdge(v4, v2);
        bfsAdjacenecyList.addEdge(v2, v3);
        bfsAdjacenecyList.addEdge(v3, v2);
        bfsAdjacenecyList.addEdge(v3, v4);
        bfsAdjacenecyList.addEdge(v4, v3);
        bfsAdjacenecyList.addEdge(v3, v5);
        bfsAdjacenecyList.addEdge(v4, v0);
        bfsAdjacenecyList.addEdge(v5, v3);

        bfsAdjacenecyList.bfsSearch(v0);


    }

}
