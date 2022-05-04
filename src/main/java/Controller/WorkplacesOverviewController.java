package Controller;

import Main.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static Main.App.context;

public class WorkplacesOverviewController implements Initializable {
    @FXML
    private Label loggedInAsLabel;

    public Hyperlink workplace0;
    public Hyperlink workplace1;
    public Hyperlink workplace2;
    public Text leader0;
    public Text leader1;
    public Text leader2;

    //Struktur af reference til main-controller og funktionskald ved sceneskift
    //er lånt fra Christian Budtz' GitHub
    private App app;
    public void setParentController(App app) {this.app = app;}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Init WorkplaceOverviewctrl");
        String name = null;
        if (app.loginType == 1){
            name = context.Volunteers.selectVolunteer((x)->x.getId()==app.loginID).get(0).getName();
        }
        else {
            name = context.TeamAdmins.selectTeamAdmin((x)->x.getId()==app.loginID).get(0).getName();
        }
        loggedInAsLabel.setText(name);
        //todo: init workplaces and leader values, variables already made
    }

    //GoTo Block:
    public void admGoToHome(ActionEvent actionEvent) throws IOException {
        app.login(0);
    }
    public void volGoToHome(ActionEvent actionEvent) throws IOException {
        app.login(1);
    }
    public void admGoToProfile(ActionEvent actionEvent) throws IOException{
        app.goToProfile(0);
    }
    public void volGoToProfile(ActionEvent actionEvent) throws IOException {
        app.goToProfile(1);
    }
    public void admGoToWorkplaces(ActionEvent actionEvent) throws IOException {
        app.goToWorkplaceOverview(0);
    }
    public void volGoToWorkplaces(ActionEvent actionEvent) throws IOException {
        app.goToWorkplaceOverview(1);
    }
    public void logOut(ActionEvent actionEvent) throws IOException {
        app.goToLogin();
    }


    public void volGoToWorkplace0(ActionEvent actionEvent) throws IOException {
        app.goToAWorkplace(0,0);
    }
    public void admGoToWorkplace0(ActionEvent actionEvent) throws IOException {
        app.goToAWorkplace(1,0);
    }
    public void volGoToWorkplace1(ActionEvent actionEvent) throws IOException {
        app.goToAWorkplace(0,1);
    }
    public void admGoToWorkplace1(ActionEvent actionEvent) throws IOException {
        app.goToAWorkplace(1,1);
    }
    public void admGoToWorkplace2(ActionEvent actionEvent) throws IOException {
        app.goToAWorkplace(0,2);
    }
    public void volGoToWorkplace2(ActionEvent actionEvent) throws IOException {
        app.goToAWorkplace(1,2);
    }

}
