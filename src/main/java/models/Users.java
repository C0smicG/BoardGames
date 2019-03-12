package models;

import java.util.HashMap;

public class Users {
    public String name;
    public HashMap<String, Integer> Scores = new HashMap<String, Integer>();



    public HashMap<String, Integer> getScores() {
        return Scores;
    }

    public String getName() {
        return name;
    }
}
