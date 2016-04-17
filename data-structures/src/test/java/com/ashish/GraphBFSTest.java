package com.ashish;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ashish Sharma
 *         Created on 8/22/2015.
 */
public class GraphBFSTest {

    @Test
    public void graphRepresentationTest() {
        Graph graph = getGraph();
    }

    private Graph getGraph() {
        GraphVertex graphVertexA = new GraphVertex(1);
        GraphVertex graphVertexB = new GraphVertex(2);
        GraphVertex graphVertexSource = new GraphVertex(0);
        GraphVertex graphVertexC = new GraphVertex(1);
        GraphVertex graphVertexD = new GraphVertex(2);
        GraphVertex graphVertexE = new GraphVertex(2);
        GraphVertex graphVertexF = new GraphVertex(3);
        GraphVertex graphVertexG = new GraphVertex(3);

        Map<GraphVertex, Integer> adjacencyListSource = new HashMap();
        adjacencyListSource.put(graphVertexA, 0);
        adjacencyListSource.put(graphVertexC, 0);
        graphVertexSource.setAdjacencyList(adjacencyListSource);

        Map<GraphVertex, Integer> adjacencyListA = new HashMap();
        adjacencyListA.put(graphVertexB, 0);
        adjacencyListA.put(graphVertexSource, 0);
        graphVertexA.setAdjacencyList(adjacencyListA);

        Map<GraphVertex, Integer> adjacencyListB = new HashMap();
        adjacencyListB.put(graphVertexA, 0);
        graphVertexB.setAdjacencyList(adjacencyListB);

        Map<GraphVertex, Integer> adjacencyListC = new HashMap();
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
    public void breadthFirstSearchTest() {
        Graph graph = getGraph();
        breadthFirstSearch(graph);
    }

    private void breadthFirstSearch(Graph graph) {
        for (GraphVertex graphVertex : graph.getGraphNodes()) {
            graphVertex.setVertexColor(GraphVertex.VertexColor.White);
            graphVertex.setDistanceFromSource(Integer.MAX_VALUE);
            graphVertex.setPredecessor(null);
        }

        GraphVertex graphVertexSource = graph.getSourceGraphVertex();
        graphVertexSource.setPredecessor(null);
        graphVertexSource.setVertexColor(GraphVertex.VertexColor.Gray);
        graphVertexSource.setDistanceFromSource(0);

        Queue<GraphVertex> queue = new Queue<GraphVertex>();
        queue.enqueue(graphVertexSource);

        // For printing BFS nodes horizontally on same level
        Queue<GraphVertex> printQueue = new Queue<GraphVertex>();
        printQueue.enqueue(graphVertexSource);

        while (queue.getQueueCount() != 0) {
            GraphVertex graphVertex = queue.dequeue();
            for (GraphVertex graphVertexAdjacent : graphVertex.getAdjacencyList().keySet()) {
                if (graphVertexAdjacent.getVertexColor() == GraphVertex.VertexColor.White) {
                    graphVertexAdjacent.setVertexColor(GraphVertex.VertexColor.Gray);
                    graphVertexAdjacent.setDistanceFromSource(graphVertex.getDistanceFromSource() + 1);
                    graphVertexAdjacent.setPredecessor(graphVertex);
                    queue.enqueue(graphVertexAdjacent);
                    // For printing BFS nodes horizontally on same level
                    printQueue.enqueue(graphVertexAdjacent);
                }
            }
            graphVertex.setVertexColor(GraphVertex.VertexColor.Black);

        }

        // For printing BFS nodes horizontally on same level
        do {
            GraphVertex graphVertex = printQueue.dequeue();
            if (graphVertex.getDistanceFromSource() == graphVertexSource.getDistanceFromSource() + 1) {
                System.out.println();
                graphVertexSource = graphVertex;
            }
            System.out.print(graphVertex.getVertexValue());
        } while (printQueue.getQueueCount() > 0);
    }
}
