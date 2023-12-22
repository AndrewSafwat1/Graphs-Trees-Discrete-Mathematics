import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Tree {
    private boolean initialize = true;
    private Queue<Node> nodes = new LinkedList<Node>();
    public void SolutionRecursive(){
        int x;
        Node root = new Node();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of the root node: ");
        x = sc.nextInt();
        if(x != -1) {
            root.setValue(x);
            root = handleInput(root);
        }else{
            return;
        }
        System.out.print("PreOrder Traversal: ");
        preOrderTraversalRecursive(root);
        System.out.println();

        System.out.print("InOrder Traversal: ");
        inOrderTraversalRecursive(root);
        System.out.println();

        System.out.print("PostOrder Traversal: ");
        postOrderTraversalRecursive(root);
        System.out.println();

    }
    public void SolutionIterative(){
        int x = 0;
        Node root = new Node();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of the root node: ");
        try {
            x = sc.nextInt();
        } catch (Exception e){
            System.out.println("You didn't enter a value, please try again.");
            System.exit(0);
        }

        if(x != -1) {
            root.setValue(x);
            root = handleInput(root);
        }
        else {
            return;
        }

        System.out.print("PreOrder Traversal: ");
        preOrderTraversalIterative(root);
        System.out.println();

        System.out.print("InOrder Traversal: ");
        inOrderTraversalIterative(root);
        System.out.println();

        System.out.print("PostOrder Traversal: ");
        postOrderTraversalIterative(root);
        System.out.println();
    }
    public Node handleInput(Node node){

        //
        //gets values of nodes by level order traversal
        //

        Node newNode;
        int left, right;
        Scanner sc = new Scanner(System.in);

        //To save root node in order to send it back
        Node rootNode = new Node();
        if(this.initialize){
            rootNode = node;
            this.initialize = false;
        }

        System.out.println("Enter left child value of " + node.getValue() +" (or -1 to skip):");
        try{
            left = sc.nextInt();
            if(left != -1){
                newNode = new Node();
                newNode.setValue(left);
                node.setLeft(newNode);
                nodes.add(newNode);
            }else{
                node.setLeft(null);
            }
        }catch (Exception e){
            System.out.println("You didn't enter a value, please try again.");
            System.exit(0);
        }

        System.out.println("Enter right child value of " + node.getValue() +" (or -1 to skip):");
        try {
            right = sc.nextInt();
            if(right != -1){
                newNode = new Node();
                newNode.setValue(right);
                node.setRight(newNode);
                nodes.add(newNode);
            }else{
                node.setRight(null);
            }
        }catch (Exception e){
            System.out.println("You didn't enter a value, please try again.");
            System.exit(0);
        }


        if(nodes.peek() != null)
            handleInput(nodes.remove());
        if(nodes.peek() != null)
            handleInput(nodes.remove());

        return rootNode;
    }

    public void postOrderTraversalRecursive(Node node){
        if(node.getLeft() != null)
            postOrderTraversalRecursive(node.getLeft());

        if(node.getRight() != null)
            postOrderTraversalRecursive(node.getRight());

        System.out.print(node.getValue() + " ");
    }

    public void inOrderTraversalRecursive(Node node){
        if(node.getLeft() != null)
            inOrderTraversalRecursive(node.getLeft());

        System.out.print(node.getValue() + " ");

        if(node.getRight() != null)
            inOrderTraversalRecursive(node.getRight());
    }

    public void preOrderTraversalRecursive(Node node){
        System.out.print(node.getValue() + " ");

        if(node.getLeft() != null)
            preOrderTraversalRecursive(node.getLeft());

        if(node.getRight() != null)
            preOrderTraversalRecursive(node.getRight());
    }
    public void postOrderTraversalIterative(Node root){
        if (root == null) {
            return;
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);
        while(!stack1.isEmpty()) {
            Node node = stack1.pop();
            stack2.push(node);
            if (node.getLeft() != null) {
                stack1.push(node.getLeft());
            }
            if (node.getRight() != null) {
                stack1.push(node.getRight());
            }
        }
        while(!stack2.isEmpty()){
            System.out.print(stack2.pop().getValue() + " ");
        }
    }
    public void inOrderTraversalIterative(Node root){
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node node = root;
        while(!stack.isEmpty() || node != null){
            while(node != null){
                stack.push(node);
                node = node.getLeft();
            }
            node = stack.pop();
            System.out.print(node.getValue() + " ");
            node = node.getRight();
        }
    }
    public void preOrderTraversalIterative(Node root){
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            System.out.print(node.getValue() + " ");
            if(node.getRight() != null){
                stack.push(node.getRight());
            }
            if(node.getLeft() != null){
                stack.push(node.getLeft());
            }
        }
    }
}

