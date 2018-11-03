package bst;

import java.util.Arrays;
import java.util.List;

public class BstTree implements SdaBst {

    private Node root;

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
        Node traveler = root;
        traveler = getNodeWithValue(element, traveler);
        return traveler != null;
    }

    @Override
    public void delete(Integer element) {

        Node nodeToBeRemoved = getNodeWithValue(element, root);

        if (nodeToBeRemoved == null) {
          return;
        } else if (nodeToBeRemoved == root) {
            if (isLeaf(root)) {
                root = null;
                return;
            } else if (root.left != null && root.right == null) {
                root = root.left;
            } else if (root.left == null && root.right != null) {
                root = root.right;
            } else {
                Node parent = root;
                Node traveler = root.right;
                while (traveler.left != null ) {
                    parent = traveler;
                    traveler = traveler.left;
                }
                Node replacement = traveler;
                root.value = replacement.value;
                if(isLeftChild(replacement, parent)) {
                    parent.left = replacement.right;
                } else {
                    parent.right = replacement.right;
                }
            }
        }
    }

    private Node getNodeWithValue(Integer element, Node startFrom) {
        while (startFrom != null && !startFrom.value.equals(element)) {
            if (element <= startFrom.value) {
                startFrom = startFrom.left;
            } else {
                startFrom = startFrom.right;
            }
        }
        return startFrom;
    }

    private boolean isLeftChild(Node child, Node parent) {
        return child != root && parent.left == child;
    }

    private boolean isLeaf(Node traveler) {
        return traveler.left == null && traveler.right == null;
    }

    @Override
    public List<Integer> toList() {
        return null;
    }

    class Node {
        Node left;
        Node right;
        Integer value;

        Node(Integer value) {
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
