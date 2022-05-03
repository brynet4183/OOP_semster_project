package Controller;

import Main.App;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static Main.App.context;

public class WorkplacesOverviewController implements Initializable {

    public Label loggedInAsLabel;
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
    }

    public void aGoToHome(ActionEvent actionEvent) throws IOException {
        app.login(0);
    }
    public void vGoToHome(ActionEvent actionEvent) throws IOException {
        app.login(1);
    }


    public void vGoToProfile(ActionEvent actionEvent) {
    }

    public void vGoToWorkplaces(ActionEvent actionEvent) {
    }

    
}
