package heap;

import trees.TreePrinter;

public class ArrayHeapMain {
    public static void main(String[] args) {
        SdaHeap heap = new ArrayHeap();
        heap.push(4);
        heap.push(5);
        heap.push(10);
        heap.push(1);

        TreePrinter.coolPrint(heap.toArray());

//        System.out.println("-----------------Testing pop-------------------------------------");
//
//        Integer pop = heap.pop();
//        System.out.println("heap.pop() returned: " + pop);
//        TreePrinter.coolPrint(heap.toArray());
//
//        pop = heap.pop();
//        System.out.println("heap.pop() returned: " + pop);
//        TreePrinter.coolPrint(heap.toArray());
//
//        pop = heap.pop();
//        System.out.println("heap.pop() returned: " + pop);
//        TreePrinter.coolPrint(heap.toArray());
//
//        pop = heap.pop();
//        System.out.println("heap.pop() returned: " + pop);
//        TreePrinter.coolPrint(heap.toArray());
//
//        System.out.println("-----------------Testing pop2-------------------------------------");
//
//        TreeHeap heap2 = new TreeHeap();
//        heap2.push(4);
//        heap2.push(5);
//        heap2.push(10);
//        heap2.push(1);
//
//        TreePrinter.coolPrint(heap2.toArray());
//
//        Integer pop2 = heap2.pop2();
//        System.out.println("heap.pop() returned: " + pop2);
//        TreePrinter.coolPrint(heap2.toArray());
//
//        pop2 = heap2.pop2();
//        System.out.println("heap.pop() returned: " + pop2);
//        TreePrinter.coolPrint(heap2.toArray());
//
//        pop2 = heap2.pop2();
//        System.out.println("heap.pop() returned: " + pop2);
//        TreePrinter.coolPrint(heap2.toArray());
//
//        pop2 = heap2.pop2();
//        System.out.println("heap.pop() returned: " + pop2);
//        TreePrinter.coolPrint(heap2.toArray());
//
//        System.out.println("-----------------Testing size()-------------------------------------");
//
//        TreeHeap heap3 = new TreeHeap();
//        System.out.println(heap3.size());
//        heap3.push(1);
//        System.out.println(heap3.size());
//        heap3.push(12);
//        System.out.println(heap3.size());
//        heap3.push(13);
//        System.out.println(heap3.size());
//        heap3.push(100);
//        System.out.println(heap3.size());
//        heap3.push(15);
//        TreePrinter.coolPrint(heap3.toArray());

    }
}
