package Main;

import Controller.*;
import data.Context;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class App extends Application {
    private Stage stage;
    public static Context context = null;
    public static int loginID = 0;
    public static int loginType = 0;
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/VolunteerHomeView.fxml")); //TODO: change to admin view
            Scene scene = loader.load();
            HomeController controller = loader.getController();
            controller.setParentController(this);
            stage.setScene(scene);
        }
        else if (usr == 1){  //volunteer login
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/VolunteerHomeView.fxml"));
            Scene scene = loader.load();
            HomeController controller = loader.getController();
            controller.setParentController(this);
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

    public void goToWorkplaceOverview(int usr) throws IOException {
        //Lånt fra Christian Budtz' GitHub
        if (usr == 1) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/VolWorkplacesView.fxml"));
            Scene scene = loader.load();
            WorkplacesOverviewController controller = loader.getController();
            controller.setParentController(this);
            stage.setScene(scene);
        }
        else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/VolWorkplacesView.fxml"));//todo: change to admin
            Scene scene = loader.load();
            WorkplacesOverviewController controller = loader.getController();
            controller.setParentController(this);
            stage.setScene(scene);
        }
    }

    public void goToProfile(int usr) throws IOException {
        //Lånt fra Christian Budtz' GitHub
        if (usr == 1) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/VolProfileView.fxml"));
            Scene scene = loader.load();
            ProfileController controller = loader.getController();
            controller.setParentController(this);
            stage.setScene(scene);
        }
        else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/VolProfileView.fxml"));//todo: change to admin
            Scene scene = loader.load();
            ProfileController controller = loader.getController();
            controller.setParentController(this);
            stage.setScene(scene);
        }
    }



}
