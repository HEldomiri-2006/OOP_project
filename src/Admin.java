import java.time.LocalDate;
import java.util.ArrayList;


public class Admin extends Account{
    private int workingHours;

    public Admin(String username, String password, LocalDate dateOfBirth, int workingHours, String mainRole){
        super(username, password, dateOfBirth, mainRole);
        this.workingHours = workingHours;
    }

    public void addRoom(int roomID, int roomCapacity, double price){
        Room newRoom = new Room();

        newRoom.setRoomID(roomID);
        newRoom.setRoomCapacity(roomCapacity);
        newRoom.setPrice(price);
        // newRoom.setRoomStatus(roomStatus);
        // roomList.add(newRoom); (store new room)
    }
    public void viewAllRooms() {
        // loop through rooms array and display each room's info in a tabular form
    }
    public void viewAllEvents(){
        // loop through events array and display each event's info in a tabular form
    }
    public void viewAllAttendees(){
        // loop through attendees array and display each attendee's info in a tabular form
    }
    public void manageCategories(){
        // CRUD ops for categories array
    }
}
