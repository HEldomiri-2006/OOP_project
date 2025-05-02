public class Exit implements  IOoperations{

    public void opr(Database database,User user){


        System.out.println("Logging out... Returning to the main menu.");
        user.setCurrentlog(false);
        database.setLogout(0);
        //Main.main(new String[]{});
       }
}