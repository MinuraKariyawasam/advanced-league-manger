package com.iit.cw.service;

import com.iit.cw.model.FootballClub;
import com.iit.cw.model.MatchManager;

import java.util.List;

public interface LeagueManager {
    // add new sport club
    void addNewFootBallClub(FootballClub newClub);
    // delete football club
    void deleteRegClub(String registerClubName);
    // view all statics in specific club
    void showStatistics(String sportClubName);
    // view all club statics
    void checkPremierLeagueTable();
    // add new matches manually
    void addNewMatch(String firstClubTeam, String secondClubName, int teamOneScore, int teamTwoScore, String matchDate);
    // generate random matches
    void generateRandomData();
    // search matches from match date
    List<MatchManager> searchView(String matchDate);
    // load save data
    void loadData();
    // save load data
    void saveData();
}
