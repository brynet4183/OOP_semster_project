package Controller;

import Main.App;
import Models.Shift;
import Models.Volunteer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static Main.App.context;
import static Main.App.loginID;

public class AWorkplaceController implements Initializable {

    @FXML
    private Label loggedInAsLabel;

    //Struktur af reference til main-controller, initialize og funktionskald ved sceneskift
    //er lånt fra Christian Budtz' GitHub
    private App app;
    public void setParentController(App app) {this.app = app;}



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Init WorkplaceOverviewCtrl");
        String name = null;
        if (app.loginType == 1){
            name = context.Volunteers.selectVolunteer((x)->x.getId()==app.loginID).get(0).getName();
        }
        else {
            name = "Admin " + context.TeamAdmins.get(loginID).personalInfo.getLastName();
        }
        loggedInAsLabel.setText(name);
        List<Volunteer> vList = context.Teams.get(app.workPlace).volunteers;
        for (Volunteer v: vList) {
            Text nameText = new Text(v.personalInfo.getFirstName() + " " + v.personalInfo.getLastName());
        }
        List<Shift> sList = context.Teams.get(app.workPlace).shifts;
        for (Shift s: sList) {
            Text startText = new Text(s.getStart());
            Text endText = new Text(s.getEnd());
            Text durText = new Text(s.getDuration());
            Text volText = new Text(s.volunteer.personalInfo.getFirstName());
        }
        //todo: init workplace fields
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

    public void goToConfirmVolunteer(ActionEvent actionEvent) throws IOException {
        app.goToConfirmVolunteer();
    }

    public void goToFindVolunteer(ActionEvent actionEvent) throws IOException {
        app.goToFindVolunteer();
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
