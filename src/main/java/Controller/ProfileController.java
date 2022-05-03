package Controller;

import Main.App;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static Main.App.context; //giver adgang til data

public class ProfileController implements Initializable {
    public Label loggedInAsLabel;
    //Edit mode text fields
    public TextField firstNameField;
    public TextField lastNameField;
    public TextField languageField;
    public TextField emailField;
    public TextField phoneNoField;
    public TextField countryField;
    public TextField zipField;
    public TextField cityField;
    public TextField streetField;
    public TextField houseNoField;

    //Struktur af reference til main-controller og funktionskald ved sceneskift
    //er lånt fra Christian Budtz' GitHub
    private App app;
    public void setParentController(App app) {this.app = app;}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Init Profilectrl");
        String name = null;
        if (app.loginType == 1){
            name = context.Volunteers.selectVolunteer((x)->x.getId()==app.loginID).get(0).getName();
        }
        else {
            name = context.TeamAdmins.selectTeamAdmin((x)->x.getId()== app.loginID).get(0).getName();
        }
        loggedInAsLabel.setText(name);
        //todo: init personal values
    }


    //GoTo Block:
    public void admGoToHome(ActionEvent actionEvent) throws IOException {
        app.login(0);
    }
    public void volGoToHome(ActionEvent actionEvent) throws IOException {
        app.login(1);
    }
    public void admGoToProfile(ActionEvent actionEvent) throws IOException{
        app.goToProfile(0);
    }
    public void volGoToProfile(ActionEvent actionEvent) throws IOException {
        app.goToProfile(1);
    }
    public void admGoToWorkplaces(ActionEvent actionEvent) throws IOException {
        app.goToWorkplaceOverview(0);
    }
    public void volGoToWorkplaces(ActionEvent actionEvent) throws IOException {
        app.goToWorkplaceOverview(1);
    }
    public void logOut(ActionEvent actionEvent) throws IOException {
        app.goToLogin();
    }

    //Edit profile
    public void volEditProfile(ActionEvent actionEvent) throws IOException {
        app.editProfile(1);
    }
    public void saveProfileChanges(ActionEvent actionEvent) throws IOException {
        app.goToProfile(1); //todo: save changes
    }
}
