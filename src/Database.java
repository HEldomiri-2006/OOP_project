import java.util.ArrayList;

public class Database {
    ArrayList <User>users = new ArrayList<User>();
    ArrayList <String> name = new ArrayList<String>();

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
}
