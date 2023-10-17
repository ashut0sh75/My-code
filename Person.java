class Person {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

class Employee extends Person {
    private String jobTitle;

    public Employee(String firstName, String lastName, String jobTitle) {
        super(firstName, lastName);
        this.jobTitle = jobTitle;
    }

    @Override
    public String getLastName() {
        return super.getLastName() + " (" + jobTitle + ")";
    }
}

