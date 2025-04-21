import java.util.Scanner;

public class addCategories implements IOoperations{
    @Override
    public void opr(Database database, User user) {
        System.out.print("Enter category name: ");
        Scanner a = new Scanner(System.in);
        String categoryName = a.next();

        System.out.print("Enter category description: ");
        Scanner b = new Scanner(System.in);
        String description = b.next();

        //object instance to use during array handling
        database.categories.add(new Category(categoryName, description));
        System.out.println("Category created successfully.");

        a.close();
        b.close();
    }
}
