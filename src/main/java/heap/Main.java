package heap;

import trees.TreePrinter;

public class Main {
    public static void main(String[] args) {
        SdaHeap heap = new TreeHeap();
        heap.push(4);
        heap.push(5);
        heap.push(10);
        heap.push(1);

        Integer[] heapAsArray = heap.toArray();

        TreePrinter.coolPrint(heapAsArray)
                .stream()
                .forEach(System.out::println);

        Integer pop = heap.pop();
        System.out.println(pop);
    }
}
