package com.iit.cw.view;

import com.iit.cw.model.MatchManager;
import com.iit.cw.service.PremierLeagueManager;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MatchViewGUI extends Application {
    TableView<MatchManager> matchManagerTableView;
    Scene matchViewScene;
    PremierLeagueManager premierLeagueManagerForMatchView = new PremierLeagueManager();

    @Override
    public void start(Stage matchViewStage) {

        // create name column
        TableColumn<MatchManager, String> teamOneName = new TableColumn<>("Team One Name");
        // create min width to the column
        teamOneName.setMinWidth(110);
        // create max width to the column
        teamOneName.setMaxWidth(110);
        // set cell value
        teamOneName.setCellValueFactory(new PropertyValueFactory<>("teamOneName"));

        // create name column
        TableColumn<MatchManager, Integer> teamOneScore = new TableColumn<>("Team One Score");
        // create min width to the column
        teamOneScore.setMinWidth(110);
        // create max width to the column
        teamOneScore.setMaxWidth(110);
        // set cell value
        teamOneScore.setCellValueFactory(new PropertyValueFactory<>("teamOneScore"));

        // create name column
        TableColumn<MatchManager, String> teamTwoName = new TableColumn<>("Team Two Name");
        // create min width to the column
        teamTwoName.setMinWidth(110);
        // create max width to the column
        teamTwoName.setMaxWidth(110);
        // set cell value
        teamTwoName.setCellValueFactory(new PropertyValueFactory<>("teamTwoName"));

        // create name column
        TableColumn<MatchManager, Integer> teamTwoScore = new TableColumn<>("Team One Score");
        // create min width to the column
        teamTwoScore.setMinWidth(110);
        // create max width to the column
        teamTwoScore.setMaxWidth(110);
        // set cell value
        teamTwoScore.setCellValueFactory(new PropertyValueFactory<>("teamTwoScore"));

        // create name column
        TableColumn<MatchManager, String> matchDate = new TableColumn<>("Match Date");
        // create min width to the column
        matchDate.setMinWidth(110);
        // create max width to the column
        matchDate.setMaxWidth(110);
        // set cell value
        matchDate.setCellValueFactory(new PropertyValueFactory<>("matchDate"));


        matchManagerTableView = new TableView<>();
        // set collection and sort the list according to date
        // PremierLeagueManager.matchManagerDetails.sort(Collections.reverseOrder(premierLeagueManagerForMatchView.matchManagerDateComparator));
        // set list item to table
        matchManagerTableView.setItems(getMatchSortDetails());
        // set selection to Multiple
        matchManagerTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        // set column to table
        matchManagerTableView.getColumns().addAll(teamOneName,teamOneScore,teamTwoName,teamTwoScore,matchDate);

        // create vBox to add columns
        VBox matchVBox = new VBox();
        // add table to vbox
        matchVBox.getChildren().add(matchManagerTableView);
        // add vbox to scene
        matchViewScene = new Scene(matchVBox,539,400);
        // add scene to stage
        matchViewStage.setScene(matchViewScene);
        // display the title
        matchViewStage.setTitle("Match View");
        // set scene
        matchViewStage.setScene(matchViewScene);
        // disable resizable
        matchViewStage.setResizable(false);
        // display the stage
        matchViewStage.show();
    }


    public ObservableList<MatchManager> getMatchSortDetails(){
        // convert and return sorted date list
        return FXCollections.observableArrayList(premierLeagueManagerForMatchView.sortedDateList());
    }
}
