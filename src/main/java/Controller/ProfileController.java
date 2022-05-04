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
import static Main.App.loginID;

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
            //name = context.Volunteers.selectVolunteer((x)->x.getId()==app.loginID).get(0).getName();
            name = context.Volunteers.get(loginID).getName();
        }
        else {
            name = context.TeamAdmins.get(loginID).getName();
        }
        loggedInAsLabel.setText(name);
        //todo: init personal values
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

    //Edit profile
    public void admGoToEditProfile(ActionEvent actionEvent) throws IOException {
        app.goToEditProfile();
        //todo: insert values in text fields
    }
    public void volGoToEditProfile(ActionEvent actionEvent) throws IOException {
        app.goToEditProfile();
        //todo: insert values in text fields
    }
    public void volSaveProfileChanges(ActionEvent actionEvent) throws IOException {

        context.Volunteers.get(loginID).setName(firstNameField.getText());

        //todo: save ALL fields


        context.Save();
        app.goToProfile();
    }
}
