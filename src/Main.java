public class Main {
    public static void main(String[] args) {
        MyArray<String> myArray = new MyArray<>();

        //add elements
        myArray.insert(new ArrayElement<>(0, "A"));
        myArray.insert(new ArrayElement<>(1, "B"));
        myArray.insert(new ArrayElement<>(2, "C"));
        myArray.insert(new ArrayElement<>(3, "D"));

        System.out.println("Before reverse: ");
        System.out.print(myArray);

        myArray.reverse();

        System.out.println("After reverse: ");
        System.out.print(myArray);
    }
}