public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();

        list.insert(new ListLink<>(1, "A"));
        list.insert(new ListLink<>(2, "B"));
        list.insert(new ListLink<>(3, "C"));

        System.out.println("Before reverse: ");
        System.out.print(list);

        list.reverse();

        System.out.println("After reverse: ");
        System.out.print(list);

        System.out.println("Before reverse: ");
        System.out.print(list);

        list.reverse();

        System.out.println("After reverse: ");
        System.out.print(list);

    }
}