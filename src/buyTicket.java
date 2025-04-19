public class buyTicket implements IOoperations{
    @Override
    public void opr(Database database , User user) {
        user=new attendee();
        System.out.println("choose an event");
        viewEvent events = new viewEvent();
        events.opr(database,user);




    }
}
