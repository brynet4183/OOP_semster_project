package data;

import Models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class DataMap<K extends Integer, V extends Model> extends HashMap<K, V> {
    public List<V> selectTeam(WhereTeam ws){
        List<V> rd = new ArrayList<>();
        for (V v : this.values()) {
            if(ws.run((Team) v)){
                rd.add(v);
            }
        }
        return rd;
    }
    public List<V> selectShift(WhereShift ws){
        List<V> rd = new ArrayList<>();
        for (V v : this.values()) {
            if(ws.run((Shift) v)){
                rd.add(v);
            }
        }
        return rd;
    }
    public List<V> selectTeamAdmin(WhereTeamAdmin ws){
        List<V> rd = new ArrayList<>();
        for (V v : this.values()) {
            if(ws.run((TeamAdmin) v)){
                rd.add(v);
            }
        }
        return rd;
    }
    public List<V> selectVolunteer(WhereVolunteer ws){
        List<V> rd = new ArrayList<>();
        for (V v : this.values()) {
            if(ws.run((Volunteer) v)){
                rd.add(v);
            }
        }
        return rd;
    }
    public void insert(V v){
        int l = this.keySet().toArray().length;
        Object lastId = this.keySet().toArray()[l-1];
        Integer id = ((Integer)lastId)+1;
        v.setId(id);
        this.put((K)id, v);
    }

    public interface WhereTeam {
        Boolean run(Team model);
    }
    public interface WhereShift {
        Boolean run(Shift model);
    }
    public interface WhereTeamAdmin {
        Boolean run(TeamAdmin model);
    }
    public interface WhereVolunteer {
        Boolean run(Volunteer model);
    }
    public interface WherePersonalInfo {
        Boolean run(PersonalInfo model);
    }
}
