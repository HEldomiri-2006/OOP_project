import java.util.Scanner;

public class createEvent implements IOoperations {
    @Override
    public void opr(Database database, User user) {
        Scanner s = new Scanner(System.in);
        Events event = new Events();

        System.out.println("Enter event name:");
        event.setEvent_name(s.next());
        System.out.println("Enter event organizer:");
        event.setEvent_organizer(s.next());
        System.out.println("Enter event category:");
        event.setEvent_category(s.next());
        System.out.println("Enter event price:");
        event.setPrice(s.nextDouble());

        // Handle event ID with validation loop
        while (true) {
            System.out.println("Enter event ID:");
            int eventId = s.nextInt();

            if (database.eventexistancecheck(eventId)) {
                System.out.println("Event ID is taken. Please choose another ID.");
            } else {
                event.setEvent_id(eventId);
                database.CreateEvent(event);
                System.out.println("Event created successfully!");
                break;  // Exit the loop when valid ID is provided
            }
        }
    }
}