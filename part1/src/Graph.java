import java.util.ArrayList;
import java.util.Arrays;
public class Graph {
    private int[][] adjacencyMatrix;
    private int[] parent;
    public Graph(int vertices){
        adjacencyMatrix = new int[vertices][vertices];
        parent = new int[vertices];
    }
    public void addEdge(int source, int destination, int weight){
        adjacencyMatrix[source][destination] = weight;
        adjacencyMatrix[destination][source] = weight;
    }
    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }
    private String print2dArray(int[][] array) {
        StringBuilder result = new StringBuilder();
        for(int[] ints : array) {
            result.append(Arrays.toString(ints)).append("\n");
        }
        return result.toString();
    }
    public int[] dijkstra(int[][] graph, int source){
        int v = graph.length;
        int[] distance = new int[v];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;
        parent[source] = -1;
        boolean[] visited = new boolean[v];
        for(int i=0;i<v-1;i++){
            int current = -1;
            for(int j=0;j<v;j++){
                if(!visited[j] && (current == -1 || distance[j] < distance[current])){
                    current = j;
                }
            }
            visited[current] = true;
            for(int j=0;j<v;j++){
                if(graph[current][j] != 0){
                    int newDistance = distance[current] + graph[current][j];
                    if(newDistance < distance[j]){
                        distance[j] = newDistance;
                        parent[j] = current;
                    }
                }
            }
        }
        return distance;
    }
    public ArrayList<Integer> getPath(int destination){
        ArrayList<Integer> path = new ArrayList<>();
        int current = destination;
        while(current != -1){
            for(int i=0;i<parent.length;i++){
                if(i == current){
                    path.add(i);
                    current = parent[i];
                }
            }
        }
        for(int i=0;i<path.size()/2;i++){
            int temp = path.get(i);
            path.set(i,path.get(path.size()-i-1));
            path.set(path.size()-i-1,temp);
        }
        return path;
    }
    @Override
    public String toString() {
        return "Graph{" +
                "adjacencyMatrix=" + "\n" +
                print2dArray(adjacencyMatrix) +
                '}';
    }
}
