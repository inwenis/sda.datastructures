import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        // declare list as LinkedList instead of SdaList to use .toCoolString()
        System.out.println("testing addLast()");
        addLastTest();

        System.out.println("testing addFirst()");
        addFirstTest();

        System.out.println("testing removeFirst()");
        removeFirstTest();

        System.out.println("testing removeLast()");
        removeLastTest();

        System.out.println("testing size()");
        sizeTest();

        System.out.println("testing get()");
        getTest();

        System.out.println("testing isEmpty()");
        isEmptyTest();

        System.out.println("testing getFirst()");
        getFirstTest();

        System.out.println("testing getLast()");
        getLastTest();

        System.out.println("testing clear()");
        clearTest();

        System.out.println("testing setAt()");
        setAtTest();

        System.out.println("testing setAt()");
        setAtTest();

        System.out.println("testing addAt()");
        addAtTest();

        System.out.println("testing removeAt()");
        removeAtTest();
    }

    private static void removeAtTest() {
        LinkedList list = new LinkedList();
        System.out.println("\t" + list.toCoolString() + " expected: empty");
        list.removeAt(0);
        list.removeAt(1);
        list.removeAt(-1);
        list.removeAt(100);
        System.out.println("\t" + list.toCoolString() + " expected: empty");
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        System.out.println("\t" + list.toCoolString() + " expected: 1,2,3,4");
        list.removeAt(0);
        System.out.println("\t" + list.toCoolString() + " expected: 2,3,4");
        list.removeAt(1);
        System.out.println("\t" + list.toCoolString() + " expected: 2,4");
    }

    private static void addAtTest() {
        LinkedList list = new LinkedList();
        list.addAt(0, 5);
        System.out.println("\t" + list.toCoolString() + " expected: 5");
        list.addAt(0, 10);
        System.out.println("\t" + list.toCoolString() + " expected: 10,5");
        list.addAt(2, 20);
        System.out.println("\t" + list.toCoolString() + " expected: 10,5,20");
        list.addAt(1, 42);
        System.out.println("\t" + list.toCoolString() + " expected: 10,42,5,20");

        try {
            list.addAt(-10, 5);
            System.out.println("the line above should throw an exception and we should not see this message, never ever.");
        } catch(IndexOutOfBoundsException e) {
            System.out.println("expected to catch IndexOutOfBoundsException, and in deed we caught it!");
            System.out.println("here is the message: " + e.getMessage() );
        }

        try {
            list.addAt(100, 5);
            System.out.println("the line above should throw an exception and we should not see this message, never ever.");
        } catch(IndexOutOfBoundsException e) {
            System.out.println("expected to catch IndexOutOfBoundsException, and in deed we caught it!");
            System.out.println("here is the message: " + e.getMessage() );
        }
    }

    private static void setAtTest() {
        LinkedList list = new LinkedList();
        list.addLast(1);
        System.out.println("\t" + list.toCoolString() + " expected: 1");
        list.setAt(0, 10);
        System.out.println("\t" + list.toCoolString() + " expected: 10");
        list.addLast(2);
        list.addLast(3);
        System.out.println("\t" + list.toCoolString() + " expected: 10,2,3");
        list.setAt(1, 42);
        System.out.println("\t" + list.toCoolString() + " expected: 10,42,3");
        try {
            list.setAt(100, 42);
            System.out.println("the line above should throw an exception and we should not see this message, never ever.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("expected to catch IndexOutOfBoundsException, and in deed we caught it!");
            System.out.println("here is the message: " + e.getMessage() );
        }

        try {
            list.setAt(-1, 42);
            System.out.println("the line above should throw an exception and we should not see this message, never ever.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("expected to catch IndexOutOfBoundsException, and in deed we caught it!");
            System.out.println("here is the message: " + e.getMessage() );
        }
    }

    private static void clearTest() {
        LinkedList list = new LinkedList();
        list.clear();
        list.addLast(5);
        list.addLast(10);
        System.out.println("\t" + list.toCoolString() + " expected 5,10");
        list.clear();
        System.out.println("\t" + list.toCoolString() + " expected empty");
    }

    private static void getFirstTest() {
        LinkedList list = new LinkedList();
        list.addLast(5);
        list.addLast(10);
        System.out.println("\t" + list.getFirst() + " expected 5");
        list.addFirst(1);
        System.out.println("\t" + list.getFirst() + " expected 1");
        LinkedList emptyList = new LinkedList();
        try {
            int first = emptyList.getFirst();
            System.out.println("the line above should throw an exception and we should not see this message, never ever.");
        } catch (NoSuchElementException e) {
            System.out.println("expected to catch NoSuchElementException, and in deed we caught it!");
            System.out.println("here is the message: " + e.getMessage() );
        }
    }

    private static void getTest() {
        LinkedList list = new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(10);
        System.out.println("\t" + list.toCoolString());
        System.out.println("\t" + list.get(0) + " expected 1");
        System.out.println("\t" + list.get(1) + " expected 2");
        System.out.println("\t" + list.get(2) + " expected 3");
        System.out.println("\t" + list.get(5) + " expected 10");
        try {
            list.get(100);
            System.out.println("the line above should throw an exception and we should not see this message, never ever.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("expected to catch IndexOutOfBoundsException, and in deed we caught it!");
            System.out.println("here is the message: " + e.getMessage() );
        }
    }

    private static void sizeTest() {
        LinkedList list = new LinkedList();
        System.out.println("\t" + list.toCoolString());
        System.out.println("\t" + list.size() + " expected: 0");
        list.addFirst(1);
        list.addFirst(2);
        System.out.println("\t" + list.toCoolString());
        System.out.println("\t" + list.size() + " expected: 2");
        list.removeLast();
        System.out.println("\t" + list.toCoolString());
        System.out.println("\t" + list.size() + " expected: 1");
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        System.out.println("\t" + list.toCoolString());
        System.out.println("\t" + list.size() + " expected: 4");
    }

    private static void removeLastTest() {
        LinkedList list = new LinkedList();
        System.out.println("\t" + list.toCoolString() + " expected: empty");
        list.removeLast();
        System.out.println("\t" + list.toCoolString() + " expected: empty");
        list.addFirst(1);
        list.addFirst(2);
        System.out.println("\t" + list.toCoolString() + " expected: 2, 1");
        list.removeLast();
        System.out.println("\t" + list.toCoolString() + " expected: 2");
        list.removeLast();
        System.out.println("\t" + list.toCoolString() + " expected: empty");
        // let's test if after removing all elements we can add elements again
        list.addFirst(10);
        System.out.println("\t" + list.toCoolString() + " expected: 10");
    }

    private static void removeFirstTest() {
        LinkedList list = new LinkedList();
        System.out.println("\t" + list.toCoolString() + " expected: empty");
        list.addFirst(1);
        list.addFirst(2);
        System.out.println("\t" + list.toCoolString() + " expected: 2, 1");
        list.removeFirst();
        System.out.println("\t" + list.toCoolString() + " expected: 1");
        list.removeFirst();
        System.out.println("\t" + list.toCoolString() + " expected: empty");
        try {
            list.removeFirst();
            System.out.println("the line above should throw an exception and we should not see this message, never ever.");
        } catch (NoSuchElementException e) {
            System.out.println("expected to catch IndexOutOfBoundsException, and in deed we caught it!");
            System.out.println("here is the message: " + e.getMessage() );
        }
    }

    private static void addFirstTest() {
        LinkedList list = new LinkedList();
        list.addFirst(1);
        System.out.println("\t" + list.toCoolString() + " expected: 1");
        list.addFirst(2);
        list.addFirst(3);
        System.out.println("\t" + list.toCoolString() + " expected: 3,2,1");
    }

    private static void addLastTest() {
        LinkedList list = new LinkedList();
        System.out.println("\t" + list.toCoolString() + " expected: empty");
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        System.out.println("\t" + list.toCoolString() + " expected: 1,2,3");
        list.addLast(4);
    }

    private static void isEmptyTest() {
        LinkedList list = new LinkedList();
        System.out.println("\t" + list.isEmpty() + " expected: true");
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        System.out.println("\t" + list.isEmpty() + " expected: false");
    }

    public static void getLastTest() {
        LinkedList list = new LinkedList();
        list.addLast(1);
        System.out.println("\t" + list.getLast() + " expected: 1");
        list.addLast(2);
        System.out.println("\t" + list.getLast() + " expected: 2");
        list.addLast(3);
        System.out.println("\t" + list.getLast() + " expected: 3");

        LinkedList emptyList = new LinkedList();
        try {
            int first = emptyList.getLast();
            System.out.println("the line above should throw an exception and we should not see this message, never ever.");
        } catch (NoSuchElementException e) {
            System.out.println("expected to catch NoSuchElementException, and in deed we caught it!");
            System.out.println("here is the message: " + e.getMessage() );
        }

    }
}
