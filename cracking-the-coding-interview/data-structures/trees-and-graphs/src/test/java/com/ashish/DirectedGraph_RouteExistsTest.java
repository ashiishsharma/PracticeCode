package com.ashish;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 4.2
 * <p>
 * Given a directed graph, design an algorithm to find out whether there is a route
 * between two nodes.
 *
 * @author Ashish Sharma on 3/23/2017.
 *         <p>
 * @since 3/23/2017.
 */
public class DirectedGraph_RouteExistsTest {

    @Test
    public void testRouteExists() {
        Graph graph = getGraph();
        GraphVertex sourceGraphVertex = graph.getSourceGraphVertex();
        GraphVertex destinationGraphVertex = graph.getGraphNodes().get(7);
        System.out.println("Source node : " + sourceGraphVertex.getVertexName());
        System.out.println("Destination node : " + destinationGraphVertex.getVertexName());
        System.out.println("Path exists : " + breadthFirstSearch(graph, destinationGraphVertex));

    }

    private boolean breadthFirstSearch(Graph graph, GraphVertex destinationGraphVertex) {
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


        while (queue.getQueueCount() != 0) {
            GraphVertex graphVertex = queue.dequeue();
            for (GraphVertex graphVertexAdjacent : graphVertex.getAdjacencyList().keySet()) {
                if (graphVertexAdjacent.getVertexColor() == GraphVertex.VertexColor.White) {
                    graphVertexAdjacent.setVertexColor(GraphVertex.VertexColor.Gray);
                    graphVertexAdjacent.setDistanceFromSource(graphVertex.getDistanceFromSource() + 1);
                    graphVertexAdjacent.setPredecessor(graphVertex);
                    queue.enqueue(graphVertexAdjacent);

                    if (graphVertexAdjacent.getVertexName().equals(destinationGraphVertex.getVertexName())) {
                        return true;
                    }
                }
            }
            graphVertex.setVertexColor(GraphVertex.VertexColor.Black);
        }
        return false;
    }

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
//        adjacencyListF.put(graphVertexF, 0);
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
}
