import java.time.LocalDate;
import java.util.Scanner;

public class attendee extends User {
    private Gender gender;
    private String address;
    private double balance;
    private String interests;
    private Events event;

    public attendee() {
    }

    public attendee(String name) {
        super(name);
        this.operations = new IOoperations[]{
                new viewEvent(),
                new buyTicket(),
                new createEvent()
        };
    }

    public attendee(String name, String phonenumber, String email, LocalDate DateofBirth, String address, double balance, String interests /* ,Gender gender*/) {
        super(name, phonenumber, email, DateofBirth);
        this.address = address;
        this.balance = balance;
        this.interests = interests;
        // this.gender = gender;
        this.operations = new IOoperations[]{
                new viewEvent(),
                new buyTicket(),

        };
    }

    @Override
    public void menu(Database database , User user) {
        System.out.println("1.view event");
        System.out.println("2.Buy ticket");


        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        this.operations[n-1].opr( database ,  user);
    }

    public void view_event() {
    }

    public void select_event() {
    }

    public void buy_ticket() {
        // Implementation for buying a ticket
    }
}  // Added missing class closing brace