import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Node {

    private String name;

    private List shortestPath = new LinkedList<>();

    private List shortestPathTraffic = new LinkedList<>();

    private Integer distance = Integer.MAX_VALUE;
    private Integer distanceTraffic = Integer.MAX_VALUE;


    Map< Node, PairDistance> adjacentNodes = new HashMap<>();

    public void addDestination(Node destination, PairDistance distance) {
        adjacentNodes.put(destination, distance);
    }

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(List shortestPath) {
        this.shortestPath = shortestPath;
    }

    public List getShortestPathTraffic() {
        return shortestPathTraffic;
    }

    public void setShortestPathTraffic(List shortestPathTraffic) {
        this.shortestPathTraffic = shortestPathTraffic;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getDistanceTraffic() {
        return distanceTraffic;
    }

    public void setDistanceTraffic(Integer distanceTraffic) {
        this.distanceTraffic = distanceTraffic;
    }

    public Map< Node, PairDistance> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(Map adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", shortestPath=" + shortestPath +
                ", distance=" + distance +
                '}';
    }
}
