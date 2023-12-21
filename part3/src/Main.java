import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int x = 0;
        Tree tree = new Tree();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1 for iterative solution and 2 for recursive solution: ");
        try {
            x = sc.nextInt();
        } catch (Exception e){
            System.out.println("You didn't enter a value, please try again.");
            System.exit(0);
        }

        if(x == 1)
            tree.SolutionIterative();
        else if(x == 2)
            tree.SolutionRecursive();
    }
}
