package com.iit.cw.model;

import java.io.Serializable;
import java.util.Objects;

public class SportsClub implements Serializable {
    /* Creating fields to SportClub class to store name, location
     */
    private String nameOfTheClub;
    private String locationOfTheClub;

    public SportsClub(){} // Default constructor

    // Parameterized constructor
    public SportsClub(String nameOfTheClub, String locationOfTheClub) {
        this.nameOfTheClub = nameOfTheClub;
        this.locationOfTheClub = locationOfTheClub;
    }

    public String getNameOfTheClub() { // get name of the club
        return nameOfTheClub;
    }

    public void setNameOfTheClub(String nameOfTheClub) { // update name of the club
        this.nameOfTheClub = nameOfTheClub;
    }

    public String getLocationOfTheClub() { // get location of the club
        return locationOfTheClub;
    }

    public void setLocationOfTheClub(String locationOfTheClub) { // update location of the club
        this.locationOfTheClub = locationOfTheClub;
    }

    @Override
    public boolean equals(Object objEqualsCheck) { // Equals Method
        if (this == objEqualsCheck)
            return true;
        if (objEqualsCheck == null || getClass() != objEqualsCheck.getClass())
            return false;
        SportsClub that = (SportsClub) objEqualsCheck;
        return nameOfTheClub.equals(that.nameOfTheClub) && locationOfTheClub.equals(that.locationOfTheClub);
    }

    @Override
    public int hashCode() { // hash Code
        return Objects.hash(nameOfTheClub, locationOfTheClub);
    }

}
