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
    }
}
