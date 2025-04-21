import java.util.Scanner;

public class viewAllAttendies implements IOoperations{
    @Override
    public void opr(Database database, User user) {
        Scanner s =new Scanner(System.in);

        System.out.println("enter the event id : ");
        int event_id=s.nextInt();
        if(!database.eventexistancecheck(event_id)){
            System.out.println("Event not found. Please choose another ID.");
        }
        else {
            for (int i = 0; i < database.Attendeecoming.size(); i++) {
                if (database.Attendeecomingid.get(i) == event_id){
                    System.out.println(database.Attendeecoming.get(i));
                }
            }
        }

    }
}
