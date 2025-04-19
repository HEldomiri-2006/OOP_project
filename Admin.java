package project;

import java.time.LocalDate;

public class Admin extends Account{
    private int workingHours;

    public Admin(String username, String password, LocalDate dateOfBirth, int workingHours){
        super(username, password, dateOfBirth);
        this.workingHours = workingHours;
    }

    public void addRoom(){

    }
    public void viewAllRooms() {

    }
    public void viewAllEvents(){

    }
    public void viewAllAttendees(){

    }
    public void manageCategories(){

    }
}
