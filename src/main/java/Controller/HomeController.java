package Controller;

import Main.App;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static Main.App.context; //giver adgang til data
import static Main.App.loginID;

public class HomeController implements Initializable {

    public Text welcomeNameLabel;
    public Label loggedInAsLabel;
    //Struktur af reference til main-controller, initialize og funktionskald ved sceneskift
    //er lånt fra Christian Budtz' GitHub
    private App app;
    public void setParentController(App app) {this.app = app;}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Init Homectrl");
        String name = null;
        if (app.loginType == 1){
            name = context.Volunteers.selectVolunteer((x)->x.getId()==app.loginID).get(0).getName();
        }
        else {
            name = "Admin " + context.TeamAdmins.get(loginID).personalInfo.getLastName();
        }
        loggedInAsLabel.setText(name);
        welcomeNameLabel.setText(name);
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

    public void goToConfirmVolunteer(ActionEvent actionEvent) {
        app.goToConfirmVolunteer();
    }
    public void goToFindVolunteer(ActionEvent actionEvent) {
        app.goToFindVolunteer();
    }
}
