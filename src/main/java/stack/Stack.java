package stack;

import java.util.Optional;

public class Stack {
    // push/pop/peek/isEmpty

    Node top = null;

    public void push(int i) {
        if(top == null) {
            top = new Node(i);
        } else {
            Node node = new Node(i);
            node.next = top;
            top = node;
        }
    }

    public Optional<Integer> pop() {
        if(top == null) {
            return Optional.empty();
        } else {
            Optional<Integer> num = Optional.of(top.num);
            top = top.next;
            return num;
        }
    }

    public Optional<Integer> peek() {
        if(top == null) {
            return Optional.empty();
        } else {
            return Optional.of(top.num);
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

    class Node {
        int num;
        Node next;

        Node(int num) {
            this.num = num;
        }
    }
}
