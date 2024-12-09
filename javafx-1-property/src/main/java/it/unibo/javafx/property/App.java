package it.unibo.javafx.property;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(final Stage primaryStage) throws Exception {
        primaryStage.setTitle("Controls Exercise!");
        final VBox mainPane = new VBox();
        final HBox hbox = new HBox();
        final Counter counter = new Counter();
        final Label count = new Label("0");
        
        Button butDec = new Button("-");
        Button butAdd = new Button("+");
        butAdd.setMinWidth(100);
        butDec.setMinWidth(100);

        // Imposta gli eventi dei pulsanti
        butAdd.setOnAction(event -> counter.increment());
        butDec.setOnAction(event -> counter.decrement());

        // Collega la proprietà del contatore al testo della Label
        count.textProperty().bind(counter.counterProperty().asString());

        // Aggiungi pulsanti e Label ai layout
        hbox.getChildren().addAll(butAdd, butDec);
        mainPane.getChildren().addAll(count, hbox);

        primaryStage.setScene(new Scene(mainPane, 300, 300));
        primaryStage.show();
    }

    public static class Main {
        public static void main(final String... args) {
            Application.launch(App.class, args);
        }
    }
}
