import java.util.Scanner;

public class addCategories implements IOoperations{
    @Override
    public void opr(Database database, User user) {
        Scanner input = new Scanner(System.in);

        String categoryName = InputHelper.getAlphabeticInput("Enter your category name: ");

        System.out.print("Enter category description: ");
        String description = input.next();

        //object instance to use during array handling
        database.categories.add(new Category(categoryName, description));
        System.out.println("Category created successfully.");
        database.setLogout(1);
    }
}