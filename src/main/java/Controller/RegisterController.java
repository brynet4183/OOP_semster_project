package Controller;

import Main.App;
import Models.PersonalInfo;
import Models.Volunteer;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import java.io.IOException;
import static Main.App.context; //giver adgang til data

public class RegisterController {
    public Label registerStatusLabel;

    public TextField registerFirstnameField;
    public TextField registerLastnameField;
    public TextField registerEmailField;
    public TextField registerLanguageField;
    public TextField registerCityField;
    public TextField registerZipField;
    public TextField registerStreetField;
    public TextField registerNoField;
    public TextField registerCountryField;
    public TextField registerPhonenoField;

    //Struktur af reference til main-controller, initialize og funktionskald ved sceneskift
    //er lånt fra Christian Budtz' GitHub
    private App app;
    public void setParentController(App app) {this.app = app;}

    public void handleRegistration(ActionEvent actionEvent) {
    //Todo: lav en metode her lol
        if (allFieldsFilled()){
            PersonalInfo pi = new PersonalInfo(0, registerFirstnameField.getText(),registerLastnameField.getText(),registerLanguageField.getText(),registerEmailField.getText(),
                    registerPhonenoField.getText(),registerCountryField.getText(),Integer.parseInt(registerZipField.getText()),registerCityField.getText(),registerStreetField.getText(),registerNoField.getText());
            int volId = context.Volunteers.lastId()+1;
            Volunteer vol = new Volunteer(0,Integer.toString(volId),null,null,false);
            vol.setPassword("pass" + volId);
            context.PersonalInfos.insert(pi);
            vol.personalInfo = pi;
            context.Volunteers.insert(vol);
            registerStatusLabel.setText("Du er nu registreret"); //ToDo: det her skal kun dukke op upon conf
            registerStatusLabel.setTextFill(Color.GREEN);
            context.Save();
        }
        else{
            registerStatusLabel.setText("Du mangler at udfylde et eller flere felter");
            registerStatusLabel.setTextFill(Color.RED);
        }

    }

    public void handleBackClicked(ActionEvent actionEvent) throws IOException {
            app.goToLogin();
    }
    public boolean allFieldsFilled(){
        if( registerFirstnameField.getText()!=""    &&
            registerLastnameField.getText() !=""    &&
            registerEmailField.getText()    !=""    &&
            registerLanguageField.getText() !=""    &&
            registerCityField.getText()     !=""    &&
            registerZipField.getText()      !=""    &&
            registerStreetField.getText()   !=""    &&
            registerNoField.getText()       !=""    &&
            registerCountryField.getText()  !=""    &&
            registerPhonenoField.getText()  !=""    ) {
            return true;}
            else {return false;}
    }
    public void saveData(){

    }

}
