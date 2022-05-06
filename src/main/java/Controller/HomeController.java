package Controller;

import Main.App;
import Models.Shift;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static Main.App.context; //giver adgang til data
import static Main.App.loginID;

public class HomeController extends Controller{

    public Text welcomeNameLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Init Homectrl");
        String name = null;
        if (app.loginType == 1){
            name = context.Volunteers.selectVolunteer((x)->x.getId()==app.loginID).get(0).getName();
            List<Shift> sList = context.Volunteers.get(app.loginID).shifts;
            for (Shift s: sList) {
                Text startText = new Text(s.getStart());
                Text endText = new Text(s.getEnd());
                Text durText = new Text(s.getDuration());
                Text teamText = new Text(s.team.getName());
            }
        }
        else {
            name = "Admin " + context.TeamAdmins.get(loginID).personalInfo.getLastName();
        }
        loggedInAsLabel.setText(name);
        welcomeNameLabel.setText(name);
    }
}
