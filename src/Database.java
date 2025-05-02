import javafx.scene.control.Label;
import javafx.scene.control.TextInputControl;

import java.util.ArrayList;
import java.util.Objects;

public class Database {
    ArrayList <User>users = new ArrayList<User>();
    ArrayList <String> name = new ArrayList<String>();
    ArrayList <Events> events = new ArrayList<Events>();
    ArrayList <String> eventName=new ArrayList<String>();
    ArrayList <Room> allRooms = new ArrayList<>();
    ArrayList<Room> rentedRooms =new ArrayList<>();
    ArrayList <Category> categories = new ArrayList<>();
    ArrayList <String> Attendeecoming = new ArrayList<String>();
    ArrayList <Integer> Attendeecomingid = new ArrayList<Integer>();
    int logout;

    public void addUser(User s) {
        users.add(s);
        name.add(s.getName());
    }

    public void addattendeecoming(User s , int eventid) {
        Attendeecoming.add(s.getName());
        Attendeecomingid.add(eventid);

    }

    public void addRooms(Room room)
    {
        allRooms.add(room);
    }

    public void addrentedRoom(Room room)
    {
        rentedRooms.add(room);
    }

    public int getLogout() {
        return logout;
    }

    public void setLogout(int logout) {
        this.logout = logout;
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
                    i.setCurrentlog(true);
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

    public void roomAvailability()
    {
        for(int i=0 ; i< allRooms.size();i++)
        {
            for (int j = 0 ; j< rentedRooms.size();j++)
            {
                if(allRooms.get(i).getRoomId()==rentedRooms.get(j).getRoomId())
                {
                    allRooms.get(i).setOccupied(true);
                }
            }
        }
}

    public boolean eventexistancecheck(int event_id) {
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).getEvent_id() == event_id) {  // Fixed: get() instead of []
                return true;
            }
        }
        return false;
    }

    public int whichevent(int event_id) {
        if (eventexistancecheck(event_id)) {
            for (int i = 0; i < events.size(); i++) {
                if (events.get(i).getEvent_id() == event_id) {
                    return i;
                }
            }
        }
        return -1;  // Explicit return if event not found
    }
    public int userexistancecheck(String email, String phonenumber, String password) {
        for (int i = 0; i < users.size(); i++) {
            if (Objects.equals(users.get(i).getPhonenumber(), phonenumber)) {
                return -1;
            }
            if (Objects.equals(users.get(i).getEmail(), email)){
                return -2;
            }
            if(Objects.equals(users.get(i).password, password)){
                return -3;
            }
        }
        return -4;
    }
}
