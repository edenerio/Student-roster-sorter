package RosterSort;

public class Node {
	StudentRecord data;
	protected Node right;
	protected Node left;
	
	public Node() {
		data = new StudentRecord();
		right = null;
		left = null;
	}
	
	
	public Node(StudentRecord data) {
		this.data = data;
		right = null;
		left = null;
	}
	
	public void setData(StudentRecord data) {
		this.data = data;
	}
	
	
	public void setRight(Node right) {
		this.right = right;
	}
	
	public void setLeft(Node left) {
		this.left = left;
	}
	
	public Student getData() {
		return this.data;
	}
	
	
	public Node getRight() {
		return this.right;
	}
	
	public Node getLeft() {
		return this.left;
	}
	
	public String toString() {
		return data.toString();
	}

}
