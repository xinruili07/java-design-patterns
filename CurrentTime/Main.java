import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.LocalDateTime;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Current Time");
        String time = LocalDateTime.now().toString();
        Text text1 = new Text();
        text1.setText(time);

        Button button = new Button("Get current time");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                text1.setText(LocalDateTime.now().toString());
            }
        });

        GridPane root = createPane(); // The root of the GUI component graph
        root.add(text1, 0, 0, 1, 1);
        root.add(button, 0, 1, 1, 1);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        //primaryStage.setScene(new Scene(button, 300, 275));
        //primaryStage.show();
    }

    private static GridPane createPane()
    {
        GridPane root = new GridPane();
        root.setHgap(100);
        root.setVgap(100);
        root.setPadding(new Insets(5));
        return root;
    }


    public static void main(String[] args) {
        launch(args);
    }
}