import java.util.*;
public class Main {
    public static void main(String[] args) {
        Hashtable<String, Integer> hashtable = new Hashtable<>();
        Hashtable<Integer, String> reverseHashtable = new Hashtable<>();
        String[] nodes, edge;
        Scanner sc = new Scanner(System.in);
        System.out.print("Classes: ");
        nodes = sc.nextLine().replace(",", "").split(" ");

        for(int i = 0 ; i < nodes.length; i++){
            //handling if same node entered twice
            if(hashtable.contains(nodes[i]))
                continue;
            hashtable.put(nodes[i], i);
            reverseHashtable.put(i, nodes[i]);
        }

        Graph g = new Graph(nodes.length);
        // any spaces or commas between different nodes will be removed
        System.out.println("Conflicting classes (cannot occur simultaneously) (put '-' between different nodes):");

        while (sc.hasNextLine()){
            Integer[] edgeStartEnd = new Integer[2];
            edge = sc.nextLine().replace(" ", "")
                    .replace(",", "").split("-");

            if(edge.length == 1 && edge[0].isEmpty()) {
                break;
            }else if(edge.length != 2){
                System.out.println("Not valid edge length");
                return;
            }


            for(int i = 0 ; i < 2 ; i ++){
                edgeStartEnd[i] = hashtable.get(edge[i]);

                if(edgeStartEnd[i] == null){
                    System.out.println("You didn't declare "+ edge[i] + " as a node");
                    return;
                }
            }

            g.addEdge(edgeStartEnd[0], edgeStartEnd[1]);

        }


        ArrayList<Node> answer = g.color();
        System.out.println("Optimized Class Schedule:");
        for (Node node : answer) {
            System.out.println(reverseHashtable.get(node.getValue()) + " - " + node.getColor());
        }
    }
}