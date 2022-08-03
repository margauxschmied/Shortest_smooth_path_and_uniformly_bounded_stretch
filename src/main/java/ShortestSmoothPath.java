import java.util.LinkedList;
import java.util.List;

public class ShortestSmoothPath {
    Dijkstra dijkstra;
    UBS ubs;

    public ShortestSmoothPath() {
        this.dijkstra = new Dijkstra();
        this.ubs = new UBS();
    }

    public LinkedList<Node> iterativePathFixing(float e, Graph graph, Node source, Node destination){
        graph = dijkstra.calculateShortestPathFromSource(graph, source, true);

        LinkedList<Node> path= (LinkedList<Node>) destination.getShortestPathTraffic();
        path.add(destination);

        while (!ubs.eSmooth(e, graph, path, false)){

            dijkstra.calculateShortestPathFromSource(graph, ubs.getStartStretchestPath(), false);

            List shortetsPath =ubs.getEndStretchestPath().getShortestPath();

            LinkedList<Node> pathRes=new LinkedList<>();

            boolean stop=false;
            for (int i=0; i<path.size(); i++){

                if(path.get(i)==shortetsPath.get(0)){
                    pathRes.addAll(shortetsPath);
                    stop=true;
                }
                else if (stop && path.get(i)==ubs.getEndStretchestPath()){
                    pathRes.add(path.get(i));
                    stop =false;
                }
                else if (!stop) {
                    pathRes.add(path.get(i));
                }
            }

            path=pathRes;

        }
        return path;
    }
}

