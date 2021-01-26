import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Match } from './matchManager';

@Injectable({
  providedIn: 'root'
})
export class MatchServiceService {


  MATCH_BASE_URL = "http://localhost:8080/match";
  SEARCH_BASE_URL = "http://localhost:8080/match";

  constructor(private httpClient : HttpClient) { }

  getMatchDetails(): Observable<Match[]>{
    return this.httpClient.get<Match[]>(`${this.MATCH_BASE_URL}`);
 }

 getSearchDetails(validatedMatchDate:string): Observable<Match[]>{
    return this.httpClient.get<Match[]>(`${this.SEARCH_BASE_URL}` + '/' + validatedMatchDate);
 }

}
