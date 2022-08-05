package com.example.goalguess;

public class User {

    private int id;
    private String player_name;
    private int gls;
    private double mkt_val;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", player_name='" + player_name + '\'' +
                ", gls=" + gls +
                ", mkt_val=" + mkt_val +
                '}';
    }

    public User(int id, String player_name, int gls, double mkt_val) {
        this.id = id;
        this.gls = gls;
        this.mkt_val = mkt_val;
        this.player_name = player_name;
    }

    public User() {
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
        return gls;
    }

    public void setGls(int gls) {
        this.gls = gls;
    }

    public double getMkt_val() {
        return mkt_val;
    }

    public void setMkt_val(double mkt_val) {
        this.mkt_val = mkt_val;
    }
}
