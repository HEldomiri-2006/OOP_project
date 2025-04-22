import java.util.ArrayList;

public class Database {
    ArrayList <User>users = new ArrayList<User>();
    ArrayList <String> name = new ArrayList<String>();
    ArrayList <Events> events = new ArrayList<Events>();
    ArrayList <String> eventName=new ArrayList<String>();
    ArrayList <Room> allRooms = new ArrayList<Room>();
    ArrayList <Room> rentendRooms = new ArrayList<Room>();
    ArrayList <Category> categories = new ArrayList<>();
    ArrayList <String> Attendeecoming = new ArrayList<String>();
    ArrayList <Integer> Attendeecomingid = new ArrayList<Integer>();



    public void addUser(User s) {
        users.add(s);
        name.add(s.getName());
    }

    public void addattendeecoming(User s , int eventid) {
        Attendeecoming.add(s.getName());
        Attendeecomingid.add(eventid);
    }

    public void addrooms(Room room) {
        allRooms.add(room);
    }

    public void addrentedrooms(Room rentedroom)
    {
        rentendRooms.add(rentedroom);
    }

    public void CreateEvent (Events event)
    {
        events.add(event);
        eventName.add(event.getEvent_name());
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

    public void roomAvailability()
    {
        for(int i=0 ; i< allRooms.size();i++)
        {
            for (int j = 0 ; j< rentendRooms.size();j++)
            {
                if(allRooms.get(i).getRoomId()==rentendRooms.get(j).getRoomId())
                {
                    allRooms.get(i).setOccupied(true);
                }
            }
        }
    }

}
