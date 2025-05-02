import java.util.Scanner;

public class viewAttendees implements IOoperations{
    @Override
    public void opr(Database database, User user) {
        Scanner s = new Scanner(System.in);
        int event_id;
        System.out.println("Enter event ID.");
        do {
            event_id = s.nextInt();
            System.out.println("Event not found. Please choose another ID.");
        } while(!database.eventexistancecheck(event_id));
        if(database.Attendeecoming.isEmpty()){
            System.out.println("\nNo attendees are attending an event.");
        }
        for (int i = 0; i < database.Attendeecomingid.size(); i++) {
            if (database.Attendeecomingid.get(i) == event_id){
                System.out.println("All attendees attending an event: ");
                System.out.println(database.Attendeecoming.get(i));

            }
        }
    }
}
