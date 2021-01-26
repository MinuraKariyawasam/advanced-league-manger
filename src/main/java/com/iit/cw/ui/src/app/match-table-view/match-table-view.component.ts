import { Component, OnInit } from '@angular/core';
import { MatchServiceService } from './match-service.service';
import { Match } from './matchManager';

@Component({
  selector: 'app-match-table-view',
  templateUrl: './match-table-view.component.html',
  styleUrls: ['./match-table-view.component.css']
})
export class MatchTableViewComponent implements OnInit {
  // define empty array in Match type
  matchList : Match[];
  // define empty string
  matchDate: string;

  constructor(private matchService: MatchServiceService) { }

  ngOnInit(): void {
    // access getMatchDetails using matchService
    this.matchService.getMatchDetails()
    // save response to the tem var data
    .subscribe(data => {
      // add it to matchList
      this.matchList = data;
    });
    // set error label to empty
    document.getElementById('searchHelp').innerText = ""
  }

  getSearchResult(){
      if(this.matchDate == undefined){
        console.log("Invalid");
        // set error label to user error message
        document.getElementById('searchHelp').innerText = "Search field is empty.If you have any issue please read the help menu."
      }else{
        // access getSearchDetails using matchService
        this.matchService.getSearchDetails(this.matchDate)
        // save response to the tem var data
        .subscribe(data => {
        // add it to matchList
        this.matchList = data;
        });
        // set error label to empty
        document.getElementById('searchHelp').innerText = ""
      }

    }

}
