public class rentRoom implements IOoperations{
    @Override
    public void opr(Database database, User user) {

            if(room[roomID].roomavailabe == true)
            {
                event[whichevent(event_id)].room = roomID;
                System.out.println("Room "+ room.roomID + " is rented successfully");
                room[roomID].roomavailable = false;
            }
            else{
                System.out.println("Room is taken. Choose another room");
                int newroomID = scanner.nextInt();
                rentRoom(newroomID, event_id);*/

        }
    }

