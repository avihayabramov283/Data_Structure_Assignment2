
public class Main {
    public static void main(String[] args) {
        MyDynamicSet<String> set = new MyDynamicSet<>(10);

        // הכנסת איברים (לא שומרים את המצביעים!)
        set.insert(new Element<>(5, "five"));
        set.insert(new Element<>(2, "two"));
        set.insert(new Element<>(8, "eight"));

        // חיפוש כדי לקבל את המצביעים הנכונים (ListLink<T>)
        Element<String> five = set.search(5);
        Element<String> two = set.search(2);
        Element<String> eight = set.search(8);

        // בדיקות
        System.out.println("Search 5: " + five);         // [5]
        System.out.println("Search 4: " + set.search(4)); // null

        System.out.println("Minimum: " + set.minimum()); // [2]
        System.out.println("Maximum: " + set.maximum()); // [8]

        System.out.println("Successor of 5: " + set.successor(five));     // [8]
        System.out.println("Predecessor of 5: " + set.predecessor(five)); // [2]

        // מחיקה
        set.delete(five);

        // בדיקה מחדש אחרי מחיקה
        System.out.println("After deleting 5:");
        System.out.println("Search 5: " + set.search(5));           // null
        System.out.println("Successor of 2: " + set.successor(two));   // [8]
        System.out.println("Predecessor of 8: " + set.predecessor(eight)); // [2]
    }
}
