package com.algo.graph.dfs;

import com.algo.graph.model.Vertex;

import java.util.*;

public class TopologicalSort {

    public static void main(String[] args) {
        Vertex english = new Vertex("English");
        Vertex maths = new Vertex("Maths");
        Vertex pl = new Vertex("Programming logic");
        Vertex html = new Vertex("Html");
        Vertex python = new Vertex("Python");
        Vertex java = new Vertex("Java");
        Vertex css = new Vertex("CSS");
        Vertex js = new Vertex("JS");
        Vertex webDevlopment = new Vertex("Web Development");
        GSort gSort = new GSort(9);
        gSort.addVertex(english);
        gSort.addVertex(maths);
        gSort.addVertex(pl);
        gSort.addVertex(html);
        gSort.addVertex(python);
        gSort.addVertex(java);
        gSort.addVertex(css);
        gSort.addVertex(js);
        gSort.addVertex(webDevlopment);
        gSort.addEdge(english, pl);
        gSort.addEdge(maths, pl);
        gSort.addEdge(english, html);
        gSort.addEdge(pl, html);
        gSort.addEdge(pl, python);
        gSort.addEdge(pl, java);
        gSort.addEdge(pl, js);
        gSort.addEdge(html, css);
        gSort.addEdge(css, js);
        gSort.addEdge(js, webDevlopment);
        gSort.addEdge(python, webDevlopment);
        gSort.addEdge(java, webDevlopment);
        gSort.sort();
//        Vertex zero = new Vertex("0");
//        Vertex one = new Vertex("1");
//        Vertex two = new Vertex("2");
//        Vertex three = new Vertex("3");
//        Vertex four = new Vertex("4");
//        Vertex five = new Vertex("5");
//        Vertex six = new Vertex("6");
//        Vertex seven = new Vertex("7");
//        GSort gsort = new GSort(8);
//        gsort.addVertex(zero);
//        gsort.addVertex(one);
//        gsort.addVertex(two);
//        gsort.addVertex(three);
//        gsort.addVertex(four);
//        gsort.addVertex(five);
//        gsort.addVertex(six);
//        gsort.addVertex(seven);
//        gsort.addEdge(seven,five);
//        gsort.addEdge(seven,six);
//        gsort.addEdge(five,four);
//        gsort.addEdge(six,four);
//        gsort.addEdge(five,two);
//        gsort.addEdge(six,three);
//        gsort.addEdge(two,one);
//        gsort.addEdge(three,one);
//        gsort.addEdge(one,zero);
//        gsort.sort();


    }

    private static class GSort {
        private int size;
        private List<Vertex> vertices;
        private Map<String, List<Vertex>> adjacencyMap;

        public GSort(int size) {
            this.size = size;
            this.vertices = new ArrayList<>(this.size);
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

        public void sort() {
            Stack<Vertex> stack = new Stack<>();
            for (Vertex vertex : this.vertices) {
                if (!vertex.isVisited()) {
                    //Do dfs for each node
                    sortUtil(vertex, stack);
                }
            }
            while (!stack.isEmpty()) {
                System.out.print(stack.pop().getLabel() + "  -->  ");
            }

        }

        private void sortUtil(Vertex source, Stack<Vertex> stack) {
            if (source.isVisited()) {
                return;
            }
            source.setVisited(true);
            List<Vertex> vertices = adjacencyMap.get(source.getLabel());
            if (vertices != null && !vertices.isEmpty()) {
                for (Vertex vertex : vertices) {
                    sortUtil(vertex, stack);
                }

            }
            stack.push(source);
        }


    }
}
