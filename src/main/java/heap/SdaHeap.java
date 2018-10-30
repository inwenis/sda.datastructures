package heap;

public interface SdaHeap {

    /**
     * Dodaje nowy element do kopca. Po dodaniu elementu do tablicy, własność kopca musi zostać zachowana.
     *
     * @throws IllegalStateException jeśli kopiec jest pełny
     */
    void push(Integer element);

    /**
     * Usuwa z kopca i zwraca element o najwyższej wartości.
     *
     * @throws NoSuchElementException jeśli kopiec jest pusty
     */
    Integer pop();

    /**
     * Zwraca ilość elementów na kopcu.
     */
    int size();

    /**
     * Zwraca tablicę zawierającą elementy kopca.
     */
    Integer[] toArray();
}