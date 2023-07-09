package StudentRegistration;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


class Student
{
    private String registrationNumber;
    private String name;
    private LocalDate dateOfBirth;
    private ArrayList<String> registeredCourses;

    Student( String registrationNumber, String name, String dateOfBirth )
    {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");

        this.registrationNumber = registrationNumber;
        this.name = name;
        this.dateOfBirth = LocalDate.parse( dateOfBirth, dateFormatter );
        this.registeredCourses = new ArrayList<String>();
    }

    Student( String registrationNumber, String name, String dateOfBirth, ArrayList<String> registeredCourses )
    {
        this( registrationNumber, name, dateOfBirth );
        this.registeredCourses = registeredCourses;
    }

    public String getRegistrationNumber()
    {
        return this.registrationNumber;
    }

    public void setRegistrationNumber( String registrationNumber)
    {
        this.registrationNumber = registrationNumber;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getDateOfBirth()
    {
        return this.dateOfBirth.toString();
    }

    public void AddCourse( String courseName )
    {

        if ( this.registeredCourses.size() >= 3 )
        {
            System.out.println("Max Limit Hit! Cannot add more courses..");
            return;
        }

        this.registeredCourses.add( courseName );
    }

    public int getAge()
    {
        return LocalDate.now().getYear() - dateOfBirth.getYear();
    }

    public void display()
    {
        System.out.println( String.format("%s\t\t%s\t%s", this.registrationNumber, this.getAge(),  this.name ) );
    }
}

public class Main 
{
    public static void main(String[] args) throws IOException
    {
        String regNumber;
        String name;
        String dateOfBirth;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Student[] students = new Student[3];
        for (int i = 0; i < 3; i++)
        {

            System.out.println("Enter details of student " + (i+1) + ":");

            System.out.print("Registration number: ");
            regNumber = reader.readLine();

            System.out.print("Name: ");
            name = reader.readLine();

            System.out.print("Date of birth: ");
            dateOfBirth = reader.readLine();

            students[i] = new Student(regNumber, name, dateOfBirth );

            for (int j = 0; j < 3; j++)
            {
                System.out.print("Course " + (j+1) + ": ");
                students[i].AddCourse( reader.readLine() );
            }

        }

        System.out.println("\nRoll No.\t\t\tAge\tName");
        for ( int i=0; i<3; i++)
            students[i].display();


    }
}