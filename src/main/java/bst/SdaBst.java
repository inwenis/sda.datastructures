package bst;

import java.util.List;

public interface SdaBst {

    /**
     * Wstawia nowy element do drzewa BST.
     *
     * Jeśli element o takiej samej wartości już znajduje się w drzewie,
     * zostaje zastąpiony przez nowy element.
     */
    void insert(Integer element);

    /**
     * Zwraca true, jeśli podany element znajduje się w drzewie.
     *
     * Uwaga: elementy należy porównywać poprzez .compareTo(..), nie .equals(..).
     */
    boolean contains(Integer element);

    /**
     * Usuwa element z drzewa BST (jeśli taki istnieje).
     *
     * Podpowiedź: należy rozpatrzyć trzy przypadki:
     * - usuwany węzeł nie ma dzieci
     * - usuwany węzeł ma jedno dziecko
     * - usuwany węzeł ma dwoje dzieci
     *
     * Uwaga: zauważ, że nasza implementacja Node nie przechowuje referencji na rodzica (parent),
     * więc nie każde rozwiazanie znalezione w Internecie się dla nas nadaje.
     *
     * Podpowiedź: ta stronka może się tutaj bardziej przydać niż Wikipedia:
     * https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/
     */
    void delete(Integer element);

    /**
     * Zwraca listę zawierającą wszystkie elementy, posortowane.
     */
    List<Integer> toList();
}