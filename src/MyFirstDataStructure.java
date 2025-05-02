/**
 * @param <T> The type of the satellite data of the elements in the data structure.
 */
public class MyFirstDataStructure<T> {
	public MyAVLTree<T> avlTree;
	private TreeNode<T> maxNode;
	private TreeNode<T> firstInserted;
	private TreeNode<T> lastInserted;
	/*
     * You may add any fields that you wish to add.
     * Remember that the use of built-in Java classes is not allowed,
     * the only variables types you can use are:
     * 	-	the given classes in the assignment
     * 	-	basic arrays
     * 	-	primitive variables
     */

	/***
     * This function is the Init function.
	 * @param N The maximum number of elements in the data structure at each time.
     */
	public MyFirstDataStructure(int N) {
		this.avlTree = new MyAVLTree<>();
		this.maxNode = null;
		this.firstInserted = null;
		this.lastInserted = null;
	}
	
	public void insert(Element<T> x) {
		TreeNode<T> newNode = new TreeNode<>(x);
		this.avlTree.insert(newNode);
		if (this.maxNode == null || newNode.key() > maxNode.key())
			this.maxNode = newNode;
		if(firstInserted == null) {
			firstInserted = newNode;
			this.lastInserted = newNode;
		}
		else {
			lastInserted.setNextInserted(newNode);
			newNode.setPrevInserted(lastInserted);
			lastInserted = newNode;
		}
	}

	private TreeNode<T> findMax(TreeNode<T> node) {
		if(node == null)
			return null;
		while (node.getRight() != null) {
			node = node.getRight();
		}
		return node;
	}
	
	public void findAndRemove(int k) {
		TreeNode<T> node = this.avlTree.search(k);
		if (node == null)
			return;

		avlTree.delete(node);

		if(node == maxNode)
			maxNode = findMax(avlTree.root());

		TreeNode<T> prev = node.getPrevInserted();
		TreeNode<T> next = node.getNextInserted();

		if(prev != null)
			prev.setNextInserted(next);
		else
			firstInserted = next;

		if(next != null)
			next.setPrevInserted(prev);
		else
			lastInserted = prev;

	}

	public Element<T> maximum() {
		return maxNode;
	}

	public Element<T> first() {
		return firstInserted;
	}

	public Element<T> last() {
		return lastInserted;
	}

}
