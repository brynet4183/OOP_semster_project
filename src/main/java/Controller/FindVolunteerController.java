package Controller;
import Models.Volunteer;
import Main.App;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static Main.App.context;
import static Main.App.loginID;

public class FindVolunteerController implements Initializable {
    public Label loggedInAsLabel;
    public ListView<String> listView;
    public TextField searchField;
    //Struktur af reference til main-controller, initialize og funktionskald ved sceneskift
    //er lånt fra Christian Budtz' GitHub
    private App app;
    public void setParentController(App app) {this.app = app;}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loggedInAsLabel.setText("Admin " + context.TeamAdmins.get(loginID).personalInfo.getLastName());

        searchField.textProperty().addListener(((observableValue, s, t1) -> {
            listView.getItems().clear();
            List<String> list = new ArrayList<>();
            for (Volunteer v: context.Volunteers.selectVolunteer((x)-> x.personalInfo.getFirstName().contains(t1) || x.personalInfo.getLastName().contains(t1))) {
                list.add(v.personalInfo.getFirstName() + " " + v.personalInfo.getLastName());
                System.out.println(v.personalInfo.getFirstName() + " " + v.personalInfo.getLastName());
            }
            listView.getItems().addAll(list);
        }));
    }






    //GoTo Block:
    public void goToHome(ActionEvent actionEvent) throws IOException {
        app.login();
    }
    public void goToProfile(ActionEvent actionEvent) throws IOException{
        app.goToProfile();
    }
    public void goToWorkplaces(ActionEvent actionEvent) throws IOException {
        app.goToWorkplaceOverview();
    }
    public void logOut(ActionEvent actionEvent) throws IOException {
        app.goToLogin();
    }

    public void goToConfirmVolunteer(ActionEvent actionEvent) throws IOException {
        app.goToConfirmVolunteer();
    }
    public void goToFindVolunteer(ActionEvent actionEvent) throws IOException {
        app.goToFindVolunteer();
    }

    public void search(ActionEvent actionEvent) {
        searchField.textProperty().addListener(((observableValue, s, t1) -> {
            listView.getItems().clear();
            List<String> list = new ArrayList<>();
            for (Volunteer v: context.Volunteers.selectVolunteer((x)-> x.personalInfo.getFirstName().contains(t1) || x.personalInfo.getLastName().contains(t1))) {
                list.add(v.personalInfo.getFirstName() + " " + v.personalInfo.getLastName());
                System.out.println(v.personalInfo.getFirstName() + " " + v.personalInfo.getLastName());
            }
            listView.getItems().addAll(list);
        }));
    }
}
