import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        Dijkstra dijkstra=new Dijkstra();
        UBS ubs=new UBS();

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        nodeA.addDestination(nodeB, new PairDistance(10, 10));
        nodeA.addDestination(nodeC, new PairDistance(15, 15));

        nodeB.addDestination(nodeD, new PairDistance(12, 12));
        nodeB.addDestination(nodeF, new PairDistance(15, 15));

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

        graph = dijkstra.calculateShortestPathFromSource(graph, nodeA, false);


        LinkedList path = new LinkedList<>();

        path.add(nodeA);
        path.add(nodeB);
        path.add(nodeF);

//        System.out.println(ubs.pathWeight(path));
//
//        System.out.println(nodeF.getDistance());
//
//        System.out.println(ubs.stretch(graph, path));
//
//        System.out.println(ubs.calcul(graph, path, false));


        Graph graph2 = new Graph();

        graph2.addNode(nodeA);
        graph2.addNode(nodeB);
        graph2.addNode(nodeC);
        graph2.addNode(nodeD);
        graph2.addNode(nodeE);
        graph2.addNode(nodeF);

        graph2 = dijkstra.calculateShortestPathFromSource(graph2, nodeA, true);


        System.out.println(ubs.pathWeightTraffic(path));

        System.out.println(nodeF.getDistanceTraffic());

        System.out.println(ubs.stretchTraffic(graph2, path));


        System.out.println(ubs.calcul(graph, path, true));
    }
}
