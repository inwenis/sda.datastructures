package heap;

import trees.TreePrinter;

import java.util.Date;
import java.util.Random;

public class TreeHeapMain {
    public static void main(String[] args) {
        SdaHeap heap = new TreeHeap();
        heap.push(4);
        heap.push(5);
        heap.push(10);
        heap.push(1);

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

        System.out.println("-----------------Testing pop2-------------------------------------");

        TreeHeap heap2 = new TreeHeap();
        heap2.push(4);
        heap2.push(5);
        heap2.push(10);
        heap2.push(1);

        TreePrinter.coolPrint(heap2.toArray());

        Integer pop2 = heap2.pop2();
        System.out.println("heap.pop() returned: " + pop2);
        TreePrinter.coolPrint(heap2.toArray());

        pop2 = heap2.pop2();
        System.out.println("heap.pop() returned: " + pop2);
        TreePrinter.coolPrint(heap2.toArray());

        pop2 = heap2.pop2();
        System.out.println("heap.pop() returned: " + pop2);
        TreePrinter.coolPrint(heap2.toArray());

        pop2 = heap2.pop2();
        System.out.println("heap.pop() returned: " + pop2);
        TreePrinter.coolPrint(heap2.toArray());

        System.out.println("-----------------Testing size()-------------------------------------");

        TreeHeap heap3 = new TreeHeap();
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

        System.out.println("-----------------Testing heap sort---------------------------------");
        TreeHeap heap4 = new TreeHeap();
        Random random = new Random(new Date().getTime());
        for (int i = 0; i < 20; i++) {
            heap4.push(random.nextInt(10));
        }
        TreePrinter.coolPrint(heap4.toArray());

        while (heap4.size() != 0) {
            System.out.print(heap4.pop() + " ");
        }

    }
}
