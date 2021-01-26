import { Component, OnInit } from '@angular/core';
import { PremierLeagueService } from './premier-league.service';
import { PremierLeague } from './premierLeague';

@Component({
  selector: 'app-premier-league-view',
  templateUrl: './premier-league-view.component.html',
  styleUrls: ['./premier-league-view.component.css']
})
export class PremierLeagueViewComponent implements OnInit {

  // define empty array in PremierLeague type
  premierLeague: PremierLeague[];

  constructor(private premierLeagueService: PremierLeagueService) { }

  ngOnInit(): void {
    // access getPremierLeagueDetails using matchService
    this.premierLeagueService.getPremierLeagueDetails()
    // save response to the tem var data 
    .subscribe(data => {
      // add it to premierLeague
      this.premierLeague = data;
    });
  }

  getGoalSortedList(){
    // access getPremierLeagueGoalSortedList using matchService
    this.premierLeagueService.getPremierLeagueGoalSortedList()
    // save response to the tem var data
    .subscribe(data => {
      // add it to premierLeague
      this.premierLeague = data;
    });
  }

  getPointSortedList(){
    // access getPremierLeaguePointSortedList using matchService
    this.premierLeagueService.getPremierLeaguePointSortedList()
    // save response to the tem var data
    .subscribe(data => {
      // add it to premierLeague
      this.premierLeague = data;
    });
  }

  getWinsSortedList(){
    // access getPremierLeagueWinsSortedList using matchService
    this.premierLeagueService.getPremierLeagueWinsSortedList()
    // save response to the tem var data
    .subscribe(data => {
      // add it to premierLeague
      this.premierLeague = data;
    });
  }

  getGenerateList(){
    // access getPremierGeneratedList using matchService
    this.premierLeagueService.getPremierGeneratedList()
    // save response to the tem var data
    .subscribe(data => {
      // add it to premierLeague
      this.premierLeague = data;
    });
  }

}
