package queue;

import java.util.Optional;

public class Queue {

    Node first;
    Node last;

    public void enqueue(int i) {
        if(last == null) {
            Node node = new Node(i);
            last = node;
            first = node;
        } else {
            Node node = new Node(i);
            last.next = node;
            last = node;
        }
    }

    public Optional<Integer> dequeue() {
        if(first == null) {
            return Optional.empty();
        } else {
            Node x = first;
            first = first.next;
            if(first == null) {
                last = null;
            }
            return Optional.of(x.num);
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public Optional<Integer> peek() {
        if(first == null) {
            return Optional.empty();
        } else {
            return Optional.of(first.num);
        }
    }
    //enqueue/dequeue/peek/isEmpty

    class Node {
        int num;
        Node next;

        public Node(int num) {
            this.num = num;
        }
    }
}
