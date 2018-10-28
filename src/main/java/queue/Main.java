package queue;

public class Main {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(10);
        q.enqueue(11);
        q.enqueue(12);

        System.out.println(q.dequeue().orElse(-1));
        System.out.println(q.dequeue().orElse(-1));
        System.out.println(q.dequeue().orElse(-1));
        System.out.println(q.dequeue().orElse(-1));
        System.out.println(q.dequeue().orElse(-1));
    }
}
