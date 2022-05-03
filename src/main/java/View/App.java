package View;

import data.Context;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class App extends Application {
    private Stage stage;
    public static Context context = null;
    public static void run(){
        context = new Context();
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        //Lånt fra Christian Budtz' GitHub
        this.stage = stage;
        goToLogin();
        stage.show();
    }

    public void login(int usr) throws IOException {
        //Delementer lånt fra Christian Budtz' GitHub
        if (usr == 0) { //admin login
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/HomeView.fxml")); //TODO: change to admin view
            Scene scene = loader.load();
            stage.setScene(scene);
        }
        if (usr == 1){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/VolunteerHomeView.fxml"));
            Scene scene = loader.load();
            stage.setScene(scene);
        }
    }

    public void goToRegister() throws IOException{
        //Lånt fra Christian Budtz' GitHub
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/RegisterView.fxml"));
        Scene scene = loader.load();
        RegisterController controller = loader.getController();
        controller.setParentController(this);
        stage.setScene(scene);
    }

    public void goToLogin() throws IOException {
        //Lånt fra Christian Budtz' GitHub
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/LoginView.fxml"));
        Scene scene = loader.load();
        LoginController controller = loader.getController();
        controller.setParentController(this);
        stage.setScene(scene);
    }
}
