package trees;

import java.util.*;

/**
 * Zaimplementuj poniższe metody operujące na drzewie binarnym.
 */
public class TreeTraverseExercises {

    /**
     * Przechodzi podane drzewo w kolejności pre-order i zwraca listę
     * elementów w kolejności takiej, w jakiej były napotkane.
     *
     * Uwaga: metodę należy zaimplementować z wykorzystaniem rekurencji.
     */
    public static List<Integer> traversePreOrder(SdaTree node) {
         List<Integer> nodes = new ArrayList<>();
         nodes.add(node.getValue());
         if (node.getLeftChild().isPresent()) {
             List<Integer> leftNodes = traversePreOrder(node.getLeftChild().get());
             nodes.addAll(leftNodes);
         }
         if (node.getRightChild().isPresent()) {
             List<Integer> rightNodes = traversePreOrder(node.getRightChild().get());
             nodes.addAll(rightNodes);
         }
         return nodes;
    }

    /**
     * Przechodzi podane drzewo w kolejności in-order i zwraca listę
     * elementów w kolejności takiej, w jakiej były napotkane.
     *
     * Uwaga: metodę należy zaimplementować z wykorzystaniem rekurencji.
     */
    public static List<Integer> traverseInOrder(SdaTree node) {
        List<Integer> nodes = new ArrayList<>();
        if (node.getLeftChild().isPresent()) {
            List<Integer> leftNodes = traverseInOrder(node.getLeftChild().get());
            nodes.addAll(leftNodes);
        }
        nodes.add(node.getValue());
        if (node.getRightChild().isPresent()) {
            List<Integer> rightNodes = traverseInOrder(node.getRightChild().get());
            nodes.addAll(rightNodes);
        }
        return nodes;
    }

    /**
     * Przechodzi podane drzewo w kolejności post-order i zwraca listę
     * elementów w kolejności takiej, w jakiej były napotkane.
     *
     * Uwaga: metodę należy zaimplementować z wykorzystaniem rekurencji.
     */
    public static List<Integer> traversePostOrder(SdaTree node) {
        List<Integer> nodes = new ArrayList<>();
        if (node.getLeftChild().isPresent()) {
            List<Integer> leftNodes = traversePostOrder(node.getLeftChild().get());
            nodes.addAll(leftNodes);
        }
        if (node.getRightChild().isPresent()) {
            List<Integer> rightNodes = traversePostOrder(node.getRightChild().get());
            nodes.addAll(rightNodes);
        }
        nodes.add(node.getValue());
        return nodes;
    }

