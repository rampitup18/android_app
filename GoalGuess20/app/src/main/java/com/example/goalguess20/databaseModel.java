package com.example.goalguess20;

public class databaseModel {
    private int id;
    private String player_name;
    private int goals;
    private float mkt_val;


    @Override
    public String toString() {
        return "DatabaseModel{" +
                "id=" + id +
                ", player_name='" + player_name + '\'' +
                ", goals=" + goals +
                ", mkt_val=" + mkt_val +
                '}';
    }
    public databaseModel(int id, String player_name, int goals, float mkt_val) {
        this.id = id;
        this.player_name = player_name;
        this.goals = goals;
        this.mkt_val = mkt_val;
    }

    public  databaseModel() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public int getGls() {
        return goals;
    }

    public void setGls(int goals) {
        this.goals = goals;
    }

    public double getMkt_val() {
        return mkt_val;
    }

    public void setMkt_val(float mkt_val) {
        this.mkt_val = mkt_val;
    }
}
