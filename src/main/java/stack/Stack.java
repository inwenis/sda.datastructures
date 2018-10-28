package stack;

import java.util.Optional;

public class Stack {
    // push/pop/peek/isEmpty

    Node head = null;

    public void push(int i) {
        if(head == null) {
            head = new Node(i);
        }
    }

    public Optional<Integer> pop() {
        if(head == null) {
            return Optional.empty();
        } else {
            Optional<Integer> num = Optional.of(head.num);
            head = null;
            return num;

        }
    }

    class Node {
        int num;
        Node next;

        Node(int num) {
            this.num = num;
        }
    }
}
