package kindergarten;

import java.util.LinkedList;
import java.util.List;

/**
 * This class represents a Classroom, with:
 * - an SNode instance variable for students in line,
 * - an SNode instance variable for musical chairs, pointing to the last student in the list,
 * - a boolean array for seating availability (eg. can a student sit in a given seat), and
 * - a Student array parallel to seatingAvailability to show students filed into seats 
 * --- (more formally, seatingAvailability[i][j] also refers to the same seat in studentsSitting[i][j])
 * 
 * @author Ethan Chou
 * @author Kal Pandit
 * @author Maksims Kurjanovics Kravcenko
 * 
 */
public class Classroom {
    private SNode studentsInLine;             // when students are in line: references the FIRST student in the LL
    private SNode musicalChairs;              // when students are in musical chairs: references the LAST student in the CLL
    private boolean[][] seatingAvailability;  // represents the classroom seats that are available to students
    private Student[][] studentsSitting;      // when students are sitting in the classroom: contains the students

    /**
     * Constructor for classrooms. Do not edit.
     * @param l passes in students in line
     * @param m passes in musical chairs
     * @param a passes in availability
     * @param s passes in students sitting
     */
    public Classroom ( SNode l, SNode m, boolean[][] a, Student[][] s ) {
		studentsInLine      = l;
        musicalChairs       = m;
		seatingAvailability = a;
        studentsSitting     = s;
	}
    /**
     * Default constructor starts an empty classroom. Do not edit.
     */
    public Classroom() {
        this(null, null, null, null);
    }

    /**
     * This method simulates students coming into the classroom and standing in line.
     * 
     * Reads students from input file and inserts these students in alphabetical 
     * order to studentsInLine singly linked list.
     * 
     * Input file has:
     * 1) one line containing an integer representing the number of students in the file, say x
     * 2) x lines containing one student per line. Each line has the following student 
     * information separated by spaces: FirstName LastName Height
     * 
     * @param filename the student information input file
     */
    public void makeClassroom ( String filename ) 
    {
        StdIn.setFile(filename);
        int amountOfStudents = StdIn.readInt(); 
        Student[] Students = new Student[amountOfStudents]; 

        for(int i = 0; i < amountOfStudents; i++)
        { 
            String firstName = StdIn.readString();
            String lastName = StdIn.readString();
            int height  = StdIn.readInt();
            Student student =  new Student( firstName, lastName , height);
            Students[i] = student;
        } 
         for(int j = 0; j < Students.length; j++)
        { for(int k = j + 1; k < Students.length; k++)
            {
              if(Students[j].compareNameTo(Students[k]) > 0){
                Student swap = Students[j];
                Students[j] = Students[k];
                Students[k] = swap;
              }
            }
        }

            SNode nextStud = null;
            for(int i = Students.length-1; i >= 0; i--)
            {
              studentsInLine = new SNode(Students[i] , nextStud);
              nextStud = studentsInLine; 
            }
    }

    /**
     * 
     * This method creates and initializes the seatingAvailability (2D array) of 
     * available seats inside the classroom. Imagine that unavailable seats are broken and cannot be used.
     * 
     * Reads seating chart input file with the format:
     * An integer representing the number of rows in the classroom, say r
     * An integer representing the number of columns in the classroom, say c
     * Number of r lines, each containing c true or false values (true denotes an available seat)
     *  
     * This method also creates the studentsSitting array with the same number of
     * rows and columns as the seatingAvailability array
     * 
     * This method does not seat students on the seats.
     * 
     * @param seatingChart the seating chart input file
     */
    public void setupSeats(String seatingChart) {

        StdIn.setFile(seatingChart);
        int r = StdIn.readInt(); 
        int c = StdIn.readInt(); 
        seatingAvailability = new boolean[r][c];
        studentsSitting = new Student[r][c]; 
        
        for(int row = 0; row < seatingAvailability.length; row++)
        { for(int col = 0; col < seatingAvailability[row].length; col++)
          {
            String trueFalse = StdIn.readString(); 
            seatingAvailability[row][col] = Boolean.parseBoolean(trueFalse);
          }
        }
    }

