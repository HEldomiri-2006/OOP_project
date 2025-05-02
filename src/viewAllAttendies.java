
import java.util.Scanner;

public class viewAllAttendies implements IOoperations{
    @Override
    public void opr(Database database, User user) {

        if(database.Attendeecoming.isEmpty()){
            System.out.println("\nNo attendees are attending an event.");
        }
        for (int i = 0; i < database.Attendeecoming.size(); i++) {
           System.out.println("All attendees attending an event: ");
            System.out.println(database.Attendeecoming.get(i));
        }

        database.setLogout(1);
    }
}