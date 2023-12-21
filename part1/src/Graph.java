import java.util.*;
public class Graph {
    private int v;
    private ArrayList<Node>[] adj;
    private ArrayList<Node> nodes = new ArrayList<>();
    public Graph(int v) {
        this.v = v;
        adj = new ArrayList[v];
        for (int i = 0; i < v; ++i){
            adj[i] = new ArrayList<>();
            nodes.add(new Node(i)); //also saved at place i
        }
    }
    void addEdge(Integer v, Integer w) {
        //adding edge for both nodes as it is undirected
        if(v == w){
            adj[v].add(nodes.get(w));
            return;
        }
        adj[v].add(nodes.get(w));
        adj[w].add(nodes.get(v));
    }
}
