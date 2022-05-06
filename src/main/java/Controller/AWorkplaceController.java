package Controller;

import Main.App;
import Models.Shift;
import Models.TeamAdmin;
import Models.Volunteer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static Main.App.*;

public class AWorkplaceController extends Controller {

    public Text workplaceTitle;
    public GridPane mainGrid;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Init WorkplaceOverviewCtrl");
        String name = null;
        if (loginType == 1){
            name = context.Volunteers.selectVolunteer((x)->x.getId()==loginID).get(0).getName();
        }
        else {
            name = "Admin " + context.TeamAdmins.get(loginID).personalInfo.getLastName();
        }
        loggedInAsLabel.setText(name);
        workplaceTitle.setText(context.Teams.get(workPlace).getName());
        List<TeamAdmin> taList = context.Teams.get(workPlace).teamAdmins;
        for (TeamAdmin ta: taList) {
            Text nameText = new Text(ta.personalInfo.getFirstName() + " " + ta.personalInfo.getLastName());
        }
        List<Volunteer> vList = context.Teams.get(workPlace).volunteers;
        for (Volunteer v: vList) {
            Text nameText = new Text(v.personalInfo.getFirstName() + " " + v.personalInfo.getLastName());
        }
        List<Shift> sList = context.Teams.get(workPlace).shifts;
        for (Shift s: sList) {
            Text startText = new Text(s.getStart());
            Text endText = new Text(s.getEnd());
            Text durText = new Text(s.getDuration());
            Text volText = new Text(s.volunteer.personalInfo.getFirstName());
        }
    }
}
