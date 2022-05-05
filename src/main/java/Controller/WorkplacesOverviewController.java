package Controller;

import Main.App;
import Models.Team;
import Models.TeamAdmin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static Main.App.context;
import static Main.App.loginID;

public class WorkplacesOverviewController implements Initializable {

    @FXML
    private Label loggedInAsLabel;

    public GridPane mainGrid;
    public GridPane navGrid;

    //Struktur af reference til main-controller, initialize og funktionskald ved sceneskift
    //er lånt fra Christian Budtz' GitHub
    private App app;
    public void setParentController(App app) {this.app = app;}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Init WorkplaceOverviewctrl");
        String name = null;
        List<Team> tList = new ArrayList<>();
        if (app.loginType == 1){
            name = context.Volunteers.selectVolunteer((x)->x.getId()==app.loginID).get(0).getName();
            tList = context.Volunteers.get(app.loginID).teams;
        }
        else {
            name = "Admin " + context.TeamAdmins.get(loginID).personalInfo.getLastName();
            tList = context.Teams.selectTeam((x) -> x.getId() > 0);
        }
        loggedInAsLabel.setText(name);
        int i = 1;
        for (Team t : tList) {
            Hyperlink nextLink = new Hyperlink(t.getName());
            nextLink.setOnAction(this::goToWorkplace);
            nextLink.setId(Integer.toString(t.getId()));
            nextLink.setUnderline(true);
            mainGrid.add(nextLink, 0,i);
            nextLink = new Hyperlink(t.getName());
            nextLink.setOnAction(this::goToWorkplace);
            nextLink.setId(Integer.toString(t.getId()));
            nextLink.setUnderline(true);
            navGrid.add(nextLink, 0,i+(app.loginType == 1 ? 1 : 3));
            List<TeamAdmin> taList = t.teamAdmins;
            int j = 1;
            for (TeamAdmin ta : taList) {
                Text nextAdmin = new Text(ta.getName());
                mainGrid.add(nextAdmin, j,i);
                j++;
            }
            i++;
        }
    }

    //GoTo Block:
    public void goToHome(ActionEvent actionEvent) throws IOException {
        app.login();
    }
    public void goToProfile(ActionEvent actionEvent) throws IOException{
        app.goToProfile();
    }
    public void goToWorkplaces(ActionEvent actionEvent) throws IOException {
        app.goToWorkplaceOverview();
    }
    public void logOut(ActionEvent actionEvent) throws IOException {
        app.goToLogin();
    }


    public void goToWorkplace(ActionEvent actionEvent) {
        Object node = actionEvent.getSource();
        Hyperlink b = (Hyperlink)node;
        try {
            app.goToAWorkplace(Integer.parseInt(b.getId()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void goToWorkplace0(ActionEvent actionEvent) throws IOException {
        app.goToAWorkplace(0);
    }
    public void goToWorkplace1(ActionEvent actionEvent) throws IOException {
        app.goToAWorkplace(1);
    }
    public void goToWorkplace2(ActionEvent actionEvent) throws IOException {
        app.goToAWorkplace(2);
    }

    public void goToConfirmVolunteer(ActionEvent actionEvent) throws IOException {
        app.goToConfirmVolunteer();
    }
    public void goToFindVolunteer(ActionEvent actionEvent) throws IOException {
        app.goToFindVolunteer();
    }


}
