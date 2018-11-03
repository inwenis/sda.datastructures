package bst;

import trees.TreePrinter;

public class Main {
    public static void main(String[] args) {
        SdaBst bst = new BstTree();

        bst.insert(1);
        bst.insert(2);
        bst.insert(9);
        bst.insert(8);
        bst.insert(1);
        bst.insert(5);
        bst.insert(4);
        bst.insert(7);

        // cast to BstTree so we can access toArray() method which is not in the SdaBst interface
        TreePrinter.coolPrint(((BstTree) bst).toArray());

        System.out.println("bst.contains(1)=" + bst.contains(1));
        System.out.println("bst.contains(2)=" + bst.contains(2));
        System.out.println("bst.contains(100)=" + bst.contains(100));
        System.out.println("bst.contains(9)=" + bst.contains(9));
        System.out.println("bst.contains(0)=" + bst.contains(0));

        System.out.println("-------------------- Testing delete ---------------------------");
        bst = new BstTree();
        bst.insert(1);
        System.out.println("before delete:");
        TreePrinter.coolPrint(((BstTree) bst).toArray());
        bst.delete(1);
        System.out.println("after delete:");
        TreePrinter.coolPrint(((BstTree) bst).toArray());

        bst = new BstTree();
        bst.insert(1);
        bst.insert(2);
        System.out.println("before delete:");
        TreePrinter.coolPrint(((BstTree) bst).toArray());
        bst.delete(1);
        System.out.println("after delete:");
        TreePrinter.coolPrint(((BstTree) bst).toArray());

        bst = new BstTree();
        bst.insert(1);
        bst.insert(2);
        bst.insert(3);
        System.out.println("before delete:");
        TreePrinter.coolPrint(((BstTree) bst).toArray());
        bst.delete(1);
        System.out.println("after delete:");
        TreePrinter.coolPrint(((BstTree) bst).toArray());

        bst = new BstTree();
        bst.insert(1);
        bst.insert(2);
        bst.insert(0);
        System.out.println("before delete:");
        TreePrinter.coolPrint(((BstTree) bst).toArray());
        bst.delete(1);
        System.out.println("after delete:");
        TreePrinter.coolPrint(((BstTree) bst).toArray());

        bst = new BstTree();
        bst.insert(1);
        bst.insert(3);
        bst.insert(0);
        bst.insert(2);
        bst.insert(5);
        System.out.println("before delete:");
        TreePrinter.coolPrint(((BstTree) bst).toArray());
        bst.delete(1);
        System.out.println("after delete:");
        TreePrinter.coolPrint(((BstTree) bst).toArray());

        bst = new BstTree();
        bst.insert(1);
        bst.insert(3);
        bst.insert(0);
        bst.insert(2);
        bst.insert(5);
        System.out.println("before delete:");
        TreePrinter.coolPrint(((BstTree) bst).toArray());
        bst.delete(0);
        System.out.println("after delete:");
        TreePrinter.coolPrint(((BstTree) bst).toArray());

        bst = new BstTree();
        bst.insert(1);
        bst.insert(3);
        bst.insert(0);
        bst.insert(2);
        bst.insert(5);
        bst.insert(4);
        System.out.println("before delete:");
        TreePrinter.coolPrint(((BstTree) bst).toArray());
        bst.delete(5);
        System.out.println("after delete:");
        TreePrinter.coolPrint(((BstTree) bst).toArray());

        bst = new BstTree();
        bst.insert(1);
        bst.insert(3);
        bst.insert(0);
        bst.insert(2);
        bst.insert(5);
        bst.insert(9);
        System.out.println("before delete:");
        TreePrinter.coolPrint(((BstTree) bst).toArray());
        bst.delete(5);
        System.out.println("after delete:");
        TreePrinter.coolPrint(((BstTree) bst).toArray());

        bst = new BstTree();
        bst.insert(1);
        bst.insert(3);
        bst.insert(0);
        bst.insert(2);
        bst.insert(5);
        bst.insert(9);
        System.out.println("before delete:");
        TreePrinter.coolPrint(((BstTree) bst).toArray());
        bst.delete(3);
        System.out.println("after delete:");
        TreePrinter.coolPrint(((BstTree) bst).toArray());
    }
}
