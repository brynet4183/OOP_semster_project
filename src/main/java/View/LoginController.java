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

    public Label underLoginLabel;
    public TextField loginIDField;
    public PasswordField loginPasswordField;
    public RadioButton loginRadioVolunteer;
    public RadioButton loginRadioAdmin;
    private App app;

    public void setParentController(App app) {this.app = app;}

    public void handleLoginBtnClick(ActionEvent actionEvent) {
        try {
            if ( loginRadioAdmin.isSelected() &&
                    "admin".equals(loginIDField.getText()) &&
                    "admin".equals(loginPasswordField.getText())){
                app.login(0);
            }
            else if (loginRadioVolunteer.isSelected()){ //TODO: currently has no check for credentials
                app.login(1);
            }
            else {underLoginLabel.setText("Forkert ID eller password");
                  underLoginLabel.setTextFill(Color.RED);}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleRegisterBtnClick(ActionEvent mouseEvent) {
        try {
            app.goToRegister();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
