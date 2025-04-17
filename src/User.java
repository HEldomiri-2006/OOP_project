import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public abstract class User {
    private String username;
    private String password;  // also fixed 'Password' to lowercase (Java naming convention)
    private Date dateOfBirth;
    private String role;
    ;

    public User() {
    }

    public User(String username, String password, Date dateofBirth, String role) {
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateofBirth;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
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
            dateOfBirth = dateFormat.parse(dobInput);

            System.out.print("Are you an attendee, admin, or organizer? ");
            role = scanner.nextLine().toLowerCase();

            while (!role.equals("attendee") && !role.equals("admin") && !role.equals("organizer")) //if the user enters another role
            {
                System.out.print("Invalid role. Please enter attendee, admin, or organizer: ");
                role = scanner.nextLine().toLowerCase();
            }

            System.out.println("\nSignup successful!");
            System.out.println("Username: " + username);
            System.out.println("Role: " + role);
            System.out.println("Date of Birth: " + dateFormat.format(dateOfBirth));
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");


        }

    }
}
