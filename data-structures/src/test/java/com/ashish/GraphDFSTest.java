package com.ashish;

import org.testng.annotations.Test;

import java.util.*;
import java.util.LinkedList;

/**
 * @author Ashish Sharma
 *         Created on 8/23/2015.
 */
public class GraphDFSTest {

    @Test
    public void graphRepresentationTest() {
        Graph graph = getGraph();
    }

    private Graph getGraph() {
        GraphVertex graphVertexA = new GraphVertex(1, "A");
        GraphVertex graphVertexB = new GraphVertex(2, "B");
        GraphVertex graphVertexSource = new GraphVertex(0, "Source");
        GraphVertex graphVertexC = new GraphVertex(1, "C");
        GraphVertex graphVertexD = new GraphVertex(2, "D");
        GraphVertex graphVertexE = new GraphVertex(2, "E");
        GraphVertex graphVertexF = new GraphVertex(3, "F");
        GraphVertex graphVertexG = new GraphVertex(3, "G");

        Map<GraphVertex, Integer> adjacencyListSource = new HashMap<GraphVertex, Integer>();
        adjacencyListSource.put(graphVertexA, 0);
        adjacencyListSource.put(graphVertexC, 0);
        graphVertexSource.setAdjacencyList(adjacencyListSource);

        Map<GraphVertex, Integer> adjacencyListA = new HashMap<GraphVertex, Integer>();
        adjacencyListA.put(graphVertexB, 0);
        adjacencyListA.put(graphVertexSource, 0);
        graphVertexA.setAdjacencyList(adjacencyListA);

        Map<GraphVertex, Integer> adjacencyListB = new HashMap<GraphVertex, Integer>();
        adjacencyListB.put(graphVertexA, 0);
        graphVertexB.setAdjacencyList(adjacencyListB);

        Map<GraphVertex, Integer> adjacencyListC = new HashMap<GraphVertex, Integer>();
        adjacencyListC.put(graphVertexSource, 0);
        adjacencyListC.put(graphVertexD, 0);
        adjacencyListC.put(graphVertexE, 0);
        graphVertexC.setAdjacencyList(adjacencyListC);

        Map<GraphVertex, Integer> adjacencyListD = new HashMap<GraphVertex, Integer>();
        adjacencyListD.put(graphVertexC, 0);
        adjacencyListD.put(graphVertexE, 0);
        adjacencyListD.put(graphVertexF, 0);
        graphVertexD.setAdjacencyList(adjacencyListD);

        Map<GraphVertex, Integer> adjacencyListE = new HashMap<GraphVertex, Integer>();
        adjacencyListE.put(graphVertexC, 0);
        adjacencyListE.put(graphVertexD, 0);
        adjacencyListE.put(graphVertexG, 0);
        adjacencyListE.put(graphVertexF, 0);
        graphVertexE.setAdjacencyList(adjacencyListE);

        Map<GraphVertex, Integer> adjacencyListF = new HashMap<GraphVertex, Integer>();
        adjacencyListF.put(graphVertexD, 0);
        adjacencyListF.put(graphVertexE, 0);
        adjacencyListF.put(graphVertexG, 0);
        adjacencyListF.put(graphVertexF, 0);
        graphVertexF.setAdjacencyList(adjacencyListF);

        Map<GraphVertex, Integer> adjacencyListG = new HashMap<GraphVertex, Integer>();
        adjacencyListG.put(graphVertexE, 0);
        adjacencyListG.put(graphVertexF, 0);
        graphVertexG.setAdjacencyList(adjacencyListG);


        Graph graph = new Graph(graphVertexSource);
        List graphNodes = graph.getGraphNodes();
        graphNodes.add(graphVertexSource);
        graphNodes.add(graphVertexA);
        graphNodes.add(graphVertexB);
        graphNodes.add(graphVertexC);
        graphNodes.add(graphVertexD);
        graphNodes.add(graphVertexE);
        graphNodes.add(graphVertexF);
        graphNodes.add(graphVertexG);

        return graph;
    }

    @Test
    public void depthFirstSearchTest() {
        Graph graph = getGraph();
        depthFirstSearch(graph);
    }

    private void depthFirstSearch(Graph graph) {
        for (GraphVertex graphVertex : graph.getGraphNodes()) {
            graphVertex.setVertexColor(GraphVertex.VertexColor.White);
            graphVertex.setPredecessor(null);
        }
        int time = 0;
        for (GraphVertex graphVertex : graph.getGraphNodes()) {
            if (graphVertex.getVertexColor() == GraphVertex.VertexColor.White) {

                depthFirstSearchVisit(graph, graphVertex, time);
            }
        }
    }

    private void depthFirstSearchVisit(Graph graph, GraphVertex graphVertex, int time) {
        time = time + 1;
        graphVertex.setDiscoveryStartTime(time);
        graphVertex.setVertexColor(GraphVertex.VertexColor.Gray);
        for (GraphVertex graphVertexAdjacent : graphVertex.getAdjacencyList().keySet()) {
            if (graphVertexAdjacent.getVertexColor() == GraphVertex.VertexColor.White) {
                graphVertexAdjacent.setPredecessor(graphVertex);
                depthFirstSearchVisit(graph, graphVertexAdjacent, time);
            }
        }
        graphVertex.setVertexColor(GraphVertex.VertexColor.Black);
        time = time + 1;
        graphVertex.setDiscoveryFinishTime(time);
    }

    @Test
    public void topologicalSortTest() {
        Graph graph = getGraph();
        LinkedList<GraphVertex> topologicalSortList = new LinkedList();
        depthFirstSearchTopologicalSort(graph, topologicalSortList);
        for (GraphVertex graphVertex : topologicalSortList) {
            System.out.println(graphVertex.getVertexName());
        }
    }

    private void depthFirstSearchTopologicalSort(Graph graph, LinkedList<GraphVertex> topologicalSortList) {
        for (GraphVertex graphVertex : graph.getGraphNodes()) {
            graphVertex.setVertexColor(GraphVertex.VertexColor.White);
            graphVertex.setPredecessor(null);
        }
        int time = 0;
        for (GraphVertex graphVertex : graph.getGraphNodes()) {
            if (graphVertex.getVertexColor() == GraphVertex.VertexColor.White) {
                depthFirstSearchVisitTopologicalSort(graph, graphVertex, time, topologicalSortList);
            }
        }
    }

    private void depthFirstSearchVisitTopologicalSort(Graph graph, GraphVertex graphVertex, int time, LinkedList<GraphVertex> topologicalSortList) {
        time = time + 1;
        graphVertex.setDiscoveryStartTime(time);
        graphVertex.setVertexColor(GraphVertex.VertexColor.Gray);
        for (GraphVertex graphVertexAdjacent : graphVertex.getAdjacencyList().keySet()) {
            if (graphVertexAdjacent.getVertexColor() == GraphVertex.VertexColor.White) {
                graphVertexAdjacent.setPredecessor(graphVertex);
                depthFirstSearchVisitTopologicalSort(graph, graphVertexAdjacent, time, topologicalSortList);
            }
        }
        graphVertex.setVertexColor(GraphVertex.VertexColor.Black);
        time = time + 1;
        graphVertex.setDiscoveryFinishTime(time);
        topologicalSortList.addFirst(graphVertex);
    }
}
