import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Main {
    private static Scanner s = new Scanner(System.in); //3ashan main static method fa lazem kol
    private static Database database = new Database();

    public static void main(String[] args) {
        int num;
        DummyDataLoader.populate(database);
        DummyDataLoader.loadUsers(database);
        DummyDataLoader.loadEvents(database);
        DummyDataLoader.loadRooms(database);
        do {
            num = InputHelper.getIntegerInput("\nWelcome to our event manager \n choose: \n 1.Login \n 2.Register \n 0.Exit\n Your choice: ");

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
                    System.out.println("Invalid");
            }
        } while (num != 0);
    }

    private static void login() {
        int attempts = 0;
        final int MAX_ATTEMPTS = 5;

        while (attempts < MAX_ATTEMPTS) {
            System.out.println("Enter your phone number:");
            String phonenumber = s.nextLine();
            System.out.println("Enter your email:");
            String email = s.nextLine();
            System.out.println("Enter your password:");
            String password = s.nextLine();

            int n = database.login(phonenumber, email, password);

            if (n == -2) { // Locked account
                return; // Go back to main menu
            } else if (n != -1) {
                User user = database.getUser(n);
                System.out.println("\nWelcome " + user.getName());
                do{
                    user.menu(database, user);
                } while(database.logout!=0);
                return;
            } else {
                attempts++;
                if (attempts < MAX_ATTEMPTS) {
                    System.out.println("Login failed. Try again.");
                } else {
                    System.out.println("Too many failed attempts. Returning to main menu.");
                }
            }
        }
    }

    private static void login(String enteredphonenumber, String enteredemail, String enteredpass) {
        int attempts = 0;
        final int MAX_ATTEMPTS = 5;

        while (attempts < MAX_ATTEMPTS) {
            System.out.println("Enter your phone number:");
            String phonenumber = s.nextLine();
            System.out.println("Enter your email:");
            String email = s.nextLine();
            System.out.println("Enter your password:");
            String password = s.nextLine();

            int n = database.login(phonenumber, email, password);

            if (n == -2) { // Locked account
                return; // Go back to main menu
            } else if (n != -1) {
                User user = database.getUser(n);
                System.out.println("\nWelcome " + user.getName());
                do{
                    user.menu(database, user);
                } while(database.logout!=0);
                return;
            } else {
                attempts++;
                if (attempts < MAX_ATTEMPTS) {
                    System.out.println("Login failed. Try again.");
                } else {
                    System.out.println("Too many failed attempts. Returning to main menu.");
                }
            }
        }
    }

    private static void newUser() {
        String name = InputHelper.getAlphabeticInput("\nEnter your name: ");
        System.out.println("Enter your phone number :");
        String phonenumber = s.nextLine();
        System.out.println("Enter your email: ");
        String email = s.nextLine();
        System.out.println("Enter your password: ");
        String password = s.nextLine();

        System.out.println("Enter your date of birth (YYYY-MM-DD format):");
        LocalDate dateOfBirth = null;
        while (dateOfBirth == null) {
            try {
                dateOfBirth = LocalDate.parse(s.nextLine());
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter in YYYY-MM-DD format:");
            }
        }

        int role =InputHelper.getIntegerInput("\n1.Admin \n2.Organizer \n3.attendee\nYour choice: ");
        User user;

        if (role == 1) {
             user = new Admin(name, phonenumber, email,dateOfBirth,password);

        } else if (role == 2) {
             user = new Organizer(name, phonenumber, email,dateOfBirth,password);

        } else {
            System.out.println("\nEnter your address: ");
            String address = s.nextLine();
            System.out.println("Enter your interests: ");
            String intersts = s.nextLine();
            Double balance = InputHelper.getDoubleIntegerInput("Enter balance: ");
            //System.out.println("enter your gender");

            user = new attendee(name, phonenumber, email,dateOfBirth,password,address,balance,intersts); // Fixed class name (attendee -> Attendee)

        }
        database.addUser(user);
        System.out.println("User created successfully");
        int z = database.login(phonenumber, email, password);
        if(z != -1) {
            User user2 = database.getUser(z);
            System.out.println("\nWelcome " + user2.getName());
            do{
                user2.menu(database, user2);
            } while(database.logout!=0);
            return;
        }
    }

}