public class Main {
    public static void main(String[] args) {
        MySecondDataStructure ds = new MySecondDataStructure(100);

        Product p1 = new Product(101, 2, 50, "Item A");
        Product p2 = new Product(102, 5, 80, "Item B");
        Product p3 = new Product(103, 3, 60, "Item C");
        Product p4 = new Product(104, 1, 100, "Item D");

        ds.insert(p1);
        ds.insert(p2);
        ds.insert(p3);
        ds.insert(p4);

        System.out.println("== Initial State ==");
        System.out.println("Most Expensive: " + ds.mostExpensive());
        System.out.println("Average Quality: " + ds.avgQuality());
        System.out.println("Median Quality: " + ds.medianQuality());

        System.out.println("\n== After Removing ID 102 (Item B) ==");
        ds.findAndRemove(102);
        System.out.println("Most Expensive: " + ds.mostExpensive());
        System.out.println("Average Quality: " + ds.avgQuality());
        System.out.println("Median Quality: " + ds.medianQuality());

        System.out.println("\n== After Raising Prices of Quality 3 by 20 ==");
        ds.raisePrice(20, 3);
        System.out.println("Most Expensive: " + ds.mostExpensive());
    }
}


