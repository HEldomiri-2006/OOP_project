import java.time.LocalDate;
import java.util.Scanner;

public class Admin extends User {

    public Admin() {
    }

    public Admin(String name) {
        super(name);
        this.operations=new IOoperations[]
                {
                        new addRooms(),
                        new addCategories(),
                        new deleteCategory(),
                        new updateCategory(),
                        new viewAllRooms(),
                        new viewAllEvents(),
                        new viewAllAttendies(),
                        new Exit()
                };
    }

    public Admin(String name, String phonenumber, String email, LocalDate DateofBirth, String password) {
        super(name, phonenumber, email, DateofBirth, password);
        this.operations=new IOoperations[]
                {
                        new addRooms(),
                        new addCategories(),
                        new deleteCategory(),
                        new updateCategory(),
                        new viewAllRooms(),
                        new viewAllEvents(),
                        new viewAllAttendies(),
                        new Exit()
                };
    }


    @Override
    public void menu(Database database , User user) {

        Scanner s = new Scanner(System.in);
        int n = InputHelper.getIntegerInput("\n1. Add rooms\n2. Add categories\n3. Delete category\n4. Update category\n5. View all rooms\n6. View all events\n7. View all attendees\n8. Exit\n");
        this.operations[n-1].opr(database, user);

    }
}
