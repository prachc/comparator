import java.util.Queue;
import java.util.Stack;


/**
 * Represents a node in the Binary Search Tree.
 */
class Node<T> {
	//The value present in the node.
	public int value;

	//The reference to the left subtree.
	public Node left;

	//The reference to the right subtree.
	public Node right;

	public Node(int value) {
		this.value = value;
	}
	
	public boolean visited = false;

}

/**
 * Represents the Binary Search Tree.
 */
class BinarySearchTree {

	//Refrence for the root of the tree.
	public Node root;

	public BinarySearchTree insert(int value) {
		Node node = new Node<Integer>(value);

		if (root == null) {
			root = node;
			return this;
		}

		insertRec(root, node);
		return this;
	}

	private void insertRec(Node latestRoot, Node node) {

		if (latestRoot.value > node.value) {

			if (latestRoot.left == null) {
				latestRoot.left = node;
				return;
			} else {
				insertRec(latestRoot.left, node);
			}
		} else {
			if (latestRoot.right == null) {
				latestRoot.right = node;
				return;
			} else {
				insertRec(latestRoot.right, node);
			}
		}
	}

	/**
	 * Returns the minimum value in the Binary Search Tree.
	 */
	public int findMinimum() {
		if (root == null) {
			return 0;
		}
		Node currNode = root;
		while (currNode.left != null) {
			currNode = currNode.left;
		}
		return currNode.value;
	}

	/**
	 * Returns the maximum value in the Binary Search Tree
	 */
	public int findMaximum() {
		if (root == null) {
			return 0;
		}

		Node currNode = root;
		while (currNode.right != null) {
			currNode = currNode.right;
		}
		return currNode.value;
	}

	/**
	 * Printing the contents of the tree in an inorder way.
	 */
	public void printInorder() {
		printInOrderRec(root);
		System.out.println("");
	}

	/**
	 * Helper method to recursively print the contents in an inorder way
	 */
	private void printInOrderRec(Node currRoot) {
		if (currRoot == null) {
			return;
		}
		printInOrderRec(currRoot.left);
		System.out.print(currRoot.value + ", ");
		printInOrderRec(currRoot.right);
	}

	/**
	 * Printing the contents of the tree in a Preorder way.
	 */
	public void printPreorder() {
		printPreOrderRec(root);
		System.out.println("");
	}

	/**
	 * Helper method to recursively print the contents in a Preorder way
	 */
	private void printPreOrderRec(Node currRoot) {
		if (currRoot == null) {
			return;
		}
		System.out.print(currRoot.value + ", ");
		printPreOrderRec(currRoot.left);
		printPreOrderRec(currRoot.right);
	}

	/**
	 * Printing the contents of the tree in a Postorder way.
	 */
	public void printPostorder() {
		printPostOrderRec(root);
		System.out.println("");
	}

	/**
	 * Helper method to recursively print the contents in a Postorder way
	 */
	private void printPostOrderRec(Node currRoot) {
		if (currRoot == null) {
			return;
		}
		printPostOrderRec(currRoot.left);
		printPostOrderRec(currRoot.right);
		System.out.print(currRoot.value + ", ");

	}
	
	public void printBredth() {
		Queue queue = (Queue) new java.util.LinkedList();
		queue.offer(root);
		breadth(queue);
		System.out.println("");
	}
	
	public void breadth(Queue queue) {
		if (queue.isEmpty())
			return;

		Node node = (Node) queue.poll();

		System.out.print(node.value+", ");

		if (node.left != null)
			queue.offer(node.left);

		if (node.right != null)
			queue.offer(node.right);
		breadth(queue);
	}
	
	public void printDepth() {
		Stack stack = new Stack();
		stack.push(root);
		depth(stack);
		System.out.println("");
	}
	
	public void depth(Stack stack){
		if (stack.isEmpty())
			return;
		Node node = (Node) stack.pop();
		System.out.print(node.value + ", ");

		if (node.right != null)
			stack.push(node.right);
		if (node.left != null)
			stack.push(node.left);
		depth(stack);
	}
}

public class BinarySearchTreeDemo {
	//http://lcm.csa.iisc.ernet.in/dsa/node84.html
	//http://www.javabeat.net/binary-search-tree-traversal-java/
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst .insert(40)
		.insert(25)
		.insert(78)
		.insert(10)
		.insert(3)
		.insert(17)
		.insert(32)
		.insert(30)
		.insert(38)
		.insert(78)
		.insert(50)
		.insert(93);
		System.out.println("Inorder traversal");
		bst.printInorder();

		System.out.println("Preorder Traversal");
		bst.printPreorder();

		System.out.println("Postorder Traversal");
		bst.printPostorder();
		
		System.out.println("Bredth Traversal");
		bst.printBredth();
		
		System.out.println("Depth Traversal");
		bst.printDepth();

		System.out.println("The minimum value in the BST: " + bst.findMinimum());
		System.out.println("The maximum value in the BST: " + bst.findMaximum());

	}
}