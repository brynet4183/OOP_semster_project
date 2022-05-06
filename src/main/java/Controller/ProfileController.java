//Polished
package Controller;

import javafx.scene.text.Text;
import java.net.URL;
import java.util.ResourceBundle;
import static Main.App.*;

public class ProfileController extends Controller {
    public Text firstName;
    public Text lastName;
    public Text language;
    public Text email;
    public Text phoneNo;
    public Text country;
    public Text city;
    public Text zip;
    public Text street;
    public Text houseNo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Init Profilectrl");
        String name = null;
        if (app.loginType == 1){
            name = (context.Volunteers.get(loginID).personalInfo.getFirstName() + " " +
                    context.Volunteers.get(loginID).personalInfo.getLastName());
            firstName.setText(context.Volunteers.get(loginID).personalInfo.getFirstName());
            lastName.setText(context.Volunteers.get(loginID).personalInfo.getLastName());
            language.setText(context.Volunteers.get(loginID).personalInfo.getLanguage());
            email.setText(context.Volunteers.get(loginID).personalInfo.getEmail());
            phoneNo.setText(context.Volunteers.get(loginID).personalInfo.getPhone());
            country.setText(context.Volunteers.get(loginID).personalInfo.getCountry());
            city.setText(context.Volunteers.get(loginID).personalInfo.getCity());
            street.setText(context.Volunteers.get(loginID).personalInfo.getStreet());
            zip.setText(Integer.toString(context.Volunteers.get(loginID).personalInfo.getZip()));
            houseNo.setText(context.Volunteers.get(loginID).personalInfo.getNumber());

        }
        else {
            name = "Admin " + context.TeamAdmins.get(loginID).personalInfo.getLastName();
            firstName.setText(context.TeamAdmins.get(loginID).personalInfo.getFirstName());
            lastName.setText(context.TeamAdmins.get(loginID).personalInfo.getLastName());
            language.setText(context.TeamAdmins.get(loginID).personalInfo.getLanguage());
            email.setText(context.TeamAdmins.get(loginID).personalInfo.getEmail());
            phoneNo.setText(context.TeamAdmins.get(loginID).personalInfo.getPhone());
            country.setText(context.TeamAdmins.get(loginID).personalInfo.getCountry());
            city.setText(context.TeamAdmins.get(loginID).personalInfo.getCity());
            street.setText(context.TeamAdmins.get(loginID).personalInfo.getStreet());
            zip.setText(Integer.toString(context.TeamAdmins.get(loginID).personalInfo.getZip()));
            houseNo.setText(context.TeamAdmins.get(loginID).personalInfo.getNumber());
        }
        loggedInAsLabel.setText(name);
    }

}
