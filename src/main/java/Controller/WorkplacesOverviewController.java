package Controller;

import Main.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static Main.App.context;
import static Main.App.loginID;

public class WorkplacesOverviewController implements Initializable {
    @FXML
    private Label loggedInAsLabel;

    public Hyperlink workplace0;
    public Hyperlink workplace1;
    public Hyperlink workplace2;
    public Text leader0;
    public Text leader1;
    public Text leader2;

    //Struktur af reference til main-controller, initialize og funktionskald ved sceneskift
    //er lånt fra Christian Budtz' GitHub
    private App app;
    public void setParentController(App app) {this.app = app;}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Init WorkplaceOverviewctrl");
        String name = null;
        if (app.loginType == 1){
            name = context.Volunteers.selectVolunteer((x)->x.getId()==app.loginID).get(0).getName();
        }
        else {
            name = "Admin " + context.TeamAdmins.get(loginID).personalInfo.getLastName();
        }
        loggedInAsLabel.setText(name);
        //todo: init workplaces and leader values, variables already made
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


    public void goToWorkplace0(ActionEvent actionEvent) throws IOException {
        app.goToAWorkplace(0);
    }
    public void goToWorkplace1(ActionEvent actionEvent) throws IOException {
        app.goToAWorkplace(1);
    }
    public void goToWorkplace2(ActionEvent actionEvent) throws IOException {
        app.goToAWorkplace(2);
    }

}
