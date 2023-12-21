import java.util.*;

public class Graph {
    //colors
    private String[] colors = {"Red", "Blue", "Green", "Yellow", "Black", "White", "Grey", "Orange", "Rose", "Mint"};

    // No. of vertex
    private int vertex;

    // Adjacency Lists
    private ArrayList<Node>[] adjacencyList;
    private ArrayList<Node> nodes = new ArrayList<>();

    public Graph(int vertex) {
        this.vertex = vertex;
        adjacencyList = new ArrayList[vertex];
        for (int i = 0; i < vertex; ++i){
            adjacencyList[i] = new ArrayList<>();
            nodes.add(new Node(i)); //also saved at place i
        }
    }

    // add an edge into the graph
    void addEdge(Integer vertex, Integer otherVertex) {
        //adding edge for both nodes as it is undirected
        if(vertex == otherVertex){
            adjacencyList[vertex].add(nodes.get(otherVertex));
            return;
        }
        adjacencyList[vertex].add(nodes.get(otherVertex));
        adjacencyList[otherVertex].add(nodes.get(vertex));
    }

    public ArrayList<Node> colorGraph() {
        boolean colorIsUsed =false;
        int maxEdges = 0;
        int vertexWithMaxEdges = 0;


        //Largest degree vertex is colored first
        for (int i = 0; i < this.vertex; i++) {
            if (this.adjacencyList[i].size() > maxEdges) {
                maxEdges = this.adjacencyList[i].size();
                vertexWithMaxEdges = i;
            }
        }
        this.nodes.get(vertexWithMaxEdges).setColor(this.colors[0]);

        for(int i = 0 ; i < this.vertex; i++){ //nodes in adjacencyList array
            for(int j = 0 ; j < this.colors.length; j++){ //colors array
                colorIsUsed = false;
                for(int k = 0 ; k < this.adjacencyList[i].size(); k ++){ //neighbours for every node
                    if(this.colors[j].equals(this.adjacencyList[i].get(k).getColor())){
                        colorIsUsed = true;
                        break;
                    }
                }
                if(colorIsUsed)
                    continue;
                this.nodes.get(i).setColor(this.colors[j]);
                break;
            }
        }

        return this.nodes;
    }
}
