package Controller;
import Models.Volunteer;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static Main.App.context;
import static Main.App.loginID;

public class FindVolunteerController extends Controller {
    public ListView<String> listView;
    public TextField searchField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loggedInAsLabel.setText("Admin " + context.TeamAdmins.get(loginID).personalInfo.getLastName());

        searchField.textProperty().addListener(((observableValue, s, t1) -> {
            listView.getItems().clear();
            List<String> list = new ArrayList<>();
            for (Volunteer v: context.Volunteers.selectVolunteer((x)-> x.personalInfo.getFirstName().contains(t1) || x.personalInfo.getLastName().contains(t1))) {
                list.add("(" + v.getId() + ")" + v.personalInfo.getFirstName() + " " + v.personalInfo.getLastName());
                System.out.println(v.personalInfo.getFirstName() + " " + v.personalInfo.getLastName());
            }
            listView.getItems().addAll(list);
        }));
    }

    public void search(ActionEvent actionEvent) {
        searchField.textProperty().addListener(((observableValue, s, t1) -> {
            listView.getItems().clear();
            List<String> list = new ArrayList<>();
            for (Volunteer v: context.Volunteers.selectVolunteer((x)-> x.personalInfo.getFirstName().contains(t1) || x.personalInfo.getLastName().contains(t1))) {
                list.add("(" + v.getId() + ")" + v.personalInfo.getFirstName() + " " + v.personalInfo.getLastName());
                System.out.println(v.personalInfo.getFirstName() + " " + v.personalInfo.getLastName());
            }
            listView.getItems().addAll(list);
        }));
    }

    public void goToVolunteer(MouseEvent actionEvent) throws IOException {
        String sel = listView.getSelectionModel().getSelectedItem();
        sel = sel.replace("(", "").split("\\)")[0];
        app.goToVolunteer(Integer.parseInt(sel));
    }
}
