public class viewEvent implements IOoperations {
    @Override
    public void opr(Database database, User user) {
        int index = 1;
        for (Events e : database.events) {
            System.out.println(index++ + ". " + e.getEvent_name());
        }
        database.setLogout(1);
    }
}