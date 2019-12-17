package com.algo.graph;

import com.algo.graph.model.Vertex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnionFind {

    public static void main(String[] args) {
        Vertex v1 = new Vertex("1");
        Vertex v2 = new Vertex("2");
        Vertex v3 = new Vertex("3");
        Vertex v4 = new Vertex("4");
        Vertex v5 = new Vertex("5");
        Disjoint disjoint = new Disjoint(5);
        disjoint.addVertex(v1);
        disjoint.addVertex(v2);
        disjoint.addVertex(v3);
        disjoint.addVertex(v4);
        disjoint.addVertex(v5);
        disjoint.makeSet();
        disjoint.printSet();
        //Peroform union on vertex 1 and vertex 2
        disjoint.union(v4, v3);
        disjoint.printSet();
        //System.out.println("Find v2 =  " + disjoint.find(v1.getLabel()));
        disjoint.union(v2, v1);
        disjoint.printSet();
        disjoint.union(v1, v3);
        disjoint.printSet();


    }


    private static class Disjoint {
        private Map<String, String> parentMap;
        private List<Vertex> vertices;

        private Disjoint(int size) {
            this.vertices = new ArrayList<>(5);
            this.parentMap = new HashMap<>();
        }

        private void makeSet() {
            vertices.forEach(e -> parentMap.put(e.getLabel(), e.getLabel()));
        }

        private void union(Vertex v1, Vertex v2) {
            String v1Set = find(v1.getLabel());
            String v2Set = find(v2.getLabel());
            parentMap.put(v1Set, v2Set);
        }

        private String find(String label) {
            String set = null;
            for (int i = 0; i < parentMap.size(); i++) {
                if (parentMap.get(label).equals(label)) {
                    set = label;
                    break;
                } else {
                    label = parentMap.get(label);
                }
            }
            return set;
        }

        public void addVertex(Vertex vertex) {
            this.vertices.add(vertex);
        }

        private void printSet() {
            System.out.println();
            this.vertices.forEach(e -> System.out.print(this.find(e.getLabel()) + "\t"));
            System.out.println();
        }
    }
}
