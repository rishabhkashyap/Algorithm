package com.algo.graph.dfs;

import com.algo.graph.model.Vertex;

import java.util.*;

public class DFSCycle {

    public static void main(String[] args) {
        Vertex v0 = new Vertex("0");
        Vertex v1 = new Vertex("1");
        Vertex v2 = new Vertex("2");
        Vertex v3 = new Vertex("3");

        Cycle cycle = new Cycle(4);
        cycle.addVertex(v0);
        cycle.addVertex(v1);
        cycle.addVertex(v2);
        cycle.addVertex(v3);
        cycle.addEdge(v0, v1);
        cycle.addEdge(v1, v0);
        cycle.addEdge(v1, v2);
        cycle.addEdge(v2, v1);
        cycle.addEdge(v2, v3);
        cycle.addEdge(v3, v2);
        cycle.addEdge(v3, v0);
        cycle.addEdge(v0, v3);
        //System.out.println("Cycle exist = " + cycle.detectCycleByIteration(v0));
        System.out.println("Cycle exist = " + cycle.isCyclicRecursive(v0));

    }

    private static class Cycle {
        private int size;
        private List<Vertex> vertices;
        private Map<String, List<Vertex>> adjacencyMap;

        private Cycle(int size) {
            this.size = size;
            this.vertices = new ArrayList<>(this.size);
            this.adjacencyMap = new HashMap<>();

        }

        private void addVertex(Vertex vertex) {
            this.vertices.add(vertex);
        }

        private void addEdge(Vertex source, Vertex destination) {
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

        private boolean detectCycleByIteration(Vertex source) {
            Stack<Vertex> stack = new Stack<>();
            Map<String, Vertex> parentMap = new HashMap<>();
            parentMap.put(source.getLabel(), source);
            source.setVisited(true);
            stack.push(source);
            while (!stack.isEmpty()) {
                Vertex vertex = stack.peek();
                List<Vertex> neighbours = this.adjacencyMap.get(vertex.getLabel());
                Vertex unvisitedVertex = null;
                if (neighbours != null && !neighbours.isEmpty()) {
                    Vertex parent = parentMap.get(vertex.getLabel());
                    for (Vertex neighbour : neighbours) {
                        if (neighbour.isVisited() && !isParentVertex(parent, neighbour)) {
                            return true;
                        } else if (!neighbour.isVisited()) {
                            unvisitedVertex = neighbour;
                            parentMap.put(unvisitedVertex.getLabel(), vertex);
                            break;
                        }
                    }


                }
                if (unvisitedVertex != null) {
                    unvisitedVertex.setVisited(true);
                    stack.push(unvisitedVertex);
                } else {
                    return false;
                }

            }
            return false;
        }

        private boolean isCyclicRecursive(Vertex source) {
            return isCyclicHelper(source, source);

        }

        private boolean isCyclicHelper(Vertex source, Vertex parent) {
            source.setVisited(true);
            List<Vertex> neighbours = this.adjacencyMap.get(source.getLabel());
            if (neighbours != null && !neighbours.isEmpty()) {
                for (Vertex neighbour : neighbours) {
                    if (neighbour.isVisited() && !isParentVertex(parent, neighbour)) {
                        return true;
                    } else if (!neighbour.isVisited()) {
                        return isCyclicHelper(neighbour, source);
                    }
                }
            }
            return false;
        }

        private boolean isParentVertex(Vertex parent, Vertex vertex) {
            return (parent != null && parent.getLabel().equals(vertex.getLabel())) ? true : false;
        }
    }
}
