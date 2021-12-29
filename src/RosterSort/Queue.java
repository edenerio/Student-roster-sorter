package RosterSort;

public class Queue {

	private int maxSize = 10;
	private StudentRecord[] data = new StudentRecord[maxSize];
	private int front = 0;
	private int rear = -1;
	private int count = 0;
	private Exception EmptyQueueException;
	
	public boolean isEmpty() {
		return count == 0;
	}
	
	public void enQ(StudentRecord student) {
		//check if waiting list is full
		if(count < maxSize) {
			//circular Queue implementation
			rear = (rear + 1) % maxSize;
			data[rear] = student;
			count ++;
			System.out.println("Successfully added " + student.toString() + " to the waiting list.");
		} else {
			//case when waiting list is full, do nothing and let user know
			System.out.println("Waiting list is currently full.");
		}
	}
	
	public StudentRecord deQ() throws Exception {
		//check if waiting list is empty
		if(isEmpty()) {
			throw EmptyQueueException;
		}
		
		StudentRecord temp = data[front];
		front = (front + 1) % maxSize;
		count--;
		return temp;
	}
}

