package View;

import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {


    public TextField registerNameField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Initializing LoginController");
        registerNameField.requestFocus();        //Sætter text cursor i dette field
    }


}
