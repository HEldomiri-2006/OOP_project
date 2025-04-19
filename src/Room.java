import java.util.ArrayList;

public class Room {
    private int roomID;
    private int roomCapacity;
    private double price;
    private int availableHours;
    //roomstatus enum?
    //reserve date?

    public int getRoomID(){return roomID;}
    public int getRoomCapacity(){return roomCapacity;}
    public double getPrice(){return price;}
    public int getAvailableHours(){return availableHours;}
    //enum getRoomStatus(){}

    public void setRoomID(int roomID){this.roomID = roomID;}
    public void setRoomCapacity(int roomCapacity){this.roomCapacity = roomCapacity;}
    public void setPrice(double price){this.price = price;}
    public void setAvailableHours(int availableHours){this.availableHours = availableHours;}
    //void setRoomStatus(){}

}
