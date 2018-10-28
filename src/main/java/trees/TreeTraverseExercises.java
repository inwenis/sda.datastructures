package trees;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
    public List<Integer> traverseInOrder(SdaTree tree) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Przechodzi podane drzewo w kolejności post-order i zwraca listę
     * elementów w kolejności takiej, w jakiej były napotkane.
     *
     * Uwaga: metodę należy zaimplementować z wykorzystaniem rekurencji.
     */
    public List<Integer> traversePostOrder(SdaTree tree) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Funkcja działa tak samo jak traversePreOrder.
     *
     * Uwaga: metodę należy zaimplementować z wykorzystaniem stosu (bez rekurencji).
     */
    public  List<Integer> traversePreOrderIterative(SdaTree tree) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Przechodzi podane drzewo w kolejności level-order i zwraca listę
     * elementów w kolejności takiej, w jakiej były napotkane.
     *
     * Podpowiedź: implementacja jest bardzo podobna do traversePreOrderIterative,
     * ale zamiast stosu wykorzystuje inną strukturę danych.
     */
    public  List<Integer> traverseLevelOrder(SdaTree tree) {
        throw new UnsupportedOperationException("Not implemented yet");
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
