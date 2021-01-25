package com.iit.cw.model;

import java.io.Serializable;
import java.util.Objects;

public class SchoolFootballClub extends FootballClub  implements Serializable {
    private String schoolName;
    private String division;

    public SchoolFootballClub(){} // Default constructor

    // Parameterized constructor
    public SchoolFootballClub(String nameOfTheClub, String locationOfTheClub, int numberOfGoalsReceived, int numberOfGoalsScored, int numberOfPointsClubAchieved, int numberOfMatchesPlayed, int clubGoalDifference, int numberOfWinsClubAchieved, int numberOfDrawsClubAchieved, int numberOfDefeatsClubAchieved, String matchDate, String schoolName, String division) {
        super(nameOfTheClub, locationOfTheClub, numberOfGoalsReceived, numberOfGoalsScored, numberOfPointsClubAchieved, numberOfMatchesPlayed, clubGoalDifference, numberOfWinsClubAchieved, numberOfDrawsClubAchieved, numberOfDefeatsClubAchieved, matchDate);
        this.schoolName = schoolName;
        this.division = division;
    }

    public String getSchoolName() { // get school name
        return schoolName;
    }

    public void setSchoolName(String schoolName) { // update school name
        this.schoolName = schoolName;
    }

    public String getDivision() { // get school division
        return division;
    }

    public void setDivision(String division) { // update school division
        this.division = division;
    }

    @Override
    public boolean equals(Object objEqualsCheck) { // Equals Method
        if (this == objEqualsCheck)
            return true;
        if (objEqualsCheck == null || getClass() != objEqualsCheck.getClass())
            return false;
        SchoolFootballClub that = (SchoolFootballClub) objEqualsCheck;
        return schoolName.equals(that.schoolName) && division.equals(that.division);
    }

    @Override
    public int hashCode() { // hash Code
        return Objects.hash(schoolName, division);
    }
}
