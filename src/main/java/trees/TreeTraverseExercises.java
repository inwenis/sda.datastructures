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

    /**
     * Funkcja zwraca liczbę liści w podanym drzewie.
     */
    public static int countLeaves(SdaTree node) {
        if(isLeaf(node)) {
            return 1;
        } else {
            int count = 0;
            if (node.getLeftChild().isPresent()) {
                count += countLeaves(node.getLeftChild().get());
            }
            if (node.getRightChild().isPresent()) {
                count += countLeaves(node.getRightChild().get());
            }
            return count;
        }
    }

    private static boolean isLeaf(SdaTree node) {
        boolean noChildOnLeft = !node.getLeftChild().isPresent();
        boolean noChildOnRight = !node.getRightChild().isPresent();
        return noChildOnLeft && noChildOnRight;
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
    public static SdaTree buildTree1(String input) {
        String[][] levels = Arrays.stream(input.split("\n"))
                .map(line -> line.split("\\s+"))
                .toArray(String[][]::new);
        validate(levels);
        Queue<Optional<SdaTree>> queue = new ArrayDeque<>();
        Integer rootValue = Integer.parseInt(levels[0][0]);
        SdaTreeImpl root = new SdaTreeImpl(rootValue, null, null);
        queue.offer(Optional.of(root));

        // skip first line as it's already processed
        for (int i = 1; i < levels.length; i++) {
            String[] level = levels[i];
            for (int j = 0; j < level.length; j+=2) {
                Optional<SdaTree> parent = queue.poll();
                String leftValue = level[j];
                String rightValue = level[j+1];
                if (!leftValue.equals("-")) {
                    Integer parsedValue = Integer.parseInt(leftValue);
                    SdaTreeImpl node = new SdaTreeImpl(parsedValue, null, null);
                    parent.get().setLeftChild(node);
                    queue.offer(Optional.of(node));
                } else {
                    queue.offer(Optional.empty());
                }
                if (!rightValue.equals("-")) {
                    Integer parsedValue = Integer.parseInt(rightValue);
                    SdaTreeImpl node = new SdaTreeImpl(parsedValue, null, null);
                    parent.get().setRightChild(node);
                    queue.offer(Optional.of(node));
                }  else {
                    queue.offer(Optional.empty());
                }
            }
        }
        return root;
    }

    private static void validate(String[][] levels) {
        for (int i = 0; i < levels.length; i++) {
            String[] level = levels[i];
            int expectedNodesCount = 1 << i; // the same as Math.pow(2, i)
            if (level.length != expectedNodesCount) {
                throw new IllegalArgumentException("Expected " + expectedNodesCount + " nodes on line " + i + " but got " + level.length);
            }
        }
    }

    public static SdaTree buildTree1_reverse(String input) {
        String[][] levels = Arrays.stream(input.split("\n"))
                .map(line -> line.split("\\s+"))
                .toArray(String[][]::new);
        validate(levels);
        Queue<Optional<SdaTree>> queue = new ArrayDeque<>();

        int leavesCount = (int) Math.pow(2, levels.length);
        for (int i = 0; i < leavesCount; i++) {
            queue.offer(Optional.empty());
        }

        for (int i = levels.length - 1; i >= 0; i--) {
            String[] level = levels[i];
            for (String value : level) {
                Optional<SdaTree> leftOptional = queue.poll();
                Optional<SdaTree> rightOptional = queue.poll();

                SdaTree left = leftOptional.orElse(null);
                SdaTree right = rightOptional.orElse(null);

                if (value.equals("-")) {
                    queue.offer(Optional.empty());
                } else {
                    int parsed = Integer.parseInt(value);
                    queue.offer(Optional.of(new SdaTreeImpl(parsed, left, right)));
                }
            }
        }

        Optional<SdaTree> root = queue.poll();
        return root.orElse(null);
    }

    public static SdaTree buildTree1_recursive(String input) {
        String[][] levels = Arrays.stream(input.split("\n"))
                .map(line -> line.split("\\s+"))
                .toArray(String[][]::new);
        validate(levels);

        return buildTree1_recursive(levels, 0, 0);
    }

    private static SdaTree buildTree1_recursive(String[][] levels, int level, int offset) {
        if(level >= levels.length || levels[level][offset].equals("-")) {
            return null;
        }

        Integer value = Integer.parseInt(levels[level][offset]);
        return SdaTree.of(value,
                buildTree1_recursive(levels, level + 1, offset * 2),
                buildTree1_recursive(levels, level + 1, offset * 2 + 1));
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
