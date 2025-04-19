import java.util.Scanner;

public class buyTicket implements IOoperations {
    @Override
    public void opr(Database database, User user) {
        Scanner scanner = new Scanner(System.in);

        // Display events
        System.out.println("Choose an event:");
        new viewEvent().opr(database, user);

        // Loop until valid input
        int eventChosen;
        while (true) {
            System.out.println("Enter the event number (or 0 to cancel): ");
            eventChosen = scanner.nextInt();

            // Allow cancellation (optional)
            if (eventChosen == 0) {
                System.out.println("Cancelled.");
                return;
            }

            // Validate input
            if (eventChosen >= 1 && eventChosen <= database.events.size()) {
                break; // Exit loop if valid
            }
            System.out.println("Invalid number! Please try again.");
        }

        // Proceed with valid input
        Events selectedEvent = database.events.get(eventChosen - 1);
        double price = selectedEvent.getPrice();
        System.out.println("Price: $" + price);

        attendee wa7ed = new attendee();
        double balance = wa7ed.getWallet().getBalance();

        System.out.println("Do you want to buy a ticket (Yes/No)");
        String input = scanner.nextLine().toLowerCase();
        if (input == "yes")
        {
            if(balance>price)
            {
                balance=-price;
                System.out.println("Ticket bought succesfully\nYour current balance is: " +balance );
            }
            else {
                System.out.println("Not enough balance :(");
            }

        }
        else {
            System.out.println("Thanks for checking out bye!");
        }



    }
}