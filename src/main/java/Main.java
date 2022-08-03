import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        ShortestSmoothPath shortestSmoothPath=new ShortestSmoothPath();

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



    }
}
