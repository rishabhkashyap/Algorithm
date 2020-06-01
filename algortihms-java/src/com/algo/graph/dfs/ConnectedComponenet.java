package com.algo.graph.dfs;

import com.algo.graph.model.Vertex;

import java.util.*;

public class ConnectedComponenet {

    public static void main(String[] args) {
        Vertex amritsar = new Vertex("Amritsar");
        Vertex jaipur = new Vertex("Jaipur");
        Vertex mumbai = new Vertex("Mumbai");
        Vertex bangalore = new Vertex("Bangalore");
        Vertex bhopal = new Vertex("Bhopal");
        Vertex delhi = new Vertex("Delhi");
        Vertex agra = new Vertex("Agra");
        Vertex andaman = new Vertex("Andman");
        Vertex nicobar = new Vertex("Nicobar");

        DFSConnectedComponent dfsConnectedComponent = new DFSConnectedComponent(9);
        dfsConnectedComponent.addVertex(amritsar);
        dfsConnectedComponent.addVertex(jaipur);
        dfsConnectedComponent.addVertex(mumbai);
        dfsConnectedComponent.addVertex(bangalore);
        dfsConnectedComponent.addVertex(bhopal);
        dfsConnectedComponent.addVertex(delhi);
        dfsConnectedComponent.addVertex(agra);
        dfsConnectedComponent.addVertex(andaman);
        dfsConnectedComponent.addVertex(nicobar);
        dfsConnectedComponent.addEdge(amritsar, jaipur);
        dfsConnectedComponent.addEdge(jaipur, mumbai);
        dfsConnectedComponent.addEdge(mumbai, bangalore);
        dfsConnectedComponent.addEdge(amritsar, delhi);
        dfsConnectedComponent.addEdge(delhi, bhopal);
        dfsConnectedComponent.addEdge(bhopal, mumbai);
        dfsConnectedComponent.addEdge(jaipur, delhi);
        dfsConnectedComponent.addEdge(delhi, agra);
        dfsConnectedComponent.addEdge(andaman, nicobar);
        System.out.println("Connected component in graph = " + dfsConnectedComponent.countConnectedComponent());

    }

    private static class DFSConnectedComponent {
        private List<Vertex> vertices;
        private Map<String, List<Vertex>> adjacencyMap;
        private int size;

        private DFSConnectedComponent(int size) {
            this.vertices = new ArrayList<>(size);
            this.adjacencyMap = new HashMap<>();
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

        public int countConnectedComponent() {
            int count = 1;
            performDFS(this.vertices.get(0));
            for (Vertex vertex : this.vertices) {
                if (!vertex.isVisited()) {
                    performDFS(vertex);
                    ++count;
                }
            }
            return count;
        }

        private void performDFS(Vertex source) {
            Stack<Vertex> stack = new Stack<>();
            source.setVisited(true);
            System.out.print(source.getLabel() + "\t");
            stack.push(source);
            while (!stack.isEmpty()) {
                Vertex vertex = stack.peek();
                Vertex neighbour = getUnvisitedNeighbour(vertex);
                if (neighbour != null) {
                    neighbour.setVisited(true);
                    System.out.print(neighbour.getLabel() + "\t");
                    stack.push(neighbour);
                } else {
                    stack.pop();
                }
            }
            System.out.println();

        }

        private Vertex getUnvisitedNeighbour(Vertex vertex) {
            Vertex unvisitedNeighbour = null;
            List<Vertex> neighbours = this.adjacencyMap.get(vertex.getLabel());
            if (neighbours != null && !neighbours.isEmpty()) {
                for (Vertex neighbour : neighbours) {
                    if (!neighbour.isVisited()) {
                        unvisitedNeighbour = neighbour;
                        break;
                    }
                }
            }
            return unvisitedNeighbour;
        }
    }
}
