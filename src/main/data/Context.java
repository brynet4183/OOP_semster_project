package dataModel;
import java.Models.*;

Class DataMap Extends HashMap{
    public DataMap Where(){

    }
}

public class Context {
    HashMap<Int, Shift> Shifts = new HashMap<Int, Shift>;
    HashMap<Int,Team> Teams = new HashMap<Int,Team>;
    HashMap<Int,TeamAdmin> TeamAdmins = new HashMap<Int,TeamAdmin>;
    HashMap<Int,Volunteer> Volunteers = new HashMap<Int,Volunteer>;

    Context(){
        List<String> in = new ArrayList<String>();
        in = Reader.Read("teams");
        //id,name
        for (String inLine : in) {
            String[] line = inLine.Spilt(";", inLine);
            Teams.add(Int.parse(line[0]), new Team(Int.parse(line[0]), line[1]));
        }
        in = new ArrayList<String>();
        in = Reader.Read("teamAdmins");
        //id,name,password,salt,team_id
        for (String inLine : in) {
            String[] line = inLine.Spilt(";", inLine);
            TeamAdmins.add(Int.parse(line[0]), new Team(Int.parse(line[0]), line[1], line[2], line[3]));
            TeamAdmins.get(Int.parse(line[0])).team = Teams.get(Int.parse(line[4]));
            Teams.get(Int.parse(line[4])).teamAdmins.add(TeamAdmins.get(Int.parse(line[0])));
        }
        in = new ArrayList<String>();
        in = Reader.Read("volunteers");
        //id,name,password,salt,confirmed
        for (String inLine : in) {
            String[] line = inLine.Spilt(";", inLine);
            Volunteers.add(Int.parse(line[0]), new Team(Int.parse(line[0]), line[1], line[2], line[3], Boolean.parse(line[4])));
        }
        in = new ArrayList<String>();
        in = Reader.Read("shifts");
        //id,start,duration,team_id,volunteer_id
        for (String inLine : in) {
            String[] line = inLine.Spilt(";", inLine);
            Shifts.add(Int.parse(line[0]), new Team(Int.parse(line[0]), Int.parse(line[1]), Int.parse(line[2])));
            Shifts.get(Int.parse(line[0])).team = Teams.get(Int.parse(line[3]));
            Shifts.get(Int.parse(line[0])).volunteers = Volunteers.get(Int.parse(line[4]));
            Teams.get(Int.parse(line[3])).shifts.add(Shifts.get(Int.parse(line[0])));
            Volunteers.get(Int.parse(line[4])).shifts.add(Shifts.get(Int.parse(line[0])));
        }
        in = new ArrayList<String>();
        in = Reader.Read("volunteer_teams");
        //team_id,volunteer_id
        for (String inLine : in) {
            String[] line = inLine.Spilt(";", inLine);
            Teams.get(Int.parse(line[0])).volunteers.add(Volunteers.get(Int.parse(line[1])));
            Volunteers.get(Int.parse(line[1])).teams.add(Teams.get(Int.parse(line[0])));
        }
    }
    void Save(){
        List<String> outTeams = new ArrayList<String>();
        List<String> outTeamAdmins = new ArrayList<String>();
        List<String> outVolunteers = new ArrayList<String>();
        List<String> outShifts = new ArrayList<String>();
        List<String> outVoulnteerTeams = new ArrayList<String>();
        for (Team team : Teams) {
            int id = team.getId();
            //id,name
            outTeams.add(id + ";" + team.getName());
            //team_id,volunteer_id
            for (Volunteer v: team.volunteers) {
                outVoulnteerTeams.add(id + ";" + v.getId());
            }
        }
        //id,name,password,salt,team_id
        for (TeamAdmin ta : TeamAdmins) {
            outTeamAdmins.add(ta.getId() + ";" + ta.getName() + ";" + ta.getPassword() + ";" + ta.getSalt() + ";" + ta.team.getId());
        }
        //id,name,password,salt,confirmed
        for (Volunteer v : Volunteers) {
            outVolunteers.add(v.getId() + ";" + v.getName() + ";" + v.getPassword() + ";" + v.getSalt() + ";" + v.getConfirmed());
        }
        //id,start,duration,team_id,volunteer_id
        for (Shift s : Shifts) {
            outShifts.add(s.getId() + ";" + s.getStart() + ";" + s.getDuration() + ";" + s.team.getId() + ";" + s.volunteer.getId());
        }
        Writer.Write("teams", outTeams);
        Writer.Write("volunteer_teams", outVoulnteerTeams);
        Writer.Write("teamAdmins", outTeamAdmins);
        Writer.Write("volunteers", outVolunteers);
        Writer.Write("shifts", outShifts);
    }
}
