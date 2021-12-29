package RosterSort;
import java.util.ArrayList;

public class BSTLinked {
	private Node root;
	private int size = 0;
	
	public BSTLinked() {
		root = null;
	}
	
	public boolean isEmpty() {
		return root == null;
	}

	public int getSize() {
		return size;
	}
	
	public StudentRecord findMax(Node t) {
		if(isEmpty()) {
			System.out.println("Tree is empty.");
		}
		
		while(t.right != null) {
			t = t.right;
		}
		
		return t.data;
	}
	
	public StudentRecord findMin(Node t) {
		if(isEmpty()) {
			System.out.println("Tree is empty.");
		}
		
		while(t.left != null) {
			t = t.left;
		}
		
		return t.data;
	}
	
	
	public void delete(StudentRecord sn){
		if(isEmpty()) {
			System.out.println("Tree is empty.");
		}
		
		root = delete(sn, root);
	}
	
	private Node delete(StudentRecord sn, Node t) {
		if(t == null) {
			return t;
		}
		if(sn.compareTo(t.data) < 0) {
			//move to left
			delete(sn, t.left);
		} else if(sn.compareTo(t.data) > 0) {
			//move to right
			delete(sn, t.right);
		} else {
			//when student to delete is found
			
			//case when t.right is null
			if(t.right == null) {
				size--;
				return t.left;
			}
			//case when t.left is null
			else if(t.left == null) {
				size--;
				return t.right;
			}
			
			//when t has 2 children
			t.data = findMax(t.left);
			t.left = delete(t.data, t.left);
		}
		size--;
		return t;
	}
	
	
	public StudentRecord search(StudentRecord sn) {
		if(isEmpty()){
			System.out.println("Tree is empty.");
		}
		return search(sn, root);
	}
	
	private StudentRecord search(StudentRecord sn, Node t) {
		if(t == null) {
			System.out.println("Student not found.");
			return null;
		}
		if(sn.compareTo(t.data) < 0) {
			return search(sn, t.left);
		}
		if(sn.compareTo(t.data) > 0) {
			return search(sn, t.right);
		}
		
		
		return t.data;
	}
	
	public void insertSorted(StudentRecord sn) {
		//case when tree is empty
		if(isEmpty()) {
			root = new Node(sn);
			size++;
		}
		insertSorted(sn, root);
	}
	
	private void insertSorted(StudentRecord sn, Node t) {
		if(t != null) {
			//case when sn is less than current root
			if(sn.compareTo(t.data) < 0) {
				//case when t.left is null (which means it is the best spot for sn), insert
				if(t.left == null) {
					t.left = new Node(sn);
					size++;
				}else {
					//move to left Node
					insertSorted(sn, t.left);
				}
			}
			//case when sn is greater than current root
			else if(sn.compareTo(t.data) > 0){
				//case when t.right is null, insert
				if(t.right == null) {
					t.right = new Node(sn);
					size++;
				}else {
					//move to right Node
					insertSorted(sn, t.right);
				}
			}
			//case when there is a duplicate
			else {
				System.out.println(sn + " is already in the roster");
				sn.isDuplicate = true;
			}
		}
	}
	
	public String[] save() {
		ArrayList<String> arr = new ArrayList<>();
		arr = inOrderTraversal(root, arr);
		String[] toReturn = new String[20];
		for(int a = 0; a < size; a++) {
			toReturn[a] =  arr.get(a);
			//for separation / format of printed result
		}
		return toReturn;
	}
	
	public String inOrderTraversal() {
		//String array to input
		ArrayList<String> arr = new ArrayList<>();
		//String array to take the return String array of inOrderTraversal(Node,String[])
		ArrayList<String> forPrint = inOrderTraversal(root, arr);
		//String to return
		String toPrint = "";
		for(int a = 0; a < size; a++) {
			toPrint += forPrint.get(a);
			//for separation / format of printed result
			if(a != size-1) {
				toPrint += "\n";
			}
		}
		return toPrint;
	}
	
	private ArrayList<String> inOrderTraversal(Node t, ArrayList<String> arr) {
		if(t != null) {
			inOrderTraversal(t.left, arr);
			arr.add(t.data.toString());
			inOrderTraversal(t.right, arr);
		}
		return arr;
	}
	
	public String toString() {
		return inOrderTraversal();
	}
	
	
	
}
