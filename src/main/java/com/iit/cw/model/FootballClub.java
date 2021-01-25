package com.iit.cw.model;

import java.io.Serializable;
import java.util.Objects;

public class FootballClub extends SportsClub implements Comparable<FootballClub>, Serializable {
    /* all variables are private, cannot access by the
     * outside classes.
     */
    private int numberOfGoalsReceived;
    private int numberOfGoalsScored;
    private int numberOfPointsClubAchieved;
    private int numberOfMatchesPlayed;
    private int clubGoalDifference;

    // Store statics of the FootballClub
    private int numberOfWinsClubAchieved;
    private int numberOfDrawsClubAchieved;
    private int numberOfDefeatsClubAchieved;
    private String matchDate;

    public FootballClub(){} // Default constructor

    // Parameterized constructor
    public FootballClub(String nameOfTheClub, String locationOfTheClub, int numberOfGoalsReceived, int numberOfGoalsScored, int numberOfPointsClubAchieved, int numberOfMatchesPlayed, int clubGoalDifference, int numberOfWinsClubAchieved, int numberOfDrawsClubAchieved, int numberOfDefeatsClubAchieved, String matchDate) {
        super(nameOfTheClub, locationOfTheClub);
        this.numberOfGoalsReceived = numberOfGoalsReceived;
        this.numberOfGoalsScored = numberOfGoalsScored;
        this.numberOfPointsClubAchieved = numberOfPointsClubAchieved;
        this.numberOfMatchesPlayed = numberOfMatchesPlayed;
        this.clubGoalDifference = clubGoalDifference;
        this.numberOfWinsClubAchieved = numberOfWinsClubAchieved;
        this.numberOfDrawsClubAchieved = numberOfDrawsClubAchieved;
        this.numberOfDefeatsClubAchieved = numberOfDefeatsClubAchieved;
        this.matchDate = matchDate;
    }

    public int getNumberOfGoalsReceived() {
        return numberOfGoalsReceived;
    }

    public void setNumberOfGoalsReceived(int numberOfGoalsReceived) {
        this.numberOfGoalsReceived = numberOfGoalsReceived;
    }

    public int getNumberOfGoalsScored() {
        return numberOfGoalsScored;
    }

    public void setNumberOfGoalsScored(int numberOfGoalsScored) {
        this.numberOfGoalsScored = numberOfGoalsScored;
    }

    public int getNumberOfPointsClubAchieved() {
        return numberOfPointsClubAchieved;
    }

    public void setNumberOfPointsClubAchieved(int numberOfPointsClubAchieved) {
        this.numberOfPointsClubAchieved = numberOfPointsClubAchieved;
    }

    public int getNumberOfMatchesPlayed() {
        return numberOfMatchesPlayed;
    }

    public void setNumberOfMatchesPlayed(int numberOfMatchesPlayed) {
        this.numberOfMatchesPlayed = numberOfMatchesPlayed;
    }

    public int getNumberOfWinsClubAchieved() {
        return numberOfWinsClubAchieved;
    }

    public void setNumberOfWinsClubAchieved(int numberOfWinsClubAchieved) {
        this.numberOfWinsClubAchieved = numberOfWinsClubAchieved;
    }

    public int getNumberOfDrawsClubAchieved() {
        return numberOfDrawsClubAchieved;
    }

    public void setNumberOfDrawsClubAchieved(int numberOfDrawsClubAchieved) {
        this.numberOfDrawsClubAchieved = numberOfDrawsClubAchieved;
    }

    public int getNumberOfDefeatsClubAchieved() {
        return numberOfDefeatsClubAchieved;
    }

    public void setNumberOfDefeatsClubAchieved(int numberOfDefeatsClubAchieved) {
        this.numberOfDefeatsClubAchieved = numberOfDefeatsClubAchieved;
    }

    public int getClubGoalDifference() {
        return clubGoalDifference;
    }

    public void setClubGoalDifference(int clubGoalDifference) {
        this.clubGoalDifference = clubGoalDifference;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }

    @Override
    public boolean equals(Object objEqualsCheck) {
        if (this == objEqualsCheck)
            return true;
        if (objEqualsCheck == null || getClass() != objEqualsCheck.getClass())
            return false;
        if (!super.equals(objEqualsCheck))
            return false;
        FootballClub that = (FootballClub) objEqualsCheck;
        return numberOfGoalsReceived == that.numberOfGoalsReceived && numberOfGoalsScored == that.numberOfGoalsScored && numberOfPointsClubAchieved == that.numberOfPointsClubAchieved && numberOfMatchesPlayed == that.numberOfMatchesPlayed && clubGoalDifference == that.clubGoalDifference && numberOfWinsClubAchieved == that.numberOfWinsClubAchieved && numberOfDrawsClubAchieved == that.numberOfDrawsClubAchieved && numberOfDefeatsClubAchieved == that.numberOfDefeatsClubAchieved && matchDate.equals(that.matchDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfGoalsReceived, numberOfGoalsScored, numberOfPointsClubAchieved, numberOfMatchesPlayed, clubGoalDifference, numberOfWinsClubAchieved, numberOfDrawsClubAchieved, numberOfDefeatsClubAchieved, matchDate);
    }

    @Override
    public int compareTo(FootballClub footBallObject) { // compareTo method
        if(this.getNumberOfPointsClubAchieved() == footBallObject.getNumberOfPointsClubAchieved()){ // if points are equal, then sort to numberOfScoredClubAchieved attribute
            if (this.getClubGoalDifference() > footBallObject.getClubGoalDifference()){return -1;}
            else {return 1;}
        }
        else if (this.getNumberOfPointsClubAchieved() > footBallObject.getNumberOfPointsClubAchieved()){return -1;}
        else {return 1;}

    }
}
