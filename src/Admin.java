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
                        new viewAllAttendies()
                };
    }

    public Admin(String name, String phonenumber, String email, LocalDate DateofBirth,String password) {
        super(name, phonenumber, email, DateofBirth, password);
        this.operations=new IOoperations[]
                {
                        new addRooms(),
                        new addCategories(),
                        new deleteCategory(),
                        new updateCategory(),
                        new viewAllRooms(),
                        new viewAllEvents(),
                        new viewAllAttendies()
                };
    }


    @Override
    public void menu(Database database , User user) {
        System.out.println("1.add rooms");
        System.out.println("2.add categories");
        System.out.println("3.delete category");
        System.out.println("4.update category");
        System.out.println("5. view all rooms");
        System.out.println("6.view all events");
        System.out.println("7. view all attendies");

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        this.operations[n-1].opr(database, user);

    }
}
