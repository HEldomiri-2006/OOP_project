public class viewAvailableRooms implements IOoperations{
    @Override
    public void opr(Database database, User user) {

        public void view_availableRooms(){
            for (int i = 0; i < roomsList.size() ; i++) { // create room arraylist we room class where we create a room
                if(room[i].roomavailabe == true)
                {
                    System.out.println("Room "+ room.roomID + " is available");
                }
            }
    }
}
