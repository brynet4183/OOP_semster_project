package Controller;

import Main.App;
import Models.PersonalInfo;
import Models.Volunteer;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Text;
import javafx.scene.control.Label;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static Main.App.context;
import static Main.App.loginID;

public class ConfirmVolunteerController implements Initializable {

    public GridPane mainGrid;

    public Label loggedInAsLabel;
    //Struktur af reference til main-controller, initialize og funktionskald ved sceneskift
    //er lånt fra Christian Budtz' GitHub
    private App app;
    public void setParentController(App app) {this.app = app;}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loggedInAsLabel.setText("Admin " + context.TeamAdmins.get(loginID).personalInfo.getLastName());

        List<Volunteer> vList = context.Volunteers.selectVolunteer((x) -> !x.getConfirmed());
        int i = 1;
        for (Volunteer v :vList) {
            GridPane nextRow = new GridPane();
            ColumnConstraints col1 = new ColumnConstraints();
            col1.setPrefWidth(25);
            col1.setHgrow(Priority.SOMETIMES);
            ColumnConstraints col2 = new ColumnConstraints();
            col2.setPrefWidth(90);
            col2.setHgrow(Priority.SOMETIMES);
            ColumnConstraints col3 = new ColumnConstraints();
            col3.setPrefWidth(60);
            col3.setHgrow(Priority.SOMETIMES);
            ColumnConstraints col4 = new ColumnConstraints();
            col4.setPrefWidth(120);
            col4.setHgrow(Priority.SOMETIMES);
            ColumnConstraints col5 = new ColumnConstraints();
            col5.setPrefWidth(60);
            col5.setHgrow(Priority.SOMETIMES);
            ColumnConstraints col6 = new ColumnConstraints();
            col6.setPrefWidth(90);
            col6.setHgrow(Priority.SOMETIMES);
            ColumnConstraints col7 = new ColumnConstraints();
            col7.setPrefWidth(50);
            col7.setHgrow(Priority.SOMETIMES);
            ColumnConstraints col8 = new ColumnConstraints();
            col8.setMinWidth(20);
            col8.setHgrow(Priority.SOMETIMES);
            nextRow.getColumnConstraints().addAll(col1,col2,col3,col4,col5,col6,col7,col8);

            Text idText = new Text();
            idText.setText(Integer.toString(v.getId()));
            idText.setStrokeWidth(0.0);
            idText.setStrokeType(StrokeType.OUTSIDE);
            Text nameText = new Text(v.personalInfo.getFirstName() + " " + v.personalInfo.getLastName());
            nameText.setStrokeWidth(0.0);
            nameText.setStrokeType(StrokeType.OUTSIDE);
            Text languageText = new Text(v.personalInfo.getLanguage());
            languageText.setStrokeWidth(0.0);
            languageText.setStrokeType(StrokeType.OUTSIDE);
            Text emailText = new Text(v.personalInfo.getEmail());
            emailText.setStrokeWidth(0.0);
            emailText.setStrokeType(StrokeType.OUTSIDE);
            Text phoneText = new Text(v.personalInfo.getPhone());
            phoneText.setStrokeWidth(0.0);
            phoneText.setStrokeType(StrokeType.OUTSIDE);
            Text countryText = new Text(v.personalInfo.getCountry());
            countryText.setStrokeWidth(0.0);
            countryText.setStrokeType(StrokeType.OUTSIDE);
            Text cityText = new Text(v.personalInfo.getCity());
            cityText.setStrokeWidth(0.0);
            cityText.setStrokeType(StrokeType.OUTSIDE);
            Button button = new Button();
            button.setText("Godkend");
            button.setId(Integer.toString(v.getId()));
            button.setOnAction(this::confirmVolunteer);

            nextRow.addColumn(0, idText);
            nextRow.addColumn(1, nameText);
            nextRow.addColumn(2, languageText);
            nextRow.addColumn(3, emailText);
            nextRow.addColumn(4, phoneText);
            nextRow.addColumn(5, countryText);
            nextRow.addColumn(6, cityText);
            nextRow.addColumn(7, button);
            mainGrid.addRow(i,nextRow);
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

    //Adm only methods
    public void goToConfirmVolunteers(ActionEvent actionEvent) throws IOException {app.goToConfirmVolunteer();}
    public void goToFindVolunteer(ActionEvent actionEvent) {app.goToFindVolunteer();}

    public void confirmVolunteer(ActionEvent actionEvent) {
        Object node = actionEvent.getSource();
        Button b = (Button)node;
        context.Volunteers.get(Integer.parseInt(b.getId())).confrim();
        context.Save();
        try {
            app.goToConfirmVolunteer();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
