package com.iit.cw.view;

import com.iit.cw.model.MatchManager;
import com.iit.cw.service.PremierLeagueManager;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;
public class SearchGUI extends Application {
    Scene searchScene;
    public static TableView<MatchManager> searchResultTableView;
    PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
    public static List<MatchManager> matchDetails;
    ImageView searchImgView;

    @Override
    public void start(Stage searchStage) {
        // create a border pane
        BorderPane backgroundPane = new BorderPane();
        // create pane
        Pane searchPane = new Pane();

        // adding background image
        Image backgroundImage = new Image("file:src/main/resources/static/images/SEARCH.png");
        // set image view
        searchImgView = new ImageView(backgroundImage);
        // add image to pane
        searchPane.getChildren().add(searchImgView);


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
        TableColumn<MatchManager, Integer> teamTwoScore = new TableColumn<>("Team Two Score");
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

        // add css styles
        searchPane.getStylesheets().add("file:src/main/resources/static/styles/TablePage.css");

        Label errorLabel = new Label();
        // set x layout
        errorLabel.setLayoutX(130);
        // set y layout
        errorLabel.setLayoutY(300);
        // add label to search pane
        searchPane.getChildren().add(errorLabel);

        searchResultTableView = new TableView<>();
        // set selection mode
        searchResultTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        // add column to the table
        searchResultTableView.getColumns().addAll(teamOneName,teamOneScore,teamTwoName,teamTwoScore,matchDate);

        TextField dataInput = new TextField();
        // set x layout
        dataInput.setLayoutX(110);
        // set y layout
        dataInput.setLayoutY(130);
        // set prompt text
        dataInput.setPromptText("DD/MM/YYYY");
        // add it to the search pane
        searchPane.getChildren().add(dataInput);

        Button searchButton = new Button("Search");
        // set x layout
        searchButton.setLayoutX(110);
        // set y layout
        searchButton.setLayoutY(180);
        //  add button to the search pane
        searchPane.getChildren().add(searchButton);

        searchButton.setOnAction(e -> {
            // check date input is valid
            if (PremierLeagueManager.isDateValid(dataInput.getText())) {
                //  return search details array list and save it to the match details var
                matchDetails = premierLeagueManager.searchView(dataInput.getText());
                // set it to the table
                searchResultTableView.setItems(getMatchDetails(matchDetails));
                // set error label to empty string
                errorLabel.setText("");
            }else {
                // if text input not in proper format --> show error to user
                errorLabel.setText("Illegal Date Format.");
                // clear all table data
                searchResultTableView.getItems().clear();
            }
        });

        // create vBox to add columns
        VBox newVBox = new VBox();
        // add it to newVbox
        newVBox.getChildren().add(searchResultTableView);
        // set new height and width
        newVBox.setMaxSize(1200,400);
        // set lest pane
        backgroundPane.setLeft(newVBox);
        // set right pane
        backgroundPane.setRight(searchPane);
        //  set right pane width and height
        searchPane.setMaxSize(380,380);

        // add table to scene
        searchScene = new Scene(backgroundPane, 900,390);
        // display the title
        searchStage.setTitle("Search View");
        // set scene
        searchStage.setScene(searchScene);
        // disable resizable
        searchStage.setResizable(false);
        // display the stage
        searchStage.show();


    }


    // get all the statics from arraylist to store show in table
    public ObservableList<MatchManager> getMatchDetails(List<MatchManager> searchDetailsArray){
        // typecast arraylist to observableArraylist and return the data
        return FXCollections.observableArrayList(searchDetailsArray);
    }
}
