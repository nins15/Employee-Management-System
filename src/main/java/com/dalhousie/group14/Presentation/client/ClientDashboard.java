package com.dalhousie.group14.Presentation.client;

import com.dalhousie.group14.BusinessLogic.client.ClientDashboardValidation;
import com.dalhousie.group14.BusinessLogic.client.IClientDashboardValidation;
import com.dalhousie.group14.BusinessLogic.client.IProjectFeedback;
import com.dalhousie.group14.BusinessLogic.client.ProjectFeedback;
import com.dalhousie.group14.Database.client.IProjectDatabaseInteraction;
import com.dalhousie.group14.Database.client.ProjectDatabaseInteraction;
import com.dalhousie.group14.Presentation.utilities.IuserIntValidation;
import com.dalhousie.group14.Presentation.utilities.Login;
import com.dalhousie.group14.Presentation.utilities.userIntValidation;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
/**
 * @Author: Harjot Singh
 * @NameofFile: ClientDashboard.java
 * @ClassDescription: This class is used for the purpose of providing
 * the client dashboard.
 */
public class ClientDashboard implements IClientDashboard {
  public static int LOW_RANGE = 0;
  public static int HIGH_rANGE = 5;
  public static final int MAX_TRIES = 3;
  public static final int ONE = 1;
  public static final int TWO = 2;
  public static final int THREE = 3;
  public static final int FOUR = 4;


  public void clientscreen(String clientID) {
    IClientDashboardValidation clientDashboardValidation =
        new ClientDashboardValidation();

    boolean correctoption = false;
    int optionchosen = 0;

    System.out.printf("%80s%10s\n", "Client", "Dashboard");
    System.out.println("\nHello! Welcome Back "+clientID+" -  Employee " +
            "Management System");
    System.out.println("\nEnter from the following options");
    System.out.println("1. Define a project.");
    System.out.println("2. Check the project status.");
    System.out.println("3. Provide project feedback.");
    System.out.println("4. To Logout, Return to the Main Screen.");
    System.out.print("Provide your input here : ");

    for (int i = LOW_RANGE; i < MAX_TRIES; i++) {
      int maxlimit = MAX_TRIES - 1;
      try {
        Scanner s = new Scanner(System.in);
        optionchosen = s.nextInt();
        correctoption = clientDashboardValidation.clientInput(optionchosen, LOW_RANGE, HIGH_rANGE);
        if (correctoption) {
          break;
        } else {

          if (i != maxlimit) {
            System.out.print("Incorrect Input, Enter your input again : ");
          }
        }
      } catch (InputMismatchException inputMismatchException) {
        if (i != maxlimit) {
          System.out.print("Incorrect Input Format, Enter your input again : ");
        }
      }
    }
    if (!correctoption) {
      System.out.println("\nYou have used all your attempts, log back into " +
          "the application.");
      return;
    }
    IProjectDatabaseInteraction iProjectDatabaseInteraction =
        new ProjectDatabaseInteraction();
    Scanner scanner = new Scanner(System.in);
    IClientProject project = new ClientProject();
    if (correctoption) {
      if (optionchosen == ONE) {
        defineProjectScreen(project, clientID, scanner);
      } else if (optionchosen == TWO) {
        checkProjectStatusScreen(iProjectDatabaseInteraction, clientID, scanner);
      } else if (optionchosen == THREE) {
        giveProjectFeedbackScreen(iProjectDatabaseInteraction, clientID, scanner);
      } else if (optionchosen == FOUR) {
        Login login = new Login();
        login.userType();
      }
    }
  }

  public void defineProjectScreen(IClientProject project, String clientID,
                                  Scanner scanner) {
    boolean response = project.defineproject(clientID);
    if (response) {

      System.out.println("\n CONGRATULATIONS!");
      System.out.println("Your project has been successfully defined along with its milestones.");
      System.out.println("Enter 'BACK' to return to the main client " +
          "screen");
      String userInput = scanner.next();
      returnBack(userInput, clientID, scanner);

    } else {
      System.out.println("\n The project was not defined due to illegal " +
          "operations.");
      System.out.println("You will be returned to the main client screen.");
      clientscreen(clientID);
    }
  }


  public void checkProjectStatusScreen(IProjectDatabaseInteraction iProjectDatabaseInteraction,
                                       String clientID, Scanner scanner) {
    System.out.println();
    System.out.println("You have selected option 2, displaying the status" +
        " of all the projects that have been defined by you." +
        " ");
    if (iProjectDatabaseInteraction.projectStatusCheck(clientID)) {
      System.out.println("\n If you want to return to the main screen, " +
          "enter 'BACK'.");
      String userInput = scanner.next();
      returnBack(userInput, clientID, scanner);
    } else {
      System.out.println("No projects to display, you have not defined " +
          "any projects.");
      System.out.println("Enter 'BACK' to return to the main client " +
          "screen");
      String userInput = scanner.next();
      returnBack(userInput, clientID, scanner);
    }
  }

  public void giveProjectFeedbackScreen(IProjectDatabaseInteraction iProjectDatabaseInteraction,
                                        String clientID, Scanner scanner) {
    System.out.println("Choose the project for which you want to give the" +
        " feedback on.");
    List<String> feedbackProjects =
        iProjectDatabaseInteraction.projectPendingFeedback(clientID);
    if (feedbackProjects != null) {
      System.out.print("Enter your input, Choose the S.no of the project " +
          "that you want to give your feedback on");
      int MAX_SIZE = feedbackProjects.size();
      IuserIntValidation iuserIntValidation = new userIntValidation();
      int userInput = iuserIntValidation.takeUserinput(scanner, MAX_SIZE);
      if (userInput > LOW_RANGE) {
        System.out.println("You have chosen S.No - "+userInput);
        System.out.println("Enter the feedback of this project - 1 is the " +
            "lowest, 5 is the highest.");
        int MAX_RATING = 5;
        int userfeedback = iuserIntValidation.takeUserinput(scanner,MAX_RATING);
        if(userfeedback> LOW_RANGE){
          System.out.println("\nYour feedback has been successfully recorded," +
              "the project's client feedback will" + " be updated in the portal");
          System.out.println("We will work to improve on this feedback and " +
              "ensure that your future projects will be delivered to the best" +
              " of our capabilities.");
        }
        IProjectFeedback iProjectFeedback = new ProjectFeedback();
        String projectInfo = feedbackProjects.get(userInput-ONE);
        iProjectFeedback.processFeedback(userfeedback,projectInfo);
      } else {
        System.out.println("You have entered incorrect input multiple times, " +
            "have used all your available attempts.");
        System.out.println("Enter 'BACK' to return to the Client Dashboard");
        String userResponse = scanner.next();
        returnBack(userResponse, clientID, scanner);
      }
    } else {
      System.out.println("Sorry, there are no projects currently " +
          "available for feedback, wait while they get finished by the " +
          "respective team so you can give your feedback.");
      System.out.println("Enter 'BACK' to return to the main client " +
          "screen");
      String userInput = scanner.next();
      returnBack(userInput, clientID, scanner);
    }
  }

  private void returnBack(String userInput, String clientID, Scanner scanner) {
    String returnString = "BACK";
    if (userInput.equals(returnString)) {
      clientscreen(clientID);
    } else {
      System.out.println("You have entered a wrong input, If you want to go " +
          "back to the main client dashboard enter 'BACK'");
      userInput = scanner.next();
      returnBack(userInput, clientID, scanner);
    }
  }

}
