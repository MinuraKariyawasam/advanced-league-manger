package com.iit.cw.view;

import com.iit.cw.model.FootballClub;
import com.iit.cw.service.PremierLeagueManager;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.SelectionMode;
import javafx.collections.FXCollections;

import javafx.scene.control.cell.PropertyValueFactory;

public class TableGUI extends Application {
    // create the scene
    Scene tableViewScene;
    PremierLeagueManager generateRandomData = new PremierLeagueManager();
    // create table element
    TableView<FootballClub> premierLeagueStaticsTable;
    @Override
    public void start(Stage tableStage) {

        // create a pane
        BorderPane tableButtonPane = new BorderPane();

        // create name column
        TableColumn<FootballClub, String> clubName = new TableColumn<>("Club Name");
        // create min width to the column
        clubName.setMinWidth(100);
        // create max width to the column
        clubName.setMaxWidth(100);
        // set cell value
        clubName.setCellValueFactory(new PropertyValueFactory<>("nameOfTheClub"));

        // create no of match played column
        TableColumn<FootballClub, Integer> noOfMatchPlayed = new TableColumn<>("No Matches Played");
        // create min width to the column
        noOfMatchPlayed.setMinWidth(150);
        // create max width to the column
        noOfMatchPlayed.setMaxWidth(150);
        // set cell value
        noOfMatchPlayed.setCellValueFactory(new PropertyValueFactory<>("numberOfMatchesPlayed"));

        // create no of wins column
        TableColumn<FootballClub, Integer> noOfMatchWins = new TableColumn<>("Wins");
        // create min width to the column
        noOfMatchWins.setMinWidth(70);
        // create max width to the column
        noOfMatchWins.setMaxWidth(70);
        // set cell value
        noOfMatchWins.setCellValueFactory(new PropertyValueFactory<>("numberOfWinsClubAchieved"));

        // create no of defeats column
        TableColumn<FootballClub, Integer> noOfMatchDefeats = new TableColumn<>("Defeats");
        // create min width to the column
        noOfMatchDefeats.setMinWidth(70);
        // create max width to the column
        noOfMatchDefeats.setMaxWidth(70);
        // set cell value
        noOfMatchDefeats.setCellValueFactory(new PropertyValueFactory<>("numberOfDefeatsClubAchieved"));

        // create no of draws column
        TableColumn<FootballClub, Integer> noOfMatchDraws = new TableColumn<>("Draws");
        // create min width to the column
        noOfMatchDraws.setMinWidth(70);
        // create max width to the column
        noOfMatchDraws.setMaxWidth(70);
        // set cell value
        noOfMatchDraws.setCellValueFactory(new PropertyValueFactory<>("numberOfDrawsClubAchieved"));

        // create no of points column
        TableColumn<FootballClub, Integer> matchPoints = new TableColumn<>("Points");
        // create min width to the column
        matchPoints.setMinWidth(70);
        // create max width to the column
        matchPoints.setMaxWidth(70);
        // set cell value
        matchPoints.setCellValueFactory(new PropertyValueFactory<>("numberOfPointsClubAchieved"));

        // create no of goal scored column
        TableColumn<FootballClub, Integer> goalScored = new TableColumn<>("Goals scored");
        // create min width to the column
        goalScored.setMinWidth(150);
        // create max width to the column
        goalScored.setMaxWidth(150);
        // set cell value
        goalScored.setCellValueFactory(new PropertyValueFactory<>("numberOfGoalsScored"));

        // create no of goal received column
        TableColumn<FootballClub, Integer> goalReceived = new TableColumn<>("Goals received");
        // create min width to the column
        goalReceived.setMinWidth(150);
        // create max width to the column
        goalReceived.setMaxWidth(150);
        // set cell value
        goalReceived.setCellValueFactory(new PropertyValueFactory<>("numberOfGoalsReceived"));

        // create no of goal received column
        TableColumn<FootballClub, Integer> goalDifference = new TableColumn<>("Goal Difference");
        // create min width to the column
        goalDifference.setMinWidth(150);
        // create max width to the column
        goalDifference.setMaxWidth(150);
        // set cell value
        goalDifference.setCellValueFactory(new PropertyValueFactory<>("clubGoalDifference"));

        // create tableView add all column created
        premierLeagueStaticsTable = new TableView<>();
        // add details to the table using Observable method
        premierLeagueStaticsTable.setItems(getLeagueDetails());
        // set selection mood to MULTIPLE
        premierLeagueStaticsTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        // add column names to table
        premierLeagueStaticsTable.getColumns().addAll(clubName, noOfMatchPlayed, noOfMatchWins, noOfMatchDefeats, noOfMatchDraws, matchPoints, goalScored, goalReceived, goalDifference);

        // create right pane
        Pane rightPane = new Pane();
        // set maxWidth and maxHeight
        rightPane.setMaxSize(380,390);
        // add background color to right pane
        tableButtonPane.setStyle("-fx-background-color:  white");

        // create point button
        Button accordingToPoints = new Button("Points");
        // set X coordinates
        accordingToPoints.setLayoutX(-90);
        // set Y coordinates
        accordingToPoints.setLayoutY(100);
        accordingToPoints.setOnAction(e ->{
            premierLeagueStaticsTable.setItems(getPointSortedLeagueDetails());
        });
        // add it to the pane
        rightPane.getChildren().add(accordingToPoints);

        // create goal scored button
        Button accordingToGoalScore = new Button("Goal Scored");
        // set X coordinates
        accordingToGoalScore.setLayoutX(-90);
        // set Y coordinates
        accordingToGoalScore.setLayoutY(150);
        accordingToGoalScore.setOnAction(e -> {
            premierLeagueStaticsTable.setItems(getGoalScoredLeagueDetails());
        });
        // add it to the pane
        rightPane.getChildren().add(accordingToGoalScore);

        // create wins scored button
        Button accordingToWins = new Button("Wins");
        // set X coordinates
        accordingToWins.setLayoutX(-90);
        // set Y coordinates
        accordingToWins.setLayoutY(200);
        accordingToWins.setOnAction(e -> {
            premierLeagueStaticsTable.setItems(getWinsSortedLeagueDetails());
        });
        // add it to the pane
        rightPane.getChildren().add(accordingToWins);

        Button generateDate = new Button("Generate");
        // set X coordinates
        generateDate.setLayoutX(-90);
        // set Y coordinates
        generateDate.setLayoutY(250);
        generateDate.setOnAction(e ->{
            generateRandomData.generateRandomData();
            premierLeagueStaticsTable.setItems(getLeagueDetails());
        });
        rightPane.getChildren().add(generateDate);

        // create vBox to add columns
        VBox newVBox = new VBox();

        // add css styles
        tableButtonPane.getStylesheets().add("file:src/main/resources/static/styles/TablePage.css");

        // add all elements to vBox
        newVBox.getChildren().addAll(premierLeagueStaticsTable);
        // set maxWidth and maxHeight
        newVBox.setMaxSize(980,400);
        // set left part to vBox
        tableButtonPane.setLeft(newVBox);
        // set right part to pane
        tableButtonPane.setRight(rightPane);

        // add table to scene
        tableViewScene = new Scene(tableButtonPane, 1300,390);
        // display the title
        tableStage.setTitle("Premier League Table");
        // set scene
        tableStage.setScene(tableViewScene);
        // disable resizable
        tableStage.setResizable(false);
        // display the stage
        tableStage.show();

    }

    // get all the statics from arraylist to store show in table
    public ObservableList<FootballClub> getLeagueDetails(){
        // typecast arraylist to observableArraylist and return the data
        return FXCollections.observableArrayList(PremierLeagueManager.sportsClubsInformation);
    }
    public ObservableList<FootballClub> getPointSortedLeagueDetails(){
        // typecast arraylist to observableArraylist and return the data
        return FXCollections.observableArrayList(generateRandomData.sortedPointList());
    }
    public ObservableList<FootballClub> getWinsSortedLeagueDetails(){
        // typecast arraylist to observableArraylist and return the data
        return FXCollections.observableArrayList(generateRandomData.sortedWinList());
    }
    public ObservableList<FootballClub> getGoalScoredLeagueDetails(){
        // typecast arraylist to observableArraylist and return the data
        return FXCollections.observableArrayList(generateRandomData.goalScoredList());
    }
}
