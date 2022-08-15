/**
 * Author: Sebastián Romero Cruz
 * Summer 2022
 * */
package homeworkAssignments.assignment04;


import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Node {
    private final AtomicInteger value;
    private final AtomicReference<Node> next;
    private final AtomicReference<Node> previous;

    public Node(int value, Node next, Node previous) {
        this.value = new AtomicInteger(value);
        this.next = new AtomicReference<Node>(next);
        this.previous = new AtomicReference<Node>(next);
    }

    public Node(int value, Node next) {
        this.value = new AtomicInteger(value);
        this.next = new AtomicReference<Node>(next);
        this.previous = new AtomicReference<Node>();
    }

    public Node(int value) {
        this.value = new AtomicInteger(value);
        this.next = new AtomicReference<Node>();
        this.previous = new AtomicReference<Node>();
    }

    public int getValue() {
        return this.value.get();
    }

    public Node getNext() {
        return this.next.get();
    }

    public Node getPrevious() {
        return this.previous.get();
    }

    public void setNext(Node node) {
        this.next.set(node);
    }

    public void setPrevious(Node node) {
        this.previous.set(node);
    }

    @Override
    public String toString() {
        return Integer.toString(this.value.get());
    }
}
