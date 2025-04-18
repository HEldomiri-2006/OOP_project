import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class attendee extends User{
    Gender gender;
    String address;
    double balance;
    public attendee() {
    }

    public attendee(String name) {
        super(name);
    }

    public attendee(String name, String phonenumber, String email, LocalDate DateofBirth, String address, double balance /* ,Gender gender*/) {
        super(name, phonenumber, email, DateofBirth);
        this.address = address;
        this.balance = balance;
        //this.gender = gender;

}

    @Override
    public void menu() {
        {
            System.out.println("1.Select event");
            System.out.println("2.Create event");

        }
    }
}
