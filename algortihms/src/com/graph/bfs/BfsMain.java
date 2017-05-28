package com.graph.bfs;

import com.graph.model.Vertex;

public class BfsMain {

	public static void main(String[] args) {
		GraphBFS search=new GraphBFS(9);
		Vertex vA=new Vertex('A');
		Vertex vB=new Vertex('B');
		Vertex vC=new Vertex('C');
		Vertex vD=new Vertex('D');
		Vertex vE=new Vertex('E');
		Vertex vF=new Vertex('F');
		Vertex vG=new Vertex('G');
		Vertex vH=new Vertex('H');
		Vertex vI=new Vertex('I');
		
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
		
		//search.displayAdjacencyMatrix();
		System.out.println("\n\n\n");
		search.performBFS(vA);

	}

}
