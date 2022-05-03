package Controller;

import Main.App;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

import static Main.App.context; //giver adgang til data

public class HomeController implements Initializable {

    public Text welcomeNameLabel;
    public Label loggedInAsLabel;

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
            name = context.TeamAdmins.selectTeamAdmin((x)->x.getId()==app.loginID).get(0).getName();
        }
        loggedInAsLabel.setText(name);
        welcomeNameLabel.setText(name);
    }

    public void volunteerGoToWorkplace(ActionEvent actionEvent) {
    }

    public void volunteerGoToHome(ActionEvent actionEvent) {
    }


    public void volunteerGoToProfile(ActionEvent actionEvent) {
    }

    public void volunteerGoToWorkplaces(ActionEvent actionEvent) {
    }
}
