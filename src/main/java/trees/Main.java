package trees;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SdaTree exampleTree =
                SdaTree.of(8,
                        SdaTree.of(9,
                                SdaTree.leaf(1),
                                SdaTree.of(2,
                                        SdaTree.leaf(3),
                                        SdaTree.leaf(4))),
                        SdaTree.of(5,
                                null,
                                SdaTree.of(6,
                                        SdaTree.leaf(7),
                                        null)));
        System.out.println("pre order");
        List<Integer> nodes = TreeTraverseExercises.traversePreOrder(exampleTree);
        for (Integer n : nodes) {
            System.out.print(n + " ");
        }
        System.out.println();
        System.out.println();

        System.out.println("pre order iterative");
        List<Integer> nodesPreOrderIterative = TreeTraverseExercises.traversePreOrderIterative(exampleTree);
        for (Integer n : nodesPreOrderIterative) {
            System.out.print(n + " ");
        }
        System.out.println();
        System.out.println();

        System.out.println("in order iterative");
        List<Integer> nodesInOrder = TreeTraverseExercises.traverseInOrder(exampleTree);
        for (Integer n : nodesInOrder) {
            System.out.print(n + " ");
        }
        System.out.println();
        System.out.println();

        System.out.println("post order iterative");
        List<Integer> nodesPostOrder = TreeTraverseExercises.traversePostOrder(exampleTree);
        for (Integer n : nodesPostOrder) {
            System.out.print(n + " ");
        }
        System.out.println();
        System.out.println();


        System.out.println("level order iterative");
        List<Integer> nodesLevelOrder = TreeTraverseExercises.traverseLevelOrder(exampleTree);
        for (Integer n : nodesLevelOrder) {
            System.out.print(n + " ");
        }
        System.out.println();
        System.out.println();

        TreePrinter.coolPrint(exampleTree);
        System.out.println();
        SdaTree exampleTree2 =
                SdaTree.of(8,
                        SdaTree.leaf(9),
                        SdaTree.leaf(5));

        TreePrinter.coolPrint(exampleTree2);

        int i = TreeTraverseExercises.countLeaves(exampleTree);
        System.out.println("expected to be 4");
        System.out.println("actual " + i);

        SdaTree treeFromString = TreeTraverseExercises
                .buildTree1("9\n8 7\n6 5 - 4\n- - 3 2 - - 1 -");

        TreePrinter.coolPrint(treeFromString);

        treeFromString = TreeTraverseExercises
                .buildTree1("9\n8 1\n8 - - 1\n- - - - - - - 1");

        TreePrinter.coolPrint(treeFromString);

        treeFromString = TreeTraverseExercises
                .buildTree1_reverse("9\n8 1\n8 - - 1\n- - - - - - - 1");

        TreePrinter.coolPrint(treeFromString);

        treeFromString = TreeTraverseExercises
                .buildTree1_reverse("9\n8 7\n6 5 - 4\n- - 3 2 - - 1 -");

        TreePrinter.coolPrint(treeFromString);

        try {
            // test with invalid input
            treeFromString = TreeTraverseExercises
                    .buildTree1("9\n8\n");
        } catch (IllegalArgumentException e) {
            System.out.println("below you should see an exception which is intentional");
            Thread.sleep(500);
            e.printStackTrace();
            Thread.sleep(500);
        }

        treeFromString = TreeTraverseExercises
                .buildTree1_recursive("9\n8 7\n6 5 - 4\n- - 3 2 - - 1 -");

        TreePrinter.coolPrint(treeFromString);
    }
}
