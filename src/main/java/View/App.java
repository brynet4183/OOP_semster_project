package View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

//HUSK AT SPØRGE OM REGLERNE FOR BRUG AF BUDTZ' GIT REPO -
// Hvordan erklærer vi det uden at blive sigtet for plagiat????
public class App extends Application {
    private Stage stage;

    public static void run(){
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage = primaryStage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/LoginView.fxml"));
        Scene login = loader.load();
        LoginController controller = loader.getController();
        primaryStage.setScene(login);
        controller.setParentController(this);
        stage.show();
    }

    public void login() throws IOException {

    }
    public void viewReigster() throws IOException{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/RegisterView.fxml"));
            Scene scene = loader.load();
            stage.setScene(scene);
    }
}
