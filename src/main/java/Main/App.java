package Main;

import Controller.*;
import Models.Volunteer;
import data.Context;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App extends Application {
    private Stage stage;
    public static Context context = null;
    public static int loginID = 0;
    public static int workPlace = 0;
    public static int loginType = 0;
    public static void run(){
        context = new Context();
        launch();
    }


    @Override
    public void start(Stage stage) throws Exception {
        //Struktur/Delelementer lånt fra Christian Budtz' GitHub
        this.stage = stage;
        goToLogin();
        stage.show();
    }

    public void login() throws IOException {
        //Struktur/Delelementer lånt fra Christian Budtz' GitHub
        if (loginType == 0) { //admin login
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/AdmHomeView.fxml"));
            Scene scene = loader.load();
            HomeController controller = loader.getController();
            controller.setParentController(this);
            stage.setScene(scene);
        }
        else if (loginType == 1){  //volunteer login
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/AdmHomeView.fxml"));
            Scene scene = loader.load();
            HomeController controller = loader.getController();
            controller.setParentController(this);
            stage.setScene(scene);
        }
    }

    public void goToRegister() throws IOException{
        //Struktur/Delelementer lånt fra Christian Budtz' GitHub
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/RegisterView.fxml"));
        Scene scene = loader.load();
        RegisterController controller = loader.getController();
        controller.setParentController(this);
        stage.setScene(scene);
    }

    public void goToLogin() throws IOException {
        //Struktur/Delelementer lånt fra Christian Budtz' GitHub
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/LoginView.fxml"));
        Scene scene = loader.load();
        LoginController controller = loader.getController();
        controller.setParentController(this);
        stage.setScene(scene);
    }

    public void goToWorkplaceOverview() throws IOException {
        //Struktur/Delelementer lånt fra Christian Budtz' GitHub
        if (loginType == 1) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/VolWorkplaceOverview.fxml"));
            Scene scene = loader.load();
            WorkplacesOverviewController controller = loader.getController();
            controller.setParentController(this);
            stage.setScene(scene);
        }
        else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/AdmWorkplaceOverview.fxml"));
            Scene scene = loader.load();
            WorkplacesOverviewController controller = loader.getController();
            controller.setParentController(this);
            stage.setScene(scene);
        }
    }
    public void goToAWorkplace(int workplace) throws IOException {//todo: implement picking workplace from parameter
        //Struktur/Delelementer lånt fra Christian Budtz' GitHub
        if (loginType == 1) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/VolAWorkplaceView.fxml"));
            Scene scene = loader.load();
            AWorkplaceController controller = loader.getController();
            controller.setParentController(this);
            workPlace = workplace;
            stage.setScene(scene);
        }
        else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/AdmAWorkplaceView.fxml"));//todo: change to admin
            Scene scene = loader.load();
            AWorkplaceController controller = loader.getController();
            controller.setParentController(this);
            workPlace = workplace;
            stage.setScene(scene);
        }
    }
    public void goToProfile() throws IOException {
        //Struktur/Delelementer lånt fra Christian Budtz' GitHub
        if (loginType == 1) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/VolProfileView.fxml"));
            Scene scene = loader.load();
            ProfileController controller = loader.getController();
            controller.setParentController(this);
            stage.setScene(scene);
        }
        else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/AdmProfileView.fxml"));
            Scene scene = loader.load();
            ProfileController controller = loader.getController();
            controller.setParentController(this);
            stage.setScene(scene);
        }
    }
    public void goToEditProfile() throws IOException {
        //Struktur/Delelementer lånt fra Christian Budtz' GitHub
        if (loginType == 1) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/VolEditProfileView.fxml"));
            Scene scene = loader.load();
            EditProfileController controller = loader.getController();
            controller.setParentController(this);
            stage.setScene(scene);
        }
        else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/VolEditProfileView.fxml"));//todo: change to admin
            Scene scene = loader.load();
            EditProfileController controller = loader.getController();
            controller.setParentController(this);
            stage.setScene(scene);
        }
    }

    //Admin only methods
    public void goToConfirmVolunteer() throws IOException {
        //Struktur/Delelementer lånt fra Christian Budtz' GitHub
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ConfirmVolunteerView.fxml"));
        Scene scene = loader.load();
        ConfirmVolunteerController controller = loader.getController();
        controller.setParentController(this);
        stage.setScene(scene);
    }
    public void goToFindVolunteer() throws IOException {
        //Struktur/Delelementer lånt fra Christian Budtz' GitHub
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FindVolunteerView.fxml"));
        Scene scene = loader.load();
        FindVolunteerController controller = loader.getController();
        controller.setParentController(this);
        stage.setScene(scene);
    }
}
