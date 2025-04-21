import java.awt.print.Book;
import java.util.ArrayList;

public class Database {
    ArrayList <User>users = new ArrayList<User>();
    ArrayList <String> name = new ArrayList<String>();
    ArrayList <Events> events = new ArrayList<Events>();
    ArrayList <String> eventName=new ArrayList<String>();
    ArrayList <Room> rooms = new ArrayList<Room>();
    ArrayList <Category> categories = new ArrayList<>();


    public void addUser(User s) {
        users.add(s);
        name.add(s.getName());
    }


    public int login(String phonenumber, String email, String password) {
        int n = -1;
        for (User i : users) {
            if (i.phonenumber.matches(phonenumber) && i.email.matches(email)) {
                if (i.isLocked()) {
                    System.out.println("Account locked due to too many failed attempts");
                    return -2; // Special code for locked account
                }

                if (i.password.matches(password)) {
                    i.resetFailedAttempts();
                    n = users.indexOf(i);
                    break;
                } else {
                    i.incrementFailedAttempts();
                    System.out.println("Incorrect password. Attempts remaining: " + (5 - i.failedAttempts));
                    return -1;
                }
            }
        }
        return n;
    }

    public User getUser(int n)
    {
        return users.get(n);
    }

    public void CreateEvent (Events event)
    {
        events.add(event);
        eventName.add(event.getEvent_name());
    }
}
