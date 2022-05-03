package Main;

import View.App;
import data.Context;
import data.DataMap;
import java.util.HashMap;
import java.util.Map;

import data.DataMap;
public class Main {
    public static void main(String[] args) {
        Context context = new Context();
        System.out.println(context.Teams.selectTeam((x) -> x.getId() == 1).get(0).getName());
        System.out.println(context.Volunteers.selectVolunteer((x) -> x.getId() == 1).get(0).getName());
        context.Volunteers.selectVolunteer((x) -> x.getId() == 1).get(0).setName("test");
        context.Save();
        System.out.println(context.Volunteers.selectVolunteer((x) -> x.getId() == 1).get(0).getName());
    }
}
