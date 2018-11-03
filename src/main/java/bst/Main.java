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
    }
}
