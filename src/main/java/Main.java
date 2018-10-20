public class Main {
    public static void main(String[] args) {
        // declare list as LinkedList instead of SdaList to use .toCoolString()
        LinkedList list = new LinkedList();
        System.out.println(list.toCoolString());
        list.addLast(1);
        System.out.println(list.toCoolString());
        list.addLast(2);
        System.out.println(list.toCoolString());
        list.addLast(3);
        System.out.println(list.toCoolString());
        list.addLast(4);

    }
}
