import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class viewEventGUI implements IOoperations {

    @Override
    public void opr(Database database, User user) {
        Stage stage = new Stage();
        stage.setTitle("View Events");

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));

        Label titleLabel = new Label("Available Events");
        titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        // ListView to display events
        ListView<Events> eventListView = new ListView<>();
        eventListView.getItems().addAll(database.events);

        // Custom cell factory to display event information
        eventListView.setCellFactory(param -> new ListCell<Events>() {
            @Override
            protected void updateItem(Events event, boolean empty) {
                super.updateItem(event, empty);
                if (empty || event == null) {
                    setText(null);
                } else {
                    // Display event details in a formatted way
                    setText(String.format("%s\nPrice: $%.2f\nOrganizer: %s",
                            event.getEvent_name(),
                            event.getPrice(),
                            event.getEvent_organizer()));
                }
            }
        });

        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> stage.close());

        layout.getChildren().addAll(titleLabel, eventListView, closeButton);

        Scene scene = new Scene(layout, 500, 400);
        stage.setScene(scene);
        stage.show();

        // Maintain the logout flag behavior from original class
        database.setLogout(1);
    }
}