    /**
     * 
     * This method simulates students taking their seats in the classroom.
     * 
     * 1. seats any remaining students from the musicalChairs starting from the front of the list
     * 2. starting from the front of the studentsInLine singly linked list
     * 3. removes one student at a time from the list and inserts them into studentsSitting according to
     *    seatingAvailability
     * 
     * studentsInLine will then be empty
     */
    public void seatStudents () { 

        
    SNode pointer = studentsInLine;
    for (int row = 0; row <seatingAvailability.length; row ++){
     for (int col = 0; col <seatingAvailability[row].length; col++){
            if (pointer == null)
            {
                return;
            }
             if (musicalChairs != null && seatingAvailability[row][col] == true)
            {
                studentsSitting[row][col]=musicalChairs.getStudent();
                musicalChairs = null; 
       
            }
            else 
                if (seatingAvailability[row][col] == true)
            {
                studentsSitting[row][col] = pointer.getStudent();
                pointer = pointer.getNext();
                studentsInLine = pointer;
            }
        } 
    }
}

    

    /**
     * Traverses studentsSitting row-wise (starting at row 0) removing a seated
     * student and adding that student to the end of the musicalChairs list.
     * 
     * row-wise: starts at index [0][0] traverses the entire first row and then moves
     * into second row.
     */
    public void insertMusicalChairs () {
   //     SNode firstGuy = musicalChairs;
        SNode lastGuy = musicalChairs;

        for(int i = 0; i < studentsSitting.length; i++)        
        {for(int j = 0; j < studentsSitting[0].length; j++)
         { if(studentsSitting[i][j] != null && seatingAvailability[i][j])
            {
                if(musicalChairs == null)
                {
                    musicalChairs = new SNode();
                    musicalChairs.setStudent(studentsSitting[i][j]);
                    musicalChairs.setNext(musicalChairs);
                    lastGuy = musicalChairs;  
                } 
                else 
                {
                    musicalChairs = new SNode();
                    musicalChairs.setStudent(studentsSitting[i][j]);
                    musicalChairs.setNext(lastGuy.getNext());
                    lastGuy.setNext(musicalChairs);
                    lastGuy = musicalChairs;
                }
   
            }
         }
        }     
      //  lastGuy.setNext(firstGuy);
     //   musicalChairs = lastGuy; 
           
     }

    /**
     * 
     * This method repeatedly removes students from the musicalChairs until there is only one
     * student (the winner).
     * 
     * Choose a student to be elimnated from the musicalChairs using StdRandom.uniform(int b),
     * where b is the number of students in the musicalChairs. 0 is the first student in the 
     * list, b-1 is the last.
     * 
     * Removes eliminated student from the list and inserts students back in studentsInLine 
     * in ascending height order (shortest to tallest).
     * 
     * The last line of this method calls the seatStudents() method so that students can be seated.
     */
    public void playMusicalChairs()
    {   
        SNode pointer =musicalChairs.getNext();
        int randomMaker;
        int studentCounter = 1;
        while(pointer !=musicalChairs){
            studentCounter+=1;
            pointer = pointer.getNext();
        }

        int studentSize = studentCounter;
        Student[] musicalStudents = new Student[studentSize-1];

        for(int i=0; i<studentSize -1; i++)
        {
            randomMaker = StdRandom.uniform(studentCounter);
            SNode prevNode= musicalChairs;
            SNode currentNode = musicalChairs.getNext();
            int count =0;
            while(count != randomMaker)
            {
                count +=1;
                currentNode = currentNode.getNext();
                prevNode = prevNode.getNext();
            }
            prevNode.setNext(currentNode.getNext());
            if (randomMaker == studentCounter-1)
            {
                musicalChairs=prevNode;
            }
            studentCounter-=1;
            musicalStudents[i]=currentNode.getStudent();
        }

        for(int j = 0; j < musicalStudents.length; j++)
        {for(int k = j + 1; k < musicalStudents.length; k++)
          {
           if(musicalStudents[j].getHeight() > musicalStudents[k].getHeight())
           {
              Student swap = musicalStudents[j];
              musicalStudents[j] = musicalStudents[k];
              musicalStudents[k] = swap;
           }
           else if(musicalStudents[j].getHeight() == musicalStudents[k].getHeight())
           {
              Student swap = musicalStudents[j];
              musicalStudents[j] = musicalStudents[k];
              musicalStudents[k] = swap;
           }
          }
        }
/* 
        for(int i = 0; i < musicalStudents.length; i++)
        {
            System.out.println(musicalStudents[i].getFullName() + " " + musicalStudents[i].getHeight());
        }

*/

        SNode nextStud = null; 
        for(int i=musicalStudents.length-1;i>=0;i--)
        {
            studentsInLine = new SNode(musicalStudents[i], nextStud);
            nextStud = studentsInLine;
        }
        seatStudents();
    }

