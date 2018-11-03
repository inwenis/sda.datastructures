package bst;

import heap.TreeHeap;

import java.util.Arrays;
import java.util.List;

public class BstTree implements SdaBst {

    Node root;

    @Override
    public void insert(Integer element) {
        Node newNode = new Node(element);
        if(root == null) {
            root = newNode;
        } else {
            Node traveler = root;
            while (true) {
                if (element <= traveler.value && traveler.left == null) {
                    traveler.left = newNode;
                    break;
                } else if (element <= traveler.value && traveler.left != null) {
                    traveler = traveler.left;
                } else if (element > traveler.value && traveler.right == null) {
                    traveler.right = newNode;
                    break;
                } else if (element > traveler.value && traveler.right != null) {
                    traveler = traveler.right;
                }
            }
        }
    }

    @Override
    public boolean contains(Integer element) {
        return false;
    }

    @Override
    public void delete(Integer element) {

    }

    @Override
    public List<Integer> toList() {
        return null;
    }

    class Node {
        Node left;
        Node right;
        Integer value;

        public Node(Integer value) {
            this.value = value;
        }
    }

    public Integer[] toArray() {
        Integer[] array = new Integer[100];
        if(root != null) {
            add(array, root, 0);
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

    private void add(Integer[] array, Node node, int index) {
        if (node != null) {
            array[index] = node.value;
            add(array, node.left, index * 2 + 1);
            add(array, node.right, index * 2 + 2);
        }
    }
}
