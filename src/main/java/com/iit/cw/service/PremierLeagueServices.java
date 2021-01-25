package com.iit.cw.service;

import com.iit.cw.model.FootballClub;
import com.iit.cw.model.MatchManager;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class PremierLeagueServices {

    PremierLeagueManager returnAllLeagueData = new PremierLeagueManager();

    public List<FootballClub> getPremierLeagueList(){
        Collections.sort(PremierLeagueManager.sportsClubsInformation);
        // return sport club information list
        return PremierLeagueManager.sportsClubsInformation;
    }

    public List<FootballClub> getWinsSortedList(){
        // return wins sorted list
        return returnAllLeagueData.sortedWinList();
    }

    public List<FootballClub> getPointSortedList(){
        // return point sorted list
        return returnAllLeagueData.sortedPointList();
    }

    public List<FootballClub> getGoalScoreSortedList(){
        // return goal sorted list
        return returnAllLeagueData.goalScoredList();
    }

    public List<FootballClub> getGeneratedMatchList(){
        Collections.sort(PremierLeagueManager.sportsClubsInformation);
        // call random function to generate random data
        returnAllLeagueData.generateRandomData();
        // return updated match list
        return PremierLeagueManager.sportsClubsInformation;
    }

    public List<MatchManager> getMatchDetailsList(){
        // return match detail list
        return returnAllLeagueData.sortedDateList();
    }

    public List<MatchManager> getSearchMatches(String matchDate){
        // passing date pattern
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // converted date pattern
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        // date object
        Date date = null;
        // converted match date to pass
        String convertedMatchDate;

        try{
            // convert second date format
            date = dateFormat.parse(matchDate);
        }catch (ParseException e){
            e.printStackTrace();
        }
        // converted format assign to string value
        convertedMatchDate = formatDate.format(date);
        // return converted date to search view method
        return returnAllLeagueData.searchView(convertedMatchDate);
    }


}
