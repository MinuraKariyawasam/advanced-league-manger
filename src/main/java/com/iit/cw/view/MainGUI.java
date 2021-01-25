package com.iit.cw.view;

import com.iit.cw.PremierLeagueUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainGUI extends Application {
    Scene mainGUIScene;
    ImageView ivForBackgroundImg;
    Button premierLeagueTableView;
    Button generateRandomData;
    Button matchView;
    Button searchForMatches;

    @Override
    public void start(Stage mainStage) throws IOException {
        // creating a pane
        Pane backgroundPane = new Pane();

        // add css styles
        backgroundPane.getStylesheets().add("file:src/main/resources/static/styles/MainPage.css");
        // adding background image
        Image backgroundImage = new Image("file:src/main/resources/static/images/back03.png");
        // set image view
        ivForBackgroundImg = new ImageView(backgroundImage);
        // add image to pane
        backgroundPane.getChildren().add(ivForBackgroundImg);

        // add buttons
        premierLeagueTableView = new Button(" Premier League Table ");
        // set x layout
        premierLeagueTableView.setLayoutX(700);
        // set y layout
        premierLeagueTableView.setLayoutY(220);
        // add to premier league table view
        backgroundPane.getChildren().add(premierLeagueTableView);
        // set action on to button
        premierLeagueTableView.setOnAction(event -> {
            // when button clicks table gui launch
            PremierLeagueUI.applicationLaunchAgain(TableGUI.class);
        });

        matchView = new Button("   View Matches   ");
        // set x layout
        matchView.setLayoutX(700);
        // set y layout
        matchView.setLayoutY(290);
        // add to match table view
        backgroundPane.getChildren().add(matchView);
        // set action on to button
        matchView.setOnAction(e -> {
            // when button clicks table gui launch
            PremierLeagueUI.applicationLaunchAgain(MatchViewGUI.class);
        });

        searchForMatches = new Button("  Search for Matches  ");
        // set x layout
        searchForMatches.setLayoutX(700);
        // set y layout
        searchForMatches.setLayoutY(360);
        // add to match table search view
        backgroundPane.getChildren().add(searchForMatches);
        // set action on to button
        searchForMatches.setOnAction(e -> {
            // when button clicks search view launch
            PremierLeagueUI.applicationLaunchAgain(SearchGUI.class);
        });

        generateRandomData = new Button(" EXIT ");
        // set x layout
        generateRandomData.setLayoutX(700);
        // set y layout
        generateRandomData.setLayoutY(430);
        // set action on to exit button
        generateRandomData.setOnAction(e ->{
            // get current stage and save it to stage var
            Stage currentMainStage = (Stage) generateRandomData.getScene().getWindow();
            // close that stage var
            currentMainStage.close();
        });
        // add it main gui
        backgroundPane.getChildren().add(generateRandomData);

        // add pane to scene
        mainGUIScene = new Scene(backgroundPane,1190,590);
        // set scene
        mainStage.setScene(mainGUIScene);
        // disable resizable
        mainStage.setResizable(false);
        // display the title
        mainStage.setTitle("LEAGUISTIC");
        // display the stage
        mainStage.show();
    }
}
