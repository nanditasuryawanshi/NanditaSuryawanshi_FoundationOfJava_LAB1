import java.util.Random;
/*
Problem Statement:
You are an IT Support Administrator and are charged with the task of creating credentials for
new hires
Your application should do the following:
a) Generate an email with the following syntax
firstNamelastName@department.company.com
b) Determine the department (Technical, Admin, Human Resource, Legal)
c) Generate a random password which will contain (number, capital letter, small letter &
special character)
d) Display the generated credentials
e) Use parameterized constructor of class Employee, to pass firstName, lastName.
f) Create a separate CredentialService which will have generatePassword,
generateEmailAddress, & showCredentials method.
 */
class Employee {
    String firstName;
    String lastName;
    String department;
    String email;
    String password;

    // Parameterized constructor
    public Employee(String firstName, String lastName, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }
}

class CredentialService {
    // Generate a random password with a number, capital letter, small letter, and special character
    public static String generatePassword() {
        String passwordCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(passwordCharacters.length());
            password.append(passwordCharacters.charAt(index));
        }

        return password.toString();
    }


    // Generate email with syntax: firstNamelastName@department.company.com
    public static String generateEmailAddress(Employee employee) {
         return employee.firstName.toLowerCase() + employee.lastName.toLowerCase() +
                "@" + employee.department.toLowerCase() + ".company.com";
    }

    // Display generated credentials
    public static void showCredentials(Employee employee) {
        System.out.println("Employee Name: " + employee.firstName + " " + employee.lastName);
        System.out.println("Department: " + employee.department);

        System.out.println("Dear "+employee.firstName.toLowerCase()+"your your generated credentials are as follows");

        System.out.println("Email Address: " + employee.email);
        System.out.println("Password: " + employee.password);

    }
}

class Main {
    public static void main(String[] args) {
        // Example usage
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter department (Technical, Admin, Human Resource, Legal): ");
        String department = scanner.nextLine();

        // Create an employee using the parameterized constructor
        Employee newEmployee = new Employee(firstName, lastName, department);

        // Generate credentials using CredentialService
        newEmployee.email = CredentialService.generateEmailAddress(newEmployee);

        newEmployee.password = CredentialService.generatePassword();

        // Display generated credentials
        CredentialService.showCredentials(newEmployee);
    }
}
