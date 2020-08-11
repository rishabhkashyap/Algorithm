package com.algo.graph;

import com.algo.graph.model.Vertex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class FloydWarshall {
    public static void main(String[] args) {
        Vertex vertex0 = new Vertex("1");
        Vertex vertex1 = new Vertex("2");
        Vertex vertex2 = new Vertex("3");
        Vertex vertex3 = new Vertex("4");
        Graph graph = new Graph(4);
        graph.addVertex(vertex0);
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        graph.addVertex(vertex3);
        graph.addEdge(vertex0, vertex1, 5);
        graph.addEdge(vertex1, vertex2, 3);
        graph.addEdge(vertex2, vertex3, 1);
        graph.addEdge(vertex0, vertex3, 10);
        graph.computeShortestDistance();
        graph.printDistance();

    }

    private static class Graph {
        private List<Vertex> vertices;
        private int[][] adjMatrix;
        private int[][] distMatrix;


        public Graph(int size) {
            this.vertices = new ArrayList<>();
            this.adjMatrix = new int[size][size];
            this.distMatrix = new int[size][size];
            initializeArray(adjMatrix);
            initializeArray(distMatrix);

        }

        private void initializeArray(int[][] matrix) {
            for (int[] arr : matrix) {
                Arrays.fill(arr, 999);
            }
        }

        public void addVertex(Vertex vertex) {
            this.vertices.add(vertex);
        }

        public void addEdge(Vertex source, Vertex destination, int distance) throws NoSuchElementException {
            int i = this.vertices.indexOf(source);
            if (i == -1) {
                throw new NoSuchElementException(source.getLabel() + " not found");
            }
            int j = this.vertices.indexOf(destination);
            if (j == -1) {
                throw new NoSuchElementException(destination.getLabel() + " not found");
            }
            addDistance(adjMatrix, i, j, distance);
            addDistance(distMatrix, i, j, distance);

        }

        private void addDistance(int[][] matrix, int i, int j, int distance) {
            matrix[i][i] = 0;
            matrix[j][j] = 0;
            matrix[i][j] = distance;
        }

        public void computeShortestDistance() {
            for (int k = 0; k < vertices.size(); k++) {
                for (int i = 0; i < vertices.size(); i++) {
                    for (int j = 0; j < vertices.size(); j++) {
                        if (distMatrix[i][j] > distMatrix[i][k] + distMatrix[k][j]) {
                            distMatrix[i][j] = distMatrix[i][k] + distMatrix[k][j];
                        }
                    }
                }
            }
        }

        public void printDistance() {
            for (int i = 0; i < distMatrix.length; i++) {
                for (int j = 0; j < distMatrix.length; j++) {
                    System.out.print(distMatrix[i][j] + "\t\t");
                }
                System.out.println();
            }
        }
    }
}
