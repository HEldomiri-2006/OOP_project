import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Organizer extends User{
private Wallet wallet;

    public Organizer() {}

   public Organizer(String name) {
        super(name);
       this.wallet = new Wallet(0.0);
        this.operations=new IOoperations[]
                {
                        new createEvent(),
                        new editEvent(),
                        new deleteEvent(),
                        new rentRoom(),
                        new viewCreatedEvents(),
                        new viewAttendees(),
                        new Exit()
                };
    }
    public Wallet getWallet() {
        return wallet;
    }
    public Organizer(String name, String phonenumber, String email, LocalDate DateofBirth,String password) {
        super(name, phonenumber, email, DateofBirth,password);
        this.wallet = new Wallet(0.0);
        this.operations=new IOoperations[]
                {
                        new createEvent(),
                        new editEvent(),
                        new deleteEvent(),
                        new rentRoom(),
                        new viewCreatedEvents(),
                        new viewAttendees(),
                        new Exit()
                };

}



    @Override
    public void menu(Database database , User user) {

        Scanner s = new Scanner(System.in);
        int n = InputHelper.getIntegerInput("\n1. Create event\n2. Edit event\n3. Delete event\n4. Rent Room\n5. View created Events\n6. View Attendees\n7. Exit\n");
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
