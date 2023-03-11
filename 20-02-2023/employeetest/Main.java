package employeetest;

// 4. Create a class called Employee that includes three instance variables—a first name (type String), a last
// name (type String) and a monthly salary (double). Provide a constructor that initializes the three
// instance variables. Provide a set and a get method for each instance variable. If the monthly salary is not
// positive, do not set its value. Write a test app named EmployeeTest that demonstrates class Employee’s
// capabilities. Create two Employee objects and display each object’s yearly salary. Then give each
// Employee a 10% raise and display each Employee’s yearly salary again.

class Employee {
    private String firstName;
    private String lastName;
    private double monthlySalary;

    public Employee(String firstName, String lastName, double monthlySalary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.monthlySalary = monthlySalary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        if ( monthlySalary >= 0) this.monthlySalary = monthlySalary;
    }
    
}

class EmployeeTest {
    public void Init() {
        Employee employee1 = new Employee("John", "Doe", 20000);
        Employee employee2 = new Employee("Jane", "Doe", 2000);

        System.out.printf("Employee 1: %s %s%n", employee1.getFirstName(), employee1.getLastName());
        System.out.printf("Employee 2: %s %s%n", employee2.getFirstName(), employee2.getLastName());

        System.out.printf("Employee 1 yearly salary: %f%n", employee1.getMonthlySalary() * 12);
        System.out.printf("Employee 2 yearly salary: %f%n", employee2.getMonthlySalary() * 12);

        employee1.setMonthlySalary(employee1.getMonthlySalary() * 1.1);
        employee2.setMonthlySalary(employee2.getMonthlySalary() * 1.1);

        System.out.printf("Employee 1 yearly salary after 10%% raise: %f%n", employee1.getMonthlySalary() * 12);
        System.out.printf("Employee 2 yearly salary after 10%% raise: %f%n", employee2.getMonthlySalary() * 12);
    }
}

public class Main {
    public static void main( String[] args ) {
        EmployeeTest employeeTest = new EmployeeTest();
        employeeTest.Init();
    }
}