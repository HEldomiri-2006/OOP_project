import java.awt.print.Book;
import java.util.Scanner;

public class createEvent implements IOoperations {
    @Override
    public void opr(Database database , User user) {
        Scanner s =new Scanner(System.in);
        Events event = new Events();
        System.out.println("enter event name:");
        event.setEvent_name(s.next());
        System.out.println("enter event organizer:");
        event.setEvent_organizer(s.next());
        System.out.println("enter event category:");
        event.setEvent_category(s.next());
        System.out.println("enter event id:");
        event.setEvent_id(s.nextInt());
        System.out.println("enter event price: ");
        event.setPrice(s.nextDouble());
        database.CreateEvent(event);
        System.out.println("event created succesfuly");




    }
    /*event_name;
    private String event_organizer;
    private String event_category;
    private int event_id;*/

}

