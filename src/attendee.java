import java.time.LocalDate;
import java.util.Scanner;

public class attendee extends User {
    private Gender gender;
    private String address;
    private double balance;
    private String interests;
    private Events event;
    private Wallet wallet;// Corrected typo (renamed from 'waller' to 'wallet')


    public attendee() {
        this.wallet = new Wallet(0.0); // Initialize with default balance
    }

    public attendee(String name) {
        super(name);
        this.wallet = new Wallet(0.0); // Initialize with default balance
        this.operations = new IOoperations[]{
                new viewEvent(),
                new buyTicket(),
                new createEvent()
        };
    }

    public attendee(String name, String phonenumber, String email, LocalDate DateofBirth,String password,String address, double balance, String interests /*, Gender gender*/) {
        super(name, phonenumber, email, DateofBirth,password);
        this.address = address;
        this.balance = balance;
        this.interests = interests;
        // this.gender = gender;
        this.wallet = new Wallet(balance); // Initialize with the provided balance
        this.operations = new IOoperations[]{
                new viewEvent(),
                new buyTicket()
        };
    }

    // Getter for Wallet (optional but recommended for access)
    public Wallet getWallet() {
        return wallet;
    }


    @Override
    public void menu(Database database, User user) {
        System.out.println("1. View event");
        System.out.println("2. Buy ticket");

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        this.operations[n-1].opr(database, user);
    }

    // Other methods (view_event, select_event, buy_ticket) remain unchanged
}