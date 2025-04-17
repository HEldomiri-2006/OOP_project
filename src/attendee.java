import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class attendee extends User {
    private String address;
    private int balance;
    private Gender gender;
    private String interests;
    public boolean isAttending = false;
    private Scanner scanner = new Scanner(System.in);
    protected Wallet wallet;

    public attendee() {}

    public attendee(String username, String password, Date dateofBirth, String role,
                    String address, int balance,  Gender gender, String interests, Wallet wallet) {
        super(username, password, dateofBirth, role);
        this.address = address;
        this.balance = balance;
        this.gender = gender;
        this.interests = interests;
        this.wallet=wallet;
    }



    public void attendEvent() {
        System.out.print("Will you be attending the event? (yes/no): ");
        String response = scanner.nextLine().trim().toLowerCase();

        if (response.equals("yes")) {
            isAttending = true;
            System.out.println("Great! We've marked you as attending.");
        } else if (response.equals("no")) {
            isAttending = false;
            System.out.println("We've updated your attendance status.");
        } else {
            System.out.println("Invalid response. Please answer with 'yes' or 'no'.");
            // Recursively call until valid response
            attendEvent();
        }

    }
    public void buyTickets(int ticketPrice ) {
        wallet.pay(ticketPrice);
    }

    // Getters and setters
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public boolean isAttending() {
        return isAttending;
    }
}