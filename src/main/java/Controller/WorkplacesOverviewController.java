package Controller;

import Main.App;
import Models.Team;
import Models.TeamAdmin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static Main.App.*;

public class WorkplacesOverviewController extends Controller {

    public GridPane mainGrid;
    public GridPane navGrid;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Init WorkplaceOverviewctrl");
        String name = null;
        List<Team> tList = new ArrayList<>();
        if (loginType == 1){
            name = context.Volunteers.selectVolunteer((x)->x.getId()==loginID).get(0).getName();
            tList = context.Volunteers.get(loginID).teams;
        }
        else {
            name = "Admin " + context.TeamAdmins.get(loginID).personalInfo.getLastName();
            tList = context.Teams.selectTeam((x) -> x.getId() > 0);
        }
        loggedInAsLabel.setText(name);
        int i = 1;
        for (Team t : tList) {
            Hyperlink nextLink = new Hyperlink(t.getName());
            nextLink.setOnAction(this::goToWorkplace);
            nextLink.setId(Integer.toString(t.getId()));
            nextLink.setUnderline(true);
            mainGrid.add(nextLink, 0,i);
            nextLink = new Hyperlink(t.getName());
            nextLink.setOnAction(this::goToWorkplace);
            nextLink.setId(Integer.toString(t.getId()));
            nextLink.setUnderline(true);
            if(i <= 3)
                navGrid.add(nextLink, 0,i+(loginType == 1 ? 1 : 3));
            List<TeamAdmin> taList = t.teamAdmins;
            int j = 1;
            for (TeamAdmin ta : taList) {
                Text nextAdmin = new Text(ta.getName());
                mainGrid.add(nextAdmin, j,i);
                j++;
            }
            i++;
        }
    }
    public void goToWorkplace(ActionEvent actionEvent) {
        Object node = actionEvent.getSource();
        Hyperlink b = (Hyperlink)node;
        try {
            app.goToAWorkplace(Integer.parseInt(b.getId()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
