package com.iit.cw.service;

import com.iit.cw.model.FootballClub;
import com.iit.cw.model.MatchManager;
import com.iit.cw.model.SchoolFootballClub;
import com.iit.cw.model.SportsClub;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class PremierLeagueManager implements LeagueManager{
    //declare the ArrayList for store premier league details
    public static List<FootballClub> sportsClubsInformation = new ArrayList<>();
    //declare the ArrayList for store match manager details
    public static List<MatchManager> matchManagerDetails = new ArrayList<>();

    // Creating variable to update wins, defeat, draws, points
    private static int sportClubWins;
    private static int sportClubDefeat;
    private static int sportClubDraws;
    private static int sportClubPoints;

    // update the all the statistic according to team one and team two score
    public void matchDateUpdate(int teamOneScore, int teamTwoScore, FootballClub newFootBallClub) {
        // check team one and team two score
        if (teamOneScore > teamTwoScore) {
            // update club wins
            sportClubWins = newFootBallClub.getNumberOfWinsClubAchieved() + 1;
            // update club points
            sportClubPoints = newFootBallClub.getNumberOfPointsClubAchieved() + 3;
            // defeat must same as in arraylist
            sportClubDefeat = newFootBallClub.getNumberOfDefeatsClubAchieved();
            // draws must be same as in array
            sportClubDraws = newFootBallClub.getNumberOfDrawsClubAchieved();
            // if teams score equals ?
        } else if (teamOneScore == teamTwoScore) {
            // update club draws
            sportClubDraws = newFootBallClub.getNumberOfDrawsClubAchieved() + 1;
            // both team get 5 points
            sportClubPoints = newFootBallClub.getNumberOfPointsClubAchieved() + 1;
            // wins must be same as in array
            sportClubWins = newFootBallClub.getNumberOfWinsClubAchieved();
            // defeat must be same as in array
            sportClubDefeat = newFootBallClub.getNumberOfDefeatsClubAchieved();
            // if team defeats
        } else {
            // update club defeats ?
            sportClubDefeat = newFootBallClub.getNumberOfDefeatsClubAchieved() + 1;
            // points need to be same as in array
            sportClubPoints = newFootBallClub.getNumberOfPointsClubAchieved();
            // draws must be same as in array
            sportClubDraws = newFootBallClub.getNumberOfDrawsClubAchieved();
            // wins must be same as in array
            sportClubWins = newFootBallClub.getNumberOfWinsClubAchieved();
        }

    }

    @Override
    public void addNewFootBallClub(FootballClub newClub) { // add sport club to the system
        //define boolean value as false
        boolean isClubAlreadyIn = false;
        for (FootballClub sportsClubForNameCheck : sportsClubsInformation) {
            // check sport club already in the system
            if (sportsClubForNameCheck.getNameOfTheClub().equalsIgnoreCase(newClub.getNameOfTheClub())) {
                // if sport club in the system boolean value return true
                isClubAlreadyIn = true;
                break;
            }
        }
        // if not add sport club to the list
        if (!isClubAlreadyIn) {
            // adding sport club to the list
            sportsClubsInformation.add(newClub);
            System.out.println("------------------------------------------");
            System.out.println("Sport Club add Successfully to the system.");
            System.out.println();
            // print no of clubs
            System.out.println("Number of clubs: " + sportsClubsInformation.size());
            System.out.println("------------------------------------------");
        } else {
            // show the error message
            System.out.println("--------------------------------------");
            System.out.println("This sport club already in the system.");
            System.out.println("--------------------------------------");
        }
    }

    @Override
    public void deleteRegClub(String registerClubName) { // delete sport club from the system.
      // define boolean variable as false
      boolean isSportClubAlreadyInTheSystem = false;
      // Create Iterator to avoid ConcurrentModificationException
      Iterator<FootballClub> iterator = sportsClubsInformation.iterator();
      // first check list is empty using isEmpty
      if (sportsClubsInformation.isEmpty()) {
        System.out.println("----------------------------------------------------");
        // if its empty, give error message to the use
        System.out.println("No clubs available at the moment.");
        System.out.println("----------------------------------------------------");
      } else {
        while (iterator.hasNext()) {
          // use iterator to iterate through list
          FootballClub footballClubDetails = iterator.next();
          // check club name already in the club or not
          if (footballClubDetails.getNameOfTheClub().equalsIgnoreCase(registerClubName)) {
            // if its in the system
            isSportClubAlreadyInTheSystem = true;
            // remove from the list
            iterator.remove();
            System.out.println("------------------------------------------");
            System.out.println();
            // give message to the user
            System.out.println(footballClubDetails.getNameOfTheClub() + " Club delete Successfully.");
            //check club type using instanceof
            if (footballClubDetails instanceof SchoolFootballClub) {
              System.out.println("Football Club Type: School Football Club");
            } else {
              System.out.println("Football Club Type: University Football Club");
            }
            System.out.println();
            //System.out.println("Number of clubs: " + sportsClubsInformation.size());
            System.out.println("------------------------------------------");
          }
        }
      }

      if (!isSportClubAlreadyInTheSystem) { // club not in system
        // give error message to user about the club name
        System.out.println("----------------------------------------------------");
        System.out.println("Invalid, Please enter the sport club name correctly.");
        System.out.println("----------------------------------------------------");
      }
    }

    @Override
    public void showStatistics(String sportClubName) { // show statistic about the club
        // define boolean variable as false
        boolean isSportClubAlreadyInTheSystem = false;
        // first check list is empty using isEmpty
        if (sportsClubsInformation.isEmpty()) {
            System.out.println("----------------------------------------------------");
            // if its empty, give error message to the use
            System.out.println("No clubs available at the moment.");
            System.out.println("----------------------------------------------------");
        } else {
            for (SportsClub showClubStatistics : sportsClubsInformation) {
                // check club name in the list
                if (showClubStatistics.getNameOfTheClub().equalsIgnoreCase(sportClubName)) {
                    // if club in the array list
                    isSportClubAlreadyInTheSystem = true;
                    // print club information
                    System.out.println("-----------------------------------------------------------");
                    System.out.println();
                    System.out.println("                    Club Information                       ");
                    System.out.println();
                    System.out.println("-----------------------------------------------------------");
                    // print name of club
                    System.out.println("Name of the club: " + showClubStatistics.getNameOfTheClub());
                    // check type of the club using instanceof
                    if (showClubStatistics instanceof SchoolFootballClub) {
                        System.out.println("Football Club Type: School Football Club");
                    } else {
                        System.out.println("Football Club Type: University Football Club");
                    }
                    // location of the club
                    System.out.println("Location of the club: " + showClubStatistics.getLocationOfTheClub());
                    // no of matches played
                    System.out.println("Number of matches played: " + ((FootballClub) showClubStatistics).getNumberOfMatchesPlayed()); // type casting to FootBallClub
                    // no of wins
                    System.out.println("Number of wins: " + ((FootballClub) showClubStatistics).getNumberOfWinsClubAchieved());
                    // no of defeats
                    System.out.println("Number of defeat: " + ((FootballClub) showClubStatistics).getNumberOfDefeatsClubAchieved());
                    // no of draws
                    System.out.println("Number of draws: " + ((FootballClub) showClubStatistics).getNumberOfDrawsClubAchieved());
                    // no of goal received
                    System.out.println("Number of goals received: " + ((FootballClub) showClubStatistics).getNumberOfGoalsReceived());
                    // no of goal scored
                    System.out.println("Number of goals scored: " + ((FootballClub) showClubStatistics).getNumberOfGoalsScored());
                    // no of points
                    System.out.println("Number of points: " + ((FootballClub) showClubStatistics).getNumberOfPointsClubAchieved());
                    // no of goal difference
                    System.out.println("Club goal difference: " + ((FootballClub) showClubStatistics).getClubGoalDifference());
                }
            }
        }
        if (!isSportClubAlreadyInTheSystem) {
            // print error message to the user
            System.out.println("----------------------------------------------------");
            System.out.println("Invalid, Please Check the sport club name correctly.");
            System.out.println("----------------------------------------------------");
        }
    }

    @Override
    public void checkPremierLeagueTable() { // show all the information about who register to league
        /*
         * Code Reference: https://www.tutorialspoint.com/java-program-to-format-strings-into-table
         * developed using demo example in tutorialspoint.com
         */
        // sorting using Collection.sort
        Collections.sort(sportsClubsInformation);
        int clubRank = 1; // show the rank
        // set left alignment according to first row details
        String positionAlignment = "| %-7s | %-15s | %-18s | %-7s | %-8s | %-6s | %-6s | %-12s | %-14S | %-15s | %n"; // left alignment using string formatter
        /*
         * creating header format using System.out.format
         * Rank column automatically update when updating clubRank
         */
        System.out.format("*=========*=================*====================*=========*==========*========*========*==============*================*=================*%n");
        // upper header using * , =
        System.out.format("| Rank    | Club Name       | No Matches Played  | Wins    | Defeats  | Draws  | Points | Goals scored | Goals received | Goal Difference |%n");
        // column details according to club statistics
        System.out.format("*=========*=================*====================*=========*==========*========*========*==============*================*=================*%n");
        for (SportsClub showLeagueTable : sportsClubsInformation) { // show the club details
            // getting details form list and put it in the table column by column
            System.out.format(positionAlignment, clubRank, showLeagueTable.getNameOfTheClub(), ((FootballClub) showLeagueTable).getNumberOfMatchesPlayed(), ((FootballClub) showLeagueTable).getNumberOfWinsClubAchieved(), ((FootballClub) showLeagueTable).getNumberOfDefeatsClubAchieved(), ((FootballClub) showLeagueTable).getNumberOfDrawsClubAchieved(), ((FootballClub) showLeagueTable).getNumberOfPointsClubAchieved(), ((FootballClub) showLeagueTable).getNumberOfGoalsScored(), ((FootballClub) showLeagueTable).getNumberOfGoalsReceived(), ((FootballClub) showLeagueTable).getClubGoalDifference());
            // upper header using * , =
            System.out.format("*=========*=================*====================*=========*==========*========*========*==============*================*=================*%n");
            // update the rank
            clubRank = clubRank + 1;
        }
    }

    @Override
    public void addNewMatch(String firstClubTeam, String secondClubName, int teamOneScore, int teamTwoScore, String matchDate) { // add new match
        /*
         * Code Reference: https://www.codegrepper.com/code-examples/whatever/how+to+update+arraylist+value+in+java
         * Develop using demo example in codegrepper.com
         */
        // add match update arraylist
        MatchManager updateMatchUpdate = new MatchManager(firstClubTeam, secondClubName, teamOneScore, teamTwoScore, matchDate);
        // add match details to matchManage list
        matchManagerDetails.add(updateMatchUpdate);
        for (int i = 0; i < sportsClubsInformation.size(); i++) {
            // getting goal difference in team one
            int teamOneGoalDifference = (sportsClubsInformation.get(i).getNumberOfGoalsScored() + teamOneScore) - (sportsClubsInformation.get(i).getNumberOfGoalsReceived() + teamTwoScore);
            // getting goal difference in team two
            int teamTwoGoalDifference = (sportsClubsInformation.get(i).getNumberOfGoalsScored() + teamTwoScore) - (sportsClubsInformation.get(i).getNumberOfGoalsReceived() + teamOneScore);
            // get club 01 and update statistic of it
            if (sportsClubsInformation.get(i).getNameOfTheClub().equalsIgnoreCase(firstClubTeam)) {
                // call match update method and update wins, draws, defeat
                matchDateUpdate(teamOneScore, teamTwoScore, sportsClubsInformation.get(i));
                // create new object using updated data
                FootballClub footballClubUpdateTable = new FootballClub(firstClubTeam, sportsClubsInformation.get(i).getLocationOfTheClub(), teamTwoScore + sportsClubsInformation.get(i).getNumberOfGoalsReceived(), teamOneScore + sportsClubsInformation.get(i).getNumberOfGoalsScored(), sportClubPoints, sportsClubsInformation.get(i).getNumberOfMatchesPlayed() + 1, teamOneGoalDifference, sportClubWins, sportClubDraws, sportClubDefeat, matchDate);
                // update arraylist using object index value
                sportsClubsInformation.set(i, footballClubUpdateTable);
                // get club 02 and update statistic of it
            } else if (sportsClubsInformation.get(i).getNameOfTheClub().equalsIgnoreCase(secondClubName)) {
                // call match update method and update wins, draws, defeat
                matchDateUpdate(teamTwoScore, teamOneScore, sportsClubsInformation.get(i));
                // create new object using updated data
                FootballClub footballClubUpdateTable = new FootballClub(secondClubName, sportsClubsInformation.get(i).getLocationOfTheClub(), teamOneScore + sportsClubsInformation.get(i).getNumberOfGoalsReceived(), teamTwoScore + sportsClubsInformation.get(i).getNumberOfGoalsScored(), sportClubPoints, sportsClubsInformation.get(i).getNumberOfMatchesPlayed() + 1, teamTwoGoalDifference, sportClubWins, sportClubDraws, sportClubDefeat, matchDate);
                // update arraylist using object index value
                sportsClubsInformation.set(i, footballClubUpdateTable);
                // successful message
                System.out.println("- - - - - - - - - - - - - - - - -");
                System.out.println("Match details added successfully.");

            }

        }

    }

    public void generateRandomData() {
        // generate random data
        boolean isTeamNameEquals = true;

        String randomFirstClubName = null;

        String randomSecondClubName = null;

        int randomTeamOneScore = 0;

        int randomTeamTwoScore = 0;

        String randomDate = null;
        // check if array have any elements
        if (sportsClubsInformation.size() == 0) {
            // if not print error message
            System.out.println();
            System.out.println("No club in the Array");
        } else {

            while (isTeamNameEquals) {

                // define random object
                Random randomChoice = new Random();

                // generate random first club name
                int randomFirstClubIndex = randomChoice.nextInt(sportsClubsInformation.size());
                randomFirstClubName = sportsClubsInformation.get(randomFirstClubIndex).getNameOfTheClub();

                // generate random second club name
                int randomSecondClubIndex = randomChoice.nextInt(sportsClubsInformation.size());
                randomSecondClubName = sportsClubsInformation.get(randomSecondClubIndex).getNameOfTheClub();

                // generate team one score
                randomTeamOneScore = randomChoice.nextInt(30) + 1;
                // generate team two score
                randomTeamTwoScore = randomChoice.nextInt(30) + 1;

                // random date generate
                int randomDateGenerate = randomChoice.nextInt(28) + 1;
                // random month generate
                int randomMonthGenerate = randomChoice.nextInt(12) + 1;
                /*
                 * Code Reference: https://www.logicbig.com/how-to/code-snippets/jcode-java-random-random-dates.html
                 * Develop using demo example in logicbig.com
                 */
                // random year generate
                long randomYearGenerate = 2015 + Math.round(Math.random() * (2015 - 2020));
                // convert it to a proper format
                randomDate = String.format("%02d", randomDateGenerate) + "/" + String.format("%02d", randomMonthGenerate) + "/" + randomYearGenerate;
                // check both club names are same
                if (!randomFirstClubName.equals(randomSecondClubName)) {
                    // if club are same generate it again
                    isTeamNameEquals = false;
                }
            }
            // add all parameters in to addNewMatch method
            this.addNewMatch(randomFirstClubName, randomSecondClubName, randomTeamOneScore, randomTeamTwoScore, randomDate);

        }
    }

    public List<MatchManager> searchView(String matchDate) {
        /*
         * Code Reference: https://www.javatpoint.com/binary-search-in-java
         * Develop using demo example in javatpoint.com
         */
        // define temp array list
        List<MatchManager> returnDateList = new ArrayList<>();

        for (int i = 0; i < matchManagerDetails.size(); i++) {
            // match date equals to any dates in the array list
            if (matchManagerDetails.get(i).getMatchDate().equals(matchDate)) {
                //  add it to temp array
                returnDateList.add(matchManagerDetails.get(i));
            }
        }
        // return list
        return returnDateList;
    }

    public List<MatchManager> sortedDateList() {

        //define the sample date format
        SimpleDateFormat matchDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        // creating new comparator object
        Comparator<MatchManager> matchManagerDateComparator = new Comparator<MatchManager>() {
            @Override
            public int compare(MatchManager date1, MatchManager date2) {
                // define date result
                int sortedDateResult = 0;
                try {
                    sortedDateResult =  matchDateFormat.parse(date1.getMatchDate()).compareTo(matchDateFormat.parse(date2.getMatchDate()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                // return sorted list
                return sortedDateResult;
            }
        };
        // define a temp list and add all match details to it
        List<MatchManager> sortedDateMatches = new ArrayList<MatchManager>(matchManagerDetails);
        // sorted temp list using comparator
        Collections.sort(sortedDateMatches,matchManagerDateComparator);
        // return sorted list
        return sortedDateMatches;
    }

    public List<FootballClub> sortedPointList() {
        // use comparator to sort sport club list using date
        Comparator<FootballClub> matchManagerPointsComparator = new Comparator<FootballClub>() {
            @Override
            public int compare(FootballClub points1, FootballClub points2) {
                // comparing both variables
                return points1.getNumberOfPointsClubAchieved() - (points2.getNumberOfPointsClubAchieved());
            }
        };
        // define a temp list and add all sport club details to it
        List<FootballClub> sortedPointsTable = new ArrayList<FootballClub>(sportsClubsInformation);
        // sorted temp list using comparator
        sortedPointsTable.sort(Collections.reverseOrder(matchManagerPointsComparator));
        // return sorted array list
        return sortedPointsTable;
    }


    public List<FootballClub> sortedWinList() {
        // use comparator to sort sport club list using date
        Comparator<FootballClub> matchManagerWinComparator = new Comparator<FootballClub>() {
            @Override
            public int compare(FootballClub win1, FootballClub win2) {
                // comparing both variables
                return win1.getNumberOfWinsClubAchieved() - win2.getNumberOfWinsClubAchieved();
            }
        };
        // define a temp list and add all sport club details to it
        List<FootballClub> sortedWinsTable = new ArrayList<>(sportsClubsInformation);
        // sorted temp list using comparator
        sortedWinsTable.sort(Collections.reverseOrder(matchManagerWinComparator));
        // return sorted array list
        return sortedWinsTable;
    }

    public List<FootballClub> goalScoredList() {
        // use comparator to sort sport club list using date
        Comparator<FootballClub> matchManagerGoalScoredComparator = new Comparator<FootballClub>() {
            @Override
            public int compare(FootballClub score1, FootballClub score2) {
                // comparing both variables
                return score1.getNumberOfGoalsScored() - score2.getNumberOfGoalsScored();
            }
        };
        // define a temp list and add all sport club details to it
        List<FootballClub> sortedGoalScoredList = new ArrayList<FootballClub>(sportsClubsInformation);
        // sorted temp list using comparator
        sortedGoalScoredList.sort(Collections.reverseOrder(matchManagerGoalScoredComparator));
        // return sorted list
        return sortedGoalScoredList;
    }

    public static boolean isTeamNameValid(String clubName) { // team validate method
        for (FootballClub clubNameCheck : PremierLeagueManager.sportsClubsInformation){
            // check if club name is available in the list
            if (clubNameCheck.getNameOfTheClub().equalsIgnoreCase(clubName)){
                return false;
            }
        }
        return true;
    }

    public static boolean isDateValid(String matchDate){ // date validate method
        /*
         * Code Reference: https://youtu.be/AULXaMVc6aQ
         * Develop using demo example in youtube
         */
        //define the sample date format
        SimpleDateFormat matchDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        // create Date Object
        Date date = null;

        matchDateFormat.setLenient(false);

        try{
            // check the sample date format with user enter date
            date = matchDateFormat.parse(matchDate);
            return true; // if its correct return true
        }catch (Exception e){
            return false; // if there is a exception return false
        }

    }

    public void loadData() { // load save data to the system

        try {
            try {
              // create FileInputStream and pass premier league file instance as argument
              FileInputStream loadDataFromLogs = new FileInputStream("src/PremierLeagueLogs.txt");
              // create FileInputStream and pass match file instance as argument
              FileInputStream matchDataLogs = new FileInputStream("src/MatchDetails.txt");

                // create ObjectInputStream and pass the FileInputStream as a argument
                ObjectInputStream loadPremierLeagueObject = new ObjectInputStream(loadDataFromLogs);

                ObjectInputStream loadMatchDetails = new ObjectInputStream(matchDataLogs);

                for (; ; ) { // infinity for loop
                    try {
                        // read object and type cast it to FootBallClub
                        FootballClub loadedLogData = (FootballClub) loadPremierLeagueObject.readObject();
                        // add it to arraylist
                        sportsClubsInformation.add(loadedLogData);
                        // when it ends break the program
                    } catch (EOFException e) {
                        break;
                    }
                }
                for (; ; ) { // infinity for loop
                    try {
                        // read object and type cast it to FootBallClub
                        MatchManager matchDataLogsDetails = (MatchManager) loadMatchDetails.readObject();
                        // add it to arraylist
                        matchManagerDetails.add(matchDataLogsDetails);
                        // when it ends break the program
                    } catch (EOFException e) {
                        break;
                    }
                }
                // close the ObjectInputStream
                loadPremierLeagueObject.close();
                loadMatchDetails.close();

                // close the FileInputStream
                loadDataFromLogs.close();
                matchDataLogs.close();

            }catch (FileNotFoundException fileNotFoundException){
                // check fileNotFoundException
                System.out.println(" ::::: Log files not loaded ::::: ");
            }
        } catch (IOException | ClassNotFoundException e){

            e.printStackTrace();
        }


    }

    public void saveData() { // save data to txt file

        try {
            // create FileOutputStream and pass premier league file instance as argument
            FileOutputStream premierLeagueLogSavingFile = new FileOutputStream("src/PremierLeagueLogs.txt");
            // create FileOutputStream and pass match file instance as argument
            FileOutputStream matchDataSavingFile = new FileOutputStream("src/MatchDetails.txt");

            // create ObjectOutputStream and pass the FileOutputStream as a argument
            ObjectOutputStream premierLeagueObject = new ObjectOutputStream(premierLeagueLogSavingFile);

            ObjectOutputStream matchDetailsObject = new ObjectOutputStream(matchDataSavingFile);

            for (FootballClub dataSavingForTheTextFile : sportsClubsInformation) { // use for-each loop
                // write object to txt file
                premierLeagueObject.writeObject(dataSavingForTheTextFile);
            }
            for (MatchManager dataSavingForMatchManager: matchManagerDetails){ // use for-each loop
                // write object to txt file
                matchDetailsObject.writeObject(dataSavingForMatchManager);
            }

            // close the ObjectOutputStream
            premierLeagueObject.close();
            matchDetailsObject.close();

            // close the FileOutputStream
            premierLeagueLogSavingFile.close();
            matchDataSavingFile.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
