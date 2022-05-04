package Controller;

import Main.App;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static Main.App.*;

public class ProfileController implements Initializable {
    public Label loggedInAsLabel;
    public Text firstName;
    public Text lastName;
    public Text language;
    public Text email;
    public Text phoneNo;
    public Text country;
    public Text city;
    public Text zip;
    public Text street;
    public Text houseNo;

    //View mode info text


    //Struktur af reference til main-controller og funktionskald ved sceneskift
    //er lånt fra Christian Budtz' GitHub
    private App app;
    public void setParentController(App app) {this.app = app;}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Init Profilectrl");
        String name = null;
        if (app.loginType == 1){
            //firstName = context.Volunteers.selectVolunteer((x)->x.getId()==app.loginID).get(0).getName();
            firstName.setText(context.Volunteers.get(loginID).personalInfo.getFirstName());
            lastName.setText(context.Volunteers.get(loginID).personalInfo.getLastName());
            language.setText(context.Volunteers.get(loginID).personalInfo.getLanguage());
            email.setText(context.Volunteers.get(loginID).personalInfo.getEmail());
            phoneNo.setText(context.Volunteers.get(loginID).personalInfo.getPhone());
            country.setText(context.Volunteers.get(loginID).personalInfo.getCountry());
            city.setText(context.Volunteers.get(loginID).personalInfo.getCity());
            street.setText(context.Volunteers.get(loginID).personalInfo.getStreet());
            zip.setText(Integer.toString(context.Volunteers.get(loginID).personalInfo.getZip()));
            houseNo.setText(context.Volunteers.get(loginID).personalInfo.getNumber());

        }
        else {
            firstName.setText(context.TeamAdmins.get(loginID).personalInfo.getFirstName());
            lastName.setText(context.TeamAdmins.get(loginID).personalInfo.getLastName());
            language.setText(context.TeamAdmins.get(loginID).personalInfo.getLanguage());
            email.setText(context.TeamAdmins.get(loginID).personalInfo.getEmail());
            phoneNo.setText(context.TeamAdmins.get(loginID).personalInfo.getPhone());
            country.setText(context.TeamAdmins.get(loginID).personalInfo.getCountry());
            city.setText(context.TeamAdmins.get(loginID).personalInfo.getCity());
            street.setText(context.TeamAdmins.get(loginID).personalInfo.getStreet());
            zip.setText(Integer.toString(context.TeamAdmins.get(loginID).personalInfo.getZip()));
            houseNo.setText(context.TeamAdmins.get(loginID).personalInfo.getNumber());
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

    public void goToEditProfile(ActionEvent actionEvent) throws IOException {
        app.goToEditProfile();
    }



}
