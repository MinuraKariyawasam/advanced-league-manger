package com.iit.cw.api;

import com.iit.cw.model.FootballClub;
import com.iit.cw.model.MatchManager;
import com.iit.cw.service.PremierLeagueServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
// fix cross platform
@CrossOrigin(origins = "http://localhost:4200")
// add rest controller
@RestController
public class PremierLeagueController {

    @Autowired
    private PremierLeagueServices premierLeagueServices;

    @GetMapping("/league")
    public List<FootballClub> getPremierLeagueDetails(){
        // return premier league details
        return premierLeagueServices.getPremierLeagueList();
    }

    @GetMapping("/league/wins")
    public List<FootballClub> getWinsSortedLeagueDetails(){
        // return premier league details sorted by wins
        return premierLeagueServices.getWinsSortedList();
    }

    @GetMapping("/league/points")
    public List<FootballClub> getPointSortedList(){
        // return premier league details sorted by point
        return premierLeagueServices.getPointSortedList();
    }

    @GetMapping("/league/goal")
    public List<FootballClub> getGoalScoreSortedList(){
        // return premier league details sorted by goal
        return premierLeagueServices.getGoalScoreSortedList();
    }

    @GetMapping("/league/generate")
    public List<FootballClub> getGenerateDateList(){
        // return premier league generated details sorted by points
        return premierLeagueServices.getGeneratedMatchList();
    }

    @GetMapping("/match")
    public List<MatchManager> getMatchDetails(){
        // return match details
        return premierLeagueServices.getMatchDetailsList();
    }

    @GetMapping("match/{matchDate}")
    public List<MatchManager> searchByDate(@PathVariable("matchDate") @DateTimeFormat(pattern = "yyyy-MM-dd") String matchDate) {
        // return search result
        return premierLeagueServices.getSearchMatches(matchDate);
    }

}
