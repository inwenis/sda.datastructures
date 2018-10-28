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

        System.out.println("peek:");
        System.out.println(q.peek().orElse(-1));
        q.enqueue(13);
        System.out.println(q.peek().orElse(-1));
        q.enqueue(14);
        q.enqueue(15);
        System.out.println(q.dequeue().orElse(-1));
        System.out.println(q.dequeue().orElse(-1));
        System.out.println(q.dequeue().orElse(-1));
        System.out.println(q.dequeue().orElse(-1));
        System.out.println(q.dequeue().orElse(-1));

    }
}
