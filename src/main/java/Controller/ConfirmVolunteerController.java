package Controller;

import Main.App;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static Main.App.context;
import static Main.App.loginID;

public class ConfirmVolunteerController implements Initializable {


    public Label loggedInAsLabel;
    //Struktur af reference til main-controller, initialize og funktionskald ved sceneskift
    //er lånt fra Christian Budtz' GitHub
    private App app;
    public void setParentController(App app) {this.app = app;}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loggedInAsLabel.setText("Admin " + context.TeamAdmins.get(loginID).personalInfo.getLastName());

    }





    //GoTo Block:
    public void goToHome(ActionEvent actionEvent) throws IOException {
        app.login();
    }
    public void goToProfile(ActionEvent actionEvent) throws IOException{
        app.goToProfile();
    }
    public void goToWorkplaces(ActionEvent actionEvent) throws IOException {
        app.goToWorkplaceOverview();
    }
    public void logOut(ActionEvent actionEvent) throws IOException {
        app.goToLogin();
    }

    //Adm only methods
    public void goToConfirmVolunteers(ActionEvent actionEvent) throws IOException {app.goToConfirmVolunteer();}
    public void goToFindVolunteer(ActionEvent actionEvent) {app.goToFindVolunteer();}

    public void confirmVolunteer(ActionEvent actionEvent) {
    }
}
