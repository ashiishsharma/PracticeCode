package binarytree;

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

public class BTCopy {

	private static Node root;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		BTCopy copy = new BTCopy();
		
		copy.insertNode(7);
		copy.insertNode(1);
		copy.insertNode(0);
		copy.insertNode(3);
		copy.insertNode(2);
		copy.insertNode(5);
		copy.insertNode(4);
		copy.insertNode(6);
		
		copy.insertNode(9);
		copy.insertNode(8);
		copy.insertNode(10);
		
		System.out.println(" Inorder traversal ");
		copy.traverseInorder(root);
	
		System.out.println(" Preorder traversal ");
		copy.traversePreorder(root);
	
		System.out.println(" Post order traversal ");
		copy.traversePostorder(root);
	
	}

	private void insertNode(int i) {

		if(root == null) {
			root = getNode(i,null,null);
			return;
		}
		
		insertNode(i,root);
	}

	private Node insertNode(int i, Node root2) {

		if(root2 == null) {
			return getNode(i, null, null);
		}
		
		if(i<root2.getData()) {
			if(root2.getLeft() == null) {
				Node node = insertNode(i, root2.getLeft());
				root2.setLeft(node);
				return node;
			}else{
				return insertNode(i, root2.getLeft());
			}
		}else{
			
			if(root2.getRight() == null) {
				Node node = insertNode(i, root2.getRight());
				root2.setRight(node);
				return node;
			}else{
				return insertNode(i, root2.getRight());
			}
		}
		
	}
	
	private void traverseInorder(Node root) {
		
		if(root == null) {
			return;
		}
		
		traverseInorder(root.getLeft());
		System.out.println(root.getData());
		traverseInorder(root.getRight());
	}
	
	private void traversePreorder(Node root) {
		
		if(root == null) {
			return;
		}
		
		System.out.println(root.getData());
		traversePreorder(root.getLeft());
		traversePreorder(root.getRight());
	}

	private void traversePostorder(Node root) {
	
	if(root == null) {
		return;
	}
	
	traversePostorder(root.getLeft());
	traversePostorder(root.getRight());
	System.out.println(root.getData());
}


	private Node getNode(int i,Node rt, Node lft) {
		return new Node(i, rt, lft);
	}

}
