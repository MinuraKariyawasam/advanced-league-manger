package com.iit.cw.model;

import java.io.Serializable;
import java.util.Objects;

public class UniversityFootballClub extends FootballClub implements Serializable {
    private String universityName;
    private String universityType;

    public UniversityFootballClub(){} //Default constructor

    // Parameterized constructor
    public UniversityFootballClub(String nameOfTheClub, String locationOfTheClub, int numberOfGoalsReceived, int numberOfGoalsScored, int numberOfPointsClubAchieved, int numberOfMatchesPlayed, int clubGoalDifference, int numberOfWinsClubAchieved, int numberOfDrawsClubAchieved, int numberOfDefeatsClubAchieved, String matchDate, String universityName, String universityType) {
        super(nameOfTheClub, locationOfTheClub, numberOfGoalsReceived, numberOfGoalsScored, numberOfPointsClubAchieved, numberOfMatchesPlayed, clubGoalDifference, numberOfWinsClubAchieved, numberOfDrawsClubAchieved, numberOfDefeatsClubAchieved, matchDate);
        this.universityName = universityName;
        this.universityType = universityType;
    }

    public String getUniversityName() { // get university name
        return universityName;
    }

    public void setUniversityName(String universityName) { // update university name
        this.universityName = universityName;
    }

    public String getUniversityType() { // get university type
        return universityType;         // government or private
    }

    public void setUniversityType(String universityType) { // update university type
        this.universityType = universityType;
    }

    @Override
    public boolean equals(Object objEqualsCheck) { // Equals Method
        if (this == objEqualsCheck)
            return true;
        if (objEqualsCheck == null || getClass() != objEqualsCheck.getClass())
            return false;
        UniversityFootballClub that = (UniversityFootballClub) objEqualsCheck;
        return universityName.equals(that.universityName) && universityType.equals(that.universityType);
    }

    @Override
    public int hashCode() { // hash Code
        return Objects.hash(universityName, universityType);
    }
}
