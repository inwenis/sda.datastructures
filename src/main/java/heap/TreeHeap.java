package heap;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreeHeap implements SdaHeap {

    Node root;

    @Override
    public void push(Integer element) {
        if(root == null) {
            root = new Node(element);
        }
        Node parent = findFreeNode();
        if(parent.left == null) {
            parent.left = new Node(element);
        } else {
            parent.right = new Node(element);
        }

        //repairTree();
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
        return new Integer[0];
    }

    class Node {
        Integer value;
        Node left;
        Node right;

        public Node(Integer value) {
            this.value = value;
        }
    }
}
