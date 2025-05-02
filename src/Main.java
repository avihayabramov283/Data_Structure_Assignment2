public class Main {
    public static void main(String[] args) {
        MyFirstDataStructure<String> ds = new MyFirstDataStructure<>(10);

        // הכנסת איברים
        ds.insert(new Element<>(10, "ten"));
        ds.insert(new Element<>(5, "five"));
        ds.insert(new Element<>(20, "twenty"));
        ds.insert(new Element<>(15, "fifteen"));

        System.out.println("== After Inserts ==");
        printState(ds, 10, 5, 20, 15);

        // מחיקת 20 (המקסימום)
        ds.findAndRemove(20);
        System.out.println("\n== After Removing 20 ==");
        printState(ds, 10, 5, 20, 15);

        // מחיקת 10 (הראשון)
        ds.findAndRemove(10);
        System.out.println("\n== After Removing 10 ==");
        printState(ds, 10, 5, 20, 15);

        // מחיקת 15 (האחרון)
        ds.findAndRemove(15);
        System.out.println("\n== After Removing 15 ==");
        printState(ds, 10, 5, 20, 15);
    }

    private static void printState(MyFirstDataStructure<String> ds, int... keys) {
        System.out.println("First: " + ds.first());
        System.out.println("Last: " + ds.last());
        System.out.println("Max: " + ds.maximum());

        for (int key : keys) {
            TreeNode<String> node = (TreeNode<String>) ds.avlTree.search(key);
            if (node != null) {
                String prev = node.getPrevInserted() != null ? node.getPrevInserted().key() + "" : "null";
                String next = node.getNextInserted() != null ? node.getNextInserted().key() + "" : "null";
                System.out.println("[" + key + "] prevInserted: " + prev + ", nextInserted: " + next);
            } else {
                System.out.println("[" + key + "] not in structure");
            }
        }
    }
}

