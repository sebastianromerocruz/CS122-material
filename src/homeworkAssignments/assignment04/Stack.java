package homeworkAssignments.assignment04;

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


    /**
     * Implement addToStack().
     *
     * This method must take into account the possibility of the stack currently being empty, in which case the first
     * Node to be added will have a `previous` value of `null`. Remember to:
     *      1. Change the `top` pointer to the new top node.
     *      2. Increase the `size` integer.
     *
     * @param value The value to be added on top of the stack as a node
     */
    public void addToStack(int value) {
        // TODO - Implement add to stack method
    }


    /**
     * Implement removeFromStack(), which returns a Node object reference.
     *
     * This method must take into account the possibility of the stack currently being empty (i.e. `size` is `0` / `top`
     * is `null`), in which case return `null`. Remember to:
     *      1. Change the `top` pointer to the new top node.
     *      2. Decrease the `size` integer.
     *      3. Sever the ties of the old top node to the stack before returning it.
     *
     * @return A pointer to the node that was removed from the top of the stack
     */
    public Node removeFromStack() {
        // TODO - Implement remove from stack method

        return null;
    }

    public void printStack() {
        if (this.size == 0 || this.top == null) return;

        Node current = this.top;

        System.out.print("TOP | ");

        do {
            System.out.print(current);
            current = current.getPrevious();

            if (current != null) System.out.print(" <-> ");
        } while (current != null);

        System.out.println(" | BOTTOM");
    }
}