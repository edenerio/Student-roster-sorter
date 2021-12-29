
/* Edison Enerio Warm-up Project for CS313.
 * This program takes a .txt file of a Student Info
 * Format: 
 * 		FirstName LastName ID# Courses (Courses can be blank; must be separated with either a whitespace or a comma, but not both)
 * 		ex.: Edison Enerio E123456 CS313,CS212
 * 
 * -Duplicate Students will both show next to each other.
 * -Students with insufficient info will be printed to the console and will not be added to the output.txt file
 * -equals(String, String) will be used to validate student ID numbers in the future.
 * 
 */
package RosterSort;

public class Student implements Comparable<Student>{
	
	protected String firstName;
	protected String lastName;
	protected String IDNo;
	
	public Student() {
		this.firstName = " ";
		this.lastName = " ";
		this.IDNo = " ";
	}
	
	public Student(String firstName, String lastName, String IDNo) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.IDNo = IDNo;
	}
	
	void setFirstName(String newFirst) {
		firstName = newFirst;
	}
	
	void setLastName(String newLast) {
		lastName = newLast;
	}
	
	void setIDNo(String newIDNo) {
		IDNo = newIDNo;
	}
	
	String getFirstName() {
		return firstName;
	}
	
	String getLastName() {
		return lastName;
	}
	
	String getIDNo() {
		return IDNo;
	}

	@Override
	public int compareTo(Student o) {
		int y = this.getLastName().compareTo(o.getLastName());
		if (y != 0) {
			return y;
		}
		y = this.getFirstName().compareTo(o.getFirstName());
		if (y != 0) {
			return y;
		}
		return this.getIDNo().compareTo(o.getIDNo());
	}
	
	
	public String toString() {
		return firstName + " " + lastName + " " + IDNo;
	}
	
	public boolean equals(Student o) {
		//Check if student ID number has the correct length, first letter of last name + 6-digit code.
		if(o.IDNo.length() != 7 || this.IDNo.length() != 7) {
			return false;
		}
		else
			return this.getIDNo().equals(o.getIDNo());
	}
}

