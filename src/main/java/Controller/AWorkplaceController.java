//Polished, has TODO
package Controller;

import Models.Shift;
import Models.TeamAdmin;
import Models.Volunteer;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import static Main.App.*;

public class AWorkplaceController extends Controller {

    public Text workplaceTitle;
    public GridPane mainGrid;
    public GridPane adminGrid;
    public GridPane volGrid;
    public GridPane shiftGrid;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Init WorkplaceOverviewCtrl");
        String name = null;
        if (loginType == 1){
            name = (context.Volunteers.get(loginID).personalInfo.getFirstName() + " " +
                    context.Volunteers.get(loginID).personalInfo.getLastName());
        }
        else {
            name = "Admin " + context.TeamAdmins.get(loginID).personalInfo.getLastName();
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
        //TODO: Show workplaces in navGrid, this being visited=true
    }
}
