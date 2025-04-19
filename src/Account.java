import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;

public abstract class Account {
    private String username;
    private String password;  // also fixed 'Password' to lowercase (Java naming convention)
    private LocalDate dateOfBirth;
    private String role;


    public Account(String username, String password, LocalDate dateOfBirth, String role) {
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void signup() {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            System.out.print("Enter username: ");
            username = scanner.nextLine();

            System.out.print("Enter password: ");
            password = scanner.nextLine();

            System.out.print("Enter date of birth (yyyy-MM-dd): ");
            String dobInput = scanner.nextLine();
            dateOfBirth = LocalDate.parse(dobInput);

            System.out.print("Are you an attendee, admin, or orgaarenizer? ");
            role = scanner.nextLine().toLowerCase();

            while (!role.equals("attendee") && !role.equals("admin") && !role.equals("organizer")) {
                System.out.print("Invalid role. Please enter attendee, admin, or organizer: ");
                role = scanner.nextLine().toLowerCase();
            }

            System.out.println("\nSignup successful!");
            System.out.println("Username: " + username);
            System.out.println("Role: " + role);
            System.out.println("Date of Birth: " + dateFormat.format(dateOfBirth));
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");

        }

    }
}

