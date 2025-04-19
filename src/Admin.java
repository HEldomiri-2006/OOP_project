import java.time.LocalDate;

public class Admin extends User {

    public Admin() {
    }

    public Admin(String name) {
        super(name);
        this.operations=new IOoperations[]
                {
                        new add_rooms(),
                        new add_categories(),
                        new delete_category(),
                        new update_Category(),
                        new view_all_rooms(),
                        new view_all_events(),
                        new view_all_attendies()
                };
    }

    public Admin(String name, String phonenumber, String email, LocalDate DateofBirth) {
        super(name, phonenumber, email, DateofBirth);
        this.operations=new IOoperations[]
                {
                        new add_rooms(),
                        new add_categories(),
                        new delete_category(),
                        new update_Category(),
                        new view_all_rooms(),
                        new view_all_events(),
                        new view_all_attendies()
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

    }
}
