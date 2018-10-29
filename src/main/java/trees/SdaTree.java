package trees;

import java.util.Optional;

public interface SdaTree {

    /**
     * Tworzy nowe drzewo z korzeniem o podanej wartości oraz danych poddrzewach.
     */
    static SdaTree of(Integer value, SdaTree left, SdaTree right) {
        return new SdaTreeImpl(value, left, right);
    }

    /**
     * Tworzy nowy liść drzewa (węzeł bez dzieci).
     */
    static SdaTree leaf(Integer value) {
        return new SdaTreeImpl(value, null, null);
    }

    /**
     * Zwraca wartość tego węzła.
     */
    Integer getValue();

    /**
     * Zwraca lewe poddrzewo.
     */
    Optional<SdaTree> getLeftChild();

    /**
     * Zwraca prawe poddrzewo.
     */
    Optional<SdaTree> getRightChild();

    void setLeftChild(SdaTree value);

    void setRightChild(SdaTree value);
}