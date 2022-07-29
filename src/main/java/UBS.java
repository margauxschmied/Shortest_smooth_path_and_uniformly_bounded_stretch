import java.util.LinkedList;
import java.util.List;

public class UBS {
    Dijkstra dijkstra=new Dijkstra();

    public int pathWeight(List<Node> path){
        int weight=0;
        for (int i=0; i< path.size()-1; i++){
            weight+=path.get(i).getAdjacentNodes().get(path.get(i+1)).getDistanceWithoutTrafic();
        }
        return weight;
    }
    public int pathWeightTraffic(List<Node> path){
        int weight=0;
        for (int i=0; i< path.size()-1; i++){
            weight+=path.get(i).getAdjacentNodes().get(path.get(i+1)).getDistanceWithTrafic();
        }
        return weight;
    }

    public float stretch(Graph graph, LinkedList<Node> path){
        float weightP = pathWeight(path);
        dijkstra.calculateShortestPathFromSource(graph, path.getFirst(), false);
        float shortestPath = path.getLast().getDistance();
        return weightP/shortestPath;
    }

    public float stretchTraffic(Graph graph, LinkedList<Node> path){
        float weightP = pathWeightTraffic(path);
        dijkstra.calculateShortestPathFromSource(graph, path.getFirst(), true);
        float shortestPath = path.getLast().getDistanceTraffic();
        return weightP/shortestPath;
    }

    public void interativePathFixing(){

    }
}
