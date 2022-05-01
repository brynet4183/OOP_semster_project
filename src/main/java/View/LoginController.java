package View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    public PasswordField loginPasswordField;
    @FXML
    public TextField loginIDField;
    private App app;

    public void setParentController(App app) {this.app = app;}

    public void handleLoginBtnClick(ActionEvent actionEvent) {
        //Change Scene - welcome screen
    }
    public void handleRegisterBtnClick(ActionEvent mouseEvent) {
        try {
            app.viewReigster();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Initializing");
        //
        //loginPasswordField.requestFocus();
    }
}
