public class LinkedList implements SdaList {

    private Node head;

    public boolean isEmpty() {
        return false;
    }

    public int size() {
        if(head == null) {
            return 0;
        } else if (head.next == null) {
            return 1;
        } else {
            int count = 1;
            Node traveler = head;
            while (traveler.next != null) {
                traveler = traveler.next;
                count++;
            }
            return count;
        }
    }

    public int getFirst() {
        return 0;
    }

    public int getLast() {
        return 0;
    }

    public int get(int index) {
        // use a private method that gets the Node at index as opposed to just the value
        //Node selected = getNodeAt(index);
        return 0;
    }

    private Node getNodeAt(int index) {
        return null;
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
        if(head == null) {
            return;
        } else if (head.next == null) {
            head = null;
            return;
        } else {
            Node traveler = head;
            // we use .next.next here cuz we need to get the "preLast" node
            while (traveler.next.next != null) {
                traveler = traveler.next;
            }
            traveler.next = null;
            return;
        }
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
