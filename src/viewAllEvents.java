import java.util.Locale;
import java.util.Scanner;

public class viewAllEvents implements IOoperations{

    @Override
    public void opr(Database database, User user) {
        Scanner input = new Scanner(System.in);
        String eventCategory = null;
        boolean validCategory = false;

        while(!validCategory){
            System.out.print("Enter desired categories (enter all for all categories): ");
            eventCategory = input.next().toLowerCase();

            if(eventCategory.toLowerCase().equals("all")){
                validCategory = true;
                break;
            }

            for(Events events : database.events){
                if(events.getEvent_category().toLowerCase().equals(eventCategory)){
                    validCategory = true;
                    break;
                }
            }
            if(!validCategory){
                System.out.println("Invalid category.");
            }
        }

        System.out.printf("%-15s %-15s %-12s %-10s %-10s%n", "Event Name", "Organizer", "Category", "Event ID", "Price");

        for (Events event: database.events) { // create room arraylist we room class where we create a room
            if(eventCategory.equals("all"))
            {
                System.out.printf("%-15s %-15s %-12s %-10d %-10.2f%n",
                        event.getEvent_name(),
                        event.getEvent_organizer(),
                        event.getEvent_category(),
                        event.getEvent_id(),
                        event.getPrice());
            }
            else if(event.getEvent_category().toLowerCase().equals(eventCategory)){
                System.out.printf("%-15s %-15s %-12s %-10d %-10.2f%n",
                        event.getEvent_name(),
                        event.getEvent_organizer(),
                        eventCategory,
                        event.getEvent_id(),
                        event.getPrice());
            }
        }

        input.close();
    }
}