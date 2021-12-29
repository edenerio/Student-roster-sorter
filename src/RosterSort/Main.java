package RosterSort;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws Exception {
		//load roster from a file
		
		int rosterMax = 20;
		Queue waitingList = new Queue();
		BSTLinked studentList = new BSTLinked();
		
		//helper to keep track of Students on the list.
		int helper = 0;
		
		//file reader
		Scanner scan1 = new Scanner(new File("roster.txt"));
		//Check if there is still text on the roster.txt file.
		while(scan1.hasNext()) {
			//store each line in a string to use split()
			String tempStr = scan1.nextLine();
			//store lines to a String array to have the ability to access each word/data separately
			String[] strArr = tempStr.split(" |,");
			//Assigning each data in a String for StudentRecord initialization
			String firstName = strArr[0];
			String lastName = strArr[1];
			String IDN;
			//Check if student has complete info.
			if(strArr.length < 3) {
				System.out.println("Insufficient info for " + firstName + " " + lastName); //Printing to console if student info is not complete; student will not be added to the rosterSorted.txt file.
			}else {
				IDN = strArr[2];
				StudentRecord tempStudent = new StudentRecord(firstName, lastName, IDN);
				//Get Student Courses if available.
				//Because of rosterSorted.txt's format on student courses ([course1, course2, course3]) the '[]' are being copied as part of Student's course name
				if(strArr.length > 3) {
					for(int a = 3; a < strArr.length; a++) {
						String listCourses = strArr[a];
						//Because rosterSorted.txt courses is formatted [courses1, course2, course3] we split each word when char is a comma OR a whitespace so we get instances where str[a] is a whitespace or just nothing (not null) when it comes after a comma
						if(listCourses != "") {
							//case when course name has character '['
							listCourses = listCourses.replaceAll("\\[", "");
							//case when course name has character ']'
							listCourses = listCourses.replaceAll("\\]", "");
							tempStudent.studentCourses.add(listCourses);
						}
					}
						
				}
				
				//add student to the Array
				if(helper < rosterMax) {
					studentList.insertSorted(tempStudent);
					helper++;
				} else {
					System.out.println("Student roster is currently full, " + tempStudent.toString() + " will be added to the waiting list.");
					waitingList.enQ(tempStudent);
				}
			}
		}
		scan1.close();
		System.out.println("Load successful!");
		Scanner scan = new Scanner(System.in);
		int opt = 0;
		do {
			System.out.println("Menu:");
			System.out.println("1. Add Student");
			System.out.println("2. Drop Student");
			System.out.println("3. Search Student in the current roster");
			System.out.println("4. Print current roster");
			System.out.println("5. Save and Close Program");
			
			opt = scan.nextInt();
			
			switch(opt) {
			case 1:
				//Adding Student
				
				//input taker
				System.out.println("Enter Student First Name: ");
				String fn = scan.next();
				
				System.out.println("Enter Student Last Name: ");
				String ln = scan.next();
				
				System.out.println("Enter Student ID Number: ");
				String IDN = scan.next();
				
				//creating the student
				StudentRecord newStudent = new StudentRecord(fn, ln, IDN);
				
				//giving newStudent courses
				System.out.println("Student Courses (separated with a comma(\",\" and no whitespaces) put N/a if student has no course: ");
				String courseIn = scan.next();
				if(!courseIn.equalsIgnoreCase("N/a")) {
					String[] courses = courseIn.split(",");
					for(int a=0; a < courses.length; a++) {
						newStudent.studentCourses.add(courses[a]);
					}
				}
				
				//case when roster is not full, simply add new student to the roster.
				if(helper < rosterMax) {
					studentList.insertSorted(newStudent);
					if(newStudent.isDuplicate == true) {
						break;
					}
					helper++;
					System.out.println("Successfully added " + newStudent.toString() + " to the roster.");
				} else {
					System.out.println("Student roster is currently full, " + newStudent.toString() + " will be added to the waiting list.");
					waitingList.enQ(newStudent);
				}
				
				break;
				
			case 2: 
				//Dropping Student
				
				//input taker
				System.out.println("Enter Student First Name: ");
				String first = scan.next();
				
				System.out.println("Enter Student Last Name: ");
				String last = scan.next();
				
				System.out.println("Enter Student ID Number: ");
				String id = scan.next();
				
				//creating the student
				StudentRecord toDrop = new StudentRecord(first, last, id);
				
				if(!waitingList.isEmpty()) {
					
					//case when student to drop is not found
					if(studentList.search(toDrop) == null) {
						break;
					} else {
						//case when student is currently in the roster
						studentList.delete(toDrop);
						//add student from the waiting list to the roster
						StudentRecord forUser = waitingList.deQ();
						studentList.insertSorted(forUser);
							
						System.out.println(forUser.toString() + " from the waiting list has been added to the current roster.");
					}
				}else {
					//case when waiting list is empty
					studentList.delete(toDrop);
					}
				
				break;
				
			case 3:
				//search for a student within the roster
				
				//input taker
				System.out.println("Enter Student First Name: ");
				String firstN = scan.next();
				
				System.out.println("Enter Student Last Name: ");
				String lastN = scan.next();
				
				System.out.println("Enter Student ID Number: ");
				String idN = scan.next();
				
				//creating the student
				StudentRecord toSearch = new StudentRecord(firstN, lastN, idN);
				StudentRecord temp = studentList.search(toSearch);
				if(temp == null) {
					break;
				}else {
					System.out.println("Student found: " + temp.toString());
				}
				
				break;
				
			case 4:
				//print current roster
				System.out.println(studentList.toString());
				break;
				
			case 5:
				//Save and Close program. Save roster and waiting list on 2 different files.
				
				PrintWriter out = new PrintWriter("studentRoster.txt");
				String[] studentArr = new String[rosterMax];
				studentArr = studentList.save();
				for(int j = 0; j < helper; j++) {
					if(studentArr[j] != null) {
						out.println(studentArr[j]);
					}
				}
				
				PrintWriter out2 = new PrintWriter("waitingList.txt");
				for(int a = 0; a < 10; a++) {
					if(!waitingList.isEmpty()) {
						out2.println(waitingList.deQ());
					}
				}
				
				out.close();
				out2.close();
			}
			
		}while(opt != 5);
		
		scan.close();
		System.out.println("Program Exited.");
		
	}
}


