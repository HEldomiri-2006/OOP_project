import java.util.Scanner;

public class editEvent implements IOoperations{
    @Override
    public void opr(Database database, User user) {

        Scanner s =new Scanner(System.in);
        int tany =0;

        int event_id=InputHelper.getIntegerInput("Enter event ID: ");

        if(!database.eventexistancecheck(event_id)){
            System.out.println("Event not found. Please choose another ID.");
        }
        else {
            do {

                int response = InputHelper.getIntegerInput("What do you want to change?\n1. The Event Name\n2. The Event Category\n3. The Price\n0. Exit\n");
                do {
                    switch (response) {
                        case (1):
                            String newname = InputHelper.getAlphabeticInput("Enter the new event name: ");
                            database.events.get(database.whichevent(event_id)).setEvent_name(newname);
                            System.out.println("Do you want to make any other changes?");
                            System.out.println("Enter 1 for yes and any other number for NO");
                            tany = s.nextInt();
                            break;
                        case (2):
                            String newcategory = InputHelper.getAlphabeticInput("Enter the new event category: ");
                            database.events.get(database.whichevent(event_id)).setEvent_category(newcategory);
                            System.out.println("Do you want to make any other changes?");
                            System.out.println("Enter 1 for yes and any other number for NO");
                            tany = s.nextInt();
                            break;
                        case (3):
                            database.events.get(database.whichevent(event_id)).setPrice(InputHelper.getDoubleIntegerInput("Enter the new price: "));
                            System.out.println("Do you want to make any other changes?");
                            System.out.println("Enter 1 for yes and any other number for NO");
                            tany = s.nextInt();
                            break;
                        case (0):
                            tany =0;
                            break;
                        default:
                            response = InputHelper.getIntegerInput("Error! Unknown number entered. Please enter a new number.");
                    }
                } while (response != 1 && response != 2 && response != 3 && response != 0);
            }while (tany == 1);
        }
        database.setLogout(1);
    }
}