    /**
     * Funkcja działa tak samo jak traversePreOrder.
     *
     * Uwaga: metodę należy zaimplementować z wykorzystaniem stosu (bez rekurencji).
     */
    public static List<Integer> traversePreOrderIterative(SdaTree node) {
        List<Integer> nodes = new ArrayList<>();
        Stack<SdaTree> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()) {
            SdaTree currentNode = stack.pop();
            nodes.add(currentNode.getValue());
            // this is a fancy way of using Optional
            currentNode.getRightChild().ifPresent(stack::push);
            currentNode.getLeftChild().ifPresent(stack::push);
        }
        return nodes;
    }

    /**
     * Przechodzi podane drzewo w kolejności level-order i zwraca listę
     * elementów w kolejności takiej, w jakiej były napotkane.
     *
     * Podpowiedź: implementacja jest bardzo podobna do traversePreOrderIterative,
     * ale zamiast stosu wykorzystuje inną strukturę danych.
     */
    public static List<Integer> traverseLevelOrder(SdaTree node) {
        List<Integer> nodes = new ArrayList<>();
        Queue<SdaTree> queue = new ArrayDeque<>();
        queue.offer(node);
        while(!queue.isEmpty()) {
            SdaTree currentNode = queue.poll();
            nodes.add(currentNode.getValue());
            // this is a fancy way of using Optional
            currentNode.getLeftChild().ifPresent(queue::offer);
            currentNode.getRightChild().ifPresent(queue::offer);
        }
        return nodes;
    }

    public static void coolPrint(SdaTree node) {
        Integer[] array = toArray(node);

        int maxLevel = log(array.length + 2,2);
        int width = (int) Math.pow(2, maxLevel) * 2 - 1;

        Integer[][] arr = new Integer[maxLevel+1][width];

        int currentLevel = -1;
        int baseOffset = 0;
        int betweenNodes = 0;
        for (int i = 0; i < array.length; i++) {
            int levelOfNode = log(i+1,2);

            if(levelOfNode != currentLevel) {
                currentLevel = levelOfNode;
                int childLevelCount = maxLevel - currentLevel;
                baseOffset = (int) (Math.pow(2, childLevelCount) - 1);
                betweenNodes = (int) (Math.pow(2, childLevelCount + 1) - 1);
            }

            int indexInLevel = (int) (i - Math.pow(2, levelOfNode) + 1);
            int x = baseOffset + betweenNodes * indexInLevel + indexInLevel;
            arr[levelOfNode][x] = array[i];
        }


        for (int i = 0; i < maxLevel; i++) {
            for (int j = 0; j < width; j++) {
                if(arr[i][j] != null) {
                    System.out.print(arr[i][j]);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }

    private static Integer[] toArray(SdaTree node) {
        Integer[] array = new Integer[100];
        Queue<LevelNodePair> queue = new ArrayDeque<>();
        queue.offer(new LevelNodePair(node, 0));
        while(!queue.isEmpty()) {
            LevelNodePair pair = queue.poll();
            Optional<SdaTree> optionalCurrentNode = pair.node;
            int index = pair.index;
            if(optionalCurrentNode.isPresent()) {
                SdaTree currentNode = optionalCurrentNode.get();
                array[index] = currentNode.getValue();
                Optional<SdaTree> optionalLeft = currentNode.getLeftChild();
                Optional<SdaTree> optionalRight = currentNode.getRightChild();
                if (optionalLeft.isPresent()) {
                    queue.offer(new LevelNodePair(optionalLeft.get(), 2 * index + 1));
                }
                if (optionalRight.isPresent()) {
                    queue.offer(new LevelNodePair(optionalRight.get(), 2 * index + 2));
                }
            }
        }

        int lastNonEmptyIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] != null) {
                lastNonEmptyIndex = i;
            }
        }

        Integer[] truncatedArray = Arrays.copyOf(array, lastNonEmptyIndex + 1);

        return truncatedArray;
    }

    static int log(int x, int base)
    {
        return (int) (Math.log(x) / Math.log(base));
    }

    /**
     * Funkcja zwraca liczbę liści w podanym drzewie.
     */
    public int countLeaves(SdaTree tree) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Tworzy drzewo binarne na podstawie podanego tekstu.
     *
     * Tekst zawiera tyle linijek, ile poziomów ma drzewo.
     * Każda linijka zawiera wartości węzłów na odpowiednim poziomie rozdzielone spacjami, po kolei,
     * czyli każda linijka zawiera dwa razy więcej wartości niż poprzednia.
     * Wartość "-" oznacza, że węzeł na danej pozycji nie istnieje.
     *
     * Np. drzewo ze slajdów przedstawione byłoby jako "9\n8 7\n6 5 - 4\n- - 3 2 - - 1 -",
     * czyli zapisując w wielu liniach:
     * 9
     * 8 7
     * 6 5 - 4
     * - - 3 2 - - 1 -
     *
     * Uwaga: nie należy modyfikować klas SdaTree i SdaTreeImpl.
     *
     * @throws IllegalArgumentException jeśli któraś z linijek zawiera nieprawidłową ilość wartości
     */
    public SdaTree buildTree1(String input) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    ////////////////////////////////////////////
    //                                        //
    // PONIŻEJ ZADANIA DODATKOWE DLA CHĘTNYCH //
    //                                        //
    ////////////////////////////////////////////

    /**
     * Tworzy drzewo binarne na podstawie podanego tekstu.
     *
     * Każda linijka zawiera informację o parze rodzic-dziecko.
     * Format każdej linijki wygląda następująco:
     *
     * left(rodzic)=dziecko
     *
     * lub
     *
     * right(rodzic)=dziecko
     *
     * dla lewego i prawego dziecka odpowiednio.
     *
     * Uwaga: nie należy modyfikować klas SdaTree i SdaTreeImpl.
     *
     * @throws IllegalArgumentException jeśli któraś z linijek jest niezgodna z powyższym formatem
     */
    public SdaTree buildTree2(String input) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Funkcja oblicza wysokość drzewa.
     *
     * Przypomnienie: wysokość drzewa składającego się jedynie z korzenia to 0.
     */
    public int calcHeight(SdaTree tree) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Funkcja znajduje największy element w drzewie.
     */
    public Integer findMax(SdaTree tree, Comparator<Integer> comparator) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
