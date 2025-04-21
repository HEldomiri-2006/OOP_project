import java.util.Scanner;

public class editEvent implements IOoperations{
    @Override
    public void opr(Database database, User user) {

        Scanner s =new Scanner(System.in);

        System.out.println("enter the event id : ");
        int event_id=s.nextInt();

        if(!database.eventexistancecheck(event_id)){
            System.out.println("Event not found. Please choose another ID.");
        }
        else {
            System.out.println("What do you want to change?");
            System.out.println("1.The Event Name");
            System.out.println("2.The Event Category");
            System.out.println("3.The Price");
            System.out.println("4.Exit");
            int response = s.nextInt();
            do {
                switch (response) {
                    case (1):
                        System.out.println("Enter the new event name.");
                        /*msh fahem eh events dih*/ Events[database.whichevent(event_id)].event_name = s.nextLine();
                        System.out.println("Do you want to make any other changes?");
                        System.out.println("Enter 1 for yes and any other number for NO");
                        int tany = s.nextInt();
                        if (tany == 1){
                            editEvent(event_id);
                        }
                        break;
                    case (2):
                        System.out.println("Enter the new event category.");
                        Events[database.whichevent(event_id)].event_category = s.nextLine();
                        System.out.println("Do you want to make any other changes?");
                        System.out.println("Enter 1 for yes and any other number for NO");
                        int again = s.nextInt();
                        if (again == 1){
                            editEvent(event_id);
                        }
                        break;
                    case (3):
                        System.out.println("Enter the new price.");
                        Events[database.whichevent(event_id)].price = s.nextDouble();
                        System.out.println("Do you want to make any other changes?");
                        System.out.println("Enter 1 for yes and any other number for NO");
                        int marakaman = s.nextInt();
                        if (marakaman == 1){
                            editEvent(event_id);
                        }
                        break;
                    case(0):
                        break;
                    default:
                        System.out.println("Error! Unknown number entered. Please enter a new number.");
                        response = s.nextInt();
                }
            }while(response != 1 && response !=2 && response !=3 && response != 0);
        }
    }
}
