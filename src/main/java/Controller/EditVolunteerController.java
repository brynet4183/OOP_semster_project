package Controller;

import Main.App;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static Main.App.*;
import static Main.App.context;

public class EditVolunteerController extends Controller {

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
    public TextField passField1;
    public TextField passField2;
    public Text passStatusLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Init Profilectrl");
        loggedInAsLabel.setText(context.TeamAdmins.get(loginID).personalInfo.getFirstName() + " " + context.TeamAdmins.get(loginID).personalInfo.getLastName());


        firstNameField.setText(context.Volunteers.get(volunteer_id).personalInfo.getFirstName());
        lastNameField.setText(context.Volunteers.get(volunteer_id).personalInfo.getLastName());
        languageField.setText(context.Volunteers.get(volunteer_id).personalInfo.getLanguage());
        emailField.setText(context.Volunteers.get(volunteer_id).personalInfo.getEmail());
        phoneNoField.setText(context.Volunteers.get(volunteer_id).personalInfo.getPhone());
        countryField.setText(context.Volunteers.get(volunteer_id).personalInfo.getCountry());
        zipField.setText(Integer.toString(context.Volunteers.get(volunteer_id).personalInfo.getZip()));
        cityField.setText(context.Volunteers.get(volunteer_id).personalInfo.getCity());
        streetField.setText(context.Volunteers.get(volunteer_id).personalInfo.getStreet());
        houseNoField.setText(context.Volunteers.get(volunteer_id).personalInfo.getNumber());
    }


    public void saveProfileChanges(ActionEvent actionEvent) throws IOException {
        context.Volunteers.get(volunteer_id).personalInfo.setFirstName(firstNameField.getText());
        context.Volunteers.get(volunteer_id).personalInfo.setLastName(lastNameField.getText());
        context.Volunteers.get(volunteer_id).personalInfo.setLanguage(languageField.getText());
        context.Volunteers.get(volunteer_id).personalInfo.setEmail(emailField.getText());
        context.Volunteers.get(volunteer_id).personalInfo.setPhone(phoneNoField.getText());
        context.Volunteers.get(volunteer_id).personalInfo.setCountry(countryField.getText());
        context.Volunteers.get(volunteer_id).personalInfo.setZip(Integer.parseInt(zipField.getText()));
        context.Volunteers.get(volunteer_id).personalInfo.setCity(cityField.getText());
        context.Volunteers.get(volunteer_id).personalInfo.setStreet(streetField.getText());
        context.Volunteers.get(volunteer_id).personalInfo.setNumber(houseNoField.getText());
        if (Objects.equals(passField1.getText(), "") && Objects.equals(passField2.getText(), "")){
            context.Save();
            app.goToProfile();
        }
        else{
            if (passField1.getText().equals(passField2.getText())){
                context.Volunteers.get(volunteer_id).setPassword(passField1.getText());
                context.Save();
                app.goToProfile();
            }
            else{
                passStatusLabel.setText("Adgangskoderne skal være ens!");
            }
        }
    }

    public void goToVolunteer(ActionEvent actionEvent) throws IOException {
        app.goToVolunteer(volunteer_id);
    }


}
