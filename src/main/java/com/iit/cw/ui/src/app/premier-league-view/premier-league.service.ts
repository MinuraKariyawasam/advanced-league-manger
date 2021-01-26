import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PremierLeague } from './premierLeague';

@Injectable({
  providedIn: 'root'
})
export class PremierLeagueService {

  private BASE_PREMIER_LEAGUE_URL = "http://localhost:8080/league";
  private PREMIER_LEAGUE_POINTS_SORT = "http://localhost:8080/league/points";
  private PREMIER_LEAGUE_GOAL_SCORED_SORT = "http://localhost:8080/league/goal";
  private PREMIER_LEAGUE_WINS_SCORED_SORT = "http://localhost:8080/league/wins";
  private PREMIER_LEAGUE_GENERATED_LIST = "http://localhost:8080/league/generate";
  
  constructor(private httpClient: HttpClient) {

  }

   getPremierLeagueDetails(): Observable<PremierLeague[]>{
      return this.httpClient.get<PremierLeague[]>(`${this.BASE_PREMIER_LEAGUE_URL}`);
   }

   getPremierLeaguePointSortedList(): Observable<PremierLeague[]>{
     return this.httpClient.get<PremierLeague[]>(`${this.PREMIER_LEAGUE_POINTS_SORT}`);
   }

   getPremierLeagueGoalSortedList(): Observable<PremierLeague[]>{
    return this.httpClient.get<PremierLeague[]>(`${this.PREMIER_LEAGUE_GOAL_SCORED_SORT}`);
  }

  getPremierLeagueWinsSortedList(): Observable<PremierLeague[]>{
    return this.httpClient.get<PremierLeague[]>(`${this.PREMIER_LEAGUE_WINS_SCORED_SORT}`);
  }

  getPremierGeneratedList(): Observable<PremierLeague[]>{
    return this.httpClient.get<PremierLeague[]>(`${this.PREMIER_LEAGUE_GENERATED_LIST}`);
  }

}
