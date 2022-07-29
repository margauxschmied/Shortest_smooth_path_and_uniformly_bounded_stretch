import java.util.*;

public class Dijkstra {

    public Graph calculateShortestPathFromSource(Graph graph, Node source, boolean traffic) {
        source.setDistance(0);
        source.setDistanceTraffic(0);


        Set settledNodes = new HashSet<>();
        Set unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);

        while (unsettledNodes.size() != 0) {
            Node currentNode = getLowestDistanceNode(unsettledNodes, traffic);
            unsettledNodes.remove(currentNode);
            for (Map.Entry< Node, PairDistance> adjacencyPair:
                    currentNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight;
                if(traffic) {
                    edgeWeight = adjacencyPair.getValue().getDistanceWithTrafic();

                    if (!settledNodes.contains(adjacentNode)) {
                        calculateMinimumDistanceTraffic(adjacentNode, edgeWeight, currentNode);

                        unsettledNodes.add(adjacentNode);
                    }
                }
                else {
                    edgeWeight = adjacencyPair.getValue().getDistanceWithoutTrafic();

                    if (!settledNodes.contains(adjacentNode)) {
                        calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);

                        unsettledNodes.add(adjacentNode);
                    }
                }
            }
            settledNodes.add(currentNode);
        }
        return graph;
    }

    private Node getLowestDistanceNode(Set < Node > unsettledNodes, boolean traffic) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node: unsettledNodes) {
            int nodeDistance;
            if(traffic) {
                nodeDistance = node.getDistanceTraffic();
            }
            else {
                nodeDistance = node.getDistance();
            }
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }


    private void calculateMinimumDistance(Node evaluationNode,
                                                 Integer edgeWeigh, Node sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

    private void calculateMinimumDistanceTraffic(Node evaluationNode,
                                          Integer edgeWeigh, Node sourceNode) {
        Integer sourceDistance = sourceNode.getDistanceTraffic();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistanceTraffic()) {
            evaluationNode.setDistanceTraffic(sourceDistance + edgeWeigh);
            LinkedList shortestPath = new LinkedList<>(sourceNode.getShortestPathTraffic());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

}
