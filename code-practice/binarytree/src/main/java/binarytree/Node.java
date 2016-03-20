package binarytree;

public class Node {

	int data;
	Node left;
	Node right;
	
	
	

	public Node(int data, Node left, Node right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node next) {
		this.left = next;
	}
	
	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
	
}
