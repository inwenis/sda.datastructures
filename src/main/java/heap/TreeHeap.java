package heap;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class TreeHeap implements SdaHeap {

    Node root;

    @Override
    public void push(Integer element) {
        if(root == null) {
            root = new Node(element);
        }
        else {
            Node parent = findFreeNode();
            Node newNode = new Node(element);
            newNode.parent = parent;
            if(parent.left == null) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }
            repairHeap(newNode);
        }
    }

    private void repairHeap(Node node) {
        if(node != root && node.value > node.parent.value) {
            swap(node, node.parent);
            repairHeap(node.parent);
        }
    }

    private void swap(Node node, Node parent) {
        Integer temp = node.value;
        node.value = parent.value;
        parent.value = temp;
    }

    private Node findFreeNode() {
        Queue<Node> toVisit = new ArrayDeque<>();
        toVisit.offer(root);

        Node node = null;
        while (!toVisit.isEmpty()) {
            node = toVisit.poll();
            if(node.left == null || node.right == null) {
                break;
            } else {
                toVisit.offer(node.left);
                toVisit.offer(node.right);
            }
        }

        return node;
    }

    @Override
    public Integer pop() {
        if(root == null) {
            return null;
        } else {
            Node temp = this.root;
            root = null;
            return temp.value;
        }
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Integer[] toArray() {
        Integer[] array = new Integer[100];
        if(root != null) {
            array[0] = root.value;
            add(array, root.left, 1);
            add(array, root.right, 2);
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

    class Node {
        Integer value;
        Node parent;
        Node left;
        Node right;

        public Node(Integer value) {
            this.value = value;
        }
    }
}