    /**
     * Insert a student to wherever the students are at (ie. whatever activity is not empty)
     * Note: adds to the end of either linked list or the next available empty seat
     * @param firstName the first name
     * @param lastName the last name
     * @param height the height of the student
     */
    public void addLateStudent ( String firstName, String lastName, int height ) {

       if ( studentsInLine != null ) // if students are inside of the line 
        {
            SNode currentPointer = getStudentsInLine();
            SNode previousPointer = null;
            while ( currentPointer != null )
            {
                previousPointer = currentPointer;
                currentPointer = currentPointer.getNext();
            }
            SNode studNode = new SNode(new Student(firstName, lastName, height), null);
            previousPointer.setNext(studNode);
        } 
        else 
             if ( musicalChairs != null ) // if Students are inside of the musical Chairs 
             {   SNode temp = musicalChairs;
                 SNode lastNode = new SNode(new Student(firstName, lastName, height), temp.getNext());
                 temp.setNext(lastNode);
                 musicalChairs = lastNode;
             }
        else { // Student are sittings inside of thier seat
            for ( int i = 0; i < seatingAvailability.length; i++ ) {
                for ( int j = 0; j < seatingAvailability[i].length; j++ ) {

                    if ( seatingAvailability[i][j] == true && studentsSitting[i][j] == null ) {
                        studentsSitting[i][j] = new Student(firstName, lastName, height);
                        return;
                    }
                }
            }
        }  
    }
        
    /**
     * A student decides to leave early
     * This method deletes an early-leaving student from wherever the students 
     * are at (ie. whatever activity is not empty)
     * 
     * Assume the student's name is unique
     * 
     * @param firstName the student's first name
     * @param lastName the student's last name
     */
    public void deleteLeavingStudent ( String firstName, String lastName ) 
    {
        if ( getMusicalChairs() != null )
         {
            SNode pointer = musicalChairs.getNext();
            SNode previousNode = musicalChairs;

            while ( pointer.getStudent().getFirstName().equalsIgnoreCase(firstName) == false && pointer.getStudent().getLastName().equalsIgnoreCase(lastName) == false);
            {
                if ( previousNode.getStudent().getFirstName().equalsIgnoreCase(firstName) && 
                    previousNode.getStudent().getLastName().equalsIgnoreCase(lastName) ) 
                {
                    if ( previousNode.getStudent() == getMusicalChairs().getNext().getStudent() ) 
                    {   SNode start = getMusicalChairs().getNext();
                        SNode end  = getMusicalChairs();
                        start.setNext(start.getNext());

                    } 
                    else 
                        if ( getMusicalChairs().getStudent() == pointer.getStudent() ) 
                        {
                            previousNode.setNext(pointer.getNext());
                            musicalChairs = previousNode;
                        } 
                        else
                         {
                            previousNode.setNext(pointer.getNext());
                         }

                    return;
                }
                previousNode = pointer;
                pointer = pointer.getNext();
            } 

        } else 
            if ( studentsInLine != null )
            {
                SNode pointer = getStudentsInLine();
                SNode previousNode = null;
            
                  if ( pointer != null && pointer.getStudent().getFirstName().equalsIgnoreCase(firstName) 
                && pointer.getStudent().getLastName().equalsIgnoreCase(lastName) ) 
             {
                
                studentsInLine = pointer.getNext();
                return;

             } 
             else 
                {   while ( pointer != null && !pointer.getStudent().getFirstName().equalsIgnoreCase(firstName) 
                        && !pointer.getStudent().getLastName().equalsIgnoreCase(lastName) ) 
                    {
                         previousNode = pointer;
                        pointer = pointer.getNext();
                     }
                 if ( pointer != null )
                 {

                    previousNode.setNext(pointer.getNext());
                 }
                 }
             } 
          else
           { for ( int i = 0; i < studentsSitting.length; i++ ) 
            {
                for (int j = 0; j < studentsSitting[i].length; j++) 
                {

                    if (studentsSitting[i][j] != null) 
                    {
                        
                        if (studentsSitting[i][j].getFirstName().equalsIgnoreCase(firstName) && 
                            studentsSitting[i][j].getLastName().equalsIgnoreCase(lastName)) 
                        {
                            studentsSitting[i][j] = null;
                            return;
                        }
                    }
                }
            }
        }
    }

    

    

