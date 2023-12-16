import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tree {
    private boolean initialize = true;
    private Queue<Node> nodes = new LinkedList<Node>();
    public void Solution(){
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
        preOrderTraversal(root);
        System.out.println();

        System.out.print("InOrder Traversal: ");
        inOrderTraversal(root);
        System.out.println();

        System.out.print("PostOrder Traversal: ");
        postOrderTraversal(root);
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
        left = sc.nextInt();

        if(left != -1){
            newNode = new Node();
            newNode.setValue(left);
            node.setLeft(newNode);
            nodes.add(newNode);
        }else{
            node.setLeft(null);
        }

        System.out.println("Enter right child value of " + node.getValue() +" (or -1 to skip):");
        right = sc.nextInt();
        if(right != -1){
            newNode = new Node();
            newNode.setValue(right);
            node.setRight(newNode);
            nodes.add(newNode);
        }else{
            node.setRight(null);
        }

        if(nodes.peek() != null)
            handleInput(nodes.remove());
        if(nodes.peek() != null)
            handleInput(nodes.remove());

        return rootNode;
    }

    public void postOrderTraversal(Node node){
        if(node.getLeft() != null)
            postOrderTraversal(node.getLeft());

        if(node.getRight() != null)
            postOrderTraversal(node.getRight());

        System.out.print(node.getValue() + " ");
    }

    public void inOrderTraversal(Node node){
        if(node.getLeft() != null)
            inOrderTraversal(node.getLeft());

        System.out.print(node.getValue() + " ");

        if(node.getRight() != null)
            inOrderTraversal(node.getRight());
    }

    public void preOrderTraversal(Node node){
        System.out.print(node.getValue() + " ");

        if(node.getLeft() != null)
            preOrderTraversal(node.getLeft());

        if(node.getRight() != null)
            preOrderTraversal(node.getRight());
    }
}

