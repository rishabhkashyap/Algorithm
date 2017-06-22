package com.graph.dfs;

import com.graph.model.Vertex;

public class DfsMain {

	public static void main(String[] args) {
		GraphDfs dfs=new GraphDfs(5);
		
		Vertex v1=new Vertex('1');
		Vertex v2=new Vertex('2');
		Vertex v3=new Vertex('3');
		Vertex v4=new Vertex('4');
		Vertex v5=new Vertex('5');
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
		

	}

}
