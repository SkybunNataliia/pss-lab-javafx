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

        // Aggiungo i fogli di stile
        root.getStylesheets().add("dracula.css");
        root.getStylesheets().add("style.css");
        root.setId("root");

        // Left Pane, contiene il titolo e il form per aggiungere nuovi task.
        VBox leftPane = new VBox();
        leftPane.setId("left-pane");
        leftPane.setAlignment(Pos.TOP_CENTER);

        Label title = new Label("Todo App");
        title.getStyleClass().addAll("accent", "title-1");

        TextField taskField = new TextField();
        Button addButton = new Button("Add");

        leftPane.getChildren().addAll(title, taskField, addButton);

        VBox rightPane = new VBox();
        rightPane.setId("right-pane");
        rightPane.setAlignment(Pos.TOP_CENTER);
        Label tit2 = new Label("Tasks");
        tit2.getStyleClass().addAll("accent", "title-2");

        // Area dei task, contiene due liste: una per i task da fare e una per i task completati.
        HBox taskArea = new HBox();
        VBox.setVgrow(taskArea, Priority.ALWAYS);
        taskArea.setId("tasks-area");

        VBox todoPane = new VBox();
        todoPane.setAlignment(Pos.TOP_CENTER);
        Label toDo = new Label("Todo");
        toDo.getStyleClass().add("title-3");
        todoPane.getChildren().add(toDo);

        VBox donePane = new VBox();
        donePane.setAlignment(Pos.TOP_CENTER);
        Label done = new Label("Done");
        done.getStyleClass().add("title-3");
        donePane.getChildren().add(done);

        // Setta la larghezza minima delle liste
        HBox.setHgrow(toDo, Priority.ALWAYS);
        HBox.setHgrow(toDo, Priority.ALWAYS);

        taskArea.getChildren().addAll(toDo, donePane);
        rightPane.getChildren().addAll(tit2, taskArea);

        // Aggiungo dei task di esempio
        var task1 = createTaskSection("Task1");
        var task2 = createTaskSection("Task2");
        todoPane.getChildren().addAll(task1, task2);
        
        // Aggiungo dei task completati di esempio
        VBox doneTask = new VBox(new Label("Task 2"));
        doneTask.getStyleClass().add("task");
        donePane.getChildren().add(doneTask);

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
        HBox task = new HBox();
        task.getStyleClass().add("task");

        Label taskLabel = new Label(content);
        VBox text = new VBox(taskLabel);
        Button doneBut = new Button("X");
        HBox.setHgrow(text,Priority.ALWAYS);

        task.getChildren().addAll(text, doneBut);
        return task;
    }
}
