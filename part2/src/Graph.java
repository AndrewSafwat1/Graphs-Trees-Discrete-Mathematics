import java.util.*;

public class Graph {
    //colors
    private String[] colors = {"Red", "Green", "Blue", "Yellow", "Black", "White", "Grey", "Orange", "Rose", "Mint"};

    // No. of vertices
    private int v;

    // Adjacency Lists
    private ArrayList<Node>[] adj;
    private ArrayList<Node> nodes = new ArrayList<>();

    // Constructor
    public Graph(int v) {
        this.v = v;
        adj = new ArrayList[v];
        for (int i = 0; i < v; ++i){
            adj[i] = new ArrayList<>();
            nodes.add(new Node(i)); //also saved at place i
        }
    }

    // Function to add an edge into the graph
    void addEdge(Integer v, Integer w) {
        //adding edge for both nodes as it is undirected
        if(v == w){
            adj[v].add(nodes.get(w));
            return;
        }
        adj[v].add(nodes.get(w));
        adj[w].add(nodes.get(v));
    }

    public ArrayList<Node> color() {
        boolean flag =false;
        int maxEdges = 0;
        int vertexWithMaxEdges = 0;


        //Largest degree vertex is colored first
        for (int i = 0; i < this.v; i++) {
            if (this.adj[i].size() > maxEdges) {
                maxEdges = this.adj[i].size();
                vertexWithMaxEdges = i;
            }
        }
        this.nodes.get(vertexWithMaxEdges).setColor(this.colors[0]);

        for(int i = 0 ; i < this.v; i++){ //nodes in adj array
            for(int j = 0 ; j < this.colors.length; j++){ //colors array
                flag = false;
                for(int k = 0 ; k < this.adj[i].size(); k ++){ //neighbours for every node
                    if(this.colors[j].equals(this.adj[i].get(k).getColor())){
                        flag = true;
                        break;
                    }
                }
                if(flag)
                    continue;
                this.nodes.get(i).setColor(this.colors[j]);
                break;
            }
        }

        return this.nodes;
    }
}
