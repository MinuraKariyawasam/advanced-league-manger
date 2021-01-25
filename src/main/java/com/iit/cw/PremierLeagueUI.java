package com.iit.cw;

import com.iit.cw.model.SchoolFootballClub;
import com.iit.cw.model.UniversityFootballClub;
import com.iit.cw.service.PremierLeagueManager;
import com.iit.cw.view.MainGUI;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import java.util.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PremierLeagueUI {
    // creating a PremierLeagueManager object
    private final static PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
    // set application leached boolean value to false
    private static boolean isApplicationLaunch = false;

    public static void main(String[] args) {
        // variable check exit
        boolean isExit = true;
        System.out.println("======================================");
        System.out.println();
        System.out.println("   Welcome to Premier League Manager  ");
        System.out.println();
        System.out.println("======================================");
        // load data back to list when starting the system.
        premierLeagueManager.loadData();
        while (isExit){
            // creating scanner object
            Scanner USER_INPUT = new Scanner(System.in);

            int USER_RESPONSE;
            System.out.println();
            System.out.println("::::::::::::: Main Menu ::::::::::::::");
            System.out.println();
            System.out.println("0: Instructions");
            System.out.println("1: Add new sport club");
            System.out.println("2: Delete a sport club");
            System.out.println("3: View sport club details");
            System.out.println("4: View premier league table");
            System.out.println("5; GUI premier league table");
            System.out.println("6: Add match details");
            System.out.println("7: Launch REST API");
            System.out.println("8: Exit");

            while (true) {
                try {
                    // get input from user
                    System.out.print(">> ");
                    USER_RESPONSE = USER_INPUT.nextInt();
                    // do input validation
                } catch (InputMismatchException | IllegalArgumentException e) {
                    // print error message
                    System.out.println();
                    System.out.println("---------------------------------------------------------");
                    System.out.println("Please provide a valid input.");
                    System.out.println("If you need a help. Please read instruction pressing 0.");
                    System.out.println("---------------------------------------------------------");
                    // show input again
                    USER_INPUT.next();
                    continue;
                }
                break;
            }
            // check user input and call method according to user input
            switch (USER_RESPONSE){
                case 0:
                    // show instruction method
                    showInstructions();
                    break;
                case 1:
                    // add new club method
                    addNewSportClub();
                    break;
                case 2:
                    // delete new club method
                    deleteSportClub();
                    break;
                case 3:
                    // view sport club method
                    viewSportClubDetails();
                    break;
                case 4:
                    // view premier leauge table
                    viewPremierLeagueTable();
                    break;
                case 5:
                    // launch gui
                    GUIPremierLeagueTable();
                    break;
                case 6:
                    // add new match details method
                    addNewMatchDetails();
                    break;
                case 7:
                    // launch web application (spring boot)
                    SpringApplication.run(PremierLeagueUI.class, args);
                    System.out.println("API launched successfully.");
                    break;
                case 8:
                    // exit method
                    isExit = false;
                    // thank you message
                    System.out.println("------------------------------------------");
                    System.out.println("Thank You for using Premier League Manager");
                    System.out.println("Data save successfully.");
                    System.out.println("------------------------------------------");
                    // Save data to txt file when exiting the system
                    premierLeagueManager.saveData();
                    break;
                default:
                    System.out.println("---------------------------------------------------------");
                    System.out.println("Invalid, Please try again.");
                    System.out.println("If you need a help. Please read instruction pressing 0.");
                    System.out.println("---------------------------------------------------------");
            }
        }


    }


    private static void showInstructions() { // user instruction: how to use League Manager

        System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        System.out.println();
        System.out.println("      Premier League Manager System User Instructions      ");
        System.out.println();
        System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        System.out.println();
        System.out.println("1. Please read the guidance view carefully.");
        System.out.println();
        System.out.println("2. Premier League manager allows school & university club only.");
        System.out.println();
        System.out.println("3. When you add clubs to the system, Please provide the correct information.");
        System.out.println();
        System.out.println("4. When you delete the clubs, Please enter exact club name.");

    }

    private static void addNewSportClub() { // add new sport club to the system
        Scanner USER_CLUB_INPUT = new Scanner(System.in);
        int USER_RESPONSE_CHECK;

        // getting club name
        System.out.print("Enter club name: ");
        String clubName = USER_CLUB_INPUT.next();
        USER_CLUB_INPUT.nextLine();
        // getting club location
        System.out.print("Enter sport club location: ");
        String clubLocation = USER_CLUB_INPUT.next();

        System.out.println("-------------------------------------");
        System.out.println();
        System.out.println(" Select the type of the sport club ");
        System.out.println();
        System.out.println("1: School Football Club");
        System.out.println("2: University Football Club");
        System.out.println();
        System.out.println("-------------------------------------");
        // creating objects schoolClub and UniversityClub
        SchoolFootballClub schoolFootballClub = null;

        UniversityFootballClub universityFootballClub = null;

        while (true) {
            try {
                System.out.print(">> ");
                USER_RESPONSE_CHECK = USER_CLUB_INPUT.nextInt();
            } catch (InputMismatchException | IllegalArgumentException e) { // do input validation
                System.out.println();
                System.out.println("---------------------------------------------------------");
                System.out.println("Please provide a valid input.");
                System.out.println("If you need a help. Please read instruction pressing 0.");
                System.out.println("---------------------------------------------------------");
                USER_CLUB_INPUT.next();
                continue;
            }
            break;
        }

        switch (USER_RESPONSE_CHECK){
            // check sport club type
            case 1:
                System.out.print("Enter school name: ");
                String schoolName = USER_CLUB_INPUT.next();
                USER_CLUB_INPUT.nextLine();

                System.out.print("Enter school division: ");
                String schoolDivision = USER_CLUB_INPUT.next();
                USER_CLUB_INPUT.nextLine();
                // pass parameters to SchoolFootballClub object
                schoolFootballClub = new SchoolFootballClub(clubName,clubLocation,0,0,0,0,0,0,0,0,"-",schoolName,schoolDivision);
                // pass schoolFootBallCub object to addNewMember method
                premierLeagueManager.addNewFootBallClub(schoolFootballClub);
                break;
            case 2:
                System.out.print("Enter university name: ");
                String universityName = USER_CLUB_INPUT.next();
                USER_CLUB_INPUT.nextLine();

                System.out.print("Enter university type (Government [1]/Private [2]): ");
                int universityType;
                while (true) {
                    try {
                        universityType = USER_CLUB_INPUT.nextInt();
                    } catch (InputMismatchException | IllegalArgumentException e) {
                        // do input validation
                        System.out.print("Invalid, (Government [1]/Private [2]): ");
                        USER_CLUB_INPUT.next();
                        continue;
                    }
                    break;
                }
                switch (universityType){
                    case 1:
                        universityFootballClub = new UniversityFootballClub(clubName,clubLocation,0,0,0,0,0,0,0,0,"-",universityName,"Government");
                        // pass universityFootBallClub to addNewMember method based on there type
                        premierLeagueManager.addNewFootBallClub(universityFootballClub);
                        break;
                    case 2:
                        universityFootballClub = new UniversityFootballClub(clubName,clubLocation,0,0,0,0,0,0,0,0,"-",universityName,"Private");
                        // pass universityFootBallClub to addNewMember method based on there type
                        premierLeagueManager.addNewFootBallClub(universityFootballClub);
                        break;
                    default:
                        System.out.println("Invalid Choice.");
                }
                break;
            default:
                System.out.println("Invalid Choice. Please try again.");
        }
    }

    private static void deleteSportClub() { // delete sport club from the system
        Scanner USER_INPUT_VIEW_DELETE = new Scanner(System.in);

        System.out.print("Enter sport club name: ");
        String deleteSportClubName = USER_INPUT_VIEW_DELETE.next();
        USER_INPUT_VIEW_DELETE.nextLine();
        // pass clubName to delete the club from system
        premierLeagueManager.deleteRegClub(deleteSportClubName);
    }

    private static void viewSportClubDetails() { // view sportClub details passing name as parameter
        Scanner USER_INPUT_VIEW_DETAILS = new Scanner(System.in);

        System.out.print("Enter sport club name: ");
        String sportClubName = USER_INPUT_VIEW_DETAILS.next();
        USER_INPUT_VIEW_DETAILS.nextLine();
        // pass the club name to showStatistics method
        premierLeagueManager.showStatistics(sportClubName);
    }

    private static void viewPremierLeagueTable() { // view premier league table
        System.out.println("--------------------------");
        System.out.println();
        System.out.println("   Premier League Table   ");
        System.out.println();
        System.out.println("--------------------------");
        System.out.println();
        // call premierLeagueTable method
        premierLeagueManager.checkPremierLeagueTable();
    }

    private static void addNewMatchDetails() {
        Scanner USER_MATCH_DATA_INPUT = new Scanner(System.in);
        // creating local variables
        String matchDate;
        String teamOneName;
        String teamTwoName;
        int teamTwoScore;
        int teamOneScore;

        System.out.println("---------------------");
        System.out.println();
        System.out.println(" Add Match Details ");
        System.out.println();
        System.out.println("---------------------");
        System.out.println();


        // ::::::: getting team names and validate it :::::::::::

        System.out.print("Team one name: ");
        teamOneName = USER_MATCH_DATA_INPUT.next();
        USER_MATCH_DATA_INPUT.nextLine();

        while (PremierLeagueManager.isTeamNameValid(teamOneName)){ // pass team one as parameter to validate club name
            System.out.print("Invalid club Name. Please enter team one name: ");
            teamOneName = USER_MATCH_DATA_INPUT.nextLine();
            USER_MATCH_DATA_INPUT.nextLine();
        }


        System.out.print("Team two name: ");
        teamTwoName = USER_MATCH_DATA_INPUT.next();
        USER_MATCH_DATA_INPUT.nextLine();
        while (PremierLeagueManager.isTeamNameValid(teamTwoName)){ // pass team two as parameter to validate club name
            System.out.print("Invalid club Name. Please enter team two name: ");
            teamTwoName = USER_MATCH_DATA_INPUT.nextLine();
            USER_MATCH_DATA_INPUT.nextLine();
        }

        // ::::::: getting team score and validate it :::::::::::
        while (true) {
            try {
                System.out.print("Team one Score: ");
                teamOneScore = USER_MATCH_DATA_INPUT.nextInt();

                System.out.print("Team two Score: ");
                teamTwoScore = USER_MATCH_DATA_INPUT.nextInt();
            } catch (InputMismatchException | IllegalArgumentException e) { // team score validation
                System.out.print("Invalid score, Please enter again: ");
                USER_MATCH_DATA_INPUT.next();
                continue;
            }
            break;
        }

        System.out.print("Match Date (dd/MM/yyyy): ");
        matchDate = USER_MATCH_DATA_INPUT.next();
        // check user entered match date are valid
        while (!PremierLeagueManager.isDateValid(matchDate)){ // pass the data in string type to validate it
            System.out.print("Invalid Date Format (dd/MM/yyyy): ");
            matchDate = USER_MATCH_DATA_INPUT.next();
        }
        //pass all user data to the premierLeagueManager method
        premierLeagueManager.addNewMatch(teamOneName, teamTwoName , teamOneScore, teamTwoScore , matchDate);

    }


    private static void GUIPremierLeagueTable() throws IllegalStateException {
        // launch the gui
        // Application.launch(MainGUI.class);
        applicationLaunchAgain(MainGUI.class);
        System.out.println("GUI launched successfully.");
    }


    public static void applicationLaunchAgain(Class<? extends  Application> javaFxClass) { // if application launch --> start application using new thread
        /*
         * Code Reference: https://stackoverflow.com/questions/24320014/how-to-call-launch-more-than-once-in-java
         * Develop using demo example in stackOverflow
         */
        if (!isApplicationLaunch){
            // check first time launch
            Platform.setImplicitExit(false);
            // create new thread using anonymous class
            new Thread(() -> Application.launch(javaFxClass)).start();
            isApplicationLaunch = true;
        } else { // check second time
            Platform.runLater(() -> {
                try{
                    // create a new instance of application to launch in second time
                    Application javaFXApplication = javaFxClass.newInstance();
                    // create a new stage
                    Stage primaryLaunchStage = new Stage();
                    // pass stage as a argument in application.start method
                    javaFXApplication.start(primaryLaunchStage);
                    // catch all exception
                } catch (Exception e){
                    e.printStackTrace();
                }
            });
        }

    }
}
