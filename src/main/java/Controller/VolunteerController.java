package Controller;

import Models.Shift;
import Models.Volunteer;
import javafx.event.ActionEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static Main.App.context;
import static Main.App.loginID;

public class VolunteerController extends Controller {
    public Text nameLabel;
    public GridPane shiftGrid;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Init Volunteerctrl");
        String name = null;
        Volunteer volunteer = context.Volunteers.get(app.volunteer_id);
        name = (volunteer.personalInfo.getFirstName() + " " +
                volunteer.personalInfo.getLastName());
        List<Shift> sList = volunteer.shifts;
        int i = 1;
        for (Shift s: sList) {
            Text startText = new Text(s.getStart());
            Text endText = new Text(s.getEnd());
            Text durText = new Text(s.getDuration());
            Text teamText = new Text(s.team.getName());
            shiftGrid.add(teamText, 0,i);
            shiftGrid.add(startText, 1,i);
            shiftGrid.add(endText, 2,i);
            shiftGrid.add(durText, 3,i);
            i++;
        }
        loggedInAsLabel.setText("Admin " + context.TeamAdmins.get(loginID).personalInfo.getLastName());
        nameLabel.setText(name);
    }

    public void goToEditVolunteer(ActionEvent actionEvent) throws IOException {
        app.goToEditVolunteer();
    }
}
