package Controller;

import Main.App;
import Models.TeamAdmin;
import Models.Volunteer;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.awt.desktop.SystemEventListener;
import java.io.IOException;
import java.util.List;

import static Main.App.context;

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
            if ( loginRadioAdmin.isSelected()){
                List<TeamAdmin> taList = context.TeamAdmins.selectTeamAdmin((x) -> x.getName().equals(loginIDField.getText()));
                if(!taList.isEmpty() && taList.get(0).login(loginPasswordField.getText())){
                    app.loginID = taList.get(0).getId();
                    app.loginType = 0;
                    app.login(0); //login mode: admin
                    return;
                }
            }
            else if (loginRadioVolunteer.isSelected()){
                List<Volunteer> vList = context.Volunteers.selectVolunteer((x) -> x.getName().equals(loginIDField.getText()));
                if(!vList.isEmpty() && vList.get(0).login(loginPasswordField.getText())){
                    app.loginID = vList.get(0).getId();
                    app.loginType = 1;
                    app.login(1);
                    return;
                }
            }
            loginStatusLabel.setText("Forkert ID eller password");
            loginStatusLabel.setTextFill(Color.RED);
    }

    public void handleRegisterBtnClick(ActionEvent mouseEvent) throws IOException {
            app.goToRegister();
    }

}
