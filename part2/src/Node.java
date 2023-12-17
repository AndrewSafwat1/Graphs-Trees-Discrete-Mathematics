public class Node {
    private Integer value;
    private String color;

    public Node(Integer value){ this.value = value; }

    public int getValue() {
        return value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
