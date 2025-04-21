import java.util.Scanner;

public class addRooms implements IOoperations{
    @Override
    public void opr(Database database, User user) {

        System.out.print("Enter room ID: ");
        Scanner a = new Scanner(System.in);
        int roomID = a.nextInt();

        System.out.print("Enter room capacity: ");
        Scanner b = new Scanner(System.in);
        int roomCapacity = b.nextInt();

        System.out.print("Enter room price: ");
        Scanner c = new Scanner(System.in);
        Double price = c.nextDouble();

        //object instance to use during array handling
        Database db = new Database();
        db.rooms.add(new Room(roomCapacity, roomID, price));
    }
}
