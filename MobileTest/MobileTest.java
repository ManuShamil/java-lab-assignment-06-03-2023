import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        // Create an ArrayList to store Person objects
        ArrayList<Person> persons = new ArrayList<>();

        // Create some Person objects
        Person person1 = new Person("John", 25);
        Person person2 = new Person("Jane", 30);
        Person person3 = new Person("Mike", 35);

        // Add Person objects to the ArrayList
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);

        // Get the size of the ArrayList
        int size = persons.size();
        System.out.println("Size of ArrayList: " + size);

        // Access elements in the ArrayList
        Person retrievedPerson = persons.get(1);
        System.out.println("Person at index 1: " + retrievedPerson);

        // Modify an element in the ArrayList
        Person newPerson = new Person("Alice", 40);
        persons.set(2, newPerson);
        System.out.println("Modified ArrayList: " + persons);

        // Remove an element from the ArrayList
        persons.remove(0);
        System.out.println("ArrayList after removing element: " + persons);

        // Check if the ArrayList contains a specific element
        boolean contains = persons.contains(person1);
        System.out.println("ArrayList contains person1: " + contains);

        // Iterate over the elements of the ArrayList
        System.out.println("Iterating over ArrayList:");
        for (Person person : persons) {
            System.out.println(person);
        }

        // Clear the ArrayList
        persons.clear();
        System.out.println("Cleared ArrayList: " + persons);
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}