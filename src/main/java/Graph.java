import java.util.HashSet;
import java.util.Set;

public class Graph {

    private Set nodes = new HashSet<>();

    public void addNode(Node nodeA) {
        nodes.add(nodeA);
    }

    public Set getNodes() {
        return nodes;
    }

    public void setNodes(Set nodes) {
        this.nodes = nodes;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "nodes=" + nodes +
                '}';
    }
}
