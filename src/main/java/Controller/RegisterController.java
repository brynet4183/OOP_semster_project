//Polished. Has todo
package Controller;

import Main.App;
import Models.PersonalInfo;
import Models.Volunteer;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static Main.App.context;

public class RegisterController implements Initializable {
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
    //LoginInfo for registrant
    public Text loginInfoTitle;
    public Text loginIDTitle;
    public Text loginPassTitle;
    public Label loginIDInfo;
    public Label loginPassInfo;

    //Struktur af reference til main-controller, initialize og funktionskald ved sceneskift
    //er lånt fra Christian Budtz' GitHub
    private App app;
    public void setParentController(App app) {this.app = app;}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginInfoTitle.setText("");
        loginIDTitle.setText("");
        loginPassTitle.setText("");
        loginIDInfo.setText("");
        loginPassInfo.setText("");
    }

    public void handleRegistration(ActionEvent actionEvent) {
        if (allFieldsFilled()){
            PersonalInfo pi = new PersonalInfo(0,registerFirstnameField.getText(),
                    registerLastnameField.getText(),registerLanguageField.getText(),
                    registerEmailField.getText(),   registerPhonenoField.getText(),
                    registerCountryField.getText(), Integer.parseInt(registerZipField.getText()),
                    registerCityField.getText(),    registerStreetField.getText(), registerNoField.getText());
            int volId = context.Volunteers.lastId()+1;
            Volunteer vol = new Volunteer(0,Integer.toString(volId),null,null,false);
            vol.setPassword("pass" + volId);
            context.PersonalInfos.insert(pi);
            vol.personalInfo = pi;
            context.Volunteers.insert(vol);
            registerStatusLabel.setText("Du er nu registreret. Afvent godkendelse fra en administrator."); //todo() er der en måde det her kan confirmes på?
            registerStatusLabel.setTextFill(Color.GREEN);
            context.Save();
            loginInfoTitle.setText("Dine Loginoplysninger:");
            loginIDTitle.setText("Login-ID:");
            loginPassTitle.setText("Password:");
            loginIDInfo.setText(Integer.toString(context.Volunteers.get(volId).getId()));
            loginPassInfo.setText("pass" + (context.Volunteers.lastId()));
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
        if(!Objects.equals(registerFirstnameField.getText(), "") &&
                !Objects.equals(registerLastnameField.getText(), "") &&
                !Objects.equals(registerEmailField.getText(), "") &&
                !Objects.equals(registerLanguageField.getText(), "") &&
                !Objects.equals(registerCityField.getText(), "") &&
                !Objects.equals(registerZipField.getText(), "") &&
                !Objects.equals(registerStreetField.getText(), "") &&
                !Objects.equals(registerNoField.getText(), "") &&
                !Objects.equals(registerCountryField.getText(), "") &&
                !Objects.equals(registerPhonenoField.getText(), "")) {
            return true;}
        else {return false;}
    }


}
