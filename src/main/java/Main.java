public class Main {
    public static void main(String[] args) {
        // declare list as LinkedList instead of SdaList to use .toCoolString()
        LinkedList list = new LinkedList();
        System.out.println(list.toCoolString() + " expected: empty");
        list.addLast(1);
        System.out.println(list.toCoolString() + " expected: 1");
        list.addLast(2);
        System.out.println(list.toCoolString() + " expected: 1,2");
        list.addLast(3);
        System.out.println(list.toCoolString() + " expected: 1,2,3");
        list.addLast(4);


        LinkedList list2 = new LinkedList();
        list2.addFirst(1);
        System.out.println(list2.toCoolString() + " expected: 1");
        list2.addFirst(2);
        System.out.println(list2.toCoolString() + " expected: 2,1");
        list2.addFirst(3);
        System.out.println(list2.toCoolString() + " expected: 3,2,1");

    }
}
