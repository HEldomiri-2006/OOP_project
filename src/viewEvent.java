public class viewEvent implements IOoperations{

    @Override
    public void opr(Database database , User user)
    {

        for(Events e : database.events)
        {
            System.out.println(e.getEvent_name());
        }
    }
}
