# Student roster sorter
 This is my CSCI313 (Data Structure) Final Project. This Java program essentially takes a list of students (given in a text file roster.txt) and sorts the list alphabetically wiith their last name. If 2 students have the same last name, these 2 students' first names will be compared, then their Student ID number. It implements Binary Search Tree for quicker search time and uses Queue for the waiting list.
 
 This program allows the user to add / remove students before the roster is finally being sorted and printed to a text file (studentRoster.txt).

![image](border.png)

# Program usage samples with screenshots
* **First run (assuming roster.txt is found):**<br> <br>
![image](https://user-images.githubusercontent.com/31665473/147693655-816e8ff3-d927-429a-a00d-c8b4d8d1ed32.png)<br>
The Program is set to only have a maximum roster of 20. If "roster.txt" has more than 20 valid students (not duplicates), then the first 20 listed students from the roster text file will be added to the current roster and the rest will go to the waiting list.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;***NOTE*** : The roster at this point is structured as a Binary Tree and the waiting list is using Queue.
<br>
<br>

* **Adding a student from the roster:** <br> <br>
![image](https://user-images.githubusercontent.com/31665473/147693883-89613192-8e9f-4120-9ade-e62d3bf712da.png)<br>
The user will be asked for a student's first name, last name and student ID. When adding a student, the user can also include the Student's current courses for the record.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;***NOTE*** : If the current roster is full, then the newly added student will automatically go to the waiting list.
<br>
<br>

* **Dropping a student from the roster:** <br><br>
![image](https://user-images.githubusercontent.com/31665473/147695156-3bbbcddd-2540-4a48-a1a2-490d39c1fb50.png)<br>
When dropping a student, the user will be asked for the student's first name, last name and student ID. If the student is found in the current roster, then the student will be dropped and the first student on the waiting list queue will be added to the current roster. If the student is not found, then the user will be prompted.
<br>
<br>

* **Printing current roster:** <br><br>
![image](https://user-images.githubusercontent.com/31665473/147695675-3c8f99b6-6c9e-4c9c-8df6-1c75e2d93611.png) <br>
This traverses through the Binary Search Tree in-order.
<br>
<br>

* **Searching for a student in the current roster:** <br><br>
![image](https://user-images.githubusercontent.com/31665473/147695508-6c0cbe66-a7c0-481e-b25b-42d7c0ac0f87.png)<br>
This feature implements binary search for a faster run time.
<br>
<br>

* **Saving and exiting:** <br><br>
![image](https://user-images.githubusercontent.com/31665473/147695982-6eda59be-833c-491b-aefb-2edae5e56b59.png)<br>
When done, the current roster will be saved in a text file called "studentRoster.txt" and the waiting list saved in "waitingList.txt".

