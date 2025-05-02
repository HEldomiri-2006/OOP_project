//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class rentRoom implements IOoperations {
//    @Override
//    public void opr(Database database, User user) {
//        ArrayList requiredrooms = new ArrayList<Integer>();
//        System.out.println("Enter the capacity you want. 50 or 100 or 150");
//        int wantedcapacity;
//        Scanner s = new Scanner(System.in);
//        do {
//            wantedcapacity = s.nextInt();
//            if(wantedcapacity != 50 && wantedcapacity != 100 && wantedcapacity != 150){
//                System.out.println("Wanted capacity is unavailable. Please enter a new capacity. 50 or 100 or 150");
//            }
//        } while (wantedcapacity != 50 && wantedcapacity != 100 && wantedcapacity != 150);
//        System.out.println("The available rooms are:");
//        for (int i = 0; i < database.allRooms.size(); i++) {
//            if (!database.allRooms.get(i).getOccupied() && database.allRooms.get(i).getRoomCapacity() == wantedcapacity) {
//                System.out.println("Room ID:" + database.allRooms.get(i).getRoomId());
//                requiredrooms.add(database.allRooms.get(i).getRoomId());
//            }
//        }
//        System.out.println("Choose the wanted room.");
//        int n = -1;
//        do {
//            int wantedid = s.nextInt();
//            for (int i = 0; i < requiredrooms.size(); i++) {
//                if ((Integer)wantedid == requiredrooms.get(i)) {
//                    n = 1;
//                    for (int j = 0; j < database.users.size(); j++) {
//                        if (database.users.get(j).currentlyloggedin) {
//                            database.users.get(j).roomids.add(wantedid);
//                            for (int k = 0; k < database.allRooms.size(); k++) {
//                                if (database.allRooms.get(k).getRoomId() == wantedid) {
//                                    database.allRooms.get(k).setOccupied(true);
//                                    database.addrentedRoom(database.allRooms.get(k));
//                                    break;
//                                }
//                            }
//                            break;
//                        }
//                    }
//                }
//            }
//        } while (n != -1);
//        database.setLogout(1);
//    }
//}
import java.util.ArrayList;
import java.util.Scanner;

public class rentRoom implements IOoperations {
    @Override
    public void opr(Database database, User user) {
        ArrayList<Integer> requiredrooms = new ArrayList<>();
        System.out.println("Enter the capacity you want. 50 or 100 or 150");
        int wantedcapacity;
        Scanner s = new Scanner(System.in);

        do {
            wantedcapacity = s.nextInt();
            if(wantedcapacity != 50 && wantedcapacity != 100 && wantedcapacity != 150){
                System.out.println("Wanted capacity is unavailable. Please enter a new capacity. 50 or 100 or 150");
            }
        } while (wantedcapacity != 50 && wantedcapacity != 100 && wantedcapacity != 150);

        System.out.println("The available rooms are:");
        for (int i = 0; i < database.allRooms.size(); i++) {
            if (!database.allRooms.get(i).getOccupied() && database.allRooms.get(i).getRoomCapacity() == wantedcapacity) {
                System.out.println("Room ID:" + database.allRooms.get(i).getRoomId());
                requiredrooms.add(database.allRooms.get(i).getRoomId());
            }
        }

        if (requiredrooms.isEmpty()) {
            System.out.println("No rooms available with the selected capacity.");
            return;
        }

        System.out.println("Choose the wanted room.");
        while (true) {
            int wantedid = s.nextInt();
            if (requiredrooms.contains(wantedid)) {
                for (int j = 0; j < database.users.size(); j++) {
                    if (database.users.get(j).currentlyloggedin) {
                        database.users.get(j).roomids.add(wantedid);
                        for (int k = 0; k < database.allRooms.size(); k++) {
                            if (database.allRooms.get(k).getRoomId() == wantedid) {
                                database.allRooms.get(k).setOccupied(true);
                                database.addrentedRoom(database.allRooms.get(k));
                                break;
                            }
                        }
                        break;
                    }
                }
                break;
            }
            else {
                System.out.println("Invalid room ID. Please choose from the available rooms:");
            }
        }
        System.out.println("Room rented successfully");
        database.setLogout(1);
    }
}