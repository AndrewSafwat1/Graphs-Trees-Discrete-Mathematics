import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter list of airports: ");
        char[] airports = scan.nextLine().replaceAll(", ","").toCharArray();
        System.out.print("Enter the flights: ");
        String[] flights = scan.nextLine().replaceAll(",","").split(" ");
        Graph g = new Graph(airports.length, airports);
        for(int i = 0; i < flights.length; i++) {
            String[] temp = flights[i].split("-");
            Character a = temp[0].charAt(0);
            Character b = temp[1].charAt(0);
            g.addEdge(a, b);
        }
        System.out.println("The distance for each flight (in miles): ");
        for(int i = 0; i < flights.length; i++) {
            String[] temp = flights[i].split("-");
            Character a = temp[0].charAt(0);
            Character b = temp[1].charAt(0);
            System.out.print(a + " to " + b + ": ");
            int cost = scan.nextInt();
            g.addCost(a, b, cost);
        }
        System.out.println("Enter source airport: ");
        char source = scan.next().charAt(0);
        System.out.println("Enter destination airport: ");
        char destination = scan.next().charAt(0);
        g.dijkstra(source, destination);
        System.out.println("Shortest path from " + source + " to " + destination + " is: ");
        System.out.println(g.getShortestPath());
        System.out.println("Total Distance: " + g.getMinCost());
    }
}
