import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class buyTicketGui {

    public static void opr(Database database, User user) {
        if (!(user instanceof attendee)) {
            showAlert("Error", "Only attendees can buy tickets!");
            return;
        }

        attendee attendeeUser = (attendee) user;
        Stage stage = new Stage();
        stage.setTitle("Buy Tickets");

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));

        Label titleLabel = new Label("Available Events");
        titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        // List of events
        ListView<Events> eventListView = new ListView<>();
        eventListView.getItems().addAll(database.events);
        eventListView.setCellFactory(param -> new ListCell<Events>() {
            @Override
            protected void updateItem(Events event, boolean empty) {
                super.updateItem(event, empty);
                if (empty || event == null) {
                    setText(null);
                } else {
                    setText(String.format("%s - $%.2f", event.getEvent_name(), event.getPrice()));
                }
            }
        });

        Label balanceLabel = new Label(String.format("Your balance: $%.2f", attendeeUser.getWallet().getBalance()));
        Button buyButton = new Button("Buy Ticket");
        Button cancelButton = new Button("Cancel");

        buyButton.setOnAction(e -> {
            Events selectedEvent = eventListView.getSelectionModel().getSelectedItem();
            if (selectedEvent == null) {
                showAlert("Error", "Please select an event first!");
                return;
            }

            double price = selectedEvent.getPrice();
            double balance = attendeeUser.getWallet().getBalance();

            if (balance >= price) {
                // Process payment
                attendeeUser.getWallet().setBalance(balance - price);

                // Transfer money to organizer
                String organizerName = selectedEvent.getEvent_organizer();
                for (User orgUser : database.users) {
                    if (orgUser instanceof Organizer && orgUser.getName().equals(organizerName)) {
                        Organizer organizer = (Organizer) orgUser;
                        double orgBalance = organizer.getWallet().getBalance();
                        organizer.getWallet().setBalance(orgBalance + price);
                        break;
                    }
                }

                database.addattendeecoming(attendeeUser, selectedEvent.getEvent_id());
                showAlert("Success", "Ticket purchased successfully!\nNew balance: $" + attendeeUser.getWallet().getBalance());
                stage.close();
            } else {
                showAlert("Error", "Insufficient funds!");
            }
        });

        cancelButton.setOnAction(e -> stage.close());

        layout.getChildren().addAll(titleLabel, eventListView, balanceLabel, buyButton, cancelButton);

        Scene scene = new Scene(layout, 400, 400);
        stage.setScene(scene);
        stage.show();
    }

    private static void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}