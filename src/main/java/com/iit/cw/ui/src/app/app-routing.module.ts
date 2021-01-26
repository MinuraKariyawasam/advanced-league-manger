import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HelpComponent } from './help/help.component';
import { HomeComponent } from './home/home.component';
import { MatchTableViewComponent } from './match-table-view/match-table-view.component';
import { PremierLeagueViewComponent } from './premier-league-view/premier-league-view.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'league', component: PremierLeagueViewComponent},
  {path: 'match', component: MatchTableViewComponent},
  {path: 'help', component: HelpComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
