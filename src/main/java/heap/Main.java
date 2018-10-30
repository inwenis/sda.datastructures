package heap;

import trees.TreePrinter;

public class Main {
    public static void main(String[] args) {
        SdaHeap heap = new TreeHeap();
        heap.push(4);
        heap.push(5);
        heap.push(10);
        heap.push(1);

        TreePrinter.coolPrint(heap.toArray());

        Integer pop = heap.pop();
        System.out.println("heap.pop() returned: " + pop);
        TreePrinter.coolPrint(heap.toArray());

        pop = heap.pop();
        System.out.println("heap.pop() returned: " + pop);
        TreePrinter.coolPrint(heap.toArray());

        pop = heap.pop();
        System.out.println("heap.pop() returned: " + pop);
        TreePrinter.coolPrint(heap.toArray());

    }
}
