import java.util.Scanner;

public class addRooms implements IOoperations{
    @Override
    public void opr(Database database, User user) {

        Scanner input = new Scanner(System.in);

        int roomID;
        while(true) {
            roomID = InputHelper.getIntegerInput("Enter room ID: ");

            boolean duplicate = false;
            for(Room room : database.allRooms){
                if(room.getRoomId() == roomID) {
duplicate= true;
break;
                }
                }
            if(duplicate) {
                System.out.println("This room ID is already in use. Please enter a different ID.");
            } else if (roomID >= 1 && roomID <= 300) {
                break;

            }else {
                System.out.println("Please enter a valid room ID (1 to 300).");
            }
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

        Double price = InputHelper.getDoubleIntegerInput("Enter room price: ");

        //object instance to use during array handling
        database.allRooms.add(new Room(roomCapacity, roomID, price));
        System.out.println("Room updated successfully");
        database.setLogout(1);
    }
}
