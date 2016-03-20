package binarytree;

public class BinaryTree {

	/**
	 * 
	 *           2
	 *         1   3
	 *               6
	 *              5 7  
	 * 
	 * 
	 *            2
	 *           3 1
	 *          6
	 *         7 5
	 */
	
	private static Node root;
	
	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
		Node root = tree.insertNode(null, 2);
		tree.insertNode(root, 3);
		tree.insertNode(root, 1);
		tree.insertNode(root, 5);
		tree.insertNode(root, 7);
		tree.insertNode(root, 6);
		
		inorderTraversal(root);
		
		mirror(root);
		System.out.println("Mirror done");
		inorderTraversal(root);
	}

	private static void inorderTraversal(Node root2) {
		
		if(root2 == null) {
			return;
		}
		
		inorderTraversal(root2.left);
		System.out.println(root2.data);
		inorderTraversal(root2.right);
		
	}

	private Node insertNode(Node root2, int i) {

		if(root2 == null)
		{
			return getNode(i);
		}
		
		if(i < root2.data) {
			root2.left = insertNode(root2.left,i);
		}else
		{
			root2.right = insertNode(root2.right,i);
		}
		return root2;
	}

	

	private Node getNode(int i) {

		return new Node(i, null, null);
	}

	private static void mirror(Node node) {
		  if (node != null) {
		    // do the sub-trees
		    mirror(node.left);
		    mirror(node.right);

		    // swap the left/right pointers
		    Node temp = node.left;
		    node.left = node.right;
		    node.right = temp;
		  }
	}
}
