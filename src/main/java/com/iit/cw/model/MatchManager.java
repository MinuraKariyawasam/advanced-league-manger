package com.iit.cw.model;

import java.io.Serializable;

public class MatchManager implements Serializable {
    // team one name
    private String teamOneName;
    // team two name
    private String teamTwoName;
    // team one score
    private int teamOneScore;
    // team two score
    private int teamTwoScore;
    // match date
    private String matchDate;

    public MatchManager(){}

    public MatchManager(String teamOneName, String teamTwoName, int teamOneScore, int teamTwoScore, String matchDate) {
        this.teamOneName = teamOneName;
        this.teamTwoName = teamTwoName;
        this.teamOneScore = teamOneScore;
        this.teamTwoScore = teamTwoScore;
        this.matchDate = matchDate;
    }

    public String getTeamOneName() {
        return teamOneName;
    }

    public void setTeamOneName(String teamOneName) {
        this.teamOneName = teamOneName;
    }

    public String getTeamTwoName() {
        return teamTwoName;
    }

    public void setTeamTwoName(String teamTwoName) {
        this.teamTwoName = teamTwoName;
    }

    public int getTeamOneScore() {
        return teamOneScore;
    }

    public void setTeamOneScore(int teamOneScore) {
        this.teamOneScore = teamOneScore;
    }

    public int getTeamTwoScore() {
        return teamTwoScore;
    }

    public void setTeamTwoScore(int teamTwoScore) {
        this.teamTwoScore = teamTwoScore;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }
}
