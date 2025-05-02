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

            // Allow cancellation
            if (eventChosen == 0) {
                System.out.println("Cancelled.");
                return;
            }

            // Validate input
            if (eventChosen >= 1 && eventChosen <= database.events.size()) {
                break;
            }
            System.out.println("Invalid number! Please try again.");
        }

        // Proceed with valid input
        Events selectedEvent = database.events.get(eventChosen - 1);
        double price = selectedEvent.getPrice();
        int eventid = selectedEvent.getEvent_id();
        System.out.println("Price: $" + price);

        // Check if user is an attendee (who can buy tickets)
        if (!(user instanceof attendee)) {
            System.out.println("Only attendees can buy tickets!");
            return;
        }

        // Since we know it's an attendee, we can cast safely
        attendee attendeeUser = (attendee) user;

        // Get attendee's balance (assuming attendee has getBalance() directly)
        double balance = attendeeUser.getWallet().getBalance(); // Changed from getWallet().getBalance()

        System.out.println("Do you want to buy a ticket (Yes/No)");
        String input = scanner.next().toLowerCase();

        if (input.equals("yes")) {
            if (balance >= price) {
                // Deduct price from attendee's balance
                attendeeUser.getWallet().setBalance(balance - price);

                // Find the organizer and add the money to their wallet
                String organizerName = selectedEvent.getEvent_organizer();
                for (User orgUser : database.users) {
                    if (orgUser instanceof Organizer && orgUser.getName().equals(organizerName)) {
                        Organizer organizer = (Organizer) orgUser;
                        double orgBalance = organizer.getWallet().getBalance();
                        organizer.getWallet().setBalance(orgBalance + price);
                        //System.out.println("The new balance of organizer: " + organizer.getName() + " is "+ organizer.getWallet().getBalance());
                        break;
                    }
                }

                System.out.println("Ticket bought successfully!\nYour current balance is: " + attendeeUser.getWallet().getBalance());
                database.addattendeecoming(attendeeUser, eventid);
            } else {
                System.out.println("Not enough balance :(");
            }
        } else {
            System.out.println("Purchase cancelled.");
        }
    }
}