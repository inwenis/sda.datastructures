package trees;

import java.util.List;

public class Main {
    public static void main(String[] args) {
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
    }
}
