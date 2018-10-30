package heap;

public class TreeHeap implements SdaHeap {

    Node root;

    @Override
    public void push(Integer element) {
        if(root == null) {
            root = new Node(element);
        }
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