    /**
     * Used by driver to display students in line
     * DO NOT edit.
     */
    public void printStudentsInLine () {

        //Print studentsInLine
        StdOut.println ( "Students in Line:" );
        if ( studentsInLine == null ) { StdOut.println("EMPTY"); }

        for ( SNode ptr = studentsInLine; ptr != null; ptr = ptr.getNext() ) {
            StdOut.print ( ptr.getStudent().print() );
            if ( ptr.getNext() != null ) { StdOut.print ( " -> " ); }
        }
        StdOut.println();
        StdOut.println();
    }

    /**
     * Prints the seated students; can use this method to debug.
     * DO NOT edit.
     */
    public void printSeatedStudents () {

        StdOut.println("Sitting Students:");

        if ( studentsSitting != null ) {
        
            for ( int i = 0; i < studentsSitting.length; i++ ) {
                for ( int j = 0; j < studentsSitting[i].length; j++ ) {

                    String stringToPrint = "";
                    if ( studentsSitting[i][j] == null ) {

                        if (seatingAvailability[i][j] == false) {stringToPrint = "X";}
                        else { stringToPrint = "EMPTY"; }

                    } else { stringToPrint = studentsSitting[i][j].print();}

                    StdOut.print ( stringToPrint );
                    
                    for ( int o = 0; o < (10 - stringToPrint.length()); o++ ) {
                        StdOut.print (" ");
                    }
                }
                StdOut.println();
            }
        } else {
            StdOut.println("EMPTY");
        }
        StdOut.println();
    }

    /**
     * Prints the musical chairs; can use this method to debug.
     * DO NOT edit.
     */
    public void printMusicalChairs () {
        StdOut.println ( "Students in Musical Chairs:" );

        if ( musicalChairs == null ) {
            StdOut.println("EMPTY");
            StdOut.println();
            return;
        }
        SNode ptr;
        for ( ptr = musicalChairs.getNext(); ptr != musicalChairs; ptr = ptr.getNext() ) {
            StdOut.print(ptr.getStudent().print() + " -> ");
        }
        if ( ptr == musicalChairs) {
            StdOut.print(musicalChairs.getStudent().print() + " - POINTS TO FRONT");
        }
        StdOut.println();
    }

    /**
     * Prints the state of the classroom; can use this method to debug.
     * DO NOT edit.
     */
    public void printClassroom() {
        printStudentsInLine();
        printSeatedStudents();
        printMusicalChairs();
    }

    /**
     * Used to get and set objects.
     * DO NOT edit.
     */

    public SNode getStudentsInLine() { return studentsInLine; }
    public void setStudentsInLine(SNode l) { studentsInLine = l; }

    public SNode getMusicalChairs() { return musicalChairs; }
    public void setMusicalChairs(SNode m) { musicalChairs = m; }

    public boolean[][] getSeatingAvailability() { return seatingAvailability; }
    public void setSeatingAvailability(boolean[][] a) { seatingAvailability = a; }

    public Student[][] getStudentsSitting() { return studentsSitting; }
    public void setStudentsSitting(Student[][] s) { studentsSitting = s; }

}
