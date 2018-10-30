package heap;

public class Main {
    public static void main(String[] args) {
        SdaHeap heap = new TreeHeap();
        heap.push(4);
        Integer pop = heap.pop();
        System.out.println(pop);
    }
}
