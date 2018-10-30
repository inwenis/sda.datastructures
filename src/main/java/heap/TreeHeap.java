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
            Node newRoot;
            // change so that we only move values with out moving nodes
            if (root.left == null && root.right == null) {
                root = null;
                return root.value;
            } else if(root.left == null && root.right != null) {
                newRoot = pop(root.right);
            } else if (root.left != null && root.right == null) {
                newRoot = pop(root.left);
            } else if(root.left.value >= root.right.value) {
                newRoot = pop(root.left);
            } else {
                newRoot = pop(root.right);
            }
            newRoot.left = root.left;
            newRoot.right = root.right;
            if(newRoot.left!=null)newRoot.left.parent = newRoot;
            if(newRoot.right!=null)newRoot.right.parent = newRoot;
            root = newRoot;
            return temp.value;
        }
    }

    private Node pop(Node node) {
        Node replacement;
        if(node.left == null && node.right == null) {

            if(node.parent.left == node) {
                node.parent.left = null;
            } else {
                node.parent.right = null;
            }


            return node;
        } else if (node.left != null && node.right == null) {
            replacement = pop(node.left);
        } else if (node.left == null && node.right != null) {
            replacement = pop(node.right);
        } else if (node.left.value >= node.right.value) {
            replacement = pop(node.left);
        } else {
            replacement = pop(node.right);
        }
        replacement.parent = node.parent;
        if(node.parent.left == node) {
            node.parent.left = replacement;
        } else {
            node.parent.right = replacement;
        }
        replacement.left = node.left;
        replacement.right = node.right;
        if(replacement.left != null) {
            replacement.left.parent = replacement;
        }
        if(replacement.right != null) {
            replacement.right.parent = replacement;
        }
        node.left = null;
        node.right = null;
        node.parent = null;
        return node;
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
