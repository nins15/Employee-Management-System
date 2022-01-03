package com.dalhousie.group14.Presentation.client;

import com.dalhousie.group14.BusinessLogic.client.IProjectDefinition;
import com.dalhousie.group14.BusinessLogic.client.ProjectDefinition;
import com.dalhousie.group14.BusinessLogic.utilities.Validations;
import com.dalhousie.group14.Database.client.IProjectDatabaseInteraction;
import com.dalhousie.group14.Database.client.ProjectDatabaseInteraction;

import java.util.*;
/**
 * @Author: Harjot Singh
 * @NameofFile: ClientProject.java
 * @ClassDescription: This class is used for the purpose of providing
 * the screen for project definition.
 */
public class ClientProject implements IClientProject {
  String projectName = "";
  int tries = 0;
  public static final int MAX_TRIES = 3;
  Date start_date = new Date();
  Date end_date = new Date();
  Scanner s = new Scanner(System.in);
  List<String> language_requirements = new ArrayList<>();
  IProjectDefinition projectDefinition = new ProjectDefinition();


  public boolean defineproject(String clientID) {

    System.out.println();
    System.out.println("Hello! " + clientID + ", Welcome to Project " +
        "Definition Module, Please enter only numerical/alphabetical values " +
        "according " +
        "to the requirement." +
        " ");

    IProjectDatabaseInteraction projectDatabaseInteraction =
        new ProjectDatabaseInteraction();
    if (defineProjectName(projectDatabaseInteraction) && defineProjectLanguages() && defineProjectDates() && defineProjectMilestones(projectDatabaseInteraction, clientID)) {
      return true;
    } else {
      return false;
    }
  }


  public boolean defineProjectName(IProjectDatabaseInteraction projectDatabaseInteraction) {

    if (tries == MAX_TRIES) {
      System.out.println("You have used all your attempts to define" +
          " the project name, the system will now exit");
      return false;
    }

    System.out.print("Enter the project name : ");
    projectName = s.nextLine();
    if (Validations.isStringvalid(projectName)) {

      if (projectDatabaseInteraction.projectExistsCheck(projectName)) {
        return true;
      } else {
        System.out.println("This project already exists, change the project name to continue.");
        defineProjectName(projectDatabaseInteraction);
        tries++;
      }
    }
    return false;
  }

  public boolean defineProjectLanguages() {
    System.out.println();
    System.out.println("Now, you will need to enter the programming languages for the project.");
    System.out.println("Enter 'DONE' when you have finished entering the languages.");
    int count = 1;

    boolean done = false;
    while (!done) {

      System.out.print("Enter the " + Validations.noreturn(count) + " programming language that will " +
          "be used for this project : ");
      count++;
      String languageinput = s.next();
      if (languageinput.equals("DONE")) {
        done = true;
        return true;
      }
      String exceptionlanguage = "C++";
      if (Validations.isStringvalid(languageinput) || languageinput.equals(exceptionlanguage)) {
        language_requirements.add(languageinput);
      } else {
        System.out.println("Invalid Language has been entered, please enter again, " +
            "enter 'DONE' when you have finished");
        count--;
      }
    }
    return false;
  }

  public boolean defineProjectDates() {

    boolean done = false;
    boolean startvalid = false;
    while (!done) {
      Scanner scanner = new Scanner(System.in);
      System.out.println();

      if (!startvalid) {
        System.out.print("Enter the project's start date : ");
        String project_start_date = scanner.nextLine();
        start_date = projectDefinition.datesetter(project_start_date);
        if (start_date != null) {
          startvalid = true;
        } else {
          System.out.println("Invalid Date format - Follow " +
              "YYYY-MM-dd" + " " + "Format.");
          defineProjectDates();
        }
      }
      System.out.print("Enter the project's end date : ");
      String project_end_date = scanner.nextLine();
      end_date = projectDefinition.datesetter(project_end_date);
      if (end_date != null) {
        if (Validations.datecomparison(start_date, end_date)) {
          return true;
        } else {
          System.out.println("Project's end date cannot be before the start date.");
        }
      }
    }

    return false;
  }

  public boolean defineProjectMilestones(IProjectDatabaseInteraction projectDatabaseInteraction, String clientID) {
    IMilestonesDashboard obj = new MilestonesDashboard();
    Map<Date, String> milestones = obj.definemilestonescreen(start_date, end_date);
    if (milestones != null) {
      return projectDatabaseInteraction.insertProjectDB(projectName, start_date, end_date,
          language_requirements, milestones, clientID);
    }
    return false;
  }


}
