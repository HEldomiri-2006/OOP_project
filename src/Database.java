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


    public int login(String phonenumber , String email) {
        int n = -1;
        for (User i : users) {
            if (i.phonenumber.matches(phonenumber) && i.email.matches(email)) {
                n = users.indexOf(i);
                break;
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
