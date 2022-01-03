package com.dalhousie.group14.Presentation.manager;

import com.dalhousie.group14.BusinessLogic.manager.IProjectAssigner;
import com.dalhousie.group14.Database.manager.IProjectStatusRetrieve;
import com.dalhousie.group14.BusinessLogic.manager.ProjectAssigner;
import com.dalhousie.group14.Database.manager.ProjectStatus;
import com.dalhousie.group14.Presentation.utilities.IuserIntValidation;
import com.dalhousie.group14.Presentation.utilities.userIntValidation;

import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;
/**
 * @Author: Harjot Singh
 * @NameofFile: PendingProjects.java
 * @ClassDescription: This class is used for the purpose of providing
 * the screen for pending projects.
 */
public class PendingProjects implements IPendingProjects {
  public static final int MIN = 0;
  public static final int ONE = 1;

  @Override
  public void displayPendingProjects(IProjectStatusRetrieve projectStatusRetrieve) {
    Scanner scanner = new Scanner(System.in);
    int MAX_SIZE = 0;
    int userInput;
    ResultSet resultSet = ProjectStatus.checkStatus("Initiation");
    if (resultSet != null) {
      List<String> pendingprojects = projectStatusRetrieve.projectList(resultSet);
      if (pendingprojects != null) {
        MAX_SIZE = pendingprojects.size();
      }
      if (MAX_SIZE == MIN) {
        System.out.println("Couldn't find any pending projects at this " +
            "time.");
      } else {
        System.out.println("If you want to assign a pending project to the " +
            "employees, enter the S.No of the specific project.");
        IuserIntValidation iuserIntValidation = new userIntValidation();
        userInput = iuserIntValidation.takeUserinput(scanner, MAX_SIZE);
        if (userInput > MIN) {
          System.out.println("You have chosen S.No "+userInput);
          System.out.println("This process will take some time to perform " +
              "analysis and then assign projects based on the best fitting " +
              "employees to your project requirements");
          System.out.println("Please Wait...");
          IProjectAssigner obj = new ProjectAssigner();
          String assignedEmployees =
              obj.assignProject(pendingprojects.get(userInput - ONE));
          if (assignedEmployees != null) {
            System.out.println("Successfully Assigned Employees to the Project");
            System.out.println(assignedEmployees);
          } else {
            System.out.println("Couldn't assign employees to the project due to unavailability of free employees.");
          }
        }else{
          System.out.println("Returning to the Project Management Screen.");
          IProjectManagementDashboard obj = new ProjectManagementDashboard();
          obj.projDashboard();
        }
      }
    } else {
      System.out.println("No pending projects.");

    }
  }

}
