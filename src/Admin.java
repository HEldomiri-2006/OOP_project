import java.time.LocalDate;

public class Admin extends User {

    public Admin() {
    }

    public Admin(String name) {
        super(name);
    }

    public Admin(String name, String phonenumber, String email, LocalDate DateofBirth) {
        super(name, phonenumber, email, DateofBirth);
    }


    @Override
    public void menu() {
        System.out.println("1.add rooms");
        System.out.println("2.add categories");
        System.out.println("3.delete category");
        System.out.println("4.update category");
        System.out.println("5. view all rooms");
        System.out.println("6.view all events");
        System.out.println("7. view all attendies");

    }
}
