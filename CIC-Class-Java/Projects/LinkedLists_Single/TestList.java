public class TestList{
    public static void main(String[] args) {
        String[] hi = {"a", "b", "c"};
        SinglyLinkedList a = new SinglyLinkedList(hi);
        System.out.println(a);
        a.add("d");
        a.add("e");
        a.add("f");
        a.add("g");
        a.add("h");
        a.add("i");
        a.add("j");
        a.add("k");
        a.remove("g");
        System.out.println(a);
        a.insertInOrder("g");
        System.out.println(a);
        a.rotate();
        System.out.println(a);
    }
}