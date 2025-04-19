import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Main {
    private static Scanner s = new Scanner(System.in); //3ashan main static method fa lazem kol
    private static Database database = new Database();

    public static void main(String[] args) {
        int num;
        do {
            System.out.println("Welcome to our event manager \n choose: \n 1.login \n 2.Register \n 0.exit");
            num = s.nextInt();
            s.nextLine(); // Consume the newline character

            switch (num) {
                case (1):
                    login();
                    break;
                case (2):
                    newUser();
                    break;
                case (0):
                    break;
                default:
                    System.out.println("Error");
            }
        } while (num != 0);
    }

    private static void login() {
        System.out.println("enter your phone number :");
        String phonenumber = s.nextLine();
        System.out.println("enter your email: ");
        String email = s.nextLine();
        int n = database.login(phonenumber, email);
        if (n != -1) {
            User user = database.getUser(n);
            System.out.println("welcome " + user.getName());
            user.menu( database , user);
        } else {
            System.out.println("user does not exist");
        }
    }

    private static void newUser() {
        System.out.println("enter your name:");
        String name = s.nextLine();
        System.out.println("enter your phone number :");
        String phonenumber = s.nextLine();
        System.out.println("enter your email: ");
        String email = s.nextLine();

        System.out.println("Enter your date of birth (YYYY-MM-DD format):");
        LocalDate dateOfBirth = null;
        while (dateOfBirth == null) {
            try {
                dateOfBirth = LocalDate.parse(s.nextLine());
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter in YYYY-MM-DD format:");
            }
        }

        System.out.println("1.Admin \n2.Organizer \n3.attendee");
        int role = s.nextInt();
        User user;
        s.nextLine(); // Consume the newline character

        if (role == 1) {
             user = new Admin(name, phonenumber, email,dateOfBirth);

        } else if (role == 2) {
             user = new Organizer(name, phonenumber, email,dateOfBirth);

        } else {
            System.out.println("enter your address:");
            String address = s.nextLine();
            System.out.println("enter your intersts");
            String intersts = s.nextLine();
            System.out.println("enter balance");
            Double balance =s.nextDouble();
            //System.out.println("enter your gender");

            user = new attendee(name, phonenumber, email,dateOfBirth,address,balance,intersts); // Fixed class name (attendee -> Attendee)

        }
        database.addUser(user);
        user.menu(database,user);
        System.out.println("user created successfully");
    }

}