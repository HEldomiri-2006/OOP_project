import java.util.Scanner;

public class deleteEvent implements IOoperations {
    @Override
    public void opr(Database database, User user) {
        Scanner s =new Scanner(System.in);

        int event_id=InputHelper.getIntegerInput("enter the event id you want to remove: ");


            if (!database.eventexistancecheck(event_id)) {
                System.out.println("Event not found. Please choose another ID.");
            }
            else {
                database.events.remove(database.whichevent(event_id));
                System.out.println("Event deleted successfully");
            }
            database.setLogout(1);
        }
}
