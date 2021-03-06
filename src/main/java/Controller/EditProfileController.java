//Polished
package Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static Main.App.*;

public class EditProfileController extends Controller {

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
    public Text saveStatus;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Init Profilectrl");
        String name = null;
        if (loginType == 1){
            name = (context.Volunteers.get(loginID).personalInfo.getFirstName() + " " + context.Volunteers.get(loginID).personalInfo.getLastName());
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
            name = "Admin " + context.TeamAdmins.get(loginID).personalInfo.getLastName();
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
    }


    public void saveProfileChanges(ActionEvent actionEvent) throws IOException {
        if (!allFieldsFilled()){
            saveStatus.setText("Der er tomme profilinformationsfelter!");
            return;
        }
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
        if (passField1.getText()=="" && passField2.getText()==""){
            context.Save();
            app.goToProfile();
        }
        else{
            if (passField1.getText().equals(passField2.getText())){
                if (loginType==0){context.TeamAdmins.get(loginID).setPassword(passField1.getText());}
                else {context.Volunteers.get(loginID).setPassword(passField1.getText());}
                context.Save();
                app.goToProfile();
            }
            else{
                passStatusLabel.setText("Adgangskoderne skal v??re ens!");
            }
        }
    }
    public boolean allFieldsFilled(){
        if(!Objects.equals(firstNameField.getText(), "") &&
                !Objects.equals(lastNameField.getText(), "") &&
                !Objects.equals(emailField.getText(), "") &&
                !Objects.equals(languageField.getText(), "") &&
                !Objects.equals(cityField.getText(), "") &&
                !Objects.equals(zipField.getText(), "") &&
                !Objects.equals(streetField.getText(), "") &&
                !Objects.equals(houseNoField.getText(), "") &&
                !Objects.equals(countryField.getText(), "") &&
                !Objects.equals(phoneNoField.getText(), "")) {
            return true;}
        else {return false;}
    }

}
