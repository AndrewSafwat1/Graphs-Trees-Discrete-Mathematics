public class Node {
    private char value;
    public Node(char value){
        this.value = value;
    }
    public char getValue() {
        return value;
    }
    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
