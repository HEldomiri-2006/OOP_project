public class viewAvailableRooms implements IOoperations {
    @Override
    public void opr(Database database, User user) {


        for (int i = 0; i < database.allRooms.size(); i++) { // create room arraylist we room class where we create a room
            if (!database.allRooms.get(i).getOccupied()) {
                System.out.println("Room " + database.allRooms.get(i).getRoomId() + " is available");
            }

        }
    }
}
