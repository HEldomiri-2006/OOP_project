public class viewCreatedEvents implements IOoperations{
    @Override
    public void opr(Database database, User user) {

            System.out.println("The events created are:");
            for (int i = 0; i < database.events.size(); i++) {
                System.out.println(database.events.get(i).getEvent_name());
            }
        }
    }

