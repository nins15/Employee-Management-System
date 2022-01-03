/**
 * Author: Aadil Shaikh
 * This class displays the employee's projects history.
 */
package com.dalhousie.group14.Presentation.employee;

import com.dalhousie.group14.Database.employee.ProjectOperations;

import java.util.List;
import java.util.Scanner;

public class DisplayProject {

  public void display() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Project Deadlines: ");
    System.out.println();
    String empID = "2";
    List<String> milestoneInfo;
    ProjectOperations projectOperations = new ProjectOperations();
    milestoneInfo = projectOperations.getProjects(empID);
    for (int i = 0; i < milestoneInfo.size() / 6; i++) {
      System.out.print("\nProject " + (i + 1));
      System.out.print("\nProject ID: ");
      System.out.print(milestoneInfo.get(0 + (i * 6)));
      System.out.print("\nProject Name: ");
      System.out.print(milestoneInfo.get(1 + (i * 6)));
      System.out.print("\nProject Languages: ");
      System.out.print(milestoneInfo.get(2 + (i * 6)));
      System.out.print("\nProject Start Date: ");
      System.out.print(milestoneInfo.get(3 + (i * 6)));
      System.out.print("\nProject End Date: ");
      System.out.print(milestoneInfo.get(4 + (i * 6)));
      System.out.print("\nProject Status: ");
      System.out.print(milestoneInfo.get(5 + (i * 6)));
      System.out.println();
      System.out.println("Enter exit to go back to previous screen.");
      String input = scanner.nextLine();
      EmployeeProjectHandling employeeProjectHandling =
          new EmployeeProjectHandling();
      employeeProjectHandling.display();
    }
  }
}
