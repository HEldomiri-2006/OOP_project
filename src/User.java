import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public abstract class  User {
    protected String name;
    protected String phonenumber;
    protected String email;
    protected LocalDate Dateofbirth;
    protected IOoperations[] operations;
    protected String password;
    boolean currentlyloggedin= false;
    public ArrayList roomids = new ArrayList<Integer>();

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, String phonenumber, String email, LocalDate DateofBirth, String password) {
        this.name = name;
        this.phonenumber = phonenumber;
        this.email = email;
        this.Dateofbirth=DateofBirth;
        this.password=password;
    }


    public int failedAttempts = 0;

    public void incrementFailedAttempts() {
        failedAttempts++;
    }

    public void resetFailedAttempts() {
        failedAttempts = 0;
    }

    public boolean isLocked() {
        return failedAttempts >= 5;
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

    public boolean isCurrentloggedin() {
        return currentlyloggedin;
    }

    public void setCurrentlog(boolean currentlyloggedin) {
        this.currentlyloggedin = currentlyloggedin;
    }
}
