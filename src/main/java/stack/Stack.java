package stack;

import java.util.Optional;

public class Stack {
    // push/pop/peek/isEmpty

    Node head = null;

    public void push(int i) {
        if(head == null) {
            head = new Node(i);
        } else {
            Node node = new Node(i);
            node.next = head;
            head = node;
        }
    }

    public Optional<Integer> pop() {
        if(head == null) {
            return Optional.empty();
        } else {
            Optional<Integer> num = Optional.of(head.num);
            head = head.next;
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
