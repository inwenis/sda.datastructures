public class LinkedList implements SdaList {

    private Node head;

    public boolean isEmpty() {
        return false;
    }

    public int size() {
        return 0;
    }

    public int getFirst() {
        return 0;
    }

    public int getLast() {
        return 0;
    }

    public int get(int index) {
        return 0;
    }

    public void clear() {

    }

    public void addFirst(int element) {
        if(head == null) {
            head = new Node(element);
        } else {
            Node newHead = new Node(element);
            newHead.next = head;
            head = newHead;
        }
    }

    public void addLast(int element) {
        if (head == null) {
            head = new Node(element);
        } else {
            Node traveler = head;
            while (traveler.next != null) {
                traveler = traveler.next;
            }
            traveler.next = new Node(element);
        }
    }

    public void removeFirst() {
        if(head == null) {
            return;
        } else {
            head = head.next;
        }
    }

    public void removeLast() {

    }

    public void setAt(int index, int element) {

    }

    public void addAt(int index, int element) {

    }

    public void removeAt(int index) {

    }

    public String toCoolString() {
        if(head == null) {
            return "empty";
        } else {
            String listAsString = "";
            Node travler = head;
            do {
                listAsString += travler.value + " -> ";
                listAsString += travler.next == null ? "null" : "";
                travler = travler.next;
            } while(travler != null);
            return listAsString;
        }
    }

    class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
