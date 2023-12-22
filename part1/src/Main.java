import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter list of airports: ");
        char[] airports = scan.nextLine().replaceAll(", ","").toCharArray();
        Graph g = new Graph(airports.length);
        HashMap<Character, Integer> charToInt = new HashMap<>();
        HashMap<Integer, Character> intToChar = new HashMap<>();
        for(int i = 0; i < airports.length; i++) {
            charToInt.put(airports[i], i);
            intToChar.put(i, airports[i]);
        }
        System.out.print("Enter the flights: ");
        String[] flights = scan.nextLine().replaceAll(",","").split(" ");
        System.out.println("The distance for each flight (in miles): ");
        for(String flight : flights){
            String[] temp = flight.split("-");
            Character a = temp[0].charAt(0);
            Character b = temp[1].charAt(0);
            System.out.print(a + " to " + b + ": ");
            int cost = scan.nextInt();
            g.addEdge(charToInt.get(a), charToInt.get(b), cost);
        }
        System.out.print("Enter source airport: ");
        char source = scan.next().charAt(0);
        System.out.print("Enter destination airport: ");
        char destination = scan.next().charAt(0);
        int[] distance = g.dijkstra(g.getAdjacencyMatrix(), charToInt.get(source));
        ArrayList<Integer> path = g.getPath(charToInt.get(destination));
        if(distance[charToInt.get(destination)] == Integer.MAX_VALUE || distance[charToInt.get(destination)] < 0){
            System.out.println("There is no path from " + source + " to " + destination);
        }
        else{
            System.out.print("Shortest path from " + source + " to " + destination + " is: ");
            for(int i = 0; i < path.size(); i++) {
                System.out.print(intToChar.get(path.get(i)) + " ");
            }
            System.out.println();
            System.out.println("Total distance: " + distance[charToInt.get(destination)] + " miles");
        }
    }
}
