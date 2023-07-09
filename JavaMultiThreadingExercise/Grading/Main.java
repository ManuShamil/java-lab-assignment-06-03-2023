// 1. Develop a multithreaded program with two threads one of which should assign grade depending on
// marks secured in two papers by a student following the rules : 100 – 80 Grade A and 80 – 60 Grade B.
// The thread should also compute the grade point average using 10 for grade A and 8 from grade B. The
// other thread should display the name of the student and her/his grade. The latter thread should wait
// until the first thread has finished generating the grades and computing the cumulative grade point
// average for a student. Show execution of the threads in a loop of a fixed number of iterations.

package Grading;

class GradeAssignment implements Runnable {
    
    public int marksPaper1;
    public int marksPaper2;
    
    public float cumulativeGradeResult;
    public String gradeResult;

    GradeAssignment( int marksPaper1, int marksPaper2 ) {
        this.marksPaper1 = marksPaper1;
        this.marksPaper2 = marksPaper2;
    }

    public void generateGrades() {
        if ( this.marksPaper1 >= 80 && this.marksPaper2 >= 80 )
            this.gradeResult = "A";
        else if ( this.marksPaper1 >= 60 && this.marksPaper2 >= 60 )
            this.gradeResult = "B";
        else
            this.gradeResult = "Fail";
    }

    public void computeCumulativeGrade() {
        this.cumulativeGradeResult = ( this.marksPaper1 + this.marksPaper2 ) / 2;
    }
    
    public void run() {
        this.generateGrades();
        this.computeCumulativeGrade();
    }
}

class GradeDisplay implements Runnable {

    public GradeAssignment gradeAssignment;

    public GradeDisplay( GradeAssignment gradeAssignment) {
        this.gradeAssignment = gradeAssignment;
    }

    public void run() {
        System.out.println( this.gradeAssignment.gradeResult );
        System.out.println( this.gradeAssignment.cumulativeGradeResult );
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException{
        GradeAssignment gradeAssignment = new GradeAssignment( 80, 80 );
        GradeDisplay gradeDisplay = new GradeDisplay( gradeAssignment );

        Thread thread1 = new Thread( gradeAssignment );
        Thread thread2 = new Thread( gradeDisplay );

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}