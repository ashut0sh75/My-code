public class Main {
    public static void main(String[] args) {
        Person person = new Person("John", "Doe");
        Employee employee = new Employee("Jane", "Smith", "Software Engineer");

        System.out.println("Person: " + person.getFirstName() + " " + person.getLastName());
        System.out.println("Employee: " + employee.getFirstName() + " " + employee.getLastName());
    }
}