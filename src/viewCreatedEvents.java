public class viewCreatedEvents implements IOoperations {
    @Override
    public void opr(Database database, User user) {

        System.out.println("The events created are:");
        String wantedname = null;
        for (int j = 0; j < database.users.size(); j++) {
            if (database.users.get(j).currentlyloggedin) {
                wantedname = database.users.get(j).name;
                break;
            }
        }
        for (int i = 0; i < database.events.size(); i++) {
            if (database.events.get(i).getEvent_organizer().equals(wantedname)) {
                System.out.println(database.events.get(i).getEvent_name());
            }
        }
        database.setLogout(1);
    }
}