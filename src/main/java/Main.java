import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        Dijkstra dijkstra=new Dijkstra();
        UBS ubs=new UBS();
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

//        graph = dijkstra.calculateShortestPathFromSource(graph, nodeA, false);

//
//        LinkedList path = new LinkedList<>();
//
//        path.add(nodeA);
//        path.add(nodeB);
//        path.add(nodeF);

//        System.out.println(ubs.pathWeight(path));
//
//        System.out.println(nodeF.getDistance());
//
//        System.out.println(ubs.stretch(graph, path));
//
//        System.out.println(ubs.calcul(graph, path, false));

//
//        Graph graph2 = new Graph();
//
//        graph2.addNode(nodeA);
//        graph2.addNode(nodeB);
//        graph2.addNode(nodeC);
//        graph2.addNode(nodeD);
//        graph2.addNode(nodeE);
//        graph2.addNode(nodeF);

//        graph2 = dijkstra.calculateShortestPathFromSource(graph2, nodeA, true);


//        System.out.println(ubs.pathWeightTraffic(path));
//
//        System.out.println(nodeF.getDistanceTraffic());
//
//        System.out.println(ubs.stretchTraffic(graph2, path));
//
//
//        System.out.println(ubs.calcul(graph, path, true));

//        shortestSmoothPath.iterativePathFixing((float) 0.1, graph, nodeA, nodeF);



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
//        nodeD1.addDestination(nodeE1, new PairDistance(1, 1));

        nodeE1.addDestination(nodeC1, new PairDistance(1, 1));


        Graph graph1 = new Graph();

        graph1.addNode(nodeA1);
        graph1.addNode(nodeB1);
        graph1.addNode(nodeC1);
        graph1.addNode(nodeD1);
        graph1.addNode(nodeE1);

        System.out.println(shortestSmoothPath.iterativePathFixing((float) 2, graph1, nodeA1, nodeC1));


    }
}
