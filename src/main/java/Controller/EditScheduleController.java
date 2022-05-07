//Polished
package Controller;

import Models.Shift;
import Models.Team;
import Models.Volunteer;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static Main.App.*;

public class EditScheduleController extends Controller {

    public GridPane mainGrid;
    public Text Title;
    public ComboBox<String> volunteers;
    public ComboBox<String> dates;
    public TextField duration;
    public TextField start;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String name = "Admin " + context.TeamAdmins.get(loginID).personalInfo.getLastName();
        Team team = context.Teams.get(workPlace);
        loggedInAsLabel.setText(name);
        Title.setText(context.Teams.get(workPlace).getName());
        List<Volunteer> vList = context.Teams.get(workPlace).volunteers;
        for (Volunteer v: vList) {
            volunteers.getItems().add("(" + v.getId() + ")" + v.personalInfo.getFirstName() + " " + v.personalInfo.getLastName());
        }
        int i = 1;
        List<Shift> sList = context.Teams.get(workPlace).shifts;
        for (Shift s: sList) {
            Text nameText = new Text(s.volunteer.personalInfo.getFirstName() + " " + s.getStart() + " - " + s.getEnd());
            Button shiftButton = new Button();
            shiftButton.setText("Fjern");
            shiftButton.setOnAction(this::removeShift);
            shiftButton.setId(Integer.toString(s.getId()));
            mainGrid.add(nameText, 0,i);
            mainGrid.add(shiftButton, 1,i);
            i++;
        }
        dates.getItems().addAll(
                "(0) Lørdag 25/6",
                "(1) Søndag 26/6",
                "(2) Mandag 27/6",
                "(3) Tirsdag 28/6",
                "(4) Onsdag 29/6",
                "(5) Torsdag 30/6",
                "(6) Fredag 1/7",
                "(7) Lørdag 2/7"
        );
    }
    public void removeShift(ActionEvent actionEvent) {
        Object node = actionEvent.getSource();
        Button b = (Button)node;
        context.Shifts.remove(Integer.parseInt(b.getId()));
        context.Save();
        try {
            app.goToEditSchedule();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void addShift(ActionEvent actionEvent) {
        int duration = 0;
        int start = 0;
        String sel = volunteers.getValue();
        sel = sel.replace("(", "").split("\\)")[0];
        String days = dates.getValue();
        days = days.replace("(", "").split("\\)")[0];
        start = Integer.parseInt(days)*1440;
        String durTime = this.duration.getText();
        String dhour = durTime.substring(0,2);
        String dmin = durTime.substring(3,5);
        duration = Integer.parseInt(dhour.substring(0,1))*600 + Integer.parseInt(dhour.substring(1,2))*60;
        duration += Integer.parseInt(dmin.substring(0,1))*10 + Integer.parseInt(dmin.substring(1,2));
        String startTime = this.start.getText();
        String shour = startTime.substring(0,2);
        String smin = startTime.substring(3,5);
        start += Integer.parseInt(shour.substring(0,1))*600 + Integer.parseInt(shour.substring(1,2))*60;
        start += Integer.parseInt(smin.substring(0,1))*10 + Integer.parseInt(smin.substring(1,2));
        Shift s = new Shift(0, start,duration);
        s.volunteer = context.Volunteers.get(Integer.parseInt(sel));
        s.team = context.Teams.get(workPlace);
        context.Shifts.insert(s);
        context.Save();
        try {
            app.goToEditSchedule();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void goToAWorkplace(ActionEvent actionEvent) throws IOException {
        app.goToAWorkplace(workPlace);
    }

}
