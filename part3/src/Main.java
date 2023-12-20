import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1 for iterative solution and 2 for recursive solution: ");
        int x = sc.nextInt();
        if(x == 1)
            tree.SolutionIterative();
        else if(x == 2)
            tree.SolutionRecursive();
    }
}
