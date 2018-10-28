package linkedList;

public interface SdaList {

    /**
     * Zwraca true jeśli lista jest pusta.
     */
    boolean isEmpty();

    /**
     * Zwraca rozmiar listy (ilość elementów).
     */
    int size();

    /**
     * Zwraca pierwszy element listy.
     *
     * @throws NoSuchElementException jeśli lista jest pusta
     */
    int getFirst();

    /**
     * Zwraca ostatni element listy.
     *
     * @throws NoSuchElementException jeśli lista jest pusta
     */
    int getLast();

    /**
     * Pobiera element listy pod podanym indeksem.
     *
     * @throws IndexOutOfBoundsException jeśli indeks leży poza zakresem listy
     */
    int get(int index);

    /**
     * Usuwa wszystkie elementy z listy.
     */
    void clear();

    /**
     * Dodaje nowy element na początku listy.
     */
    void addFirst(int element);

    /**
     * Dodaje nowy element na końcu listy.
     */
    void addLast(int element);

    /**
     * Usuwa pierwszy element listy.
     *
     * @throws NoSuchElementException jeśli lista jest pusta
     */
    void removeFirst();

    /**
     * Usuwa ostatni element listy.
     *
     * @throws NoSuchElementException jeśli lista jest pusta
     */
    void removeLast();

    /**
     * Zamienia element pod podanym indeksem.
     *
     * @throws NoSuchElementException jeśli element o podanym indeksie nie istnieje
     */
    void setAt(int index, int element);

    /**
     * Dodaje nowy element pod wskazanym indeksem.
     *
     * @throws IndexOutOfBoundsException jeśli indeks leży poza zakresem listy
     */
    void addAt(int index, int element);

    /**
     * Usuwa element pod wskazanym indeksem.
     *
     * @throws IndexOutOfBoundsException jeśli indeks leży poza zakresem listy
     */
    void removeAt(int index);
}