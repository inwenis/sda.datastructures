package heap;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;

public class ArrayHeap implements SdaHeap {
    private final Integer[] array;

    public ArrayHeap() {
        array = new Integer[100];
    }

    @Override
    // complexity wise this implementation is not optimal - insertions are O(n)
    // inserting element as the last element and swapping it with parent if necessary would be O(log n)
    public void push(Integer element) throws NotImplementedException {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = element;
                break;
            }
            if(element > array[i]) {
                shiftRight(array, i);
                array[i] = element;
                break;
            }
        }
    }

    private void shiftRight(Integer[] array, int i) {
        for (int j = array.length - 1; j > i ; j--) {
            array[j] = array[j-1];
        }
    }

    @Override
    public Integer pop() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Integer[] toArray() {
        int lastNonEmptyIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] != null) {
                lastNonEmptyIndex = i;
            }
        }

        Integer[] truncatedArray = Arrays.copyOf(array, lastNonEmptyIndex + 1);
        return truncatedArray;
    }
}
