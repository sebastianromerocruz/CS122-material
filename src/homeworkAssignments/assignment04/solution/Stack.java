package homeworkAssignments.assignment04.solution;

import homeworkAssignments.assignment04.Node;

public class Stack {
    private Node top;
    private int size;

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.printStack();

        System.out.printf("Adding %d...%n", 7);
        stack.addToStack(7);

        System.out.printf("Adding %d...%n", 11);
        stack.addToStack(11);

        System.out.printf("Adding %d...%n", 42);
        stack.addToStack(42);

        System.out.printf("Adding %d...%n", 14);
        stack.addToStack(15);

        System.out.printf("Adding %d...%n", 9);
        stack.addToStack(9);

        stack.printStack();

        System.out.printf("Removing %d...%n", stack.removeFromStack().getValue());
        System.out.printf("Removing %d...%n", stack.removeFromStack().getValue());

        System.out.printf("Adding %d...%n", 0);
        stack.addToStack(0);

        stack.printStack();
    }

    public Stack(int firstValue) {
        this.top = new Node(firstValue);
        this.top.setPrevious(null);
        this.size = 1;
    }

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    public void addToStack(int value) {
        // Create the new node that will be added to the stack whether or not the stack is empty
        Node newNode = new Node(value);

        if (this.size == 0) {
            // If it is empty, then simply make this new node the top node and increase the size
            this.top = newNode;
            this.size++;

            return;
        }

        Node previousTop = this.top; // If it is not empty, make sure to keep a separate reference to the old node

        this.top.setNext(newNode); // Set the old top's next reference to the new node
        this.top = this.top.getNext(); // The new top node is the old top node's next reference
        this.top.setPrevious(previousTop); // And the new top node's previous reference is the old top
        this.size++; // Don't forget to do this!
    }

    public Node removeFromStack() {
        if (this.size == 0 || this.top == null) return null; // If it is empty, then just return null

        Node previousTop = this.top; // If not empty, make sure to keep a separate reference to the node to be removed

        this.top = this.top.getPrevious(); // The new top is now the old top's previous reference
        this.top.setNext(null); // And its new next reference is null

        // Sever the links of to the stack of the previous top
        previousTop.setPrevious(null);
        previousTop.setNext(null);

        return previousTop; // And return
    }

    public void printStack() {
        if (this.size == 0 || this.top == null) return;

        Node current = this.top;

        System.out.print("TOP | ");

        do {
            System.out.print(current.getValue());
            current = current.getPrevious();

            if (current != null) System.out.print(" <-> ");
        } while (current != null);

        System.out.println(" | BOTTOM");
    }
}