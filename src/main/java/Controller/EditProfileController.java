package Controller;

import Main.App;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static Main.App.*;

public class EditProfileController implements Initializable {
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

    //Struktur af reference til main-controller, initialize og funktionskald ved sceneskift
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
            firstNameField.setText(context.Volunteers.get(loginID).personalInfo.getFirstName());
            lastNameField.setText(context.Volunteers.get(loginID).personalInfo.getLastName());
            languageField.setText(context.Volunteers.get(loginID).personalInfo.getLanguage());
            emailField.setText(context.Volunteers.get(loginID).personalInfo.getEmail());
            phoneNoField.setText(context.Volunteers.get(loginID).personalInfo.getPhone());
            countryField.setText(context.Volunteers.get(loginID).personalInfo.getCountry());
            zipField.setText(Integer.toString(context.Volunteers.get(loginID).personalInfo.getZip()));
            cityField.setText(context.Volunteers.get(loginID).personalInfo.getCity());
            streetField.setText(context.Volunteers.get(loginID).personalInfo.getStreet());
            houseNoField.setText(context.Volunteers.get(loginID).personalInfo.getNumber());

        }
        else {
            name = context.TeamAdmins.get(loginID).getName();
            firstNameField.setText(context.TeamAdmins.get(loginID).personalInfo.getFirstName());
            lastNameField.setText(context.TeamAdmins.get(loginID).personalInfo.getLastName());
            languageField.setText(context.TeamAdmins.get(loginID).personalInfo.getLanguage());
            emailField.setText(context.TeamAdmins.get(loginID).personalInfo.getEmail());
            phoneNoField.setText(context.TeamAdmins.get(loginID).personalInfo.getPhone());
            countryField.setText(context.TeamAdmins.get(loginID).personalInfo.getCountry());
            zipField.setText(Integer.toString(context.TeamAdmins.get(loginID).personalInfo.getZip()));
            cityField.setText(context.TeamAdmins.get(loginID).personalInfo.getCity());
            streetField.setText(context.TeamAdmins.get(loginID).personalInfo.getStreet());
            houseNoField.setText(context.TeamAdmins.get(loginID).personalInfo.getNumber());
        }
        loggedInAsLabel.setText(name);
        //todo: init personal values
        //todo: insert values in text fields
    }


    public void saveProfileChanges(ActionEvent actionEvent) throws IOException {
        if(loginType==1){
            context.Volunteers.get(loginID).personalInfo.setFirstName(firstNameField.getText());
            context.Volunteers.get(loginID).personalInfo.setLastName(lastNameField.getText());
            context.Volunteers.get(loginID).personalInfo.setLanguage(languageField.getText());
            context.Volunteers.get(loginID).personalInfo.setEmail(emailField.getText());
            context.Volunteers.get(loginID).personalInfo.setPhone(phoneNoField.getText());
            context.Volunteers.get(loginID).personalInfo.setCountry(countryField.getText());
            context.Volunteers.get(loginID).personalInfo.setZip(Integer.parseInt(zipField.getText()));
            context.Volunteers.get(loginID).personalInfo.setCity(cityField.getText());
            context.Volunteers.get(loginID).personalInfo.setStreet(streetField.getText());
            context.Volunteers.get(loginID).personalInfo.setNumber(houseNoField.getText());
        }
        else {
            context.TeamAdmins.get(loginID).personalInfo.setFirstName(firstNameField.getText());
            context.TeamAdmins.get(loginID).personalInfo.setLastName(lastNameField.getText());
            context.TeamAdmins.get(loginID).personalInfo.setLanguage(languageField.getText());
            context.TeamAdmins.get(loginID).personalInfo.setEmail(emailField.getText());
            context.TeamAdmins.get(loginID).personalInfo.setPhone(phoneNoField.getText());
            context.TeamAdmins.get(loginID).personalInfo.setCountry(countryField.getText());
            context.TeamAdmins.get(loginID).personalInfo.setZip(Integer.parseInt(zipField.getText()));
            context.TeamAdmins.get(loginID).personalInfo.setCity(cityField.getText());
            context.TeamAdmins.get(loginID).personalInfo.setStreet(streetField.getText());
            context.TeamAdmins.get(loginID).personalInfo.setNumber(houseNoField.getText());
        }
        //todo: mangler first name!
        context.Save();
        app.goToProfile();
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


}
