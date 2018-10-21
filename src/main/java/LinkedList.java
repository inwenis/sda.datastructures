import java.util.NoSuchElementException;
import java.util.Optional;

public class LinkedList implements SdaList {

    private Node head;

    public boolean isEmpty() {
        return size() == 0;
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
        if(head == null) {
            throw new NoSuchElementException("You can not get the first element from an empty list.");
        } else {
            return head.value;
        }
    }

    public int getLast() {
        Optional<Node> optionalLast = getNodeAt(size() - 1);
        if (optionalLast.isPresent()) {
            return optionalLast.get().value;
        } else {
            throw new NoSuchElementException("You can not get the last element from an empty list.");
        }
    }

    public int get(int index) {
        // use a private method that gets the Node at index as opposed to just the value
        Optional<Node> selected = getNodeAt(index);
        if (selected.isPresent()) {
            Node node = selected.get();
            return node.value;
        }
        else {
            String message = "an element with index: " + index + " could not be found in the list. size() = " + size();
            throw new IndexOutOfBoundsException(message);
        }
    }

    private Optional<Node> getNodeAt(int index) {
        if (index < 0) {
            return Optional.empty();
        } else if(index > size() - 1) {
            return Optional.empty();
        } else {
            int currentTravelerIndex = 0;
            Node traveler = head;
            while (currentTravelerIndex != index) {
                traveler = traveler.next;
                currentTravelerIndex++;
            }
            return Optional.of(traveler);
        }
    }

    public void clear() {
        head = null;
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
            Node last = getNodeAt(size() - 1).get();
            last.next = new Node(element);
        }
    }

    public void removeFirst() {
        if(head == null) {
            throw new NoSuchElementException("Can not remove first element from an empty list.");
        } else {
            head = head.next;
        }
    }

    public void removeLast() {
        if(head == null) {
            throw new NoSuchElementException("Can not remove last element from an empty list.");
        } else if (head.next == null) {
            head = null;
            return;
        } else {
            Node preLast = getNodeAt(size() - 2).get();
            preLast.next = null;
            return;
        }
    }

    public void setAt(int index, int element) {
        Optional<Node> nodeOptional = getNodeAt(index);
        if (nodeOptional.isPresent()) {
            nodeOptional.get().value = element;
        } else {
            String message = "an element with index: " + index + " could not be found in the list. size() = " + size();
            throw new IndexOutOfBoundsException(message);
        }
    }

    public void addAt(int index, int element) {
        if (index < 0) {
            String message = "Can not add element at negative index " + index;
            throw new IndexOutOfBoundsException(message);
        }
        if (index > size()) {
            String message = "Can not add element at index " + index +
                        " as there is no predecessor for it. size() = " + size();
            throw new IndexOutOfBoundsException(message);
        }

        if (index == 0) {
            addFirst(element);
        } else if (index == size() - 1) {
            addLast(element);
        } else {
            Node left = getNodeAt(index - 1).get();
            Node right = left.next;
            Node newNode = new Node(element);
            left.next = newNode;
            newNode.next = right;
        }
    }

    public void removeAt(int index) {
        Optional<Node> optionalPrevious = getNodeAt(index - 1);
        Optional<Node> optionNext = getNodeAt(index + 1);
        if(optionalPrevious.isPresent() && optionNext.isPresent()) {
            // removing from middle of list
            Node previous = optionalPrevious.get();
            Node next = optionNext.get();
            previous.next = next;
        } else if (optionalPrevious.isPresent()) {
            removeLast();
        } else if (optionNext.isPresent()) {
            removeFirst();
        }
    }

    public String toCoolString() {
        if(head == null) {
            return "empty";
        } else {
            String listAsString = "";
            for (int i = 0; i < size(); i++) {
                listAsString += get(i) + " -> ";
            }
            listAsString += "null";
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
