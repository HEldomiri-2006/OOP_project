import java.time.LocalDate;
import java.util.Scanner;

public class Organizer extends User{


    public Organizer() {
    }

   public Organizer(String name) {
        super(name);
        this.operations=new IOoperations[]
                {
                        new createEvent(),
                        new editEvent(),
                        new deleteEvent(),
                        new viewAvailableRooms(),
                        new rentRoom(),
                        new viewCreatedEvents(),
                        new viewAttendees()
                };
    }

    public Organizer(String name, String phonenumber, String email, LocalDate DateofBirth,String password) {
        super(name, phonenumber, email, DateofBirth,password);
        this.operations=new IOoperations[]
                {
                        new createEvent(),
                        new editEvent(),
                        new deleteEvent(),
                        new viewAvailableRooms(),
                        new rentRoom(),
                        new viewCreatedEvents(),
                        new viewAttendees()
                };

}

    @Override
    public void menu(Database database , User user) {
        System.out.println("1.create event");
        System.out.println("2.edit event");
        System.out.println("3.delete event");
        System.out.println("4.view available Rooms");
        System.out.println("5.rentRoom");
        System.out.println("6.view created Events"); //lessa msh akid
        System.out.println("7. view Attendees"); // lessa msh akid

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        this.operations[n-1].opr(database, user);
    }

   /* +createEvent(eventID: int, categoryName: String): void
 +editEvent(eventID: int, old_categoryName: String, new_categoryName): void
 +deleteEvent(eventID, int): void
 +view_availableRooms(): List<Rooms>
 +rentRoom(roomID: int): Room
 +view_createdEvents(eventID: int): List<Events>
 +viewAttendees(eventID: int): List<Attendees> */
}
