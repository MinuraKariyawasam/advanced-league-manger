import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from "@angular/common/http";
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { PremierLeagueViewComponent } from './premier-league-view/premier-league-view.component';
import { PremierLeagueService } from './premier-league-view/premier-league.service';
import { MatchTableViewComponent } from './match-table-view/match-table-view.component';
import { MatchServiceService } from './match-table-view/match-service.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HelpComponent } from './help/help.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    PremierLeagueViewComponent,
    MatchTableViewComponent,
    HelpComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    CommonModule
  ],
  providers: [
    PremierLeagueService,
    MatchServiceService
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule { }
