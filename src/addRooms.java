import java.util.Scanner;

public class addRooms implements IOoperations{
    @Override
    public void opr(Database database, User user) {

        Scanner input = new Scanner(System.in);

        int roomID;
        while(true) {
                System.out.print("Enter room ID: ");
                roomID = input.nextInt();

                if(roomID >= 1 && roomID <= 300){
                    break;
                }
                System.out.println("Please enter a valid room ID.");
            }

        int roomCapacity;
        while(true) {
            System.out.print("Enter room capacity (50-100-150): ");
            roomCapacity = input.nextInt();

            if (roomCapacity == 50 || roomCapacity == 100 ||roomCapacity == 150){
                break;
            }
            System.out.println("Invalid capacity.");
        }

        System.out.print("Enter room price: ");
        Double price = input.nextDouble();

        //object instance to use during array handling
        database.rooms.add(new Room(roomCapacity, roomID, price));
        System.out.println("Room updated successfully");

        input.close();
    }
}
