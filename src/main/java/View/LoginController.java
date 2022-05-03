package View;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController{

    public Label loginStatusLabel;
    public TextField loginIDField;
    public PasswordField loginPasswordField;
    public RadioButton loginRadioVolunteer;
    public RadioButton loginRadioAdmin;

    //Struktur af reference til main-controller og funktionskald ved sceneskift
    // (f.eks. login() eller goToRegister()) er lånt fra Christian Budtz' GitHub
    private App app;
    public void setParentController(App app) {this.app = app;}

    public void handleLoginBtnClick(ActionEvent actionEvent) throws IOException {
            if ( loginRadioAdmin.isSelected() &&
                    "admin".equals(loginIDField.getText()) &&
                    "admin".equals(loginPasswordField.getText())){
                app.login(0); //login mode: admin
            }
            else if (loginRadioVolunteer.isSelected()){ //TODO: currently has no check for credentials
                app.login(1); //login mode: volunteer
            }
            else {loginStatusLabel.setText("Forkert ID eller password");
                  loginStatusLabel.setTextFill(Color.RED);}
    }

    public void handleRegisterBtnClick(ActionEvent mouseEvent) throws IOException {
            app.goToRegister();
    }

}
