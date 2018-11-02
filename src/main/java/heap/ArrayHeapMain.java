package heap;

import trees.TreePrinter;

public class ArrayHeapMain {
    public static void main(String[] args) {
        SdaHeap heap = new ArrayHeap();
        heap.push(4);
        TreePrinter.coolPrint(heap.toArray());
        heap.push(5);
        TreePrinter.coolPrint(heap.toArray());
        heap.push(10);
        TreePrinter.coolPrint(heap.toArray());
        heap.push(1);
        TreePrinter.coolPrint(heap.toArray());
        heap.push(11);
        TreePrinter.coolPrint(heap.toArray());
        heap.push(9);
        TreePrinter.coolPrint(heap.toArray());

        System.out.println("-----------------Testing pop-------------------------------------");

        Integer pop = heap.pop();
        System.out.println("heap.pop() returned: " + pop);
        TreePrinter.coolPrint(heap.toArray());

        pop = heap.pop();
        System.out.println("heap.pop() returned: " + pop);
        TreePrinter.coolPrint(heap.toArray());

        pop = heap.pop();
        System.out.println("heap.pop() returned: " + pop);
        TreePrinter.coolPrint(heap.toArray());

        pop = heap.pop();
        System.out.println("heap.pop() returned: " + pop);
        TreePrinter.coolPrint(heap.toArray());

        System.out.println("-----------------Testing size()-------------------------------------");

        SdaHeap heap3 = new ArrayHeap();
        System.out.println(heap3.size());
        heap3.push(1);
        System.out.println(heap3.size());
        heap3.push(12);
        System.out.println(heap3.size());
        heap3.push(13);
        System.out.println(heap3.size());
        heap3.push(100);
        System.out.println(heap3.size());
        heap3.push(15);
        TreePrinter.coolPrint(heap3.toArray());

    }
}
