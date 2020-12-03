package ua.edu.ucu.immutable;

@lombok.Setter
@lombok.Getter
public class Node {
    private Object val = null;
    private Node prev = null;
    private Node next = null;

    public Node(Object val, Node prev, Node next) {
        this.next = next;
        this.prev = prev;
        this.val = val;
    }
}
