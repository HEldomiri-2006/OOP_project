import java.util.Scanner;

public class deleteCategory implements IOoperations{
    @Override
    public void opr(Database database, User user) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter category name to be deleted: ");
        String delete = input.next();

        boolean removed = database.categories.removeIf(category -> delete.equals(category.getCategoryName()));

        if (removed) {
            System.out.println("Category '" + delete + "' has been deleted.");
        } else {
            System.out.println("No category with the name '" + delete + "' was found.");
        }

        input.close();
    }
}