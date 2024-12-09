package it.unibo.javafx.layouts;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Il root è un BorderPane, che divide la finestra in 5 aree: top, bottom, left, right, center.
        // Noi usiamo solo left e center.
        BorderPane root = new BorderPane();
        // Left Pane, contiene il titolo e il form per aggiungere nuovi task.
        VBox leftPane = new VBox();
        leftPane.setId("left-pane");

        Label title = new Label("Todo App");
        TextField taskField = new TextField();
        Button addButton = new Button("Add");

        leftPane.setAlignment(Pos.TOP_CENTER);

        leftPane.getChildren().addAll(title, taskField, addButton);

        VBox rightPane = new VBox();

         // Imposto i pannelli sinistro e centrale come figli del root.
        root.setLeft(leftPane);
        root.setCenter(rightPane);

        // Set scene and stage
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("ToDo List App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static class Main {
        public static void main(String... args) {
            Application.launch(App.class, args);
        }
    }

    // Crea un todo composto da una label e un bottone per segnare il task come completato.
    public static Node createTaskSection(String content) {
        throw new UnsupportedOperationException("TODO");
    }
}
