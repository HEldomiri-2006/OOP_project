import java.util.Scanner;

public class updateCategory implements IOoperations{

    @Override
    public void opr(Database database, User user) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter category name to be updated: ");
        String oldName = input.next();

        System.out.print("Enter new category name: ");
        String newName = input.next();

        System.out.print("Enter new category description: ");
        String newDescription = input.next();

        for (Category category : database.categories){
            if(category.getCategoryName().equals(oldName)){
                category.setCategoryName(newName);
                category.setDescription(newDescription);
                System.out.println("Category updated successfully.");
            }
        }

        input.close();
    }
}