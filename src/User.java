import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public abstract class  User {
    protected String name;
    protected  String phonenumber;
    protected String email;
    protected LocalDate Dateofbirth;
    protected IOoperations[] operations;


    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, String phonenumber, String email, LocalDate DateofBirth) {
        this.name = name;
        this.phonenumber = phonenumber;
        this.email = email;
        this.Dateofbirth=DateofBirth;
    }

    public String getName() {
        return name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getEmail() {
        return email;
    }
    public abstract void menu(Database database , User user);

}
