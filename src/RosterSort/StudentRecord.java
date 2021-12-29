package RosterSort;

import java.util.ArrayList;

public class StudentRecord extends Student {
	ArrayList<String> studentCourses;
	boolean isDuplicate = false;
	//Allow a creation o StudentRecord objects with the studentCoruses parameter.
	public StudentRecord(String firstName, String lastName, String IDNo, ArrayList<String> studentCourses) {
		super(firstName, lastName, IDNo);
		this.studentCourses = studentCourses;
	}
	
	public StudentRecord(String firstName, String lastName, String IDNo) {
		super(firstName, lastName, IDNo);
		this.studentCourses = new ArrayList<>();
	}
	
	public StudentRecord() {
		this.firstName = " ";
		this.lastName = " ";
		this.IDNo = " ";
	}
	
	public String toString() {
		return this.getFirstName() + " " + this.getLastName() + " " + this.getIDNo() + " " + studentCourses;
			
	}
	
	void addCourse(String newCourse) {
		studentCourses.add(newCourse);
	}
	
	void remCourse(String remCourse) {
		studentCourses.remove(studentCourses.indexOf(remCourse));
	}
	
	ArrayList<String> getCourses() {
		return studentCourses;
	}
}
