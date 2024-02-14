import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentEnrollmentSystemGUI {
    private JFrame frame;
    private JPanel panel;
    private JLabel titleLabel;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField dobField;
    private JTextField emailField;
    private JTextField phoneField;
    private JTextArea addressArea;
    private JButton addButton;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StudentEnrollmentSystemGUI app = new StudentEnrollmentSystemGUI();
            app.createGUI();
        });
    }

    public void createGUI() {
        frame = new JFrame("Student Enrollment System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2));

        titleLabel = new JLabel("Add Student Details");
        firstNameField = new JTextField(20);
        lastNameField = new JTextField(20);
        dobField = new JTextField(20);
        emailField = new JTextField(20);
        phoneField = new JTextField(20);
        addressArea = new JTextArea(4, 20);

        addButton = new JButton("Add Student");

        panel.add(titleLabel);
        panel.add(new JLabel("First Name:"));
        panel.add(firstNameField);
        panel.add(new JLabel("Last Name:"));
        panel.add(lastNameField);
        panel.add(new JLabel("Date of Birth:"));
        panel.add(dobField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(new JLabel("Phone Number:"));
        panel.add(phoneField);
        panel.add(new JLabel("Address:"));
        panel.add(new JScrollPane(addressArea));
        panel.add(new JLabel("")); // Empty label for spacing
        panel.add(addButton);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }

    // Method to add student details (print to console in this example)
    private void addStudent() {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String dob = dobField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        String address = addressArea.getText();

        System.out.println("Student Details:");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Date of Birth: " + dob);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phone);
        System.out.println("Address: " + address);

        // Add database interaction logic here
    }
}
