import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class ShortestSmoothPathTest {

    ShortestSmoothPath shortestSmoothPath;


    @BeforeEach
    void setUp() {
        shortestSmoothPath=new ShortestSmoothPath();
    }

    @Test
    void severalReroute() {
        Node nodeA1 = new Node("A1");
        Node nodeB1 = new Node("B1");
        Node nodeC1 = new Node("C1");
        Node nodeD1 = new Node("D1");
        Node nodeE1 = new Node("E1");

        nodeA1.addDestination(nodeB1, new PairDistance(1, 10));
        nodeA1.addDestination(nodeD1, new PairDistance(1, 1));

        nodeB1.addDestination(nodeC1, new PairDistance(1, 10));
        nodeB1.addDestination(nodeE1, new PairDistance(1, 1));

        nodeD1.addDestination(nodeB1, new PairDistance(1, 1));

        nodeE1.addDestination(nodeC1, new PairDistance(1, 1));


        Graph graph1 = new Graph();

        graph1.addNode(nodeA1);
        graph1.addNode(nodeB1);
        graph1.addNode(nodeC1);
        graph1.addNode(nodeD1);
        graph1.addNode(nodeE1);

        assertEquals(List.of(nodeA1, nodeB1, nodeC1), shortestSmoothPath.iterativePathFixing((float) 0.01, graph1, nodeA1, nodeC1));

    }

    @Test
    void zeroReroute() {
        Node nodeA1 = new Node("A1");
        Node nodeB1 = new Node("B1");
        Node nodeC1 = new Node("C1");
        Node nodeD1 = new Node("D1");
        Node nodeE1 = new Node("E1");

        nodeA1.addDestination(nodeB1, new PairDistance(1, 10));
        nodeA1.addDestination(nodeD1, new PairDistance(1, 1));

        nodeB1.addDestination(nodeC1, new PairDistance(1, 10));
        nodeB1.addDestination(nodeE1, new PairDistance(1, 1));

        nodeD1.addDestination(nodeB1, new PairDistance(1, 1));

        nodeE1.addDestination(nodeC1, new PairDistance(1, 1));


        Graph graph1 = new Graph();

        graph1.addNode(nodeA1);
        graph1.addNode(nodeB1);
        graph1.addNode(nodeC1);
        graph1.addNode(nodeD1);
        graph1.addNode(nodeE1);

        assertEquals(List.of(nodeA1, nodeD1, nodeB1, nodeE1, nodeC1), shortestSmoothPath.iterativePathFixing((float) 2, graph1, nodeA1, nodeC1));

    }

    @Test
    void oneReroute() {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        nodeA.addDestination(nodeB, new PairDistance(10, 10));
        nodeA.addDestination(nodeC, new PairDistance(15, 15));

        nodeB.addDestination(nodeD, new PairDistance(12, 12));
        nodeB.addDestination(nodeF, new PairDistance(5, 50));

        nodeC.addDestination(nodeE, new PairDistance(10, 10));

        nodeD.addDestination(nodeE, new PairDistance(2, 10));
        nodeD.addDestination(nodeF, new PairDistance(1, 10));

        nodeF.addDestination(nodeE, new PairDistance(5, 5));

        Graph graph = new Graph();

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);

        assertEquals(List.of(nodeA, nodeB, nodeF), shortestSmoothPath.iterativePathFixing((float) 0.01, graph, nodeA, nodeF));

    }


}