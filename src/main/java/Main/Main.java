package Main;

import Main.App;
import Models.TeamAdmin;
import Models.Volunteer;
import data.Context;
import data.DataMap;
import java.util.HashMap;
import java.util.Map;

import data.DataMap;
public class Main {
    public static void main(String[] args) {
        Context context = new Context();
        for (Volunteer v: context.Volunteers.values()) {
            v.securePassword();
        }
        for (TeamAdmin ta: context.TeamAdmins.values()) {
            ta.securePassword();
        }
        context.Save();
    }
}
