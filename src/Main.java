public class Main {
    public static void main(String[] args) {
        MyAVLTree<String> tree = new MyAVLTree<>();

        tree.insert(new TreeNode<>(10, "A"));
        tree.insert(new TreeNode<>(5, "B"));
        tree.insert(new TreeNode<>(3, "C"));
        tree.insert(new TreeNode<>(7, "D"));
        tree.insert(new TreeNode<>(1, "E"));

        System.out.println("Depth of min: " + tree.depthOfMin());

    }
}