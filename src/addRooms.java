import java.util.Scanner;

public class addRooms implements IOoperations{
    @Override
    public void opr(Database database, User user) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter room ID: ");
        int roomID = input.nextInt();

        System.out.print("Enter room capacity: ");
        int roomCapacity = input.nextInt();

        System.out.print("Enter room price: ");
        Double price = input.nextDouble();

        //object instance to use during array handling
        database.allRooms.add(new Room(roomCapacity, roomID, price));
        System.out.println("Room updated successfully");

        input.close();
    }
}