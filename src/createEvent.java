import java.util.Scanner;

public class createEvent implements IOoperations {
    @Override
    public void opr(Database database, User user) {
        Scanner s = new Scanner(System.in);
        Events event = new Events();

        event.setEvent_name(InputHelper.getAlphabeticInput("Enter event name: "));
        String wantedname = null;
        for (int j = 0; j < database.users.size(); j++) {
            if (database.users.get(j).currentlyloggedin){
                wantedname = database.users.get(j).name;
                break;
            }
        }
        event.setEvent_organizer(wantedname);
        System.out.println("Enter event category:");
        event.setEvent_category(s.next());
        event.setPrice(InputHelper.getDoubleIntegerInput("Enter event price: "));

        // Handle event ID with validation loop
        while (true) {
            int eventId = InputHelper.getIntegerInput("Enter event ID: ");

            if (database.eventexistancecheck(eventId)) {
                System.out.println("Event ID is taken. Please choose another ID.");
            } else {
                event.setEvent_id(eventId);
                database.CreateEvent(event);
                System.out.println("Event created successfully!");
                break;  // Exit the loop when valid ID is provided
            }
        }
        database.setLogout(1);
    }
}