//Polished
package Controller;

import Models.Team;
import Models.Volunteer;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static Main.App.*;

public class EditWorkplaceController extends Controller {

    public GridPane mainGrid;
    public Text Title;
    public ComboBox<String> volunteers;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String name = "Admin " + context.TeamAdmins.get(loginID).personalInfo.getLastName();
        Team team = context.Teams.get(workPlace);
        loggedInAsLabel.setText(name);
        Title.setText(context.Teams.get(workPlace).getName());
        List<Volunteer> vList = context.Volunteers.selectVolunteer((x) -> x.getConfirmed());
        for (Volunteer v: vList) {
            if(v.teams.contains(team))
                continue;
            volunteers.getItems().add("(" + v.getId() + ")" + v.personalInfo.getFirstName() + " " + v.personalInfo.getLastName());
        }
        int i = 1;
        vList = context.Teams.get(workPlace).volunteers;
        for (Volunteer v: vList) {
            Text nameText = new Text(v.personalInfo.getFirstName() + " " + v.personalInfo.getLastName());
            Button volButton = new Button();
            volButton.setText("Fjern");
            volButton.setOnAction(this::removeTeamMember);
            volButton.setId(Integer.toString(v.getId()));
            mainGrid.add(nameText, 0,i);
            mainGrid.add(volButton, 1,i);
            i++;
        }
    }

    public void addTeamMember(ActionEvent actionEvent) {
        String sel = volunteers.getValue();
        sel = sel.replace("(", "").split("\\)")[0];
        Volunteer v = context.Volunteers.get(Integer.parseInt(sel));
        context.Teams.get(workPlace).volunteers.add(v);
        context.Volunteers.get(v.getId()).teams.add(context.Teams.get(workPlace));
        context.Save();
        try {
            app.goToEditTeam();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeTeamMember(ActionEvent actionEvent) {
        Object node = actionEvent.getSource();
        Button b = (Button)node;
        Volunteer v = context.Volunteers.get(Integer.parseInt(b.getId()));
        context.Teams.get(workPlace).volunteers.remove(v);
        context.Volunteers.get(v.getId()).teams.remove(context.Teams.get(workPlace));
        context.Save();
        try {
            app.goToEditTeam();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void goToAWorkplace(ActionEvent actionEvent) throws IOException {
        app.goToAWorkplace(workPlace);
    }

}
