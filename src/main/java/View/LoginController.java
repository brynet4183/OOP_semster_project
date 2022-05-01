package View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    public Label underLoginLabel;
    public TextField loginIDField;
    public PasswordField loginPasswordField;
    private App app;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Initializing");
        loginIDField.requestFocus();        //Sætter text cursor i dette field
    }

    public void setParentController(App app) {this.app = app;}

    public void handleLoginBtnClick(ActionEvent actionEvent) {
        try {
            if ("admin".equals(loginIDField.getText()) && "admin".equals(loginPasswordField.getText())){
                app.login();
            }
            else {underLoginLabel.setText("Forkert ID eller password");
                  underLoginLabel.setTextFill(Color.RED);}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleRegisterBtnClick(ActionEvent mouseEvent) {
        try {
            app.goReigster();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
