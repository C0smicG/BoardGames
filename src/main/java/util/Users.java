package util;

import java.util.HashMap;

public class Users {
    private String name;
    private HashMap<String, Integer> Scores = new HashMap<String, Integer>();


    public Users(String name){this.name = name;}

    public HashMap<String, Integer> getScores() {
        return Scores;
    }

    public String getName() {
        return name;
    }
}
