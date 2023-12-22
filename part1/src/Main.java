import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter list of airports: ");
        char[] airports = scan.nextLine().replaceAll(", ","").toCharArray();
        Graph g = new Graph(airports.length);
        System.out.print("Enter the flights: ");
        String[] flights = scan.nextLine().replaceAll(",","").split(" ");
        System.out.println("The distance for each flight (in miles): ");
        for(int i = 0; i < flights.length; i++) {
            String[] temp = flights[i].split("-");
            Character a = temp[0].charAt(0);
            Character b = temp[1].charAt(0);
            System.out.print(a + " to " + b + ": ");
            int cost = scan.nextInt();
            g.addEdge((int)a - 65,(int)b - 65, cost);
        }
        System.out.print("Enter source airport: ");
        char source = scan.next().charAt(0);
        System.out.print("Enter destination airport: ");
        char destination = scan.next().charAt(0);
        int[] distance = g.dijkstra(g.getAdjacencyMatrix(), (int)source - 65);
        ArrayList<Integer> path = g.getPath((int)destination - 65);
        if(distance[(int)destination - 65] == Integer.MAX_VALUE || distance[(int)destination - 65] < 0){
            System.out.println("There is no path from " + source + " to " + destination);
        }
        else{
            System.out.print("Shortest path from " + source + " to " + destination + " is: ");
            for(int i = 0; i < path.size(); i++) {
                System.out.print((char)(path.get(i)+65) + " ");
            }
            System.out.println();
            System.out.println("Total distance: " + distance[(int)destination - 65] + " miles");
        }
    }
}
