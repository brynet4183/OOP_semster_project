//Polished, has TODO
package Controller;

import Models.Shift;
import Models.Team;
import Models.TeamAdmin;
import Models.Volunteer;
import javafx.event.ActionEvent;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import static Main.App.*;

public class AWorkplaceController extends Controller {

    public Text workplaceTitle;
    public GridPane mainGrid;
    public GridPane navGrid;
    public GridPane adminGrid;
    public GridPane volGrid;
    public GridPane shiftGrid;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Init WorkplaceOverviewCtrl");
        String name = null;
        List<Team> tList = new ArrayList<>();//EXP
        if (loginType == 1){
            name = (context.Volunteers.get(loginID).personalInfo.getFirstName() + " " +
                    context.Volunteers.get(loginID).personalInfo.getLastName());
                    tList = context.Volunteers.get(loginID).teams;//EXP
        }
        else {
            name = "Admin " + context.TeamAdmins.get(loginID).personalInfo.getLastName();
            tList = context.Teams.selectTeam((x) -> x.getId() > 0);//EXP
        }
        loggedInAsLabel.setText(name);
        workplaceTitle.setText(context.Teams.get(workPlace).getName());
        List<TeamAdmin> taList = context.Teams.get(workPlace).teamAdmins;
        int i = 1;
        for (TeamAdmin ta: taList) {
            Text nameText = new Text(ta.personalInfo.getFirstName() + " " + ta.personalInfo.getLastName());
            adminGrid.add(nameText, 0, i);
            i++;
        }
        List<Volunteer> vList = context.Teams.get(workPlace).volunteers;
        i = 1;
        for (Volunteer v: vList) {
            Text nameText = new Text(v.personalInfo.getFirstName() + " " + v.personalInfo.getLastName());
            volGrid.add(nameText, 0, i);
            i++;
        }
        List<Shift> sList = context.Teams.get(workPlace).shifts;
        i = 1;
        for (Shift s: sList) {
            Text shiftText = new Text(s.volunteer.personalInfo.getFirstName() + " " + s.getStart() +" - " + s.getEnd());
            shiftGrid.add(shiftText, 0, i);
            i++;
        }

        //EXPERIMENT>
        int navi = 1;
        for (Team t : tList) { //todo: set connected admin text to "Admin + adminLastName?"
            Hyperlink nextLink = new Hyperlink(t.getName());
            nextLink.setOnAction(this::goToWorkplace);
            nextLink.setId(Integer.toString(t.getId()));
            nextLink.setUnderline(true);
            nextLink = new Hyperlink(t.getName());
            nextLink.setOnAction(this::goToWorkplace);
            nextLink.setId(Integer.toString(t.getId()));
            nextLink.setUnderline(true);
            if(navi <= 3)
                navGrid.add(nextLink, 0,navi+(loginType == 1 ? 1 : 3));
            List<TeamAdmin> taaList = t.teamAdmins;
            int j = 1;
            for (TeamAdmin ta : taaList) {
                Text nextAdmin = new Text(ta.getName());
                j++;
            }
            navi++;
        }

        //<EXPERIMENT

        //TODO: Show workplaces in navGrid, this being visited=true
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
