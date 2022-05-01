package View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;



public class App extends Application {
    public static void run(){
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Controller.fxml"));
        GridPane gridPane = loader.load();
        Scene login = new Scene(gridPane);
        primaryStage.setScene(login);
        primaryStage.show();
    }
}
