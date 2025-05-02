import java.util.Scanner;

public class updateCategory implements IOoperations{

    @Override
    public void opr(Database database, User user) {

        boolean foundCategory = false;
        Scanner input = new Scanner(System.in);
        while(!foundCategory) {
            String oldName = InputHelper.getAlphabeticInput("Enter category name to be updated: ");

            String newName = InputHelper.getAlphabeticInput("Enter new category name: ");

            System.out.print("Enter new category description: ");
            String newDescription = input.next();

            for (Category category : database.categories) {
                if (category.getCategoryName().equals(oldName)) {
                    category.setCategoryName(newName);
                    category.setDescription(newDescription);
                    System.out.println("Category updated successfully.");
                    foundCategory = true;
                }
            }
            if(!foundCategory){
                System.out.println("Category not found, try again");
            }
        }
        database.setLogout(1);
    }
}