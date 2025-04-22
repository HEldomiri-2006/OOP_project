import java.time.LocalDateTime;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class Room {
    private int roomId;
    private int roomCapacity;
    Database Rooms;
    private double price;
    private Scanner scanner = new Scanner(System.in);
    private boolean Occupied;

    public Room() {
    }

    public Room(int roomCapacity, int roomId , Double price /* TimeSlot eventTime, LocalDateTime startTime, LocalDateTime endTime*/) {
        this.roomCapacity = roomCapacity;
        this.roomId = roomId;
        this.price=price;

       /* this.eventTime = eventTime;
        this.startTime = startTime;  // Sets the start time
        this.endTime = endTime;*/     // Sets the end time
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(int roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean getOccupied() {
        return Occupied;
    }

    public void setOccupied(boolean occupied) {
        Occupied = occupied;
    }

    //public boolean isAvailable()


}

