package com.algo.graph.bfs;

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
        gSort.performTopologicalSort();


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

        public void performTopologicalSort() {
            Queue<Vertex> queue = new LinkedList<>();
            Map<String, Integer> indegreeMap = getIndegreeMap();
            addZeroIndegreeVertices(queue, indegreeMap);
            while (!queue.isEmpty()) {
                Vertex vtx = queue.remove();
                System.out.print(vtx.getLabel() + " --->  ");
                List<Vertex> neighbours = this.adjacencyMap.get(vtx.getLabel());
                if (neighbours != null && !neighbours.isEmpty()) {
                    for (Vertex neighbour : neighbours) {
                        if (indegreeMap.containsKey(neighbour.getLabel())) {
                            int count = indegreeMap.get(neighbour.getLabel());
                            indegreeMap.put(neighbour.getLabel(), --count);
                            if (count == 0) {
                                queue.add(neighbour);

                            }

                        }

                    }
                }
            }
        }

        private Map<String, Integer> getIndegreeMap() {
            Map<String, Integer> indegreeMap = new HashMap<>();
            for (Vertex source : this.vertices) {
                List<Vertex> neighbours = this.adjacencyMap.get(source.getLabel());
                if (neighbours != null && !neighbours.isEmpty()) {
                    for (Vertex neighbour : neighbours) {
                        if (indegreeMap.containsKey(neighbour.getLabel())) {
                            int count = indegreeMap.get(neighbour.getLabel());
                            indegreeMap.put(neighbour.getLabel(), ++count);
                        } else {
                            indegreeMap.put(neighbour.getLabel(), 1);
                        }
                    }
                }
            }

            return indegreeMap;
        }

        private void addZeroIndegreeVertices(Queue<Vertex> queue, Map<String, Integer> indegreeMap) {
            for (Vertex vertex : this.vertices) {
                if (indegreeMap.get(vertex.getLabel()) == null) {
                    queue.add(vertex);
                }
            }

        }

    }
}
