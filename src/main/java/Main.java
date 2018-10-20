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
    }

    private static void getFirstTest() {
        LinkedList list = new LinkedList();
        list.addLast(5);
        list.addLast(10);
        System.out.println("\t" + list.getFirst() + " expected 5");
        list.addFirst(1);
        System.out.println("\t" + list.getFirst() + " expected 1");
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
        System.out.println("\t" + list.get(100) + " expected -1");
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
        list.removeFirst();
        System.out.println("\t" + list.toCoolString() + " expected: empty");
        list.addFirst(1);
        list.addFirst(2);
        System.out.println("\t" + list.toCoolString() + " expected: 2, 1");
        list.removeFirst();
        System.out.println("\t" + list.toCoolString() + " expected: 1");
        list.removeFirst();
        System.out.println("\t" + list.toCoolString() + " expected: empty");
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
}
