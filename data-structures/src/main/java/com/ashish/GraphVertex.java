package com.ashish;

import java.util.List;
import java.util.Map;

/**
 * @author Ashish Sharma
 *         Created on 8/22/2015.
 */
public class GraphVertex {

    private String vertexName;
    private Map<GraphVertex, Integer> adjacencyList;
    private int vertexValue;
    private VertexColor vertexColor;
    private GraphVertex predecessor;
    private int distanceFromSource;
    private int discoveryStartTime;
    private int discoveryFinishTime;

    public int getDistanceFromSource() {
        return distanceFromSource;
    }

    public void setDistanceFromSource(int distanceFromSource) {
        this.distanceFromSource = distanceFromSource;
    }

    public GraphVertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(GraphVertex predecessor) {
        this.predecessor = predecessor;
    }

    public VertexColor getVertexColor() {
        return vertexColor;
    }

    public void setVertexColor(VertexColor vertexColor) {
        this.vertexColor = vertexColor;
    }

    public Map<GraphVertex, Integer> getAdjacencyList() {
        return adjacencyList;
    }

    public void setAdjacencyList(Map<GraphVertex, Integer> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    public int getVertexValue() {
        return vertexValue;
    }

    public void setVertexValue(int vertexValue) {
        this.vertexValue = vertexValue;
    }

    public int getDiscoveryStartTime() {
        return discoveryStartTime;
    }

    public void setDiscoveryStartTime(int discoveryStartTime) {
        this.discoveryStartTime = discoveryStartTime;
    }

    public int getDiscoveryFinishTime() {
        return discoveryFinishTime;
    }

    public void setDiscoveryFinishTime(int discoveryFinishTime) {
        this.discoveryFinishTime = discoveryFinishTime;
    }

    public GraphVertex(int vertexValue) {
        this.vertexValue = vertexValue;
    }

    public String getVertexName() {
        return vertexName;
    }

    public void setVertexName(String vertexName) {
        this.vertexName = vertexName;
    }


    public GraphVertex(int vertexValue, String vertexName) {
        this.vertexValue = vertexValue;
        this.vertexName = vertexName;
    }

    public enum VertexColor {
        White, Gray, Black;
    }
}
