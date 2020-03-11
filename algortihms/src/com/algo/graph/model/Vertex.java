package com.algo.graph.model;

import java.util.Objects;

public class Vertex {
    private String label;
    private boolean visited;
    private String colour;


    public Vertex(String label) {
        super();
        this.label = label;
        this.visited = false;
    }

    public Vertex(String label, boolean visited, String colour) {
        this.label = label;
        this.visited = visited;
        this.colour = colour;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

}
