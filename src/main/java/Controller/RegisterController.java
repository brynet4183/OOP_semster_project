package Controller;

import Main.App;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.IOException;

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


    private App app;

    public void setParentController(App app) {this.app = app;}

    public void handleRegistration(ActionEvent actionEvent) {
    //Todo: lav en metode her lol
        if (allFieldsFilled()){
            registerStatusLabel.setText("Du er nu registreret"); //ToDo: det her skal kun dukke op upon conf
            registerStatusLabel.setTextFill(Color.GREEN);
        }
        else{
            registerStatusLabel.setText("Du mangler at udfylde et eller flere felter");
            registerStatusLabel.setTextFill(Color.RED);
        }

    }

    public void handleBackClicked(ActionEvent actionEvent) {
        try {
            app.goToLogin();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
}
