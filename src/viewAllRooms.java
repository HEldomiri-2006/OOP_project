import java.util.Scanner;

public class viewAllRooms implements IOoperations{
    @Override
    public void opr(Database database, User user) {
        Scanner input = new Scanner(System.in);
        char status;
        while(true)
        {
            System.out.println("Enter rooms status, 'u' for unoccupied, 'o' for occupied, or 'a' for all: ");
            status = Character.toLowerCase(input.next().charAt(0));

            if(status == 'u' || status == 'o' || status == 'a'){
                break;
            }
            //else
            System.out.println("Invalid choice, please enter 'u', 'o', or 'a':");
        }

        System.out.printf("%-10s %-15s %-12s %-10s%n", "Room ID", "Capacity", "Status", "Price");

        for (Room room : database.rooms) { // create room arraylist we room class where we create a room
            if(status == 'u' && !room.getOccupied())
            {
                System.out.printf("%-10d %-15d %-12s %-10.2f%n",
                        room.getRoomId(),
                        room.getRoomCapacity(),
                        "Available",
                        room.getPrice());
            }
            else if (status == 'o' && room.getOccupied()){
                System.out.printf("%-10d %-15d %-12s %-10.2f%n",
                        room.getRoomId(),
                        room.getRoomCapacity(),
                        "Occupied",
                        room.getPrice());
            }
            else{
                System.out.printf("%-10d %-15d %-12s %-10.2f%n",
                        room.getRoomId(),
                        room.getRoomCapacity(),
                        room.getOccupied() ? "Occupied" : "Available",
                        room.getPrice());
            }
        }
        input.close();
    }
}
