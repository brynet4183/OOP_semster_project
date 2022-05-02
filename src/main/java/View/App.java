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
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        goToLogin();
        stage.show();
    }

    public void login(int usr) throws IOException {
        if (usr == 0) { //admin login
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/HomeView.fxml")); //TODO: change to admin view
            Scene scene = loader.load();

            stage.setScene(scene);
        }
        if (usr == 1){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/HomeView.fxml")); //TODO: CHANGE TO VOL VIEW
            Scene scene = loader.load();
            stage.setScene(scene);
        }
    }

    public void goToRegister() throws IOException{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/RegisterView.fxml"));
            Scene scene = loader.load();
            RegisterController controller = loader.getController();
            controller.setParentController(this);
            stage.setScene(scene);
    }

    public void goToLogin() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/LoginView.fxml"));
        Scene scene = loader.load();
        LoginController controller = loader.getController();
        controller.setParentController(this);
        stage.setScene(scene);
    }
}
