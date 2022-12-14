import java.util.LinkedList;
import java.util.List;

public class UBS {
    private Dijkstra dijkstra=new Dijkstra();

    private Node startStretchestPath = null;
    private Node endStretchestPath = null;



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

    public float stretch(Graph graph, LinkedList<Node> path, int i, int j){
        LinkedList<Node> subPath = new LinkedList<>();
        for (int n=i; n<=j; n++){
            subPath.add(path.get(n));
        }
        return stretch(graph, subPath);
    }

    public float stretchTraffic(Graph graph, LinkedList<Node> path){
        float weightP = pathWeightTraffic(path);
        dijkstra.calculateShortestPathFromSource(graph, path.getFirst(), true);
        float shortestPath = path.getLast().getDistanceTraffic();
        return weightP/shortestPath;
    }

    public float stretchTraffic(Graph graph, LinkedList<Node> path, int i, int j){
        LinkedList<Node> subPath = new LinkedList<>();
        for (int n=i; n<=j; n++){
            subPath.add(path.get(n));
        }
        return stretchTraffic(graph, subPath);
    }

    public float calcul(Graph graph, LinkedList<Node> path, boolean traffic){
        float max = 0;

        for (int i=0; i<path.size(); i++){
            for (int j=0; j<path.size(); j++){
                if (i<j){
                    float n;
                    if (traffic){
                        n=stretchTraffic(graph, path, i, j);

                    }
                    else{
                        n=stretch(graph, path, i, j);
                    }
                    if (n>max){
                        max=n;
                        startStretchestPath=path.get(i);
                        endStretchestPath=path.get(j);
                    }

                }
            }
        }
        return max;
    }

    public boolean eSmooth(float e, Graph graph, LinkedList<Node> path, boolean traffic){
        return calcul(graph, path, traffic) < 1+e;
    }

    public Node getStartStretchestPath() {
        return startStretchestPath;
    }

    public Node getEndStretchestPath() {
        return endStretchestPath;
    }
}
