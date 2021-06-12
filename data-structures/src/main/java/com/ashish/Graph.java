package com.ashish;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ashish Sharma
 * Created on 8/22/2015.
 */
public class Graph {

    private GraphVertex sourceGraphVertex;

    private List<GraphVertex> graphNodes;

    public GraphVertex getSourceGraphVertex() {
        return sourceGraphVertex;
    }

    public void setSourceGraphVertex(GraphVertex sourceGraphVertex) {
        this.sourceGraphVertex = sourceGraphVertex;
    }

    public List<GraphVertex> getGraphNodes() {
        return graphNodes;
    }

    public Graph(GraphVertex sourceGraphVertex) {
        graphNodes = new ArrayList<GraphVertex>();
        this.sourceGraphVertex = sourceGraphVertex;
    }
}
