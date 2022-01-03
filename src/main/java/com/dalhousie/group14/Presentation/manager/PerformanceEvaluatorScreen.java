package com.dalhousie.group14.Presentation.manager;

import com.dalhousie.group14.BusinessLogic.manager.EmpEvaluation;
import com.dalhousie.group14.BusinessLogic.manager.IEmpEvaluation;
import com.dalhousie.group14.BusinessLogic.utilities.Validations;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * @Author: Harjot Singh
 * @NameofFile: PerformanceEvaluatorScreen.java
 * @ClassDescription: This class is used for the purpose of providing
 * the screen for the performance evaluation of employees.
 */

public class PerformanceEvaluatorScreen implements IPerformanceEvaluatorScreen {
  public static final int MAX_TRIES = 5;
  public static final int DATE = 10;
  public static final int LOW_LIMIT = 0;
  public static final int HIGH_LIMIT = 6;


  public void evaluatoroptions() {
    int userinput = 0;
    boolean correctinput = false;
    int tries = 0;
    Scanner scanner = new Scanner(System.in);
    System.out.println("Choose the following options from the options. \n" +
        "1. Show Performance Evaluation of All Employees. \n" +
        "2. Display Performance Evaluation of A Specific Employee. \n" +
        "3. Show the Most Disciplined Employees. \n" +
        "4. Show the Least Disciplined Employees. \n" +
        "5. Current Employee of the Month. \n" +
        "6. To go back to the previous screen. \n");

    try {
      userinput = scanner.nextInt();
      if (userinput > LOW_LIMIT && userinput <= HIGH_LIMIT) {
        correctinput = true;
      } else {
        System.out.println("Wrong Input Choice.");
        evaluatoroptions();
      }
    } catch (InputMismatchException inputMismatchException) {
      System.out.println("You can only enter an integer value");
    }

    if (correctinput) {
      IEmpEvaluation iEmpEvaluation = new EmpEvaluation();
      if (userinput == 1) {
        displayEvaluationAll(iEmpEvaluation);
      } else if (userinput == 2) {
        displayEmployeeEvaluation(scanner, iEmpEvaluation);
      } else if (userinput == 3) {
        displayMostDisciplined(iEmpEvaluation);
      } else if (userinput == 4) {
        displayLeastDisciplined(iEmpEvaluation);
      } else if (userinput == 5) {
        displayEoM(iEmpEvaluation);
      } else if (userinput == 6){
        ManagerLoginDashBoard obj = new ManagerLoginDashBoard();
        obj.managerLoginDashBoard();
      }
      returntoEvaluatorScreen(scanner, tries);
    }

  }

  public void displayEvaluationAll(IEmpEvaluation iEmpEvaluation) {
    System.out.println("\nAll the eligible employees will be evaluted," +
        " their discipline rating, project performance and a " +
        "commutative employee performance score will be generated " +
        ".");
    System.out.println("This process will take some time. Please Wait.");

    String evaluationString = iEmpEvaluation.EvaluateAll();
    if (evaluationString != null) {
      System.out.println("Here is the evaluation of all the eligible " +
          "employees\n");
      System.out.println(evaluationString);
    } else {
      System.out.println("Sorry, couldn't find any eligible employees " +
          "for doing performance evaluation. Please try again later.");
    }
  }

  public void displayEmployeeEvaluation(Scanner scanner, IEmpEvaluation iEmpEvaluation) {
    System.out.println("Enter the Employee User ID");
    String username = scanner.next();
    if (Validations.isStringvalid(username)) {

      System.out.println("\nThank you for entering the Employee ID of " +
          "the employee whose performance is to be evaluated," +
          " their discipline rating, project performance and a " +
          "commutative employee performance score will be generated " +
          ".");
      System.out.println("This process will take some time. Please Wait.");
      System.out.println("Processing...");
      String employeePerformance = iEmpEvaluation.EvaluateEmployee(username);
      if(employeePerformance == null){
        System.out.println("The entered employee is not eligible for the ");
        return;
      }
      System.out.println("Here is the evaluation of the entered employee");
      System.out.println(employeePerformance);
    } else {
      System.out.println("Incorrect Input Format, Please enter correctly.");
    }
  }

  public void displayMostDisciplined(IEmpEvaluation iEmpEvaluation) {

    String displayMostDisciplinedString = iEmpEvaluation.mostDisciplined();
    if (displayMostDisciplinedString != null) {
      System.out.println("\nThe employee who has been the most disciplined in" +
          " " +
          "the past month is following.");
      System.out.println(
          "-------------------------------------------------------");
      System.out.println(displayMostDisciplinedString);
    } else {
      System.out.println("Couldn't find the required employee due to there " +
          "not being sufficient number of sessions by the eligible employees.");
    }

  }

  public void displayLeastDisciplined(IEmpEvaluation iEmpEvaluation) {
    String displayLeastDisciplinedString = iEmpEvaluation.leastDisciplined();
    if (displayLeastDisciplinedString != null) {
      System.out.println("\nThe employee who has been the least disciplined " +
          "in " +
          "the past month is as follows.");
      System.out.println(
          "------------------------------------------------------");
      System.out.println(displayLeastDisciplinedString);

    } else {
      System.out.println("Couldn't find the required employee due to there " +
          "not being sufficient number of sessions by the eligible employees.");
    }

  }

  public void displayEoM(IEmpEvaluation iEmpEvaluation) {
    String EoM = iEmpEvaluation.EoMDisplay();
    if (EoM != null) {
      System.out.println("The following employee has won Employee of the Month!! ");
      System.out.println(
          "---------------------------------------------------------------------------------");

      System.out.println(EoM);
    } else {
      System.out.println("Sorry, there is currently no Employee of the Month," +
          " perform analysis on all the employees first. ");
      System.out.println("If you have already evaluated all the employees, no" +
          " employee is currently eligible for the Employee of the Month " +
          "Award.");
    }

  }

  public void returntoEvaluatorScreen(Scanner scanner, int tries) {
    String returnString = "BACK";
    if (tries == MAX_TRIES) {
      return;
    }
    while (tries < MAX_TRIES) {
      tries++;
      System.out.println("If you want to return to the Performance Evaluator " +
          "Screen, Enter 'BACK' ");
      String userInput = scanner.next();
      if (userInput.equals(returnString)) {
        evaluatoroptions();
      } else {
        System.out.println("Incorrect Input, Please enter 'BACK' to return to" +
            " the Performance Evaluator.");
        returntoEvaluatorScreen(scanner, tries);
      }
    }
  }

}
