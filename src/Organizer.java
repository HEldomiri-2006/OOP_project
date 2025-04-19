import java.time.LocalDate;

public class Organizer extends User{


    public Organizer() {
    }

    public Organizer(String name) {
        super(name);
    }

    public Organizer(String name, String phonenumber, String email, LocalDate DateofBirth) {
        super(name, phonenumber, email, DateofBirth);
        this.operations=

}

    @Override
    public void menu(Database database , User user) {
        System.out.println("1.create event");
        System.out.println("2.edit event");
        System.out.println("3.delete event");
        System.out.println("4.view_availableRooms");
        System.out.println("5.rentRoom");
        System.out.println("6.view_createdEvents"); //lessa msh akid
        System.out.println("7. viewAttendees"); // lessa msh akid
    }

   /* +createEvent(eventID: int, categoryName: String): void
 +editEvent(eventID: int, old_categoryName: String, new_categoryName): void
 +deleteEvent(eventID, int): void
 +view_availableRooms(): List<Rooms>
 +rentRoom(roomID: int): Room
 +view_createdEvents(eventID: int): List<Events>
 +viewAttendees(eventID: int): List<Attendees> */
}
