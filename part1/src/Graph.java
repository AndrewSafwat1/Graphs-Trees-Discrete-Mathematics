import java.util.*;
public class Graph {
    // No. of vertices
    private int v;
    private ArrayList<Node>[] adj;
    private ArrayList<Node> nodes = new ArrayList<>();
    private int[][] cost;
    private int minCost;
    private ArrayList<Node> shortestPath = new ArrayList<>();
    public ArrayList<Node> getShortestPath() {
        return shortestPath;
    }
    public void setShortestPath(ArrayList<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }
    public int getMinCost() {
        return minCost;
    }
    public void setMinCost(int minCost) {
        this.minCost = minCost;
    }
    public Graph(int v, char[] vertices) {
        this.v = v;
        adj = new ArrayList[v];
        for (int i = 0; i < v; ++i){
            adj[i] = new ArrayList<>();
            nodes.add(new Node(vertices[i])); //also saved at place i
        }
        cost = new int[v][v];
    }
    void addEdge(char v, char w) {
        //adding edge for both nodes as it is undirected
        if(v == w){
            adj[v-65].add(nodes.get(w-65));
            return;
        }
        adj[v-65].add(nodes.get(w-65));
        adj[w-65].add(nodes.get(v-65));
    }
    void addCost(char v, char w, int cost){
        this.cost[v-65][w-65] = cost;
        this.cost[w-65][v-65] = cost;
    }
    public ArrayList<Node> getAdj(char v){
        return adj[v-65];
    }
    public int getCost(char v, char w){
        return cost[v-65][w-65];
    }
//    public void dijkstra2(char source, char destination ) {
//        //initializing the distance array
//        int[] distance = new int[v];
//        for (int i = 0; i < v; i++) {
//            distance[i] = Integer.MAX_VALUE;
//        }
//        //initializing the visited array
//        boolean[] visited = new boolean[v];
//        //initializing the parent array
//        int[] parent = new int[v];
//        //initializing the priority queue
//        //setting the source distance to 0
//        distance[source - 65] = 0;
//        //adding the source node to the priority queue
//        pq.add(nodes.get(source - 65));
//        //setting the parent of the source node to -1
//        parent[source - 65] = -1;
//        //while the priority queue is not empty
//        while (!pq.isEmpty()) {
//            //polling the top node
//            Node node = pq.poll();
//            //marking the node as visited
//            visited[node.getValue() - 65] = true;
//            //for each adjacent node
//            for (Node n : adj[node.getValue() - 65]) {
//                //if the node is not visited
//                if (!visited[n.getValue() - 65]) {
//                    //if the distance of the adjacent node is greater than the distance of the current node + the cost of the edge between the current node and the adjacent node
//                    if (distance[n.getValue() - 65] > distance[node.getValue() - 65] + getCost(node.getValue(), n.getValue())) {
//                        //updating the distance of the adjacent node
//                        distance[n.getValue() - 65] = distance[node.getValue() - 65] + getCost(node.getValue(), n.getValue());
//                        //adding the adjacent node to the priority queue
//                        pq.add(n);
//                        //setting the parent of the adjacent node to the current node
//                        parent[n.getValue() - 65] = node.getValue();
//                    }
//                }
//            }
//        }
//        //setting the minCost to the distance of the destination node
//        minCost = distance[destination - 65];
//        //adding the destination node to the shortest path
//        shortestPath.add(nodes.get(destination - 65));
//        //setting the current node to the destination node
//        int curr = destination - 65;
//        //while the parent of the current node is not -1
//        while (parent[curr] != -1) {
//            //adding the parent of the current node to the shortest path
//            shortestPath.add(nodes.get(parent[curr]));
//            //setting the current node to the parent of the current node
//            curr = parent[curr];
//            //??
//
//
//        }
//    }
    public void dijkstra(char source ,char destination){
        boolean flag = false;
        HashMap<Node,Integer> distanceFromSource = new HashMap<>(); // cost to get to each node from the source
        for(int i = 0; i < v; i++){
            distanceFromSource.put(nodes.get(i),Integer.MAX_VALUE);
        }
        distanceFromSource.put(nodes.get(source-65),0);
        Stack<Node> path = new Stack<>();
        path.push(nodes.get(source-65));
        int i = source-65;
        while(!flag){
            Node currerntNode = nodes.get(i);
            ArrayList<Node> adjNodes = getAdj(currerntNode.getValue());
            for(Node node : adjNodes) {
                int cost = getCost(currerntNode.getValue(), node.getValue());
                if (distanceFromSource.get(node) > distanceFromSource.get(currerntNode) + cost) {
                    distanceFromSource.put(node, distanceFromSource.get(currerntNode) + cost);
                }
            }
            for(int j=0;j<distanceFromSource.size();j++) {
                int minimum = Integer.MAX_VALUE;
                if(distanceFromSource.get(nodes.get(j)) < minimum){
                    minimum = distanceFromSource.get(nodes.get(j));
                    i=j;
                }
            }
            path.push(nodes.get(i));
        }
    }
    public String getArrayOfCosts(){
        String s = "";
        for(int i = 0; i < cost.length; i++){
            s += (char) (i+65);
            s += ": [";
            for(int j = 0; j < cost[i].length; j++){
                if(cost[i][j] == 0)
                    continue;
                s += "{";
                s += (char) (j+65) + " = ";
                s += cost[i][j];
                s += "}";
            }
            s += "] ";
        }
        return s;
    }
    @Override
    public String toString() {
        return "Graph{" +
                "v=" + v +
                ", adj=" + Arrays.toString(adj) +
                ", cost=" + getArrayOfCosts() +
                '}';
    }

}
