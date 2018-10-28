package queue;

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
